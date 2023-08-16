package com.android.iz4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast

class FriendEdit : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_friendedit)

        val febtnback = findViewById<ImageButton>(R.id.febackbtn)
        febtnback.setOnClickListener {
            finish()
        }
        val editnick = findViewById<EditText>(R.id.feNickEditView)
        val editname = findViewById<EditText>(R.id.feNameEditView)
        val editmbti = findViewById<EditText>(R.id.feMbtiEditView)
        val editstatus = findViewById<EditText>(R.id.feStatusEditView)

        val btnedit = findViewById<Button>(R.id.febtnedit)
        btnedit.setOnClickListener {
            val nick = editnick.text.toString()
            val name = editname.text.toString()
            val mbti = editmbti.text.toString()
            val status = editstatus.text.toString()

            if(!nick.isEmpty() && !name.isEmpty() && !mbti.isEmpty() && !status.isEmpty()){
                val intent = Intent()
                intent.putExtra("inputName",name)
                intent.putExtra("inputNick",nick)
                intent.putExtra("inputMbti",mbti)
                intent.putExtra("inputStatus",status)
                setResult(RESULT_OK,intent)
            }else {
                Toast.makeText(this,"입력되지 않은 정보가 있습니다.", Toast.LENGTH_SHORT).show()
            }

        }
    }
}

//data class MemberManager(val name: String, val mbti: String, val status: String)
//object Members {
//    val mainmember: MutableList<MemberManager> = mutableListOf(
//        MemberManager("가", "a", ""),
//        MemberManager("나", "b", ""),
//        MemberManager("다", "c", ""),
//        MemberManager("라", "d", ""),
//    )
//    fun addmembers(membermanager: MemberManager) {
//        mainmember.add(membermanager)
//    }
//}

