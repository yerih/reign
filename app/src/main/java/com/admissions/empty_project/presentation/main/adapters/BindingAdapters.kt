package com.admissions.empty_project.presentation.main.adapters

import android.annotation.SuppressLint
import android.graphics.Color
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.databinding.BindingAdapter

@SuppressLint("SetJavaScriptEnabled")
@BindingAdapter("url")
fun WebView.setUrl(url: String){
    if(url.isEmpty())return
    webViewClient = WebViewClient()
    loadUrl(url)
//    setBackgroundColor(Color.TRANSPARENT)
    settings.setSupportZoom(true)
    settings.javaScriptEnabled = true
}