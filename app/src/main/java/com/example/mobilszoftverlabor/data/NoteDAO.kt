package com.example.mobilszoftverlabor.data

import androidx.room.*
import com.example.mobilszoftverlabor.model.Note

@Dao
interface NoteDAO {
    @Query("SELECT * FROM note")
    fun getNotes(): List<Note>

    @Query("SELECT * FROM note WHERE id = :id")
    fun getSNote(id: String): Note

    @Insert
    fun insertNote(vararg note: Note)

    @Delete
    fun deleteNote(vararg note: Note)

    @Update
    fun updateNote(vararg note: Note)
}