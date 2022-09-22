package com.admissions.reign.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.admissions.reign.data.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NavHostActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_Reign)
        setContentView(R.layout.activity_nav_host)
    }
}