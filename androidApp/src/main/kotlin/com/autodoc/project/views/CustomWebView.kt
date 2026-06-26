package com.autodoc.project.views

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.viewinterop.AndroidView
import androidx.compose.runtime.Composable
import android.annotation.SuppressLint
import androidx.compose.ui.Modifier

import android.webkit.WebViewClient
import android.webkit.WebView

@SuppressLint("SetJavaScriptEnabled")
@Composable
fun CustomWebView(
    url: String
) {
    AndroidView(
        modifier = Modifier.fillMaxSize(),
        factory = { context ->
            WebView(context).apply {
                webViewClient = WebViewClient()
                settings.javaScriptEnabled = true
                loadUrl(url)
            }
        }
    )
}