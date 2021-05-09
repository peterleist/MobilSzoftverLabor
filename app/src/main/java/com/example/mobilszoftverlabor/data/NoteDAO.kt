package com.example.mobilszoftverlabor.data

import androidx.room.*
import com.example.mobilszoftverlabor.model.Note
import com.example.mobilszoftverlabor.model.NoteResult

@Dao
interface NoteDAO {
    @Query("SELECT * FROM note")
    fun getNotes(): List<NoteResult>

    @Query("SELECT * FROM note WHERE id = :id")
    fun getSNote(id: String): NoteResult

    @Insert
    fun insertNote(vararg note: NoteResult)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNotes(notes: List<NoteResult>)

    @Delete
    fun deleteNote(vararg note: NoteResult)

    @Update
    fun updateNote(vararg note: NoteResult)
}