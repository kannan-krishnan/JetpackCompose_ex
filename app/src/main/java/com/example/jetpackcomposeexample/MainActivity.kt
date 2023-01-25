package com.example.jetpackcomposeexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           Column( modifier= Modifier
               .fillMaxHeight(.5f)
               .fillMaxWidth()
//               .requiredWidth(600.dp)
               .padding(16.dp)

               .border(5.dp,Color.Magenta)
               .padding(16.dp)
               .border(5.dp,Color.Blue)
               .padding(16.dp)
               .border(5.dp,Color.Cyan)
               .background(Color.Yellow),

//               horizontalAlignment = Alignment.CenterHorizontally,
//               verticalArrangement = Arrangement.SpaceEvenly
           ) { // place item one by one
               Text(text = "hello",

                   modifier=Modifier
//                       .offset(50.dp,20.dp)
                       .clickable {

                       }
               )
               Text(text = "tamil")
           }
          /* Row(
               modifier= Modifier
//                   .fillMaxSize(.6f)
                   .width(300.dp)
//                   .height(300.dp)
                   .fillMaxHeight(0.5f)
                   .background(Color.Yellow),

             horizontalArrangement = Arrangement.SpaceAround,
               verticalAlignment = Alignment.CenterVertically
           ) { // place  Side by side
               Text(text = "hello")
               Text(text = "tamil")
           }*/
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