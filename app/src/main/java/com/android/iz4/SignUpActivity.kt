package com.android.iz4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.android.iz4.User
import com.android.iz4.UserListData

class SignUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        val edit_name2 = findViewById<EditText>(R.id.suNameEditView)
        val edit_id2 = findViewById<EditText>(R.id.suIdEditView)
        val edit_psw2 = findViewById<EditText>(R.id.suPwEditView)
        val edit_age2 = findViewById<EditText>(R.id.suAgeEditView)
        val edit_mbti2 = findViewById<EditText>(R.id.suMbtiEditView)
        val button_calljoin2_2 = findViewById<Button>(R.id.subtnjoin)
        val btn_check = findViewById<Button>(R.id.btncheck)

        fun isValidEmail(email: String): Boolean {
            val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
            return email.matches(emailPattern.toRegex())
        }
        // 실시간 이메일 유효성 검사
        edit_id2.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if (!isValidEmail(s.toString())) {
                    edit_id2.error = "올바른 이메일 주소를 입력하세요."
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })

        // 비밀번호 유효성 검사 함수 / 8자 이상이며 숫자 + 영문이어야함(최소 1개씩)
        fun isValidPassword(password: String): Boolean {
            return password.length >= 8 && password.any { it.isDigit() } && password.any { it.isLetter() }
        }

        // 실시간 비밀번호 유효성 검사
        edit_psw2.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if (!isValidPassword(s.toString())) {
                    edit_psw2.error = "올바른 비밀번호를 입력하세요.(숫자,영문 최소1개 이상/총 8자이상)."
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })

        btn_check.setOnClickListener {
            val id2 = edit_id2.text.toString()
            val idcheck = idCheck(id2)
            if (!id2.isEmpty()) {
                if (idcheck) {
                    Toast.makeText(this, "중복된 아이디(이메일)가 존재 합니다.", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "사용 가능한 아이디(이메일) 입니다.(다만, 이메일형식이 아닐시 가입이 불가합니다.)", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "아이디(이메일)를 입력해주세요", Toast.LENGTH_SHORT).show()
            }
        }

        button_calljoin2_2.setOnClickListener {
            val name2 = edit_name2.text.toString()
            val id2 = edit_id2.text.toString()
            val psw2 = edit_psw2.text.toString()
            val age2 = edit_age2.text.toString()
            val mbti2 = edit_mbti2.text.toString()

            if (name2.isNotBlank() && id2.isNotBlank() && psw2.isNotBlank() && age2.isNotBlank() && mbti2.isNotBlank()) {
                if (idCheck(id2)) {
                    Toast.makeText(this, "아이디(이메일)가 중복됩니다.", Toast.LENGTH_SHORT).show()
                } else if (!isValidEmail(id2)) { // 이메일 유효성 검사 추가
                    Toast.makeText(this, "올바른 이메일 주소를 입력하세요.", Toast.LENGTH_SHORT).show()
                } else if (!isValidPassword(psw2)) { // 비밀번호 유효성 검사 추가
                    Toast.makeText(this, "올바른 비밀번호를 입력하세요.(숫자,영문 최소1개 이상/총 8자이상)", Toast.LENGTH_SHORT).show()
                } else {
                    val intent2_1 = Intent().apply {
                        putExtra("dataFromSignUpActivityName", name2)
                        putExtra("dataFromSignUpActivityId", id2)
                        putExtra("dataFromSignUpActivityPsw", psw2)
                        putExtra("dataFromSignUpActivityAge", age2)
                        putExtra("dataFromSignUpActivityMbti", mbti2)
                    }
                    setResult(RESULT_OK, intent2_1)
                    finish()
                }
            } else {
                Toast.makeText(this, "입력되지 않은 정보가 있습니다.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun idCheck(id: String): Boolean {
        return UserListData.userList.any { it.id == id }
    }
}