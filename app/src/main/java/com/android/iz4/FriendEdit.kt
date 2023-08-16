package com.android.iz4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class FriendEdit : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_friendedit)

        val febtnback = findViewById<ImageButton>(R.id.febackbtn)
        febtnback.setOnClickListener {
            finish()
        }

    }
}