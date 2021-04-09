package com.example.mobilszoftverlabor.ui.notedetails

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mobilszoftverlabor.R
import javax.inject.Inject

class NoteDetailsActivity: AppCompatActivity(), NoteDetailsScreen {

    @Inject
    lateinit var noteDetailsPresenter: NoteDetailsPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notedetails)
    }

    override fun getNote() {
        TODO("Not yet implemented")
    }

    override fun updateNote() {
        TODO("Not yet implemented")
    }

    override fun deleteNote() {
        TODO("Not yet implemented")
    }
}