package com.example.compose.basics

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose.basics.ui.theme.ComposebasicsTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
                MyScreenContent()
            }
        }
    }
}

@Composable
fun MyApp(content: @Composable () -> Unit) {
    ComposebasicsTheme {
        Surface(color = Color.Yellow) {
            content()
        }
    }
}

@Composable
fun MyScreenContent(names: List<String> = listOf("Android", "there")) {
    val counterState = remember { mutableStateOf(0) }
    Column(modifier = Modifier.fillMaxHeight()) {
        Column(modifier = Modifier.weight(1f)) {
            names.forEach {
                Greeting(it)
                Divider(color = Color.Black)
            }
        }
        Counter(
            count = counterState.value,
            updateCount = { counterState.value++ }
        )
    }
}

@Composable
fun Greeting(name: String) {
    Surface(color = Color.Yellow) {
        Text(text = "Hello $name!", modifier = Modifier.padding(24.dp))
    }
}

@Composable
fun Counter(count: Int, updateCount: () -> Unit) {
    Button(
        onClick = { updateCount() },
        colors = ButtonConstants.defaultButtonColors(
            backgroundColor = if (count < 5) Color.Gray else Color.Blue
        )
    ) {
        Text(text = "I've been clicked $count times")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposebasicsTheme {
        MyScreenContent()
    }
}