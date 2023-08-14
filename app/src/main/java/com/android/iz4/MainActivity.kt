package com.android.iz4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnpage = findViewById<Button>(R.id.mbtnpage)
        val btnteam = findViewById<Button>(R.id.mbtnteam)

        btnpage.setOnClickListener {
            val intent = Intent(this, MyPage::class.java )
            startActivity(intent)
        }
        btnteam.setOnClickListener {
            val intent = Intent(this, MyAbility::class.java)
            startActivity(intent)
        }

    }
}