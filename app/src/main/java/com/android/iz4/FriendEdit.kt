package com.android.iz4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast

class FriendEdit : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_friendedit)
        Log.d("Lifecycle", "onCreate")

        val febtnback = findViewById<ImageButton>(R.id.febackbtn)
        febtnback.setOnClickListener {
            finish()
        }
        val editnick = findViewById<EditText>(R.id.feNickEditView)
        val editname = findViewById<EditText>(R.id.feNameEditView)
        val editmbti = findViewById<EditText>(R.id.feMbtiEditView)
        val editstatus = findViewById<EditText>(R.id.feStatusEditView)

        val index = intent.getIntExtra("index", -1)
        val fenick = intent.getStringExtra("fenick") ?: ""
        val fename = intent.getStringExtra("fename") ?: ""
        val fembti = intent.getStringExtra("fembti") ?: ""
        val festatus = intent.getStringExtra("festatus") ?: ""

        editnick.setText(fenick)
        editname.setText(fename)
        editmbti.setText(fembti)
        editstatus.setText(festatus)

        val btnedit = findViewById<Button>(R.id.febtnedit)
        btnedit.setOnClickListener {
            val nick = editnick.text.toString()
            val name = editname.text.toString()
            val mbti = editmbti.text.toString()
            val status = editstatus.text.toString()



            if(!nick.isEmpty() && !name.isEmpty() && !mbti.isEmpty() && !status.isEmpty()){

                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("index", index)
                intent.putExtra("inputName",name)
                intent.putExtra("inputNick",nick)
                intent.putExtra("inputMbti",mbti)
                intent.putExtra("inputStatus",status)
                setResult(RESULT_OK,intent)
                finish()
            }else {
                Toast.makeText(this,"입력되지 않은 정보가 있습니다.", Toast.LENGTH_SHORT).show()
            }
        }
    }
    override fun onStart() {
        super.onStart()
        Log.d("Lifecycle", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Lifecycle", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("Lifecycle", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("Lifecycle", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Lifecycle", "onDestroy")
    }
}



