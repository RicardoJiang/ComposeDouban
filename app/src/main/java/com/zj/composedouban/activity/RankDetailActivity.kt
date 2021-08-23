package com.zj.composedouban.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.core.view.WindowCompat
import com.google.accompanist.insets.ProvideWindowInsets
import com.zj.composedouban.ui.screens.rank.RankScreen
import com.zj.composedouban.ui.theme.ComposeDoubanTheme

class RankDetailActivity : ComponentActivity() {
    companion object {
        fun navigate(context: Context) {
            val intent = Intent(context, RankDetailActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            RankDetailPage()
        }
    }
}

@Composable
fun RankDetailPage() {
    ComposeDoubanTheme {
        ProvideWindowInsets {
            RankScreen()
        }
    }
}