package com.example.mobilszoftverlabor.ui.notedetails

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mobilszoftverlabor.R
import com.example.mobilszoftverlabor.injector
import com.example.mobilszoftverlabor.model.Note
import com.example.mobilszoftverlabor.model.NoteResult
import com.example.mobilszoftverlabor.model.ResponseMessage
import com.example.mobilszoftverlabor.ui.main.MainActivity
import javax.inject.Inject

class NoteDetailsActivity: AppCompatActivity(), NoteDetailsScreen {

    private var displayedNote: NoteResult? = null

    @Inject
    lateinit var noteDetailsPresenter: NoteDetailsPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notedetails)
        supportActionBar?.hide()
        injector.inject(this)
        Log.d("Msg", "resume")

        findViewById<Button>(R.id.add_new_note).setOnClickListener {
            displayedNote?.let { it1 -> noteDetailsPresenter.updateNote(it1.id,
                Note(findViewById<EditText>(R.id.title_edit_new).text.toString(),
                    findViewById<EditText>(R.id.content_edit_new).text.toString())

            ) }
        }

        findViewById<Button>(R.id.delete).setOnClickListener {
            displayedNote?.let { it2 -> noteDetailsPresenter.deleteNote(it2) }
            navigationToMain()
        }
    }
    override fun onStart() {
        super.onStart()
        noteDetailsPresenter.attachScreen(this)
        val id = intent.getStringExtra("NOTE_ID")
        if (id != null) {
            noteDetailsPresenter.refreshNote(id)
        }
    }

    override fun onStop() {
        noteDetailsPresenter.detachScreen()
        super.onStop()
    }

    override fun onResume() {
        super.onResume()
        val id = intent.getStringExtra("NOTE_ID")
        if (id != null) {
            noteDetailsPresenter.refreshNote(id)
        }
    }

    override fun showNote(note: NoteResult?) {
        displayedNote = note
        displayedNote?.title?.let { Log.d("Msg", it) }
        findViewById<EditText>(R.id.title_edit_new).text = Editable.Factory.getInstance().newEditable(
            displayedNote?.title ?: "No title"
        )
        findViewById<EditText>(R.id.content_edit_new).text = Editable.Factory.getInstance().newEditable(
            displayedNote?.content ?: "No content"
        )

        findViewById<TextView>(R.id.create_date).text = displayedNote?.createdAt ?: "Never"
        findViewById<TextView>(R.id.update_date).text = displayedNote?.updatedAt ?: "Never"

    }

    override fun updateNote(msg: ResponseMessage?) {
        if (msg != null) {
            Toast.makeText(applicationContext, msg.message, Toast.LENGTH_LONG).show()
        }
    }

    override fun deleteNote(msg: ResponseMessage?) {
        if (msg != null) {
            Toast.makeText(applicationContext, msg.message, Toast.LENGTH_LONG).show()
        }
    }

    override fun showError(errorMsg: String) {
        Toast.makeText(applicationContext, errorMsg, Toast.LENGTH_LONG).show()
    }
    fun navigationToMain() {
        val intent = Intent(this, MainActivity::class.java)
        this.startActivity(intent)
    }

}