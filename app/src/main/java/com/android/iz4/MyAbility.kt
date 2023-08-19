package com.android.iz4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.squareup.picasso.Picasso


//(ViewBinding, Fragment, RecyclerView, Adapter는 사용하지 말아주세요.)
//7777I에엙 그럼 뭘 사용해야하지
class MyAbility : AppCompatActivity() {
    lateinit var Abilityresult: ActivityResultLauncher<Intent>

    private val titleList = mutableListOf("팀A프로젝트", "팀B프로젝트", "팀C프로젝트")
    private var progressnumList = mutableListOf("","","")
    private val progressnum2List = mutableListOf("","","")
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
                Log.d("LifecycleMyAbility",progressnumList[index])
                Abilityresult.launch(intent)
            }
        }
        Abilityresult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == RESULT_OK) {
                val data = it.data
                if (data != null) {
                    val index = data.getIntExtra("index", -1)
                    if (index >= 0) {
                        progressnumList[index] = data.getStringExtra("abdprogressnum") ?: ""
                        progressnumList.add( progressnumList[index] ?: "")
                        Log.d("LifecycleMyAbility",progressnumList[index])
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