package com.admissions.reign.presentation.main.adapters

import android.annotation.SuppressLint
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.admissions.domain.HackerNew
import com.admissions.reign.presentation.main.MainViewModel

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

@BindingAdapter("onSwipe")
fun RecyclerView.setOnSwipeListener(listener: MainViewModel.onSwipeListener){
    ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT){
        override fun onMove(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            target: RecyclerView.ViewHolder,
        ): Boolean = false

        override fun onSwiped(holder: RecyclerView.ViewHolder, direction: Int) {
            val item = (adapter as HackerNewsAdapter).currentList[holder.adapterPosition]
            listener.onSwipe(direction, item)
        }

    }).attachToRecyclerView(this)
}

@BindingAdapter("onRefresh")
fun SwipeRefreshLayout.setOnRefreshListener(listener: MainViewModel.onScrollToRefresh) = setOnRefreshListener { listener.onRefresh(); isRefreshing = false }

@BindingAdapter("visible")
fun View.setVisible(value: Boolean){ visibility = if(value) VISIBLE else GONE }


