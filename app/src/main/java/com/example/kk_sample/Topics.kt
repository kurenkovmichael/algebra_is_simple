package com.example.kk_sample

import kotlinx.serialization.Serializable

@Serializable
data class Topics(
    val topics: List<Topic>
)