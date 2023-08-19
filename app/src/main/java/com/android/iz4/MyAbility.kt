package com.android.iz4

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import android.widget.ProgressBar
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts


//(ViewBinding, Fragment, RecyclerView, Adapter는 사용하지 말아주세요.)
//7777I에엙 그럼 뭘 사용해야하지
class MyAbility : AppCompatActivity() {
    lateinit var abilityresult: ActivityResultLauncher<Intent>

    companion object{
        val titleList = mutableListOf("팀A프로젝트", "팀B프로젝트", "팀C프로젝트")
        var progressnumList = mutableListOf("0","0","0")
        val deadlinenumList = mutableListOf("0","0","0")
        val MemoList = mutableListOf("","","","","","","","","","")
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
        var finish = findViewById<ImageButton>(R.id.BackButton)
        finish.setOnClickListener{
            finish()}

        //프로그레스 바 받아오기
        var ABar = findViewById<ProgressBar>(R.id.ABarProcess)

        //디테일 페이지로 넘겨주기

        next_teamList.forEachIndexed { index,button ->
            button.setOnClickListener {
                val intent = Intent(this, MyAbilityDetail::class.java)
                intent.putExtra("index", index)
                intent.putExtra("abtitle", titleList[index])
                intent.putExtra("abprogressnum", progressnumList[index])
                intent.putExtra("abdeadline", deadlinenumList [index])
                intent.putStringArrayListExtra("abmemoList", ArrayList(MemoList))
                Log.d("LifecycleMyAbility",progressnumList[index])
                abilityresult.launch(intent)
            }
        }
        abilityresult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == RESULT_OK) {
                val data = it.data
                if (data != null) {
                    val index = data.getIntExtra("index", -1)
                    if (index >= 0) {
                        progressnumList[index] = data.getStringExtra("abdprogressnum") ?: ""
//                        deadlinenumList[index] = data.getStringExtra("abddeadlinenum") ?: ""
                        MemoList[index] = data.getStringExtra("abdmemoList") ?: ""
                        progressnumList.add( progressnumList[index] ?: "")
                        deadlinenumList.add( deadlinenumList[index] ?: "")
                        Log.d("LifecycleMyAbility","넘어왔나? ${progressnumList[index]}")

                        var ABarProcess = findViewById<ProgressBar>(R.id.ABarProcess)
                        var ABarDeadline = findViewById<ProgressBar>(R.id.ABarDeadLine)
                        var BBarProcess = findViewById<ProgressBar>(R.id.BBarProcess)
                        var BBarDeadline = findViewById<ProgressBar>(R.id.BBarDeadLine)
                        var CBarProcess = findViewById<ProgressBar>(R.id.CBarProcess)
                        var CBarDeadline = findViewById<ProgressBar>(R.id.CBarDeadLine)
                        var progressnum =  progressnumList[index].toInt()
                        var progressnum2 = deadlinenumList[index].toInt()


                        if (index == 0) {
                            ABarProcess.progress = progressnum
                            if(progressnum<progressnum2){
                                ABarDeadline.getProgressDrawable().setColorFilter(
                                    Color.RED, android.graphics.PorterDuff.Mode.SRC_IN)
                            }else if(progressnum==progressnum2) {
                                ABarDeadline.getProgressDrawable().setColorFilter(
                                    Color.GREEN, android.graphics.PorterDuff.Mode.SRC_IN
                                )
                            }
                            else{ABarDeadline.getProgressDrawable().setColorFilter(
                                Color.BLUE, android.graphics.PorterDuff.Mode.SRC_IN)
                            }
                        } else if (index == 1) {
                            BBarProcess.progress = progressnum
                            if(progressnum<progressnum2){
                                BBarDeadline.getProgressDrawable().setColorFilter(
                                    Color.RED, android.graphics.PorterDuff.Mode.SRC_IN)
                            }else if(progressnum==progressnum2) {
                                BBarDeadline.getProgressDrawable().setColorFilter(
                                    Color.GREEN, android.graphics.PorterDuff.Mode.SRC_IN
                                )
                            }
                            else{BBarDeadline.getProgressDrawable().setColorFilter(
                                Color.BLUE, android.graphics.PorterDuff.Mode.SRC_IN)
                            }
                        }else if (index == 2) {
                            CBarProcess.progress = progressnum
                            if(progressnum<progressnum2){
                                CBarDeadline.getProgressDrawable().setColorFilter(
                                    Color.RED, android.graphics.PorterDuff.Mode.SRC_IN)
                            }else if(progressnum==progressnum2) {
                                CBarDeadline.getProgressDrawable().setColorFilter(
                                    Color.GREEN, android.graphics.PorterDuff.Mode.SRC_IN
                                )
                            }
                            else{CBarDeadline.getProgressDrawable().setColorFilter(
                                Color.BLUE, android.graphics.PorterDuff.Mode.SRC_IN)
                            }
                        }
                    }
                }
            }
        }

    }
    override fun onStart() {
        super.onStart()
        Log.d("LifecycleMyAbility", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("LifecycleMyAbility", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("LifecycleMyAbility", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("LifecycleMyAbility", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("LifecycleMyAbility", "onDestroy")
    }
}