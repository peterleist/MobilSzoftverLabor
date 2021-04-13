package com.example.mobilszoftverlabor.ui.addnote

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mobilszoftverlabor.R
import com.example.mobilszoftverlabor.ui.main.MainPresenter
import javax.inject.Inject

class AddNoteActivity : AppCompatActivity(), AddNoteScreen {

    @Inject
    lateinit var addNotePresenter: AddNotePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addnote)
    }

    override fun onStart() {
        super.onStart()
        addNotePresenter.attachScreen(this)
    }

    override fun onStop() {
        addNotePresenter.detachScreen()
        super.onStop()
    }

    override fun saveNote() {
        TODO("Not yet implemented")
    }
}