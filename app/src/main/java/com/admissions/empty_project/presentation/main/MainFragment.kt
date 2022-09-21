package com.admissions.empty_project.presentation.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.admissions.domain.HackerNew
import com.admissions.empty_project.data.R
import com.admissions.empty_project.data.databinding.FragmentMainBinding
import com.admissions.empty_project.presentation.main.adapters.HackerNewsAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment(R.layout.fragment_main) {

    private val mViewModel: MainViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = HackerNewsAdapter{ item ->
            findNavController().navigate(MainFragmentDirections.actionMainFragmentToDetailFragment2(item.url))
        }
        adapter.submitList(listOf(
            HackerNew(), HackerNew(),HackerNew(), HackerNew()
        ))
        val binding = FragmentMainBinding.bind(view).apply {
            recycler.adapter = adapter
        }
    }

}