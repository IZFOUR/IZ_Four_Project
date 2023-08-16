package com.android.iz4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast


//(ViewBinding, Fragment, RecyclerView, Adapter는 사용하지 말아주세요.)
//7777I에엙 그럼 뭘 사용해야하지
class MyAbility : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_myability)

        //툴바에서 뒤로가기버튼 구현
        var finish = findViewById<ImageButton>(R.id.BackButton)
        finish.setOnClickListener{
            Toast.makeText(this, "메인페이지로 돌아가기", Toast.LENGTH_SHORT).show()
            finish()}

        //디테일 페이지로 넘겨주기
        val next = findViewById<Button>(R.id.AtoDetail)
        next.setOnClickListener{
            val intent = Intent(this, MyAbilityDetail::class.java)
            startActivity(intent)
        }
    }
}