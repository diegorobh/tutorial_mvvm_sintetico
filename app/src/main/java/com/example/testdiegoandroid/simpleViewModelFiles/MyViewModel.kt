package com.example.testdiegoandroid.simpleViewModelFiles

import android.arch.lifecycle.*
import android.os.Bundle

class MyViewModel(private var count: Int = 0) : ViewModel(),
    LifecycleObserver {
    companion object { const val COUNT_KEY = "CountKey" }

    val changeNotifier = MutableLiveData<Int>()

    fun increment() { changeNotifier.value = ++count }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume() { increment() }

    fun saveState(outState: Bundle) {
        outState.putInt(COUNT_KEY, count)
    }

    fun restoreState(inState: Bundle?) {
        inState?.let { count = inState.getInt(COUNT_KEY) }
    }
}