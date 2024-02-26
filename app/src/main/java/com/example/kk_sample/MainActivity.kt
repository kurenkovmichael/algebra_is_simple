package com.example.kk_sample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kk_sample.ui.theme.KKsampleTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val repository = TasksRepository(resources = resources)
        val topics = repository.loadTopics()

        setContent {
            Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                Column {
                    topics.forEach {
                        TextRow(it.title)
                    }
                }
            }
        }
    }
}

@Composable
fun TextRow(name: String) {
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
            text = "Hello $name!",
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
fun GreetingPreview() {
    KKsampleTheme {
        TextRow("Android")
    }
}