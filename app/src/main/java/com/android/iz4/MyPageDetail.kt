package com.android.iz4

import android.content.Intent
import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast

class MyPageDetail : AppCompatActivity() {
//    var i = 0
//    var max = 0
//    var imageView: ImageView? = null
//    var typedArray: TypedArray? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mypagedetail)

//        imageView = findViewById<ImageView>(R.id.iv_myimage) as ImageView
//        typedArray = resources.obtainTypedArray(R.array.bamin1)
//        i = 0
//        max = typedArray!!.length()
//        imageView!!.setImageResource(typedArray!!.getResourceId(i, -1))
//        val left_btn = findViewById<View>(R.id.left_btn) as Button
//        left_btn.setOnClickListener {
//            i--
//            if (i <= 0) i = 0
//            imageView!!.setImageResource(typedArray!!.getResourceId(i, -1))
//        }
//        val right_btn = findViewById<View>(R.id.right_btn) as Button
//        right_btn.setOnClickListener {
//            i++
//            if (i >= max) {
//                i = max -1;
//            }
//            imageView!!.setImageResource(typedArray!!.getResourceId(i, -1))
//        }

        val btn_AddMemo = findViewById<Button>(R.id.btn_addmemo)
        val edit_today = findViewById<EditText>(R.id.et_today)
        val edit_detail = findViewById<EditText>(R.id.et_detail)
        val edit_story = findViewById<EditText>(R.id.et_story)

        btn_AddMemo.setOnClickListener {
            val today = edit_today.text.toString()
            val detail = edit_detail.text.toString()
            val story = edit_story.text.toString()

            val intent = Intent(this,MyPage::class.java).apply {
                putExtra("MyPageDetailAtivityToday",today)
                putExtra("MyPageDetailAtivityDetail",detail)
                putExtra("MyPageDetailAtivityStory",story)
            }
            Toast.makeText(this,R.string.MyDt_SAVED,Toast.LENGTH_SHORT).show()
            setResult(RESULT_OK,intent)
            finish()
        }


//        val btnmemo = findViewById<Button>(R.id.ib_addmemo)
//
//        btnmemo.setOnClickListener {
//            val today = intent.getStringExtra("")
//            val review = intent.getStringExtra("")
//            val intent = Intent(this, MyPage::class.java)
//            intent.putExtra("today", today)
//            intent.putExtra("review", review)
//
//            startActivity(intent)

        var ib_back2 = findViewById<ImageView>(R.id.ib_back2)
        ib_back2.setOnClickListener {
            var intent = Intent(this, MyPage::class.java)
            finish()
        }

    }
}
