package com.android.iz4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout

class MyPageDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mypagedetail)

        var ib_back2 = findViewById<ImageView>(R.id.ib_back2)
        ib_back2.setOnClickListener {
            var intent = Intent(this, MyPage::class.java)
            finish()
        }

    }
}