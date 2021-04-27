package com.example.mobilszoftverlabor.mock

import com.example.mobilszoftverlabor.data.AppDatabase
import dagger.Provides
import javax.inject.Singleton

class MockDatabaseModule {
    @Provides
    @Singleton
    fun provideAppointmentsDb(): AppDatabase = MockAppDatabase()
}