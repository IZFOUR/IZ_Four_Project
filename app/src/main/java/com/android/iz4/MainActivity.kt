package com.android.iz4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Nickname
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.squareup.picasso.Picasso

class MainActivity : AppCompatActivity() {
    lateinit var friendresult: ActivityResultLauncher<Intent>
    private lateinit var imgadd: LinearLayout
    private lateinit var addmemberbtn: FloatingActionButton
    companion object {
        val nickList = mutableListOf("팀원", "팀원", "팀원", "팀장","")
        val nameList = mutableListOf("조병현", "장재원", "황진주", "박성수","")
        val mbtiList = mutableListOf("INFP", "INFP", "ENFP", "ESFJ","")
        val statusList = mutableListOf("왈랄랄루", "화이팅!", "안녕하세요!", "잘 부탁드려요!","")
        val titleList = mutableListOf("","","","","")
        val contentList = mutableListOf("","","","","")
        val imageUrlList = mutableListOf("character2","character7","character11","character1","")
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
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
            imgbtn.scaleType = ImageView.ScaleType.CENTER_INSIDE
            imgbtn.clipToOutline = true
            imgbtn.setBackgroundResource(R.drawable.round)
            imgbtn.setImageResource(R.drawable.zz)
            imgadd.addView(imgbtn)
            imgBtnList.add(imgbtn)
            addbtnList(imgBtnList)
        }

        val btnpage = findViewById<Button>(R.id.mbtnpage)
        val btnteam = findViewById<Button>(R.id.mbtnablility)

        btnpage.setOnClickListener {
            val id = intent.getStringExtra("dataFromSignInActivityId")
            val name = intent.getStringExtra("dataFromSignInActivityName")
            val age = intent.getStringExtra("dataFromSignInActivityAge")
            val mbti = intent.getStringExtra("dataFromSignInActivityMbti")
            val intent = Intent(this, MyPage::class.java)
            intent.putExtra("id",id)
            intent.putExtra("name",name)
            intent.putExtra("age",age)
            intent.putExtra("mbti",mbti)

            startActivity(intent)
            overridePendingTransition(R.anim.animation_in, R.anim.animation_out)
        }
        btnteam.setOnClickListener {
            val intent = Intent(this, MyAbility::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.animation_in, R.anim.animation_out)
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
                        titleList[index] = data.getStringExtra("inputTitle")?:""
                        contentList[index] = data.getStringExtra("inputContent") ?:""
                        imageUrlList[index] = data.getStringExtra("imageUrl") ?:""
                        Log.d("MainActivity imageUrlList",imageUrlList[index] )
                        if (imageUrlList[index].isNotEmpty()) {
                            val imgBtn = imgBtnList[index]
                            val commu_img1 = findViewById<ImageView>(R.id.commu_img1)
                            val commu_img2 = findViewById<ImageView>(R.id.commu_img2)
                            val commu_name1 = findViewById<EditText>(R.id.commu_name1)
                            val commu_name2 = findViewById<EditText>(R.id.commu_name2)
                            Picasso.get().load(imageUrlList[index]).error(R.drawable.question).into(imgBtn)
                            if (index == 0) {
                                Picasso.get().load(imageUrlList[index]).error(R.drawable.question).into(commu_img1)
                                commu_name1.setText(nameList[index])
                            } else if (index == 1) {
                                Picasso.get().load(imageUrlList[index]).error(R.drawable.question).into(commu_img2)
                                commu_name2.setText(nameList[index])
                            }
                        }

                        nickList.add(nickList[index] ?: "")
                        nameList.add(nameList[index] ?: "")
                        mbtiList.add(mbtiList[index] ?: "")
                        statusList.add(statusList[index] ?: "")
                        titleList.add(titleList[index] ?:"")
                        contentList.add(contentList[index] ?:"")
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
                    intent.putExtra("fetitle", titleList[index])
                    intent.putExtra("fecontent", contentList[index])
                    intent.putExtra("imgBtn",imageUrlList[index])
                    Log.d("fromMainActivity imageUrlList", nickList[index])
                    friendresult.launch(intent)
                    overridePendingTransition(R.anim.animation_in, R.anim.animation_out)
                }
            }
        }
    }
}


