package com.admissions.reign.common

import androidx.lifecycle.*
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.cancellable
import kotlinx.coroutines.launch


fun <T> LifecycleOwner.launchAndCollect(
    flow: Flow<T>,
    state: Lifecycle.State = Lifecycle.State.STARTED,
    body: (T) -> Unit,
) {
    lifecycleScope.launch {
        this@launchAndCollect.repeatOnLifecycle(state) {
            flow.cancellable().collect(body)
        }
    }
}

fun ViewModel.launch(dispatcher: CoroutineDispatcher = Dispatchers.Main, run: suspend ()->Unit){ viewModelScope.launch(dispatcher){run()} }


