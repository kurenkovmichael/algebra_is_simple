package com.example.kk_sample

import kotlinx.serialization.Serializable

@Serializable
data class Topic(
    val title: String,
    val tasks: List<Task>
)
