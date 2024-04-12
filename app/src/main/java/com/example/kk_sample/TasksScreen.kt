package com.example.kk_sample

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kk_sample.ui.theme.KKsampleTheme

@Composable
fun TasksScreen(
    topic: Topic
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(state = rememberScrollState())
                .background(Color.LightGray)
                .padding(all = 12.dp)
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = topic.title,
                fontSize = 44.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(),
            )
            Spacer(modifier = Modifier.height(16.dp))

            topic.tasks.forEach {
                TaskRow(task = it)
            }

            Spacer(modifier = Modifier.height(80.dp))
        }
    }
}


@Preview(showBackground = true)
@Composable
fun TasksScreenPreview() {
    KKsampleTheme {
        TasksScreen(
            topic = Topic(
                title = "Title",
                tasks = listOf(
                    Task(
                        title = "Task",
                        formulation = "formulation",
                        answer = "answer",
                        solutionLink = "solutionLink"
                    ),
                    Task(
                        title = "Task",
                        formulation = "formulation",
                        answer = "answer",
                        solutionLink = "solutionLink"
                    )
                )
            )
        )
    }
}