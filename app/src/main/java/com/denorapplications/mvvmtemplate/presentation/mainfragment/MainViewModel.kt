package com.denorapplications.mvvmtemplate.presentation.mainfragment

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.denorapplications.mvvmtemplate.domain.models.ItemState
import com.denorapplications.mvvmtemplate.domain.usecases.GetItemByIdUseCase
import com.denorapplications.mvvmtemplate.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.* // ktlint-disable no-wildcard-imports
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getItemByIdUseCase: GetItemByIdUseCase
) : ViewModel() {

    private val state = ItemState(isLoading = true, item = null, error = null)
    private val _item = MutableStateFlow<ItemState?>(state)
    val item: StateFlow<ItemState?> = _item.asStateFlow()

    init {
        Log.d("MainViewModel", "Init")
    }

    fun getItemById(id: Long) {

        val result = getItemByIdUseCase(id)

        result.map { result ->
            when (result) {
                is Resource.Error -> {
                    _item.value = state.copy(isLoading = false, item = null, error = result.message)
                }
                is Resource.Loading -> {
                    _item.value = state.copy(isLoading = true, item = null, error = null)
                }
                is Resource.Success -> {
                    _item.value = state.copy(isLoading = false, item = result.data, error = null)
                }
            }
        }.launchIn(viewModelScope)
    }

    fun alive() {
        Log.d("MainViewModel", "I'm alive")
    }

    override fun onCleared() {
        super.onCleared()
        Log.d("MainViewModel", "Clear")
    }
}
