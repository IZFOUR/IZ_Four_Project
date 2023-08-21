package com.android.iz4

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MyAbilityDetail : AppCompatActivity() {
    companion object{var progressnum: Int = 0}
    var progressnum2: Int = 77
    var texttest = ""
    var texttest2 = ""
    var MemoList = mutableListOf("", "", "", "", "", "", "", "", "", "")
    var memoList = arrayListOf("", "", "", "", "", "", "", "", "", "")

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_myabilitydetail)


        val ProcessPlus = findViewById<Button>(R.id.DetailUpdate)
        val ABarProcess = findViewById<ProgressBar>(R.id.abd_ABarProcess)
        val ABarDeadline = findViewById<ProgressBar>(R.id.abd_ABarDeadLine)

        val memosave = findViewById<Button>(R.id.memosave)
        val memoinput = findViewById<EditText>(R.id.memoinput)
        val memoone = findViewById<TextView>(R.id.memoone)
        val memotwo = findViewById<TextView>(R.id.memotwo)
        val memothree = findViewById<TextView>(R.id.memothree)
        val memofour = findViewById<TextView>(R.id.memofour)
        val memofive = findViewById<TextView>(R.id.memofive)
        val memosix = findViewById<TextView>(R.id.memosix)
        val memoseven = findViewById<TextView>(R.id.memoseven)
        val memoeight = findViewById<TextView>(R.id.memoeight)
        val memonine = findViewById<TextView>(R.id.memonine)
        val memoten = findViewById<TextView>(R.id.memoten)
        val text_title = findViewById<TextView>(R.id.abd_title)

        val index = intent.getIntExtra("index", -1)
        val title = intent.getStringExtra("abtitle") ?: ""
        val mbd_progress = intent.getStringExtra("abprogressnum") ?: ""
        val mbd_deadline = intent.getStringExtra("abdeadline") ?:""
        text_title.text = title


        try {
            ABarDeadline.progress = mbd_deadline.toInt()
            ABarProcess.progress = mbd_progress.toInt()
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
        } catch (e: Exception) {
            ABarProcess.progress =  progressnum
        }

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
            val input = memoinput.text.toString()

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
            memoinput.text.clear()
        }


        val finish = findViewById<ImageButton>(R.id.BacktoMain)
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

            intent.putExtra("abprogressnum", "0")
            intent.putExtra("abdeadlinenum", "0")

            setResult(RESULT_OK, intent)
            finish()
        }
    }


}