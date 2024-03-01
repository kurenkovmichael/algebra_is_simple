package com.example.kk_sample

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kk_sample.ui.theme.KKsampleTheme

@Composable
fun TopicRow(topic: Topic) {
    Row(
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .background(color = Color.Transparent)
            .border(width = 1.dp, color = Color.Black)
            .fillMaxWidth()
            .height(100.dp)
    ) {
        Text(
            text = "Hello ${topic.title}!",
            fontSize = 30.sp,
            modifier = Modifier
                .padding(20.dp)
        )
        Image(
            Icons.Rounded.ShoppingCart,
            contentDescription = null,
            alignment = Alignment.Center,
            modifier = Modifier
                .padding(20.dp)
        )

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
                        formulation = listOf(),
                        answer = listOf(),
                        solutionLink = "solutionLink"
                    )
                )
            )
        )
    }
}