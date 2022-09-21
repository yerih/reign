package com.admissions.empty_project.presentation.main.adapters

import android.annotation.SuppressLint
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.admissions.domain.HackerNew

@SuppressLint("SetJavaScriptEnabled")
@BindingAdapter("url")
fun WebView.setUrl(url: String){
    if(url.isEmpty())return
    webViewClient = WebViewClient()
    loadUrl(url)
    settings.setSupportZoom(true)
    settings.javaScriptEnabled = true
}

@BindingAdapter("list")
fun RecyclerView.setList(list: List<HackerNew>){ (adapter as HackerNewsAdapter).submitList(list) }
