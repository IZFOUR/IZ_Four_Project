package com.android.iz4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Nickname
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    lateinit var friendresult: ActivityResultLauncher<Intent>
    private lateinit var imgadd: LinearLayout
    private lateinit var addmemberbtn: FloatingActionButton
    companion object {
        val nickList = mutableListOf("aaa", "bbb", "ccc", "ddd","")
        val nameList = mutableListOf("aaa", "bbb", "ccc", "ddd","")
        val mbtiList = mutableListOf("aaa", "bbb", "ccc", "ddd","")
        val statusList = mutableListOf("aaa", "bbb", "ccc", "ddd","")
        val titleList = mutableListOf("","","","","")
        val contentList = mutableListOf("","","","","")
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
                    friendresult.launch(intent)
                    overridePendingTransition(R.anim.animation_in, R.anim.animation_out)
                }
            }
        }
    }
}


