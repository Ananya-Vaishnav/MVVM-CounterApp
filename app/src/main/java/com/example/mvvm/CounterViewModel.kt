package com.example.mvvm

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel


class CounterViewModel() : ViewModel() {
    private val _repository: CounterRepository = CounterRepository()
    private val _count = mutableStateOf(_repository.getCounter().count)

    //Expose the count as an immutable state
    //(meaning now the priv var _count is not visible to the user, but it's value is)
    val count : MutableState<Int> = _count

    fun increment() {
        _repository.incrementCounter()
        _count.value = _repository.getCounter().count
    }
    fun decrement() {
        _repository.decrementCounter()
        _count.value = _repository.getCounter().count
    }
}