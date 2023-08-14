package com.android.iz4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast

class MyAbilityDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_myabilitydetail)

        var finish = findViewById<ImageButton>(R.id.BacktoMain)
        finish.setOnClickListener{
            Toast.makeText(this, "마이팀 메인페이지로 돌아가기", Toast.LENGTH_SHORT).show()
            finish()}
    }
}