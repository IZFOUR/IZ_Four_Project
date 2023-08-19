package com.android.iz4

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.android.iz4.User
import com.android.iz4.UserListData

class SignInActivity : AppCompatActivity() {

    lateinit var signInLauncher: ActivityResultLauncher<Intent>
    private lateinit var edit_id: EditText  //아이디 입력란 나중에 초기화
    private lateinit var edit_psw: EditText  //패스워드 입력란 나중에 초기화

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)

        edit_id = findViewById(R.id.editTextTextEmailAddress)
        edit_psw = findViewById(R.id.editTextTextPassword)
        val btn_calllognin1_1 = findViewById<Button>(R.id.sibtnlogin)

        fun isValidEmail(email: String): Boolean {
            val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
            return email.matches(emailPattern.toRegex())  //이메일 유효성 검사함수
        }

        // 실시간 이메일 유효성 검사
        edit_id.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if (!isValidEmail(s.toString())) {
                    edit_id.error = "올바른 이메일 주소를 입력하세요."
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // Nothing to do here
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // Nothing to do here
            }
        })

        // 비밀번호 유효성 검사 함수 / 8자 이상이며 숫자 + 영문이어야함
        fun isValidPassword(password: String): Boolean {
            return password.length >= 8 && password.any { it.isDigit() } && password.any { it.isLetter() }
        }

        // 실시간 비밀번호 유효성 검사
        edit_psw.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if (!isValidPassword(s.toString())) {
                    edit_psw.error = "올바른 비밀번호를 입력하세요."
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
        })

        btn_calllognin1_1.setOnClickListener {
            val id = edit_id.text.toString()
            val psw = edit_psw.text.toString()

            val user = UserListData.userList.find { it.id == id && it.password == psw }
            if (user != null) {
                val intent1 = Intent(this, MainActivity::class.java)
                intent1.putExtra("dataFromSignInActivityId", user.id)
                intent1.putExtra("dataFromSignInActivityName", user.name)
                intent1.putExtra("dataFromSignInActivityAge", user.age)
                intent1.putExtra("dataFromSignInActivityMbti", user.mbti)

                startActivity(intent1)
                Toast.makeText(this, "로그인 되었습니다.", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "아이디(이메일)/비밀번호를 확인해주세요", Toast.LENGTH_SHORT).show()
            }
        }

        val btn_calljoin2_1 = findViewById<Button>(R.id.sibtnjoin)
        btn_calljoin2_1.setOnClickListener {
            val intent2_1 = Intent(this, SignUpActivity::class.java)
            signInLauncher.launch(intent2_1)
        }

        signInLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == RESULT_OK) {
                    val data = result.data
                    if (data != null) {
                        val newUser = User(
                            id = data.getStringExtra("dataFromSignUpActivityId") ?: "",
                            password = data.getStringExtra("dataFromSignUpActivityPsw") ?: "",
                            name = data.getStringExtra("dataFromSignUpActivityName") ?: "",
                            age = data.getStringExtra("dataFromSignUpActivityAge") ?: "",
                            mbti = data.getStringExtra("dataFromSignUpActivityMbti") ?: ""
                        )
                        UserListData.userList.add(newUser)
                        edit_id.setText(newUser.id)
                        edit_psw.setText(newUser.password)
                    }
                }
            }
    }
}
object UserListData {
    val userList: MutableList<User> = mutableListOf()
}