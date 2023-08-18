package com.android.iz4

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MyAbilityDetail : AppCompatActivity() {
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_myabilitydetail)


        var ProcessPlus = findViewById<Button>(R.id.DetailUpdate)
        var ABarProcess = findViewById<ProgressBar>(R.id.ABarProcess)
        var ABarDeadline = findViewById<ProgressBar>(R.id.ABarDeadLine)

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
            }
            else{ABarDeadline.getProgressDrawable().setColorFilter(
                Color.BLUE, android.graphics.PorterDuff.Mode.SRC_IN);}

        }

        memosave.setOnClickListener {
            var input = memoinput.text.toString()
            var one = memoone.text.toString()
            var two = memotwo.text.toString()
            var three = memothree.text.toString()
            var four = memofour.text.toString()
            var five = memofive.text.toString()
            var six = memosix.text.toString()
            var seven = memoseven.text.toString()
            var eight = memoeight.text.toString()
            var nine = memonine.text.toString()
            var ten = memoten.text.toString()

                if(memoone != null){
                memoone.setText(input)
                } else if(memotwo != null){
                    memotwo.setText(input)
                }
        }


        var finish = findViewById<ImageButton>(R.id.BacktoMain)
        finish.setOnClickListener{
            finish()}
    }




}