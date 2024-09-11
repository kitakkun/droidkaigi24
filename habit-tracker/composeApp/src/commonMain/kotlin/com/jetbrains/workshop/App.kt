package com.jetbrains.workshop

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    val exercises = listOf(
        "Running",
        "Pull-ups",
        "Squats",
        "Plank",
        "Dumbbells",
        "Jogging",
        "Push-ups",
        "Lunges",
        "Sit-ups",
        "High knees",
        "Burpees",
    )
    MaterialTheme {
        Box(
            Modifier.fillMaxSize().background(Color.White),
            contentAlignment = Alignment.Center,
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    text = "Habit Tracker",
                    style = MaterialTheme.typography.h1,
                )
                exercises.forEach {
                    MyElement(
                        label = it,
                        count = 10,
                        onUpdateLabel = {},
                        onClickMinus = {},
                        onClickPlus = {},
                    )
                }
            }
        }
    }
}

@Composable
fun MyElement(
    label: String,
    count: Int,
    onUpdateLabel: (String) -> Unit,
    onClickMinus: () -> Unit,
    onClickPlus: () -> Unit,
) {
    Row(
        modifier = Modifier
            .border(
                width = 1.dp,
                color = Color.Black,
                shape = RoundedCornerShape(10.dp)
            )
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(
            10.dp,
        )
    ) {
        TextField(label, onUpdateLabel)
        IconButton(onClick = onClickMinus) {
            Icon(
                Icons.Default.Delete,
                null,
            )
        }
        Text(count.toString())
        IconButton(onClick = onClickPlus) {
            Icon(
                Icons.Default.Add,
                null,
            )
        }
    }
}

@Preview
@Composable
fun MyElementPreview() {
    MyElement(
        "Hello",
        count = 10,
        onUpdateLabel = {},
        onClickMinus = {},
        onClickPlus = {},
    )
}
















