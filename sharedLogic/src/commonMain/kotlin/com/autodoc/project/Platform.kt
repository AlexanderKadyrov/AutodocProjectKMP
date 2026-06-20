package com.autodoc.project

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform