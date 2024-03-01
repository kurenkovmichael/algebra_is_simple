package com.example.kk_sample

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun TasksScreen(topic: Topic) {
    Text(text = topic.title)
}