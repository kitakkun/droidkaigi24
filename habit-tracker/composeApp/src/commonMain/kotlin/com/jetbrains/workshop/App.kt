package com.jetbrains.workshop

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import kotlinproject.composeapp.generated.resources.Res
import kotlinproject.composeapp.generated.resources.app_name
import kotlinproject.composeapp.generated.resources.bliss
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
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
            Modifier
                .paint(
                    painterResource(Res.drawable.bliss),
                    contentScale = ContentScale.FillBounds,
                )
                .fillMaxSize(),
            contentAlignment = Alignment.Center,
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    text = stringResource(Res.string.app_name),
                    style = MaterialTheme.typography.h1,
                )
                exercises.forEach {
                    MyElement(
                        label = it,
                        count = 10,
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
) {
    var editableLabel by remember(label) { mutableStateOf(label) }
    var counter by remember(count) { mutableStateOf(count) }
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
        TextField(
            editableLabel,
            onValueChange = {
                editableLabel = it
            },
        )
        IconButton(onClick = { counter-- }) {
            Icon(
                Icons.Default.Delete,
                null,
            )
        }
        Text(counter.toString())
        IconButton(onClick = { counter++ }) {
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
    )
}
















