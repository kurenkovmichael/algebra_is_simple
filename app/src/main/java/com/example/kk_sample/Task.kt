package com.example.kk_sample
import android.graphics.drawable.Drawable
import kotlinx.serialization.Serializable

@Serializable
data class Task(
    val title: String,
    val formulation: List<String>,
    val answer: List<String>,
    val solutionLink: String
)

fun Task.formulationDrawble(context: android.content.Context) =
    formulation.map { getDrawble(name = it, context = context) }

fun Task.getDrawble(name: String, context: android.content.Context): Drawable? {
    val id = context.resources.getIdentifier(name, "drawable", context.packageName)
    return context.getDrawable(id)
}