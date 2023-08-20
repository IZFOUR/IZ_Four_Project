package com.android.iz4

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import com.google.android.material.floatingactionbutton.FloatingActionButton

// 재원이형님 이미지 파일들 해상도별 분리 후 추가해놔서 좀 작아져 있는데 도대채 이유를 모르겠습니다. =
// 혹시나해서 제사진으로 써보니까 이상은없습니다.. 혹시나 사진변경가능하시면 해상도별로 추가부탁드리겠습니다.
// Theme에서 Parent부분 Material3 -> AppCompat 변경해서 액션바랑 기타 버튼들 색상이 변경되어있을겁니다.
class MyPage : AppCompatActivity() {

    lateinit var MyPageLauncher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mypage)


        val id = findViewById<TextView>(R.id.tv_id)
        val name = findViewById<TextView>(R.id.tv_name)
        val age = findViewById<TextView>(R.id.tv_age)
        val mbti = findViewById<TextView>(R.id.tv_mbti)
        if (intent.hasExtra("id") || (intent.hasExtra("name") || (intent.hasExtra("age") || (intent.hasExtra(
                "mbti"
            ))))
        ) {

            id.text = "ID: " + intent.getStringExtra("id")
            name.text = "NAME: " + intent.getStringExtra("name")
            age.text = "AGE: " + intent.getStringExtra("age")
            mbti.text = "MBTI: " + intent.getStringExtra("mbti")


//        Log.d("MyPage", "id = $id, name = $name, age = $age, mbti = $mbti")
        }


        MyPageLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                if (it.resultCode == Activity.RESULT_OK) {
                    val memo = it.data
                    if (memo != null) {
                        val today = memo.getStringExtra("MyPageDetailAtivityToday") ?: ""
                        val detail = memo.getStringExtra("MyPageDetailAtivityDetail") ?: ""
                        val story = memo.getStringExtra("MyPageDetailAtivityStory") ?: ""
                        val mytoday = findViewById<TextView>(R.id.tv_today)
                        mytoday.text = today
                        val mydetail = findViewById<TextView>(R.id.tv_detail)
                        mydetail.text = detail


                    }
                }
            }

        val today = findViewById<TextView>(R.id.tv_today)
        val detail = findViewById<TextView>(R.id.tv_detail)
        if (intent.hasExtra("today") || (intent.hasExtra("detail") || (intent.hasExtra("imageView")))) {

            today.text = intent.getStringExtra("today")
            detail.text = intent.getStringExtra("detail")
        }




        val btn_image = findViewById<ImageView>(R.id.iv_safari)
        btn_image.setOnClickListener {
            val intent = Intent(this, MyPageDetail::class.java)
            MyPageLauncher.launch(intent)
        }


        var ib_back = findViewById<ImageView>(R.id.ib_back)
        ib_back.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            finish()
        }
    }
}