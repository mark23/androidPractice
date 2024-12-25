package com.mark23.androidpractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mark23.androidpractice.ui.Next
import com.mark23.androidpractice.ui.NextScreen
import com.mark23.androidpractice.ui.Top
import com.mark23.androidpractice.ui.TopScreen
import com.mark23.androidpractice.ui.theme.AndroidPracticeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidPracticeTheme {
                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = Top,
                ) {
                    composable<Top> {
                        TopScreen(onBack = {}, onNextScreen = { navController.navigate(route = Next)})
                    }
                    composable<Next> {
                        NextScreen(onBack = { navController.popBackStack() })
                    }
                }
            }
        }
    }
}
