package com.gibran.marvelservice.model

import kotlinx.serialization.Serializable

@Serializable
data class Data<T>(
    val count: Int,
    val limit: Int,
    val offset: Int,
    val results: List<T>,
    val total: Int
)