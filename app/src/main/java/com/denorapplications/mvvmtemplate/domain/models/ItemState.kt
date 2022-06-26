package com.denorapplications.mvvmtemplate.domain.models

data class ItemState(
    val isLoading: Boolean,
    val item: Item?,
    val error: String?
)
