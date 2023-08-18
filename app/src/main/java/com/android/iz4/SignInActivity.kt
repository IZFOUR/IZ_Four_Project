package com.android.iz4

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

data class User(
    val id: String,
    val password: String,
    val name: String,
    val age: String,
    val mbti: String
)

class SignInActivity : AppCompatActivity() {

    lateinit var signInLauncher: ActivityResultLauncher<Intent>
    companion object {
        val userList = mutableListOf<User>() // 유저정보저장
    }
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)

        val edit_id = findViewById<EditText>(R.id.editTextTextEmailAddress)
        val edit_psw = findViewById<EditText>(R.id.editTextTextPassword)
        val btn_calllognin1_1 = findViewById<Button>(R.id.sibtnlogin)

        btn_calllognin1_1.setOnClickListener {
            val id = edit_id.text.toString()
            val psw = edit_psw.text.toString()

            val user = userList.find { it.id == id && it.password == psw }
            if (user != null) {
                val intent1 = Intent(this, MainActivity::class.java)
                intent1.putExtra("dataFromSignInActivityId", user.id)
                intent1.putExtra("dataFromSignInActivityName", user.name)
                intent1.putExtra("dataFromSignInActivityAge", user.age)
                intent1.putExtra("dataFromSignInActivityMbti", user.mbti)

                startActivity(intent1)
                Toast.makeText(this, "로그인 되었습니다.", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "아이디/비밀번호를 확인해주세요", Toast.LENGTH_SHORT).show()
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
                        userList.add(newUser)
                        edit_id.setText(newUser.id)
                        edit_psw.setText(newUser.password)
                    }
                }
            }
    }
}