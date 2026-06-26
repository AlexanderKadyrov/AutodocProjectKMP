package com.autodoc.project

import com.autodoc.project.di.initKoin
import android.app.Application

class MainApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }
}