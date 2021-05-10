package com.example.mobilszoftverlabor.ui.main

import com.example.mobilszoftverlabor.model.NoteResult

interface MainScreen {
    fun showNotes(noteList: MutableList<NoteResult>?)
    fun showNetworkError(errorMsg: String)
}