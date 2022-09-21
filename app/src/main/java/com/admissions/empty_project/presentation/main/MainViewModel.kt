package com.admissions.empty_project.presentation.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.admissions.domain.HackerNew
import com.admissions.usecases.AnyUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    val hackerNewsUseCase: AnyUseCases
): ViewModel() {

    data class UiState(
        val list: List<HackerNew> = emptyList()
    )
    private val _state = MutableStateFlow(UiState())
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch { getHackerNews() }
    }

    suspend fun getHackerNews(){
        val result = hackerNewsUseCase.getHackerNews()
        _state.update { it.copy(list = result.result!!) }
    }
}