package com.kursivee.core.view.dux

abstract class DuxReducer<S, A> {
    abstract fun reduce(state: S, action: A): S
}