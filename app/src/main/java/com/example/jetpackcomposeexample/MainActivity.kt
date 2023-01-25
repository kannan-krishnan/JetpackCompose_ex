package com.example.jetpackcomposeexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val painter= painterResource(id = R.drawable.sample)
           Box(modifier = Modifier.fillMaxSize(.5f)) {

               ImageCard(painter = painter , title ="android Logo" , contentDescription ="android Logo" )
           }
            /*Column( modifier= Modifier
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
            }*/
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
fun ImageCard(
    painter: Painter, title: String, contentDescription: String, modifier: Modifier = Modifier
) {
    Card(modifier = modifier.fillMaxWidth(), shape = RoundedCornerShape(15.dp), elevation = 5.dp) {
        Box(modifier = Modifier.height(200.dp)) {
            Image(
                painter = painter,
                contentDescription = contentDescription,
                contentScale = ContentScale.Crop
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent, Color.Black
                            ), startY = 300f
                        )
                    )
            ) {

            }

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp),
                contentAlignment = Alignment.BottomStart
            ) {
                Text(text = title, style = TextStyle(color = Color.White, fontSize = 16.sp))

            }

        }

    }
}

