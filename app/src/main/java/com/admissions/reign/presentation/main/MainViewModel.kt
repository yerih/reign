package com.admissions.reign.presentation.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.admissions.domain.HackerNew
import com.admissions.usecases.HackerNewUserCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val hackerNewsUseCase: HackerNewUserCases
): ViewModel() {

    data class UiState(
        val list: List<HackerNew> = emptyList()
    )
    private val _state = MutableStateFlow(UiState())
    val state = _state.asStateFlow()

    init { viewModelScope.launch { getHackerNews() } }

    private suspend fun getHackerNews() = hackerNewsUseCase.getHackerNews().collect{ list -> _state.update { it.copy(list = list) } }
    fun refreshHackerNews() = viewModelScope.launch { hackerNewsUseCase.getHackerNews() }
}