package com.android.iz4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast

class MyPageDetail : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mypagedetail)

        val edit_title = findViewById<EditText>(R.id.tv_mytitle)
        val edit_stt = findViewById<EditText>(R.id.et_stt)
        val btn_addmemo = findViewById<Button>(R.id.ib_addmemo)

        btn_addmemo.setOnClickListener {
            val title = edit_title.text.toString()
            val stt = edit_stt.text.toString()

            if(!title.isEmpty() || !stt.isEmpty()) {
                val intent = Intent()
                intent.putExtra("inputTitle",title)
                intent.putExtra("inputStt",stt)
                setResult(RESULT_OK,intent)
                finish()
            }
        }

        var ib_back2 = findViewById<ImageView>(R.id.ib_back2)
        ib_back2.setOnClickListener {
            var intent = Intent(this, MyPage::class.java)
            finish()
        }

    }
}