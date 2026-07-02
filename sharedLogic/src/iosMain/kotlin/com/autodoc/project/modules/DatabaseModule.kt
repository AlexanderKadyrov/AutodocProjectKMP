package com.autodoc.project.modules

import com.autodoc.project.database.AppDatabase
import com.autodoc.project.database.getDatabase
import org.koin.dsl.module

actual fun platformModule() = module {
    single<AppDatabase> { getDatabase() }
}