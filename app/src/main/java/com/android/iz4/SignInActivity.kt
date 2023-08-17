package com.android.iz4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts

class SignInActivity : AppCompatActivity() {

    lateinit var signInLauncher: ActivityResultLauncher<Intent>
    var intent1_1_id: String? = null
    var intent2_1_psw: String? = null
    var intent3_1_name: String? = null
    var intent4_1_age: String? = null
    var intent5_1_mbti: String? = null
    companion object {
        var idList = mutableListOf<String>()
    }
    var pswList = mutableListOf<String>()
    var nameList = mutableListOf<String>()
    var ageList = mutableListOf<String>()
    var mbtiList = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)



        val edit_id = findViewById<EditText>(R.id.editTextTextEmailAddress)
        val edit_psw = findViewById<EditText>(R.id.editTextTextPassword)
        val btn_calllognin1_1 = findViewById<Button>(R.id.sibtnlogin)

        btn_calllognin1_1.setOnClickListener {
            val id = edit_id.text.toString()
            val psw = edit_psw.text.toString()

            if (!id.isEmpty() && !psw.isEmpty()) {
                val index = idList.indexOf(id)
                if (index >= 0 && id == idList[index] && psw == pswList[index]) {
                    val intent1 = Intent(this, MainActivity::class.java)
                    intent1.putExtra("dataFromSignInActivityId", idList[index])
                    intent1.putExtra("dataFromSignInActivityName", nameList[index])
                    intent1.putExtra("dataFromSignInActivityAge", ageList[index])
                    intent1.putExtra("dataFromSignInActivityMbti", mbtiList[index])

                    startActivity(intent1)
                    Toast.makeText(this, "로그인 되었습니다.", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "아이디/비밀번호를 확인해주세요", Toast.LENGTH_SHORT).show()
                }
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
                        intent1_1_id = data.getStringExtra("dataFromSignUpActivityId")
                        intent2_1_psw = data.getStringExtra("dataFromSignUpActivityPsw")
                        intent3_1_name = data.getStringExtra("dataFromSignUpActivityName")
                        intent4_1_age = data.getStringExtra("dataFromSignUpActivityAge")
                        intent5_1_mbti = data.getStringExtra("dataFromSignUpActivity")

                        idList.add(intent1_1_id ?: "")
                        pswList.add(intent2_1_psw ?: "")
                        nameList.add(intent3_1_name ?: "")
                        ageList.add(intent4_1_age ?: "")
                        mbtiList.add(intent5_1_mbti ?: "")

                        edit_id.setText(intent1_1_id)
                        edit_psw.setText(intent2_1_psw)
                    }
                }
            }
    }
}