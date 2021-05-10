package com.example.mobilszoftverlabor.mock

import com.example.mobilszoftverlabor.data.NoteDAO
import com.example.mobilszoftverlabor.model.Note
import com.example.mobilszoftverlabor.model.NoteResult
import java.math.BigDecimal

class MockNoteDAO : NoteDAO {

    override fun getNotes(): List<NoteResult> {
        return listOf(
            NoteResult("6065dde30927064ed860fb2e",
                "2021-05-09T17:52:15.973Z",
                "2021-05-09T17:52:15.973Z",
                "Test",
                "Test",
                BigDecimal(0)

            )
        )
    }

    override fun getSNote(id: String): NoteResult {
        return NoteResult("6065dde30927064ed860fb2e",
            "2021-05-09T17:52:15.973Z",
            "2021-05-09T17:52:15.973Z",
            "Test",
            "Test",
            BigDecimal(0)
        )
    }

    override fun insertNote(vararg note: NoteResult) {}

    override fun insertNotes(notes: List<NoteResult>) {}

    override fun deleteNote(vararg note: NoteResult) {}

    override fun updateNote(vararg note: NoteResult) {}
}