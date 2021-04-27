package com.example.mobilszoftverlabor.mock

import androidx.room.DatabaseConfiguration
import androidx.room.InvalidationTracker
import androidx.sqlite.db.SupportSQLiteOpenHelper
import com.example.mobilszoftverlabor.data.AppDatabase
import com.example.mobilszoftverlabor.data.NoteDAO

class MockAppDatabase : AppDatabase() {
    override fun noteDao(): NoteDAO {
        return MockNoteDAO()
    }

    override fun createOpenHelper(config: DatabaseConfiguration?): SupportSQLiteOpenHelper {
        TODO("Not yet implemented")
    }

    override fun createInvalidationTracker(): InvalidationTracker {
        TODO("Not yet implemented")
    }

    override fun clearAllTables() {
        TODO("Not yet implemented")
    }


}