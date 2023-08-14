package com.android.iz4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        val edit_name = findViewById<EditText>(R.id.suNameEditView)
        val edit_id = findViewById<EditText>(R.id.suIdEditView)
        val edit_psw = findViewById<EditText>(R.id.suPwEditView)
        val edit_age = findViewById<EditText>(R.id.suAgeEditView)
        val edit_mbti = findViewById<EditText>(R.id.suMbtiEditView)
        val btn_join = findViewById<Button>(R.id.subtnjoin)

        btn_join.setOnClickListener {
            val name = edit_name.text.toString()
            val id = edit_id.text.toString()
            val psw = edit_psw.text.toString()
            val age = edit_age.text.toString()
            val mbti = edit_mbti.text.toString()

            if(!name.isEmpty() && !id.isEmpty() && !psw.isEmpty() && !age.isEmpty() && !mbti.isEmpty()){
                val intent = Intent()
                intent.putExtra("inputName",name)
                intent.putExtra("inputId",id)
                intent.putExtra("inputPsw",psw)
                intent.putExtra("inputAge",age)
                intent.putExtra("inputMbti",mbti)
                setResult(RESULT_OK,intent)
                finish()
            }else {
                Toast.makeText(this,"입력되지 않은 정보가 있습니다.",Toast.LENGTH_SHORT).show()
            }
        }
    }
}