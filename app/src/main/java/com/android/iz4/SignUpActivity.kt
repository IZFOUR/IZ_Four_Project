package com.android.iz4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.viewmodel.CreationExtras
import com.android.iz4.R

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        val edit_name2 = findViewById<EditText>(R.id.suIdEditView)
        val edit_id2 = findViewById<EditText>(R.id.suNameEditView)
        val edit_psw2 = findViewById<EditText>(R.id.suPwEditView)
        val edit_age2 = findViewById<EditText>(R.id.suAgeEditView)
        val edit_mbti2 = findViewById<EditText>(R.id.suMbtiEditView)
        val button_calljoin2_2 = findViewById<Button>(R.id.subtnjoin)
        val btn_check = findViewById<Button>(R.id.btncheck)

        btn_check.setOnClickListener {
            val id2 = edit_id2.text.toString()
            val idcheck = idCheck(id2)
            if(!id2.isEmpty()){
                if(idcheck){
                    Toast.makeText(this,"중복된 아이디가 존재 합니다.",Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this,"사용 가능한 아이디 입니다.",Toast.LENGTH_SHORT).show()
                }
            }
            else{
                Toast.makeText(this,"아이디를 입력해주세요",Toast.LENGTH_SHORT).show()
            }
        }
        button_calljoin2_2.setOnClickListener {
            val name2 = edit_name2.text.toString()
            val id2 = edit_id2.text.toString()
            val psw2 = edit_psw2.text.toString()
            val age2 = edit_age2.text.toString()
            val mbti2 = edit_mbti2.text.toString()

            if (!name2.isEmpty() && !id2.isEmpty() && !psw2.isEmpty() && !age2.isEmpty()&& !mbti2.isEmpty()) {
                val idcheck = idCheck(id2)
                if (idcheck) {
                    Toast.makeText(this, "아이디가 중복됩니다.", Toast.LENGTH_SHORT).show()
                } else {
                    val intent2_1 = Intent()
                    intent2_1.putExtra("dataFromSignUpActivityName", name2)
                    intent2_1.putExtra("dataFromSignUpActivityId", id2)
                    intent2_1.putExtra("dataFromSignUpActivityPsw", psw2)
                    intent2_1.putExtra("dataFromSignUpActivityAge", age2)
                    intent2_1.putExtra("dataFromSignUpActivity",mbti2)
                    setResult(RESULT_OK,intent2_1)
                    finish()
                }
            } else {
                Toast.makeText(this, "입력되지 않은 정보가 있습니다.", Toast.LENGTH_SHORT).show()
            }
        }
    }
    private fun idCheck(id: String): Boolean {
        return SignInActivity.idList.contains(id)
    }
}