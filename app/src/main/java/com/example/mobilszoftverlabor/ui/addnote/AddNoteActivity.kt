package com.example.mobilszoftverlabor.ui.addnote

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mobilszoftverlabor.R
import com.example.mobilszoftverlabor.injector
import com.example.mobilszoftverlabor.model.Note
import com.example.mobilszoftverlabor.model.ResponseMessage
import com.example.mobilszoftverlabor.ui.main.MainActivity
import com.example.mobilszoftverlabor.ui.main.MainPresenter
import javax.inject.Inject

class AddNoteActivity : AppCompatActivity(), AddNoteScreen {

    @Inject
    lateinit var addNotePresenter: AddNotePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addnote)
        supportActionBar?.hide()
        injector.inject(this)

        findViewById<Button>(R.id.add_new_note).setOnClickListener {
            addNotePresenter.addNote(
                Note(
                    findViewById<EditText>(R.id.title_edit_new).text.toString(),
                    findViewById<EditText>(R.id.content_edit_new).text.toString()
                )
            )

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        addNotePresenter.attachScreen(this)
    }

    override fun onStop() {
        addNotePresenter.detachScreen()
        super.onStop()
    }

    override fun saveNote(msg: ResponseMessage?) {
        if (msg != null) {
            Toast.makeText(applicationContext, msg.message, Toast.LENGTH_LONG).show()
        }
    }
    override fun showError(errorMsg: String) {
        Toast.makeText(applicationContext, errorMsg, Toast.LENGTH_LONG).show()
    }
}