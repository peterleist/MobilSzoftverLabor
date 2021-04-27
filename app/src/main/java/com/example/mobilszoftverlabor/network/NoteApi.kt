package com.example.mobilszoftverlabor.network

import com.example.mobilszoftverlabor.model.Note
import com.example.mobilszoftverlabor.model.NoteResult
import com.example.mobilszoftverlabor.model.NotesResult
import com.example.mobilszoftverlabor.model.ResponseMessage
import retrofit2.Call
import retrofit2.http.*
import rx.Observable

interface NoteApi {

    @DELETE("note/delete/{noteid}")
    fun deleteNoteDeleteNoteid(
        @Path("noteid") noteid: String?
    ): Call<ResponseMessage?>?


    @GET("note/{noteid}")
    fun getNoteNoteid(
        @Path("noteid") noteid: String?
    ): Call<NoteResult?>?


    @get:GET("notes")
    val notes: Call<List<NotesResult?>?>?


    @Headers("Content-Type:application/json")
    @POST("note/create")
    fun postNoteCreate(
        @Body body: Note?
    ): Call<ResponseMessage?>?


    @Headers("Content-Type:application/json")
    @PUT("note/update/{noteid}")
    fun putNoteUpdateNoteid(
        @Path("noteid") noteid: String?, @Body body: Note?
    ): Call<ResponseMessage?>?
}