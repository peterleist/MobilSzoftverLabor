package com.example.mobilszoftverlabor.ui.notedetails

import com.example.mobilszoftverlabor.model.NoteResult

interface NoteDetailsScreen {
    fun showNote( note: NoteResult?)
    fun updateNote()
    fun deleteNote()
    fun showError(errorMsg: String)
}