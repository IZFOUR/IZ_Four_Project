package com.android.iz4

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity

class MyAbilityDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_myabilitydetail)


        var ProcessPlus = findViewById<Button>(R.id.DetailUpdate)
        var ABarProcess = findViewById<ProgressBar>(R.id.ABarProcess)
        var ABarDeadline = findViewById<ProgressBar>(R.id.ABarDeadLine)
        var textarea = findViewById<EditText>(R.id.memoone)
        var textarea2 = findViewById<EditText>(R.id.memotwo)

        ProcessPlus.setOnClickListener{
            ABarProcess.incrementProgressBy(20)

            //해당 코드 사용시 numberformatexception 오류발생
            var texttest = ABarProcess.progress.toString()
            var texttest2 = ABarDeadline.progress.toString()
            textarea.setText(texttest)

            //var value = ABarProcess.toString()

            var progressnum = texttest.toInt()
            var progressnum2 = texttest2.toInt()
            if(progressnum<progressnum2){
                ABarDeadline.getProgressDrawable().setColorFilter(
                    Color.RED, android.graphics.PorterDuff.Mode.SRC_IN);
            }
            else{ABarDeadline.getProgressDrawable().setColorFilter(
                Color.BLUE, android.graphics.PorterDuff.Mode.SRC_IN);}

        }



        var finish = findViewById<ImageButton>(R.id.BacktoMain)
        finish.setOnClickListener{
            finish()}
    }




}