package com.example.mobilszoftverlabor

import com.example.mobilszoftverlabor.interactor.InteractorModule
import com.example.mobilszoftverlabor.mock.MockDatabaseModule
import com.example.mobilszoftverlabor.mock.MockNetworkModule
import com.example.mobilszoftverlabor.test.AddNoteTest
import com.example.mobilszoftverlabor.test.MainTest
import com.example.mobilszoftverlabor.test.NoteDetailsTest
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [MockNetworkModule::class, TestModule::class, InteractorModule::class, MockDatabaseModule::class])
interface TestComponent: NoteApplicationComponent {
    fun inject(noteDetailsTest: NoteDetailsTest)
    fun inject(mainTest: MainTest)
    fun inject(addNoteTest: AddNoteTest)
}