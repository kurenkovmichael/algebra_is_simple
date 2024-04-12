package com.example.kk_sample

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowForward
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kk_sample.ui.theme.KKsampleTheme

@Composable
fun TopicRow(
    topic: Topic,
    onTaskClick: (Task) -> Unit = { }
) {

    var expanded by remember { mutableStateOf(true) }

    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(12.dp)
        .clip(RoundedCornerShape(6))
        .background(Color.White)
    ) {
        Text(
            text = topic.title,
            fontSize = 24.sp,
            modifier = Modifier
                .padding(all = 24.dp)
                .clickable(onClick = { expanded = !expanded })
        )

        if (expanded) {
            topic.tasks.forEach {
                Text(
                    text = "‣ " + it.title,
                    fontSize = 18.sp,
                    modifier = Modifier
                        .padding(start = 24.dp, end = 24.dp, top = 0.dp, bottom = 8.dp)
                        .clickable { onTaskClick(it) }
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
        }
    }

}

@Preview(showBackground = true)
@Composable
fun TopicRowPreview() {
    KKsampleTheme {
        TopicRow(
            Topic(
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