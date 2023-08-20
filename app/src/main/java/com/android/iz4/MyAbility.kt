package com.android.iz4

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import android.widget.ProgressBar
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts

class MyAbility : AppCompatActivity() {
    private lateinit var abilityresult: ActivityResultLauncher<Intent>
    private var progressnum = 0

    companion object {
        val titleList = mutableListOf(R.string.TAP, R.string.TBP, R.string.TCP)
        var progressnumList = mutableListOf("0", "0", "0")
        val deadlinenumList = mutableListOf("77", "48", "37")
        val MemoList1 = mutableListOf("", "", "", "", "", "", "", "", "", "")
        val MemoList2 = mutableListOf("", "", "", "", "", "", "", "", "", "")
        val MemoList3 = mutableListOf("", "", "", "", "", "", "", "", "", "")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_myability)
        Log.d("LifecycleMyAbility", "onCreate")

        val next_teamList = mutableListOf<Button>(
            findViewById(R.id.AtoDetail),
            findViewById(R.id.BtoDetail),
            findViewById(R.id.CtoDetail),
        )


        //툴바에서 뒤로가기버튼 구현
        val finish = findViewById<ImageButton>(R.id.BackButton)
        finish.setOnClickListener {
            finish()
        }

        //디테일 페이지로 넘겨주기

        next_teamList.forEachIndexed { index, button ->
            button.setOnClickListener {
                val intent = Intent(this, MyAbilityDetail::class.java)
                intent.putExtra("index", index)
                intent.putExtra("abtitle", titleList[index])
                intent.putExtra("abprogressnum", progressnumList[index])
                intent.putExtra("abdeadline", deadlinenumList[index])
                intent.putExtra("abtitle", titleList[index])
                when (index) {
                    0 -> intent.putStringArrayListExtra("abmemoList", ArrayList(MemoList1))
                    1 -> intent.putStringArrayListExtra("abmemoList", ArrayList(MemoList2))
                    2 -> intent.putStringArrayListExtra("abmemoList", ArrayList(MemoList3))
                }
                Log.d("LifecycleMyAbility", progressnumList[index])
                abilityresult.launch(intent)
            }
        }
        abilityresult =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                if (it.resultCode == RESULT_OK) {
                    val data = it.data
                    if (data != null) {
                        val index = data.getIntExtra("index", -1)
                        if (index >= 0) {
                            progressnumList[index] = data.getStringExtra("abdprogressnum") ?: ""
                            deadlinenumList[index] = data.getStringExtra("abddeadlinenum") ?: ""
                            val abdmemoList = data.getStringArrayListExtra("abdmemoList")
                            if (abdmemoList != null) {
                                when (index) {
                                    0 -> MemoList1.clear()
                                    1 -> MemoList2.clear()
                                    2 -> MemoList3.clear()
                                }
                                abdmemoList.forEachIndexed { i, memo ->
                                    when (index) {
                                        0 -> MemoList1.add(i, memo)
                                        1 -> MemoList2.add(i, memo)
                                        2 -> MemoList3.add(i, memo)
                                    }
                                }
                            }

                            progressnumList.add(progressnumList[index] ?: "")
                            deadlinenumList.add(deadlinenumList[index] ?: "")

                            val ABarProcess = findViewById<ProgressBar>(R.id.ABarProcess)
                            val ABarDeadline = findViewById<ProgressBar>(R.id.ABarDeadLine)
                            val BBarProcess = findViewById<ProgressBar>(R.id.BBarProcess)
                            val BBarDeadline = findViewById<ProgressBar>(R.id.BBarDeadLine)
                            val CBarProcess = findViewById<ProgressBar>(R.id.CBarProcess)
                            val CBarDeadline = findViewById<ProgressBar>(R.id.CBarDeadLine)
                            try {
                                progressnum = progressnumList[index].toInt()
                                val progressnum2 = deadlinenumList[index].toInt()


                                if (index == 0) {
                                    ABarProcess.progress = progressnum
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
                                } else if (index == 1) {
                                    BBarProcess.progress = progressnum
                                    if (progressnum < progressnum2) {
                                        BBarDeadline.getProgressDrawable().setColorFilter(
                                            Color.RED, android.graphics.PorterDuff.Mode.SRC_IN
                                        )
                                    } else if (progressnum == progressnum2) {
                                        BBarDeadline.getProgressDrawable().setColorFilter(
                                            Color.GREEN, android.graphics.PorterDuff.Mode.SRC_IN
                                        )
                                    } else {
                                        BBarDeadline.getProgressDrawable().setColorFilter(
                                            Color.BLUE, android.graphics.PorterDuff.Mode.SRC_IN
                                        )
                                    }
                                } else if (index == 2) {
                                    CBarProcess.progress = progressnum
                                    if (progressnum < progressnum2) {
                                        CBarDeadline.getProgressDrawable().setColorFilter(
                                            Color.RED, android.graphics.PorterDuff.Mode.SRC_IN
                                        )
                                    } else if (progressnum == progressnum2) {
                                        CBarDeadline.getProgressDrawable().setColorFilter(
                                            Color.GREEN, android.graphics.PorterDuff.Mode.SRC_IN
                                        )
                                    } else {
                                        CBarDeadline.getProgressDrawable().setColorFilter(
                                            Color.BLUE, android.graphics.PorterDuff.Mode.SRC_IN
                                        )
                                    }
                                }
                            } catch (e: Exception) {
                                progressnum = 0
                            }
                        }
                    }
                }
            }

    }
}