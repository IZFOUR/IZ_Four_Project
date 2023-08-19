package com.android.iz4

import android.annotation.SuppressLint
import android.content.SharedPreferences
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MyAbilityDetail : AppCompatActivity() {

    lateinit var pref: SharedPreferences
    lateinit var editor: SharedPreferences.Editor
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_myabilitydetail)

        //진행상황 부분
        var ProcessPlus = findViewById<Button>(R.id.DetailUpdate)
        var ABarProcess = findViewById<ProgressBar>(R.id.ABarProcess)
        var ABarDeadline = findViewById<ProgressBar>(R.id.ABarDeadLine)

        //메모부분
        var memosave = findViewById<Button>(R.id.memosave)
        var memoinput = findViewById<EditText>(R.id.memoinput)
        var memoone = findViewById<TextView>(R.id.memoone)
        var memotwo = findViewById<TextView>(R.id.memotwo)
        var memothree = findViewById<TextView>(R.id.memothree)
        var memofour = findViewById<TextView>(R.id.memofour)
        var memofive = findViewById<TextView>(R.id.memofive)
        var memosix = findViewById<TextView>(R.id.memosix)
        var memoseven = findViewById<TextView>(R.id.memoseven)
        var memoeight = findViewById<TextView>(R.id.memoeight)
        var memonine = findViewById<TextView>(R.id.memonine)
        var memoten = findViewById<TextView>(R.id.memoten)




        ProcessPlus.setOnClickListener{
            ABarProcess.incrementProgressBy(20)
            var texttest = ABarProcess.progress.toString()
            var texttest2 = ABarDeadline.progress.toString()

            var progressnum = texttest.toInt()
            var progressnum2 = texttest2.toInt()

            if(progressnum<progressnum2){
                ABarDeadline.getProgressDrawable().setColorFilter(
                    Color.RED, android.graphics.PorterDuff.Mode.SRC_IN);
            } else if(progressnum==progressnum2) {
                ABarDeadline.getProgressDrawable().setColorFilter(
                    Color.GREEN, android.graphics.PorterDuff.Mode.SRC_IN);
            }
            else{ABarDeadline.getProgressDrawable().setColorFilter(
                Color.BLUE, android.graphics.PorterDuff.Mode.SRC_IN);}

        }

        var index = 0
        val textList = arrayOf(memoone,memotwo,memothree,memofour,memofive,memosix,memoseven,memoeight,memonine,memoten)
        memosave.setOnClickListener {
            var input = memoinput.text.toString()


            if (index<textList.size){
                val textView = textList[index]
                textView.text = input
                index++
            }
            else {
                Toast.makeText(this,"메모는 10개만 지원합니다",Toast.LENGTH_SHORT).show()
            }



        }

        //MyAbility로 돌아가기
        var finish = findViewById<ImageButton>(R.id.BacktoMain)
        finish.setOnClickListener{
            finish()}
    }

    //이쯤에서 SharedPreferences 로 값 저장해주기
    private fun savedata(){

    }


}