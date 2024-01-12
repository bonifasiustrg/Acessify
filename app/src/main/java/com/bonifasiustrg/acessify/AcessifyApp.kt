package com.bonifasiustrg.acessify

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import com.bonifasiustrg.acessify.data.HomeViewModel
import com.bonifasiustrg.acessify.navigation.PostOfficeAppRouter
import com.bonifasiustrg.acessify.navigation.Screen
import com.bonifasiustrg.acessify.screens.HomeScreen
import com.bonifasiustrg.acessify.screens.LoginScreen
import com.bonifasiustrg.acessify.screens.SignUpScreen
import com.bonifasiustrg.acessify.screens.TermsAndConditionsScreen

@Composable
fun AcessifyApp(homeViewModel: HomeViewModel = viewModel()) {

    homeViewModel.checkForActiveSession()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {

        if (homeViewModel.isUserLoggedIn.value == true) {
            PostOfficeAppRouter.navigateTo(Screen.HomeScreen)
        }

        Crossfade(targetState = PostOfficeAppRouter.currentScreen) { currentState ->
            when (currentState.value) {
                is Screen.SignUpScreen -> {
                    SignUpScreen()
                }

                is Screen.TermsAndConditionsScreen -> {
                    TermsAndConditionsScreen()
                }

                is Screen.LoginScreen -> {
                    LoginScreen()
                }

                is Screen.HomeScreen -> {
                    HomeScreen()
                }
            }
        }

    }
}