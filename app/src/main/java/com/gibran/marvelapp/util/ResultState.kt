package com.gibran.marvelapp.util

sealed class ResultState<out T : Any> {
    data class Success<out T : Any>(val data: T) : ResultState<T>()
    sealed class Error(val throwable: Throwable) : ResultState<Nothing>() {
        class RecoverableError(throwable: Throwable, var action: (() -> Unit)? = null) :
            Error(throwable)

        class NonRecoverableError(throwable: Throwable) : Error(throwable)
    }

    object Loading : ResultState<Nothing>()
}