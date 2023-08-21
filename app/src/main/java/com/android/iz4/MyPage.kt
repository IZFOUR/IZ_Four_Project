package com.android.iz4


import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
class MyPage : AppCompatActivity() {

    private var imageUrl = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mypage)

        val id = findViewById<TextView>(R.id.tv_id)
        val name = findViewById<TextView>(R.id.tv_name)
        val age = findViewById<TextView>(R.id.tv_age)
        val mbti = findViewById<TextView>(R.id.tv_mbti)
        val img_profile = findViewById<ImageView>(R.id.iv_odung_smile)
        val save_Button = findViewById<Button>(R.id.mybtnedit)
        if (intent.hasExtra("id") || (intent.hasExtra("name") || (intent.hasExtra("age") || (intent.hasExtra(
                "mbti"
            ))))
        ) {
            id.text = "ID: " + intent.getStringExtra("id")
            name.text = "NAME: " + intent.getStringExtra("name")
            age.text = "AGE: " + intent.getStringExtra("age")
            mbti.text = "MBTI: " + intent.getStringExtra("mbti")

            imageUrl = intent.getStringExtra("fromprofile") ?:""
            if (!imageUrl.isNullOrEmpty()) {
                Picasso.get().load(imageUrl).error(R.drawable.question).into(img_profile)
            } else {
            }
        }
        img_profile.setOnClickListener {
            dialog(img_profile)
        }

        val today = findViewById<TextView>(R.id.tv_today)
        val detail = findViewById<TextView>(R.id.tv_detail)
        if (intent.hasExtra("today") || (intent.hasExtra("detail") || (intent.hasExtra("imageView")))) {

            today.text = intent.getStringExtra("today")
            detail.text = intent.getStringExtra("detail")
        }
        save_Button.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("myprofile", imageUrl)
            Log.d("fromMainActivity imageUrlList", "내사진주는곳 $imageUrl")
            setResult(RESULT_OK,intent)
            finish()
        }

        val ib_back = findViewById<ImageView>(R.id.ib_back)
        ib_back.setOnClickListener {
            finish()
        }
    }
    private fun dialog(imgView: ImageView) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle(R.string.PL_URL)

        val inputEditText = EditText(this)
        builder.setView(inputEditText)

        builder.setPositiveButton(R.string.Check) { dialog, which ->
            imageUrl = inputEditText.text.toString()
            if (!imageUrl.isNullOrEmpty()) {
                Picasso.get().load(imageUrl).error(R.drawable.question).into(imgView)
            }
        }
        builder.setNegativeButton(R.string.CCllt) { dialog, which ->
        }
        val dialog = builder.create()
        dialog.show()
    }
}