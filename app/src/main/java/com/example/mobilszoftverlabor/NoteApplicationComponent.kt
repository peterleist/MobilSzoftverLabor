package com.example.mobilszoftverlabor

import com.example.mobilszoftverlabor.interactor.InteractorModule
import com.example.mobilszoftverlabor.ui.UIModule
import com.example.mobilszoftverlabor.ui.main.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [UIModule::class, InteractorModule::class])
interface NoteApplicationComponent {
    fun inject(mainActivity: MainActivity)
}