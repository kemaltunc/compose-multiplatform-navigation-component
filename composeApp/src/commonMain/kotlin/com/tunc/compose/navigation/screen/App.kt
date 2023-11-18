package com.tunc.compose.navigation.screen


import androidx.compose.runtime.Composable
import com.tunc.compose.navigation.screen.navigation.MainController
import com.tunc.compose.navigation.screen.navigation.MainScreens
import com.tunc.compose.navigation.screen.screen.BottomNavigationView
import com.tunc.compose.navigation.screen.screen.DetailScreen
import com.tunc.compose.navigation.screen.screen.LoginScreen
import com.tunc.compose.navigation.screen.screen.ProfileScreen
import com.tunc.navigator.nav.NavView
import com.tunc.navigator.page.PageIdentifier

@Composable
fun App() {

    NavView<MainScreens>(
        initial = PageIdentifier(MainScreens.LoginScreen),
        controllerItem = MainController
    ) { screen ->

        when (screen) {
            MainScreens.LoginScreen -> LoginScreen()
            MainScreens.BottomNavigationScreen -> BottomNavigationView()
            is MainScreens.DetailScreen -> DetailScreen(screen.text)
            is MainScreens.ProfileScreen -> ProfileScreen()
        }


    }
}