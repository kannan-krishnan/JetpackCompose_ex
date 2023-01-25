package com.example.jetpackcomposeexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
          /* Column( modifier= Modifier
               .fillMaxSize()
               .background(Color.Yellow),

               horizontalAlignment = Alignment.CenterHorizontally,
               verticalArrangement = Arrangement.SpaceEvenly
           ) { // place item one by one
               Text(text = "hello")
               Text(text = "tamil")
           }*/
           Row(
               modifier= Modifier
                   .fillMaxSize()
                   .background(Color.Yellow),

             horizontalArrangement = Arrangement.SpaceAround,
               verticalAlignment = Alignment.CenterVertically
           ) { // place  Side by side
               Text(text = "hello")
               Text(text = "tamil")
           }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
        Greeting("Android")

}