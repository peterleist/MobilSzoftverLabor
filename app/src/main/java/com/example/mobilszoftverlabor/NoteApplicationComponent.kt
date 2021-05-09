package com.example.mobilszoftverlabor

import com.example.mobilszoftverlabor.data.DatabaseModule
import com.example.mobilszoftverlabor.interactor.InteractorModule
import com.example.mobilszoftverlabor.network.NetworkModule
import com.example.mobilszoftverlabor.ui.UIModule
import com.example.mobilszoftverlabor.ui.about.AboutActivity
import com.example.mobilszoftverlabor.ui.addnote.AddNoteActivity
import com.example.mobilszoftverlabor.ui.main.MainActivity
import com.example.mobilszoftverlabor.ui.notedetails.NoteDetailsActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [UIModule::class, DatabaseModule::class, NetworkModule::class, InteractorModule::class])
interface NoteApplicationComponent {
    fun inject(mainActivity: MainActivity)
    fun inject(noteDetailsActivity: NoteDetailsActivity)
    fun inject(addNoteActivity: AddNoteActivity)
    fun inject(aboutActivity: AboutActivity)
}