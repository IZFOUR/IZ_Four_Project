package com.android.iz4

import android.content.Intent
import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Nickname
import android.util.Log
import android.util.TypedValue
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.PopupMenu
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.squareup.picasso.Picasso
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    lateinit var friendresult: ActivityResultLauncher<Intent>
    private lateinit var imgadd: LinearLayout
    private lateinit var addmemberbtn: FloatingActionButton

    companion object {
        val nickList = mutableListOf("팀원", "팀원", "팀원", "팀장","","","","","")
        val nameList = mutableListOf("조병현", "장재원", "황진주", "박성수","","","","","")
        val mbtiList = mutableListOf("INFP", "INFP", "ENFP", "ESFJ", "","","","","","")
        val statusList = mutableListOf("왈랄랄루", "화이팅!", "안녕하세요!", "잘 부탁드려요!","","","","","")
        val titleList = mutableListOf("", "", "", "", "","","","","","")
        val contentList = mutableListOf(
            "연봉 10억 신입 모집합니다 공채하기 전에 빨리 연락 주세요!!!",
            "가 족같은 회사 신입 모집 평생 직장입니다 많은 지원 부탁드려요!!!",
            "삼성에 각 계열사에 계신 선배님들이 후배들을 위해 교육해주신답니다. 지원자 선착순으로 받습니다!!!",
            "","","","",""
        )
        val imageUrlList =
            mutableListOf("character2", "character7", "character11", "character1", "")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("LifecycleMainActivity", "onCreate")

        val mbtnback = findViewById<ImageButton>(R.id.mbackbtn)
        mbtnback.setOnClickListener {
            finish()
        }

        val imgBtnList = mutableListOf<ImageButton>(
            findViewById(R.id.mimgbtn1),
            findViewById(R.id.mimgbtn2),
            findViewById(R.id.mimgbtn3),
            findViewById(R.id.mimgbtn4),
        )
        addbtnList(imgBtnList)

        imgadd = findViewById(R.id.maddimg)
        addmemberbtn = findViewById(R.id.mbtnaddmember)

        addmemberbtn.setOnClickListener {
            val imgbtn = ImageButton(this)
            val resources = getResources()
            val width = resources.getDimensionPixelSize(R.dimen.width)
            val height = resources.getDimensionPixelSize(R.dimen.height)
            imgbtn.layoutParams = LinearLayout.LayoutParams(width,height)
            imgbtn.scaleType = ImageView.ScaleType.CENTER_CROP
            imgbtn.clipToOutline = true
            imgbtn.setBackgroundResource(R.drawable.round)
            imgbtn.setImageResource(R.drawable.zz)
            imgadd.addView(imgbtn)
            imgBtnList.add(imgbtn)
            addbtnList(imgBtnList)
        }
        val edit_content1 = findViewById<TextView>(R.id.mcontent1)
        val edit_content2 = findViewById<TextView>(R.id.mcontent2)
        val edit_content3 = findViewById<TextView>(R.id.mcontent3)
        val profile_name =findViewById<TextView>(R.id.mname)
        profile_name.text= intent.getStringExtra("dataFromSignInActivityName")
        if (contentList.size > 0) {
            edit_content1.setText(contentList[0])
        }

        if (contentList.size > 1) {
            edit_content2.setText(contentList[1])
        }
        if(contentList.size>2){
            edit_content3.setText(contentList[2])
        }

        val btnmenu = findViewById<ImageButton>(R.id.btnmenu)

        btnmenu.setOnClickListener { view ->
            val Menu = PopupMenu(this, view)
            Menu.menuInflater.inflate(R.menu.menu, Menu.menu)

            Menu.setOnMenuItemClickListener { menuItem ->
                when (menuItem.itemId) {
                    R.id.menu_item_1 -> {
                        val id = intent.getStringExtra("dataFromSignInActivityId")
                        val name = intent.getStringExtra("dataFromSignInActivityName")
                        val age = intent.getStringExtra("dataFromSignInActivityAge")
                        val mbti = intent.getStringExtra("dataFromSignInActivityMbti")

                        val intent = Intent(this, MyPage::class.java).apply {
                            putExtra("id", id)
                            putExtra("name", name)
                            putExtra("age", age)
                            putExtra("mbti", mbti)
                        }
                        startActivity(intent)
                        overridePendingTransition(R.anim.animation_in, R.anim.animation_out)
                        true
                    }
                    R.id.menu_item_2 -> {
                        val intent = Intent(this, MyAbility::class.java)
                        startActivity(intent)
                        overridePendingTransition(R.anim.animation_in, R.anim.animation_out)
                        true
                    }
                    else -> false
                }
            }
            Menu.show()
        }

        friendresult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == RESULT_OK) {
                val data = it.data
                if (data != null) {
                    val index = data.getIntExtra("index", -1)
                    if (index >= 0) {
                        nickList[index] = data.getStringExtra("inputNick") ?: ""
                        nameList[index] = data.getStringExtra("inputName") ?: ""
                        mbtiList[index] = data.getStringExtra("inputMbti") ?: ""
                        statusList[index] = data.getStringExtra("inputStatus") ?: ""
                        imageUrlList[index] = data.getStringExtra("imageUrl") ?: ""
                        Log.d("MainActivity imageUrlList", imageUrlList[index])
                        if (imageUrlList[index].isNotEmpty()) {
                            val imgBtn = imgBtnList[index]
                            val commu_img1 = findViewById<ImageView>(R.id.commu_img1)
                            val commu_img2 = findViewById<ImageView>(R.id.commu_img2)
                            val commu_img3 = findViewById<ImageView>(R.id.commu_img3)
                            val commu_name1 = findViewById<EditText>(R.id.commu_name1)
                            val commu_name2 = findViewById<EditText>(R.id.commu_name2)
                            val commu_name3 = findViewById<EditText>(R.id.commu_name3)
                            Picasso.get().load(imageUrlList[index]).error(R.drawable.question)
                                .into(imgBtn)
                            if (index == 0) {
                                Picasso.get().load(imageUrlList[index]).error(R.drawable.question)
                                    .into(commu_img1)
                                Log.d("MainActivityname", nameList[0])
                                commu_name1.setText(nameList[index])
                            } else if (index == 1) {
                                Picasso.get().load(imageUrlList[index]).error(R.drawable.question)
                                    .into(commu_img2)
                                commu_name2.setText(nameList[index])
                            }else if (index == 2) {
                                Picasso.get().load(imageUrlList[index]).error(R.drawable.question)
                                    .into(commu_img3)
                                commu_name3.setText(nameList[index])
                            }
                        }

                        nickList.add(nickList[index] ?: "")
                        nameList.add(nameList[index] ?: "")
                        mbtiList.add(mbtiList[index] ?: "")
                        statusList.add(statusList[index] ?: "")
                    }
                }
            }
        }
    }

    fun addbtnList(imgBtnList: MutableList<ImageButton>) {
        imgBtnList.forEachIndexed { index, num ->
            num.setOnClickListener {
                if (index < nickList.size && index < nameList.size &&
                    index < mbtiList.size && index < statusList.size
                ) {
                    val intent = Intent(this, FriendEdit::class.java)
                    intent.putExtra("index", index)
                    intent.putExtra("fenick", nickList[index])
                    intent.putExtra("fename", nameList[index])
                    intent.putExtra("fembti", mbtiList[index])
                    intent.putExtra("festatus", statusList[index])
                    intent.putExtra("imgBtn", imageUrlList[index])
                    Log.d("fromMainActivity imageUrlList", nickList[index])
                    friendresult.launch(intent)
                    overridePendingTransition(R.anim.animation_in, R.anim.animation_out)
                }
            }
        }
    }
    override fun onStart() {
        super.onStart()
        Log.d("LifecycleMainActivity", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("LifecycleMainActivity", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("LifecycleMainActivity", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("LifecycleMainActivity", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Lifecycle", "onDestroy")
    }
}


