package com.android.iz4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ProgressBar
import android.widget.Toast

class MyAbilityDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_myabilitydetail)


        var ProcessPlus = findViewById<Button>(R.id.DetailUpdate)
        var ABarProcess = findViewById<ProgressBar>(R.id.ABarProcess)
        var textarea = findViewById<EditText>(R.id.testarea)
        ProcessPlus.setOnClickListener{
            ABarProcess.incrementProgressBy(20)

            //해당 코드 사용시 numberformatexception 오류발생
            var texttest = ABarProcess.toString()
            textarea.setText("texttest")

            //var value = ABarProcess.toString()



        }



        var finish = findViewById<ImageButton>(R.id.BacktoMain)
        finish.setOnClickListener{
            finish()}
    }




}