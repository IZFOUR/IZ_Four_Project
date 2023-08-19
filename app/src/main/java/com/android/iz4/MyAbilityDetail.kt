package com.android.iz4

import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MyAbilityDetail : AppCompatActivity() {
    var progressnum: Int = 0
    var progressnum2: Int = 0
    var texttest = ""
    var texttest2 = ""
    var MemoList = mutableListOf("","","","","","","","","","")
    var memoList = arrayListOf("", "", "", "", "", "", "", "", "", "")
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_myabilitydetail)


        var ProcessPlus = findViewById<Button>(R.id.DetailUpdate)
        var ABarProcess = findViewById<ProgressBar>(R.id.abd_ABarProcess)
        var ABarDeadline = findViewById<ProgressBar>(R.id.abd_ABarDeadLine)

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

        val text_title = findViewById<TextView>(R.id.abd_title)

        val index = intent.getIntExtra("index", -1)
        val title = intent.getStringExtra("abtitle") ?: ""
        val mbd_progress = intent.getStringExtra("abprogressnum") ?: ""
//        val mbd_deadline = intent.getStringExtra("abdeadline") ?:""
        ABarProcess.progress = mbd_progress.toInt()
//        ABarDeadline.progress =mbd_progress.toInt()

        val abmemoList = intent.getStringArrayListExtra("abmemoList")
        if (abmemoList != null) {
            MemoList.clear()
            MemoList.addAll(abmemoList)

            memoone.text = MemoList[0]
            memotwo.text = MemoList[1]
            memothree.text = MemoList[2]
            memofour.text = MemoList[3]
            memofive.text = MemoList[4]
            memosix.text = MemoList[5]
            memoseven.text = MemoList[6]
            memoeight.text = MemoList[7]
            memonine.text = MemoList[8]
            memoten.text = MemoList[9]
        }





        text_title.setText(title)


        ProcessPlus.setOnClickListener {
            ABarProcess.incrementProgressBy(20)


            texttest = ABarProcess.progress.toString()
            texttest2 = ABarDeadline.progress.toString()


            progressnum = texttest.toInt()
            progressnum2 = texttest2.toInt()
            if (progressnum < progressnum2) {
                ABarDeadline.getProgressDrawable().setColorFilter(
                    Color.RED, android.graphics.PorterDuff.Mode.SRC_IN
                )
            } else if (progressnum == progressnum2) {
                ABarDeadline.getProgressDrawable().setColorFilter(
                    Color.GREEN, android.graphics.PorterDuff.Mode.SRC_IN
                )
            } else {
                ABarDeadline.getProgressDrawable().setColorFilter(
                    Color.BLUE, android.graphics.PorterDuff.Mode.SRC_IN
                )
            }


        }

        var memoIndex = 0
        memosave.setOnClickListener {
            var input = memoinput.text.toString()

            when (memoIndex) {
                0 -> memoone.text = input
                1 -> memotwo.text = input
                2 -> memothree.text = input
                3 -> memofour.text = input
                4 -> memofive.text = input
                5 -> memosix.text = input
                6 -> memoseven.text = input
                7 -> memoeight.text = input
                8 -> memonine.text = input
                9 -> memoten.text = input
            }
            memoIndex++
            if (memoIndex >= 10) {
                memoIndex = 0
            }
            memoList = arrayListOf(
                memoone.text.toString(),
                memotwo.text.toString(),
                memothree.text.toString(),
                memofour.text.toString(),
                memofive.text.toString(),
                memosix.text.toString(),
                memoseven.text.toString(),
                memoeight.text.toString(),
                memonine.text.toString(),
                memoten.text.toString()
            )
            Log.d("LifecycleMyAbility", "memoList 넘겨주는거맞아?${memoList[1]}")
        }




        var finish = findViewById<ImageButton>(R.id.BacktoMain)
        finish.setOnClickListener {
            finish()
        }

        val saveButton = findViewById<Button>(R.id.abd_savebutton)
        saveButton.setOnClickListener {

            val intent = Intent(this, MyAbility::class.java)
            intent.putExtra("index", index)
            intent.putExtra("abdprogressnum", texttest)
            intent.putExtra("abddeadlinenum", texttest2)
            intent.putStringArrayListExtra("abdmemoList", ArrayList(memoList))

            setResult(RESULT_OK, intent)
            finish()
        }
    }


}