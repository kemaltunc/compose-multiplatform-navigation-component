package com.tunc.compose.navigation.screen.navigation

import com.tunc.navigator.page.Page

sealed class MainScreens : Page() {
    data object LoginScreen : MainScreens()
    data object BottomNavigationScreen : MainScreens()
    data class DetailScreen(val text: String) : MainScreens()
    data class ProfileScreen(val text: String) : MainScreens()
}


sealed class TabScreens : Page() {
    data object MenuHome : TabScreens()
    data object MenuProfile : TabScreens()
    data object MenuSearch : TabScreens()
    data object MenuSettings : TabScreens()
    data object MenuHomeDetail : TabScreens()
}