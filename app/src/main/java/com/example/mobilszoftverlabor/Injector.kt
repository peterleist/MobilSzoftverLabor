package com.example.mobilszoftverlabor

import android.app.Activity

val Activity.injector: NoteApplicationComponent
    get() {
        return (this.applicationContext as NoteApplication).injector
    }