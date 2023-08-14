package com.android.iz4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast

// 조병현 형님: MyTeamPage -> MyAbility로 액티비티 이름 변경하였습니다.
// Theme에서 Parent부분 Material3 -> AppCompat 변경해서 액션바랑 기타 버튼들 색상이 변경되어있을겁니다.
class MyAbility : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_myability)

        //툴바에서 뒤로가기버튼 구현
        var finish = findViewById<ImageButton>(R.id.BackButton)
        finish.setOnClickListener{
            Toast.makeText(this, "메인페이지로 돌아가기", Toast.LENGTH_SHORT).show()
            finish()}


        val next = findViewById<Button>(R.id.testbutton)
        next.setOnClickListener{
            val intent = Intent(this, MyAbilityDetail::class.java)
            startActivity(intent)
        }
    }
}