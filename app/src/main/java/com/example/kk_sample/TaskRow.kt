package com.example.kk_sample

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kk_sample.ui.theme.KKsampleTheme

@Composable
fun TaskRow(task: Task) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
            .clip(RoundedCornerShape(6))
            .background(Color.White)
    ) {
        Text(
            text = task.title,
            fontSize = 24.sp,
            modifier = Modifier
                .padding(all = 24.dp)
        )
        Text(
            text = task.formulation,
            fontSize = 18.sp,
            modifier = Modifier
                .padding(start = 24.dp, end = 24.dp, bottom = 8.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun TaskRowPreview() {
    KKsampleTheme {
        TaskRow(
            task = Task(
                title = "Task",
                formulation = "formulation",
                answer = "answer",
                solutionLink = "solutionLink"
            )
        )
    }
}