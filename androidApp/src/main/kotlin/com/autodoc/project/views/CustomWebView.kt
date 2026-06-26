package com.autodoc.project.views

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.viewinterop.AndroidView
import androidx.compose.runtime.Composable
import android.annotation.SuppressLint
import androidx.compose.ui.Modifier

import android.webkit.WebViewClient
import android.webkit.WebView

import android.view.ViewGroup

@SuppressLint("SetJavaScriptEnabled")
@Composable
fun CustomWebView(
    url: String
) {
    AndroidView(
        modifier = Modifier.fillMaxSize(),
        factory = { context ->
            WebView(context).apply {
                layoutParams = ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
                )
                webViewClient = WebViewClient()
                settings.javaScriptEnabled = true
            }
        },
        update = { webView ->
            webView.loadUrl(url)
        }
    )
}