package com.denorapplications.mvvmtemplate.presentation.catslistfragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.denorapplications.mvvmtemplate.domain.models.CatsListState
import com.denorapplications.mvvmtemplate.domain.usecases.GetCatsListUseCase
import com.denorapplications.mvvmtemplate.util.Resource
import kotlinx.coroutines.flow.* // ktlint-disable no-wildcard-imports
import javax.inject.Inject

class CatListViewModel @Inject constructor(
    private val getCatsListUseCase: GetCatsListUseCase
) : ViewModel() {

    private val state = CatsListState(isLoading = false, list = null, error = null)
    private val _catsList = MutableStateFlow<CatsListState?>(state)
    val catsList: StateFlow<CatsListState?> = _catsList.asStateFlow()

    fun getCatsList() {
        val result = getCatsListUseCase()

        result.map { result ->
            when (result) {
                is Resource.Loading -> {
                    _catsList.value =
                        state.copy(isLoading = true, list = null, error = null)
                }
                is Resource.Error -> {
                    _catsList.value =
                        state.copy(isLoading = false, list = null, error = result.message)
                }
                is Resource.Success -> {
                    _catsList.value =
                        state.copy(isLoading = false, list = result.data, error = null)
                }
            }
        }.launchIn(viewModelScope)
    }
}
