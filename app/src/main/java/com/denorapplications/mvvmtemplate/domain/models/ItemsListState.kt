package com.denorapplications.mvvmtemplate.domain.models

data class ItemsListState(
    val isLoading: Boolean,
    val itemsList: List<Item>?,
    val error: String?
)
