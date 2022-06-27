package com.denorapplications.mvvmtemplate.domain.models

data class CatsListState(
    val isLoading: Boolean,
    val itemsList: List<Cat>?,
    val error: String?
)
