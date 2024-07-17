package com.gojek.daggersubcomponents

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gojek.daggersubcomponents.data.NameDataSource
import com.gojek.daggersubcomponents.di.ActivityScope
import javax.inject.Inject

@ActivityScope
class MainViewModel @Inject constructor(private val nameDataSource: NameDataSource): ViewModel() {
    private val _nameState = MutableLiveData<String>()
    val nameState: LiveData<String> get() = _nameState

    init {
        getName()
    }

    fun getName() {
        _nameState.value = nameDataSource.getRandomName()
    }
}