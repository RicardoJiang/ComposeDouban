package com.zj.composedouban

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import com.google.accompanist.insets.ProvideWindowInsets
import com.zj.composedouban.ui.screens.home.HomeScreen
import com.zj.composedouban.ui.screens.splash.SplashScreen
import com.zj.composedouban.ui.theme.ComposeDoubanTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            ComposeDoubanUI()
        }
    }
}

enum class AppState {
    Splash,
    Home
}

@Composable
fun ComposeDoubanUI() {
    ComposeDoubanTheme {
        ProvideWindowInsets {
            val (appState, setAppState) = remember { mutableStateOf(AppState.Splash) }

            when (appState) {
                AppState.Splash -> {
                    SplashScreen { setAppState(AppState.Home) }
                }
                AppState.Home -> {
                    HomeScreen()
                }

            }

        }
    }
}