package com.denorapplications.mvvmtemplate.presentation

import androidx.lifecycle.ViewModel
import com.denorapplications.mvvmtemplate.domain.usecases.GetItemByIdUseCase
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val getItemByIdUseCase: GetItemByIdUseCase
): ViewModel() {

}