package com.mark23.androidpractice.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.compose.dropUnlessResumed
import kotlinx.serialization.Serializable

@Serializable
object Top

@Composable
fun TopScreen(
    onBack: () -> Unit,
    onNextScreen: () -> Unit,
) {

    Scaffold(modifier = Modifier.fillMaxSize(),)
    { innerPadding ->
        Column(modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Text("TopScreen")
            // 多重遷移防止 https://stackoverflow.com/questions/76386471/how-to-avoid-onclick-callback-being-called-multiple-times-jetpack-compose/76386604#76386604
            Button(onClick = dropUnlessResumed
            {
                onNextScreen()
            }) {
                Text("nextScreen")
            }
        }
    }
}
