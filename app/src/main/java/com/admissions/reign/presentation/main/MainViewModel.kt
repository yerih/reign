package com.admissions.reign.presentation.main

import androidx.constraintlayout.motion.widget.OnSwipe
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.admissions.domain.HackerNew
import com.admissions.reign.common.launch
import com.admissions.usecases.HackerNewUserCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
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
    interface onSwipeListener{ fun onSwipe(direction: Int, item: HackerNew) }

    init {
        launch(Dispatchers.IO) {
//            delay(6000)
            getHackerNews()
            hackerNewsUseCase.hackerNews().collect{ list -> _state.update { it.copy(list = list) }}
        }
    }

    private suspend fun getHackerNews() = hackerNewsUseCase.requestHackerNews()//.collect{ list -> _state.update { it.copy(list = list) } }
    fun refreshHackerNews() = viewModelScope.launch { hackerNewsUseCase.requestHackerNews() }
    val onSwipe = object : onSwipeListener {
        override fun onSwipe(direction: Int, item: HackerNew) = launch(Dispatchers.IO) { hackerNewsUseCase.delete(item) }
    }
}