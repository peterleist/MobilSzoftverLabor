package com.example.mobilszoftverlabor.mock

import com.example.mobilszoftverlabor.data.NoteDAO
import com.example.mobilszoftverlabor.model.Note

class MockNoteDAO : NoteDAO {

    override fun getNotes(): List<Note> {
        return listOf(
            Note("6065e2723a227d5d50d472cd"
                ,"id1"
                , "Appointment1"
            )
        )
    }

    override fun getSNote(id: String): Note {
        return Note("6065e2723a227d5d50d472cd"
            ,"id1"
            , "Appointment1"
        )
    }

    override fun insertNote(vararg note: Note) {
        TODO("Not yet implemented")
    }

    override fun deleteNote(vararg note: Note) {
        TODO("Not yet implemented")
    }

    override fun updateNote(vararg note: Note) {
        TODO("Not yet implemented")
    }
}