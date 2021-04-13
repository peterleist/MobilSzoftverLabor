package com.example.mobilszoftverlabor

import android.app.Application
import com.example.mobilszoftverlabor.ui.UIModule

class NoteApplication: Application() {
    lateinit var injector: NoteApplicationComponent

    override fun onCreate() {
        super.onCreate()
        injector = DaggerNoteApplicationComponent.builder().uIModule(UIModule(this)).build()
    }
}