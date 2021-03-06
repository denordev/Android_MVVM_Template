package com.denorapplications.mvvmtemplate.domain.models

data class CatsListState(
    val isLoading: Boolean,
    val list: List<Cat>?,
    val error: String?
)
