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

        val imgBtnList = mutableListOf<ImageButton>(
            findViewById(R.id.mimgbtn1),
            findViewById(R.id.mimgbtn2),
            findViewById(R.id.mimgbtn3),
            findViewById(R.id.mimgbtn4),
        )
        addbtnList(imgBtnList)

        val imgadd = findViewById<LinearLayout>(R.id.maddimg)
        val addmemberbtn = findViewById<FloatingActionButton>(R.id.mbtnaddmember)

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
            val intent = Intent(this, MyPage::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.animation_in, R.anim.animation_out)
        }
        btnteam.setOnClickListener {
            val intent = Intent(this, MyAbility::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.animation_in, R.anim.animation_out)
        }
    }
    private fun addbtnList(imgBtnList: MutableList<ImageButton>){
        for( num in imgBtnList) {
            num.setOnClickListener {
                startActivity(Intent(this, FriendEdit::class.java))
                overridePendingTransition(R.anim.animation_in, R.anim.animation_out)
            }
        }
    }
}

