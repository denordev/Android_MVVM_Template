package com.denorapplications.mvvmtemplate.presentation.mainfragment

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.denorapplications.mvvmtemplate.domain.models.CatState
import com.denorapplications.mvvmtemplate.domain.usecases.GetItemByIdUseCase
import com.denorapplications.mvvmtemplate.util.Resource
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val getItemByIdUseCase: GetItemByIdUseCase
): ViewModel() {

    private val _cat = MutableStateFlow<CatState?>(null)
    val cat: StateFlow<CatState?> = _cat.asStateFlow()

    init {
        Log.d("MainViewModel", "Init")
    }

    fun getItemById(id: Long) {

        val result = getItemByIdUseCase(id)
        val state = CatState(isLoading = true, item = null, error = null)

        result.map { result ->
            when(result) {
                is Resource.Error -> {
                    _cat.value = state.copy(isLoading = false, item = null ,error = result.message)
                }
                is Resource.Loading -> {
                    _cat.value = state.copy(isLoading = true, item = null ,error = null)
                }
                is Resource.Success -> {
                    _cat.value = state.copy(isLoading = false, item = result.data, error = null)
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