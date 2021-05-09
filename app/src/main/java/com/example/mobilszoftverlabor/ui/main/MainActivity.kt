package com.example.mobilszoftverlabor.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.mobilszoftverlabor.R
import com.example.mobilszoftverlabor.injector
import com.example.mobilszoftverlabor.model.Note
import com.example.mobilszoftverlabor.model.NoteResult
import com.example.mobilszoftverlabor.ui.about.AboutActivity
import com.example.mobilszoftverlabor.ui.addnote.AddNoteActivity
import com.example.mobilszoftverlabor.ui.notedetails.NoteDetailsActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import javax.inject.Inject


class MainActivity : AppCompatActivity(), MainScreen {

    private val displayedNotes: MutableList<NoteResult> = mutableListOf()
    private var notesAdapter: NotesAdapter? = null

    @Inject
    lateinit var mainPresenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_main)
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        injector.inject(this)

        notesAdapter = NotesAdapter(this, mainPresenter, displayedNotes)
        findViewById<RecyclerView>(R.id.notes_rv).adapter = notesAdapter

        findViewById<FloatingActionButton>(R.id.add_note).setOnClickListener {
            val intent = Intent(this, AddNoteActivity::class.java)
            startActivity(intent)
        }

        findViewById<Button>(R.id.button).setOnClickListener {
            val intent = Intent(this, AboutActivity::class.java)
            startActivity(intent)
        }

    }

    override fun onStart() {
        super.onStart()
        mainPresenter.attachScreen(this)
    }

    override fun onStop() {
        mainPresenter.detachScreen()
        super.onStop()
    }

    override fun onResume() {
        super.onResume()
        mainPresenter.refreshNotes()
    }

    override fun showNotes(noteList: MutableList<NoteResult>) {
        displayedNotes.clear()
        displayedNotes.addAll(noteList)
        notesAdapter?.notifyDataSetChanged()
    }

    override fun showNetworkError(errorMsg: String) {
        Toast.makeText(applicationContext, errorMsg, Toast.LENGTH_LONG).show()
        Log.d("Msg", errorMsg)
    }
}