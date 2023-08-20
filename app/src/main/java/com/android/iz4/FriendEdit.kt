package com.android.iz4

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.squareup.picasso.Picasso

class FriendEdit : AppCompatActivity() {
    private lateinit var addimg: LinearLayout
    private var imageUrl: String? = null
    private var imageUrl1: String? = null
    private var imageUrl2: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_friendedit)

        val febtnback = findViewById<ImageButton>(R.id.febackbtn)
        febtnback.setOnClickListener {
            finish()
        }
        val editnick = findViewById<EditText>(R.id.feNickEditView)
        val editname = findViewById<EditText>(R.id.feNameEditView)
        val editmbti = findViewById<EditText>(R.id.feMbtiEditView)
        val editstatus = findViewById<EditText>(R.id.feStatusEditView)
        val editimgView = findViewById<ImageView>(R.id.feprofile)
        val edittitle = findViewById<EditText>(R.id.feTitle)
        val edittitle1  = findViewById<EditText>(R.id.feTitle1)
        val editcontext = findViewById<EditText>(R.id.feContext)
        val editcontext1 = findViewById<EditText>(R.id.feContext1)
        val editimgView1 = findViewById<ImageView>(R.id.feaddimgView)
        val editimgView2 = findViewById<ImageView>(R.id.feaddimgView1)

        val index = intent.getIntExtra("index", -1)
        val fenick = intent.getStringExtra("fenick") ?: ""
        val fename = intent.getStringExtra("fename") ?: ""
        val fembti = intent.getStringExtra("fembti") ?: ""
        val festatus = intent.getStringExtra("festatus") ?: ""
        val title = intent.getStringExtra("fetitle") ?: ""
        val title1 = intent.getStringExtra("fetitle1") ?:""
        val context = intent.getStringExtra("fecontext") ?:""
        val context1 = intent.getStringExtra("fecontext1")?:""

        imageUrl = intent.getStringExtra("imgBtn") ?: ""
        imageUrl1 = intent.getStringExtra("feimageUrlList1") ?:""
        imageUrl2 = intent.getStringExtra("feimageUrlList2")?:""

        editnick.setText(fenick)
        editname.setText(fename)
        editmbti.setText(fembti)
        editstatus.setText(festatus)
        edittitle.setText(title)
        edittitle1.setText(title1)
        editcontext.setText(context)
        editcontext1.setText(context1)

        if (imageUrl.isNullOrEmpty()) {
            editimgView.setImageResource(R.drawable.question)
        } else {
            val resourceId = resources.getIdentifier(imageUrl, "drawable", packageName)

            if (resourceId != 0) {
                Picasso.get().load(resourceId).error(R.drawable.question).into(editimgView)
            } else {
                Picasso.get().load(imageUrl).error(R.drawable.question).into(editimgView)
            }
        }

        if (imageUrl1.isNullOrEmpty()) {
            editimgView1.setImageResource(R.drawable.question)
        } else {
            val resourceId1 = resources.getIdentifier(imageUrl1, "drawable", packageName)

            if (resourceId1 != 0) {
                Picasso.get().load(resourceId1).error(R.drawable.question).into(editimgView1)
            } else {
                Picasso.get().load(imageUrl1).error(R.drawable.question).into(editimgView1)
            }
        }

        if (imageUrl2.isNullOrEmpty()) {
            editimgView2.setImageResource(R.drawable.question)
        } else {
            val resourceId2 = resources.getIdentifier(imageUrl2,"drawable", packageName)

            if (resourceId2 != 0) {
                Picasso.get().load(resourceId2).error(R.drawable.question).into(editimgView2)
            } else {
                Picasso.get().load(resourceId2).error(R.drawable.question).into(editimgView2)
            }
        }

        val btnedit = findViewById<Button>(R.id.febtnedit)
        btnedit.setOnClickListener {
            val nick = editnick.text.toString()
            val name = editname.text.toString()
            val mbti = editmbti.text.toString()
            val status = editstatus.text.toString()
            val title = edittitle.text.toString()
            val title1 = edittitle1.text.toString()
            val context = editcontext.text.toString()
            val context1 = editcontext1.text.toString()

            if (nick.isNotEmpty() && name.isNotEmpty()&& mbti.isNotEmpty() && status.isNotEmpty()) {

                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("index", index)
                intent.putExtra("inputName", name)
                intent.putExtra("inputNick", nick)
                intent.putExtra("inputMbti", mbti)
                intent.putExtra("inputStatus", status)
                intent.putExtra("inputTitle", title)
                intent.putExtra("inputTitle1", title1)
                intent.putExtra("inputContext", context)
                intent.putExtra("inputContext1", context1)

                if (imageUrl != null && imageUrl!!.isNotEmpty()) {
                    intent.putExtra("imageUrl", imageUrl)
                }
                setResult(RESULT_OK, intent)
                finish()
            } else {
                Toast.makeText(this, getString(R.string.No_Info), Toast.LENGTH_SHORT).show()
            }
        }

        editimgView.setOnClickListener {
            dialog( editimgView)
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



