package com.autodoc.project

import org.koin.android.ext.koin.androidContext
import com.autodoc.project.di.initKoin
import android.app.Application

class MainApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(applicationContext)
        }
    }
}