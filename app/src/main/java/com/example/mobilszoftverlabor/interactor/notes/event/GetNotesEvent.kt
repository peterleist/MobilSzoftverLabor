package com.example.mobilszoftverlabor.interactor.notes.event

import com.example.mobilszoftverlabor.model.NoteResult

data class GetNotesEvent(
    var code: Int = 0,
    var notes: List<NoteResult>? = null,
    var throwable: Throwable? = null
)
