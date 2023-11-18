package com.tunc.compose.navigation.screen.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.tunc.compose.navigation.screen.navigation.MainController

@Composable
fun DetailScreen(text: String) {

    val mainController = MainController.get()

    Column {

        Button(onClick = {
            mainController.navigateUp()
        }) {
            Text("Back")
        }
        Text(text)

    }


}