package com.mark23.androidpractice.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlinx.serialization.Serializable

@Serializable
object Recom

@Composable
fun RecomScreen(
    onBack: () -> Unit,
    modifier: Modifier = Modifier,
) {
    var count1: Int = 0
    // mutableStateOfを使うと、状態変更時に自動的にRecomposeしてくれる。
    // rememberを使うとrecompose時に値を保持してくれる。
    // byはDelegated propertyで、ここではmutableIntState型をInt型のように扱えるようにしてる
    var count2 by remember { mutableIntStateOf(0) }
    // rememberSaveableはアクティビティが破棄されても値を保持する。
    var count3 by rememberSaveable { mutableIntStateOf(0) }

    LaunchedEffect(Unit) {
        while(true) {
            delay(1000)
            count1++
            count2++
            count3++
        }
    }

    Scaffold(modifier = Modifier.fillMaxSize())
    { innerPadding ->
        Column(modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally)
        {
            Text("状態変更しても再コンポーズしないのでcount1の表示は0のまま。。。\n" +
                    "のはずだが、更新される。他ので再コンポーズされているから？")
            Text("count1:${count1}")
            Spacer(modifier = Modifier.height(8.dp))
            Text("count2変更により再コンポーズされるため表示が変わる。\n" +
                    "しかし、画面回転などでアクティビティが破棄（再構成）されるとcount2はリセットされる")
            Text("count2:${count2}")
            Spacer(modifier = Modifier.height(8.dp))
            Text("count3変更により↓のTextが再コンポーズされるため表示が変わる。\n" +
                    "画面回転などでアクティビティが破棄（再構成）されてもcount3はリセットされない")
            Text("count3:${count3}")
        }
    }
}
