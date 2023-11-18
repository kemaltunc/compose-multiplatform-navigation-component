package com.tunc.compose.navigation.screen.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tunc.compose.navigation.screen.navigation.MainController
import com.tunc.compose.navigation.screen.navigation.MainScreens
import com.tunc.navigator.page.PageIdentifier

@Composable
fun Search() {

    LazyColumn {
        items(100) {
            Text("Go Detail $it", modifier = Modifier.padding(20.dp).clickable {
                MainController.get()
                    .navigate(PageIdentifier(MainScreens.DetailScreen("Detail Text")))
            })
            Divider()
        }
    }
}