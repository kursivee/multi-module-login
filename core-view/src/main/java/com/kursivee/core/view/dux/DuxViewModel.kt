package com.kursivee.core.view.dux

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

abstract class DuxViewModel<A, R, S> constructor(
    val store: DuxStore<A, R, S>
): ViewModel() where R : DuxReducer<S, A> {
    val state: S
        get() { return store.state.value!! }
    abstract val loadingAction: A

    fun dispatch(action: A) {
        store.dispatch(action)
    }

    fun request(call: suspend () -> Unit) {
        dispatch(loadingAction)
        viewModelScope.launch {
            call()
        }
    }
}