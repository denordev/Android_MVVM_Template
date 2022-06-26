package com.denorapplications.mvvmtemplate.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.denorapplications.mvvmtemplate.domain.models.ItemState
import com.denorapplications.mvvmtemplate.domain.usecases.GetItemByIdUseCase
import com.denorapplications.mvvmtemplate.util.Resource
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class MainViewModel(
    private val getItemByIdUseCase: GetItemByIdUseCase
): ViewModel() {

    private val _item = MutableStateFlow<ItemState?>(null)
    val item: StateFlow<ItemState?> = _item.asStateFlow()

    fun getItemById(id: Long) {

        val result = getItemByIdUseCase(id)
        val state = ItemState(isLoading = true, item = null, error = null)

        result.map { result ->
            when(result) {
                is Resource.Error -> {
                    _item.value = state.copy(isLoading = false, item = null ,error = result.message)
                }
                is Resource.Loading -> {
                    _item.value = state.copy(isLoading = true, item = null ,error = null)
                }
                is Resource.Success -> {
                    _item.value = state.copy(isLoading = false, item = result.data, error = null)
                }
            }
        }.launchIn(viewModelScope)
    }
}