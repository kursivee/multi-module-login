package com.kursivee.core.view.dux

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

abstract class DuxStore<A, R, S> constructor(
    private val reducer: R
) where R : DuxReducer<S, A> {
    protected abstract val mutableState: MutableLiveData<S>
    abstract val state: LiveData<S>

    fun dispatch(action: A) {
        reducer.reduce(mutableState.value!!, action).run {
            mutableState.postValue(this)
        }
    }
}