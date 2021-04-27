package com.example.mobilszoftverlabor.mock


import com.example.mobilszoftverlabor.model.Note
import com.example.mobilszoftverlabor.model.NoteResult
import com.example.mobilszoftverlabor.model.NotesResult
import com.example.mobilszoftverlabor.model.ResponseMessage
import com.example.mobilszoftverlabor.network.NoteApi
import retrofit2.Call

class MockNotesAPI() : NoteApi{

    override fun deleteNoteDeleteNoteid(noteid: String?): Call<ResponseMessage?>? {
        TODO("Not yet implemented")
    }

    override fun getNoteNoteid(noteid: String?): Call<NoteResult?>? {
        TODO("Not yet implemented")
    }

    override val notes: Call<List<NotesResult?>?>?
        get() = TODO("Not yet implemented")

    override fun postNoteCreate(body: Note?): Call<ResponseMessage?>? {
        TODO("Not yet implemented")
    }

    override fun putNoteUpdateNoteid(noteid: String?, body: Note?): Call<ResponseMessage?>? {
        TODO("Not yet implemented")
    }
}