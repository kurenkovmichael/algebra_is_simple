package com.example.kk_sample
import android.graphics.drawable.Drawable
import kotlinx.serialization.Serializable

@Serializable
data class Topics(
    val topics: List<Topic>
)

@Serializable
data class Topic(
    val title: String,
    val tasks: List<Task>
)

@Serializable
data class Task(
    val title: String,
    val formulation: String,
    val answer: String,
    val solutionLink: String
)