package com.android.iz4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import com.google.android.material.floatingactionbutton.FloatingActionButton

// 재원이형님 이미지 파일들 해상도별 분리 후 추가해놔서 좀 작아져 있는데 도대채 이유를 모르겠습니다. =
// 혹시나해서 제사진으로 써보니까 이상은없습니다.. 혹시나 사진변경가능하시면 해상도별로 추가부탁드리겠습니다.
// Theme에서 Parent부분 Material3 -> AppCompat 변경해서 액션바랑 기타 버튼들 색상이 변경되어있을겁니다.
class MyPage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mypage)

        val id = intent.getStringExtra("id")
        val name = intent.getStringExtra("name")
        val age = intent.getStringExtra("age")
        val mbti = intent.getStringExtra("mbti")
        Log.d("MyPage", "id = $id, name = $name, age = $age, mbti = $mbti")


        val btn_memo = findViewById<FloatingActionButton>(R.id.ftActBtn)
        btn_memo.setOnClickListener {
            val intent = Intent(this,MyPageDetail::class.java)
            startActivity(intent)
        }

        var ib_back = findViewById<ImageView>(R.id.ib_back)
        ib_back.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            finish()
        }
    }
}