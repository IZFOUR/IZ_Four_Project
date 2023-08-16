package com.android.iz4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.LinearLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val mainmember: MutableList<MemberManager> = mutableListOf(
//            MemberManager("가", "a", ""),
//            MemberManager("나", "b", ""),
//            MemberManager("다", "c", ""),
//            MemberManager("라", "d", ""),
//            MemberManager("마", "e", ""),
//        )
//        for (member in mainmember){
//            Members.addmembers(member)
//        }
//        val imgbtn1 = findViewById<ImageButton>(R.id.mimgbtn1)
//        val imgbtn2 = findViewById<ImageButton>(R.id.mimgbtn2)
//        val imgbtn3 = findViewById<ImageButton>(R.id.mimgbtn3)
//        val imgbtn4 = findViewById<ImageButton>(R.id.mimgbtn4)
//
//        imgbtn1.setOnClickListener {
//            startActivity(Intent(this, OtherPage::class.java))
//        }
//        imgbtn2.setOnClickListener {
//            startActivity(Intent(this, OtherPage::class.java))
//        }
//        imgbtn3.setOnClickListener {
//            startActivity(Intent(this, OtherPage::class.java))
//        }
//        imgbtn4.setOnClickListener {
//            startActivity(Intent(this, OtherPage::class.java))
//        }

        val imgBtn= listOf(
            R.id.mimgbtn1,
            R.id.mimgbtn2,
            R.id.mimgbtn3,
            R.id.mimgbtn4,
        )
        for(imgbtn in imgBtn){
            val num = findViewById<ImageButton>(imgbtn)
            num.setOnClickListener {
                startActivity(Intent(this, FriendEdit::class.java))
                overridePendingTransition(R.anim.animation_in ,R.anim.animation_out)
            }
        }

        val imgadd = findViewById<LinearLayout>(R.id.maddimg)
        val addmemberbtn = findViewById<FloatingActionButton>(R.id.mbtnaddmember)

        addmemberbtn.setOnClickListener {
            val imgbtn = ImageButton(this)
            imgbtn.scaleType = ImageView.ScaleType.CENTER_INSIDE
            imgbtn.clipToOutline = true
            imgbtn.setBackgroundResource(R.drawable.round)
            imgbtn.setImageResource(R.drawable.zz)
            imgadd.addView(imgbtn)

            imgbtn.setOnClickListener {
                startActivity(Intent(this, FriendEdit::class.java))
                overridePendingTransition(R.anim.animation_in ,R.anim.animation_out)
            }
        }

        val btnpage = findViewById<Button>(R.id.mbtnpage)
        val btnteam = findViewById<Button>(R.id.mbtnablility)

        btnpage.setOnClickListener {
            val intent = Intent(this, MyPage::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.animation_in ,R.anim.animation_out)
        }
        btnteam.setOnClickListener {
            val intent = Intent(this, MyAbility::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.animation_in ,R.anim.animation_out)
        }
    }
}

//data class MemberManager(val name: String, val mbti: String, val status: String)
//object Members {
//    val members: MutableList<MemberManager> = mutableListOf()
//    fun addmembers(membermanager: MemberManager) {
//        members.add(membermanager)
//    }
//}