/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.ui.theme.MyTheme

private const val NAV_DOGGO_LIST = "doggo_list"
private const val NAV_ARGUMENT_DOGGO_INDEX = "doggo_index"
private const val NAV_DOGGO_DETAILS = "doggo_details/"
private const val NAV_DOGGO_DETAILS_TEMPLATE = "$NAV_DOGGO_DETAILS{$NAV_ARGUMENT_DOGGO_INDEX}"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                MyApp()
            }
        }
    }
}

// Start building your app here!
@Composable
fun MyApp() {
    val navController = rememberNavController()
    Surface(color = MaterialTheme.colors.background) {
        NavHost(navController = navController, startDestination = NAV_DOGGO_LIST) {
            composable(NAV_DOGGO_LIST) { ListComposable(navController) }
            composable(
                NAV_DOGGO_DETAILS_TEMPLATE,
                arguments = listOf(navArgument(NAV_ARGUMENT_DOGGO_INDEX) { type = NavType.IntType })
            ) { backStackEntry ->
                DetailComposable(backStackEntry.arguments?.getInt(NAV_ARGUMENT_DOGGO_INDEX) ?: 0)
            }
        }
    }
}

@Composable
private fun ListComposable(navController: NavController) {
    Column(modifier = Modifier.padding(16.dp)) {
        ListHeader()
        ListContent(navController, doggoList)
    }
}

@Composable
private fun ListHeader() {
    Text(
        modifier = Modifier.fillMaxWidth(),
        style = MaterialTheme.typography.h4,
        text = "Good Doggos",
    )
}

@Composable
private fun ListContent(navController: NavController, list: List<Doggo>) {
    LazyColumn(
        modifier = Modifier.padding(top = 16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        items(list.size) { index ->
            DoggoCard(navController, index, list[index])
        }
    }
}

@Composable
private fun DoggoCard(navController: NavController, index: Int, doggo: Doggo) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { navController.navigate("${NAV_DOGGO_DETAILS}$index") },
        elevation = 4.dp,
    ) {
        Column(
            modifier = Modifier.padding(8.dp),
        ) {
            Text(
                style = MaterialTheme.typography.h6,
                text = doggo.name,
            )
            Text(
                style = MaterialTheme.typography.subtitle1,
                text = doggo.shortDescription,
            )
        }
    }
}

@Composable
private fun DetailComposable(doggoIndex: Int) {
    val doggo = doggoList[doggoIndex]
    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            style = MaterialTheme.typography.h4,
            text = doggo.name,
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            modifier = Modifier.fillMaxWidth(),
            style = MaterialTheme.typography.body1,
            textAlign = TextAlign.Justify,
            text = doggo.longDescription,
        )
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        MyApp()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        MyApp()
    }
}
