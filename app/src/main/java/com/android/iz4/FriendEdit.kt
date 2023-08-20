package com.android.iz4

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_friendedit)
        Log.d("LifecycleFriendEdit", "onCreate")


        val febtnback = findViewById<ImageButton>(R.id.febackbtn)
        febtnback.setOnClickListener {
            finish()
        }
        val editnick = findViewById<EditText>(R.id.feNickEditView)
        val editname = findViewById<EditText>(R.id.feNameEditView)
        val editmbti = findViewById<EditText>(R.id.feMbtiEditView)
        val editstatus = findViewById<EditText>(R.id.feStatusEditView)
        val edittitle = findViewById<EditText>(R.id.feTitleEditView)
        val editcontent = findViewById<EditText>(R.id.feContentEditView)
        val editimgView = findViewById<ImageView>(R.id.feprofile)

        val index = intent.getIntExtra("index", -1)
        val fenick = intent.getStringExtra("fenick") ?: ""
        val fename = intent.getStringExtra("fename") ?: ""
        val fembti = intent.getStringExtra("fembti") ?: ""
        val festatus = intent.getStringExtra("festatus") ?: ""
        val title = intent.getStringExtra("fetitle") ?: ""
        val content = intent.getStringExtra("fecontent") ?: ""
        Log.d("AAAAAAAA",fenick)
        imageUrl = intent.getStringExtra("imgBtn") ?: ""

        editnick.setText(fenick)
        editname.setText(fename)
        editmbti.setText(fembti)
        editstatus.setText(festatus)
        edittitle.setText(title)
        editcontent.setText(content)

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

        addimg = findViewById(R.id.feaddimg)
        val addButton = findViewById<FloatingActionButton>(R.id.febtntitle)
        val viewList = arrayListOf<View>()
        addButton.setOnClickListener {
            val inflater = LayoutInflater.from(this)
            val item = inflater.inflate(R.layout.additem, addimg, false)
            addimg.addView(item)
            viewList.add(item)
        }

        val btnedit = findViewById<Button>(R.id.febtnedit)
        btnedit.setOnClickListener {
            val nick = editnick.text.toString()
            val name = editname.text.toString()
            val mbti = editmbti.text.toString()
            val status = editstatus.text.toString()
            val title = edittitle.text.toString()
            val content = editcontent.text.toString()

            viewList.forEach {
                val title1 = it.findViewById<EditText>(R.id.feTitleEditView)
                val imgView1 = it.findViewById<ImageView>(R.id.feaddimgView)
                val content1 = it.findViewById<EditText>(R.id.feContentEditView)
                Log.d("view", title1.text.toString())
            }
            if (nick.isNotEmpty() && name.isNotEmpty()&& mbti.isNotEmpty() && status.isNotEmpty()) {

                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("index", index)
                intent.putExtra("inputName", name)
                intent.putExtra("inputNick", nick)
                intent.putExtra("inputMbti", mbti)
                intent.putExtra("inputStatus", status)
                intent.putExtra("inputTitle", title)
                intent.putExtra("inputContent", content)
                if (imageUrl != null && imageUrl!!.isNotEmpty()) {
                    intent.putExtra("imageUrl", imageUrl)
                }



                setResult(RESULT_OK, intent)
                finish()
            } else {
                Toast.makeText(this, getString(R.string.No_Info), Toast.LENGTH_SHORT).show()
            }
        }
        val imgclick = findViewById<ImageView>(R.id.feprofile)
        imgclick.setOnClickListener {
            dialog(imgclick)
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

    override fun onStart() {
        super.onStart()
        Log.d("LifecycleFriendEdit", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("LifecycleFriendEdit", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("LifecycleFriendEdit", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("LifecycleFriendEdit", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("LifecycleFriendEdit", "onDestroy")
    }
}



