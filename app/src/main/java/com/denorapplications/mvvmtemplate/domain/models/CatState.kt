package com.denorapplications.mvvmtemplate.domain.models

data class CatState(
    val isLoading: Boolean,
    val item: Cat?,
    val error: String?
)
