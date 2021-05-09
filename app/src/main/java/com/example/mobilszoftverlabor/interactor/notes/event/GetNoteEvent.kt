package com.example.mobilszoftverlabor.interactor.notes.event

import com.example.mobilszoftverlabor.model.NoteResult

data class GetNoteEvent(
    var code: Int = 0,
    var note: NoteResult? = null,
    var throwable: Throwable? = null
)