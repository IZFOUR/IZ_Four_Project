package com.android.iz4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton

// 재원이형님 이미지 파일들 해상도별 분리 후 추가해놔서 좀 작아져 있는데 도대채 이유를 모르겠습니다.
// 혹시나해서 제사진으로 써보니까 이상은없습니다.. 혹시나 사진변경가능하시면 해상도별로 추가부탁드리겠습니다.
// Theme에서 Parent부분 Material3 -> AppCompat 변경해서 액션바랑 기타 버튼들 색상이 변경되어있을겁니다.
class MyPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mypage)

        var finish = findViewById<ImageView>(R.id.ib_back)
        finish.setOnClickListener{
            Toast.makeText(this, "메인페이지로 돌아가기", Toast.LENGTH_SHORT).show()
            finish()}
    }
}