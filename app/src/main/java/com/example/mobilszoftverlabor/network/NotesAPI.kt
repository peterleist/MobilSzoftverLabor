package com.example.mobilszoftverlabor.network

import com.example.mobilszoftverlabor.model.Note
import com.example.mobilszoftverlabor.model.Response
import retrofit2.Call
import retrofit2.http.*

interface NotesAPI {

    @get:GET("notes")
    val notes: Call<List<Note?>>?

    @GET("note/{id}")
    fun getNote(
        @retrofit2.http.Path("id") id: String?
    ): Call<Note?>?

    @DELETE("note/delete/{id}")
    fun deleteNote(
        @retrofit2.http.Path("id") id: String?
    ): Call<Response?>?

    @Headers("Content-Type:application/json")
    @POST("note/create")
    fun createNote(
        @retrofit2.http.Body body: Note?
    ): Call<Response?>?

    @Headers("Content-Type:application/json")
    @PUT("note/update/{id}")
    fun updateNote(
        @retrofit2.http.Path("id") id: String?, @retrofit2.http.Body body: Note?
    ): Call<Response?>?
}