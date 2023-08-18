package com.android.iz4

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MyPageDetail2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mypagedetail2)

        val btn_AddMemo2 = findViewById<Button>(R.id.btn_addmemo2)
        val edit_today2 = findViewById<EditText>(R.id.et_today2)
        val edit_detail2 = findViewById<EditText>(R.id.et_stt2)
        val edit_story2 = findViewById<EditText>(R.id.et_story2)

        btn_AddMemo2.setOnClickListener {
            val today2 = edit_today2.text.toString()
            val detail2 = edit_detail2.text.toString()
            val story2 = edit_story2.text.toString()

            val intent2 = Intent(this, MyPage::class.java).apply {
                putExtra("MyPageDetail2AtivityTitle", today2)
                putExtra("MyPageDetail2AtivityDetail", detail2)
                putExtra("MyPageDetail2AtivityStory", story2)
            }
            Toast.makeText(this, "저장되었습니다.", Toast.LENGTH_SHORT).show()
            setResult(RESULT_OK, intent2)
            finish()
        }
        var ib_back3 = findViewById<ImageView>(R.id.ib_back3)
        ib_back3.setOnClickListener {
            var intent = Intent(this, MyPage::class.java)
            finish()
        }

    }
}
