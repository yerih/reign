package com.admissions.empty_project.presentation.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.admissions.domain.HackerNew
import com.admissions.empty_project.data.R
import com.admissions.empty_project.data.databinding.FragmentMainBinding
import com.admissions.empty_project.presentation.main.adapters.HackerNewsAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment(R.layout.fragment_main) {

    private val viewModel: MainViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = HackerNewsAdapter{}
        adapter.submitList(listOf(HackerNew("hola", "", "como", "estas"),
            HackerNew("hola", "", "como", "estas"),
            HackerNew("hola", "", "como", "estas")))
        val binding = FragmentMainBinding.bind(view).apply {
            recycler.adapter = adapter
        }
    }

}