package com.example.kk_sample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.kk_sample.ui.theme.KKsampleTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val repository = TasksRepository(resources = resources)
        repository.loadTopics()

        setContent {
            KKsampleTheme {
                TopicsScreen(repository = repository)
            }
        }
    }
}
