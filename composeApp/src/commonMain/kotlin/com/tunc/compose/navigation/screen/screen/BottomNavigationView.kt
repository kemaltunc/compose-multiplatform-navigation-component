package com.tunc.compose.navigation.screen.screen

import HomeScreen
import HomeScreenDetail
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.tunc.compose.navigation.screen.navigation.ChildController
import com.tunc.compose.navigation.screen.navigation.TabScreens
import com.tunc.navigator.nav.NavView
import com.tunc.navigator.page.PageIdentifier

@Composable
fun BottomNavigationView() {


    NavView<TabScreens>(
        initial = PageIdentifier(page = TabScreens.MenuHome).apply {
            isGroupItem = true
            initialPage = true
        },
        controllerItem = ChildController
    ) { tab ->
        val childController = ChildController.get()

        Column {
            Box(modifier = Modifier.fillMaxWidth().background(Color.Gray)) {
                IconButton(onClick = {
                    childController.navigateUp()
                }) {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
                }
            }
            Box(modifier = Modifier.weight(1f)) {
                when (tab) {
                    TabScreens.MenuHome -> {
                        HomeScreen()
                    }

                    TabScreens.MenuProfile -> {
                        ProfileScreen()
                    }

                    TabScreens.MenuSearch -> Search()
                    TabScreens.MenuSettings -> Settings()
                    TabScreens.MenuHomeDetail -> HomeScreenDetail()
                }
            }

            Row(modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp)) {
                IconButton(modifier = Modifier.weight(1f), onClick = {
                    goScreen(TabScreens.MenuHome)
                }) {
                    Icon(
                        imageVector = Icons.Default.Home,
                        contentDescription = null,
                        tint = getColor(TabScreens.MenuHome)
                    )
                }

                Spacer(modifier = Modifier.width(16.dp))

                IconButton(modifier = Modifier.weight(1f), onClick = {
                    goScreen(TabScreens.MenuProfile)
                }) {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = null,
                        tint = getColor(TabScreens.MenuProfile)
                    )
                }

                Spacer(modifier = Modifier.width(16.dp))

                IconButton(modifier = Modifier.weight(1f), onClick = {
                    goScreen(TabScreens.MenuSearch)
                }) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = null,
                        tint = getColor(TabScreens.MenuSearch)
                    )
                }
                Spacer(modifier = Modifier.width(16.dp))

                IconButton(modifier = Modifier.weight(1f), onClick = {
                    goScreen(TabScreens.MenuSettings)
                }) {
                    Icon(
                        imageVector = Icons.Default.Settings,
                        contentDescription = null,
                        tint = getColor(TabScreens.MenuSettings)
                    )
                }
            }
        }
    }

}

private fun goScreen(screen: TabScreens) {
    val childController = ChildController.get()
    childController.navigate(PageIdentifier(screen).apply {
        isGroupItem = true
    })
}

private fun getColor(screen: TabScreens): Color {
    val isSelected = ChildController.get().isGroupItem(screen)

    return if (isSelected) Color.Black else Color.Gray
}