package com.tunc.compose.navigation.screen.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.tunc.compose.navigation.screen.navigation.MainController
import com.tunc.compose.navigation.screen.navigation.MainScreens
import com.tunc.navigator.page.PageIdentifier

@Composable
fun LoginScreen() {


    val mainController = MainController.get()


    Box(modifier = Modifier.fillMaxSize()) {
        Button(modifier = Modifier.align(Alignment.Center), onClick = {
            mainController.navigate(PageIdentifier(MainScreens.BottomNavigationScreen))
        }) {
            Text("Go to BottomNavigation Screen")
        }
    }

}
