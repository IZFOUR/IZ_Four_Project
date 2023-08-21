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
                    edit_id2.error = getString(R.string.EdIt_IdError)
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
                    edit_psw2.error = getString(R.string.EdIt_PwError)
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
                    Toast.makeText(this, R.string.Dlc_Email, Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, R.string.Available_Email, Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, R.string.Pl_Id, Toast.LENGTH_SHORT).show()
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
                    Toast.makeText(this, R.string.Dlc_Email, Toast.LENGTH_SHORT).show()
                } else if (!isValidEmail(id2)) { // 이메일 유효성 검사 추가
                    Toast.makeText(this, R.string.EdIt_IdError, Toast.LENGTH_SHORT).show()
                } else if (!isValidPassword(psw2)) { // 비밀번호 유효성 검사 추가
                    Toast.makeText(this, R.string.EdIt_PwError, Toast.LENGTH_SHORT).show()
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
                Toast.makeText(this, R.string.No_Info, Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun idCheck(id: String): Boolean {
        return UserListData.userList.any { it.id == id }
    }
}