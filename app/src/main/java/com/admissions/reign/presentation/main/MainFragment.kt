package com.admissions.reign.presentation.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.admissions.reign.common.launchAndCollect
import com.admissions.reign.data.R
import com.admissions.reign.data.databinding.FragmentMainBinding
import com.admissions.reign.presentation.main.adapters.HackerNewsAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment(R.layout.fragment_main) {

    private val mViewModel: MainViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = HackerNewsAdapter { item ->
            findNavController().navigate(MainFragmentDirections.actionMainFragmentToDetailFragment2(item.url))
        }
        val binding = FragmentMainBinding.bind(view).apply { viewModel = mViewModel; recycler.adapter = adapter }
        launchAndCollect(mViewModel.state){ state -> binding.state = state }
    }

}