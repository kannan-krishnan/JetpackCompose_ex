package com.example.jetpackcomposeexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import kotlinx.coroutines.launch
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            ConstraintLayoutEx()
//            LazyColumn()
//            SnackBarExample()


            /*Column() {
                val colors= remember {
                    mutableStateOf(Color.Blue)
                }
                ColorBox(modifier= Modifier
                    .fillMaxSize()
                    .weight(1f)){
                    colors.value=it
                }
                Box(modifier = Modifier
                    .weight(1f)
                    .fillMaxSize()
                    .background(colors.value)) {
                    
                }
            }*/

//            TextStyleEx()


            val painter = painterResource(id = R.drawable.sample)
            /*Box(modifier = Modifier.fillMaxSize(.5f)) {

                ImageCard(painter = painter , title ="android Logo" , contentDescription ="android Logo" )
            }*/


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
fun ConstraintLayoutEx(){

    val constantsSet= ConstraintSet {
        val greenBox=createRefFor("greenbox")
        val redBox=createRefFor("redbox")
    constrain(greenBox){
        top.linkTo(parent.top)
        start.linkTo(parent.start)
        width= Dimension.value(150.dp)
        height= Dimension.value(150.dp)
    }
        constrain(redBox){
            top.linkTo(parent.top)
            start.linkTo(greenBox.end)
            end.linkTo(parent.end)
            width= Dimension.value(150.dp)
            height= Dimension.value(150.dp)
        }
        createVerticalChain(    greenBox,redBox, chainStyle = ChainStyle.Packed)
    }
    ConstraintLayout(constantsSet, modifier = Modifier.fillMaxSize()) {
        
        Box(modifier = Modifier
            .background(Color.Green)
            .layoutId("greenbox"))
        Box(modifier = Modifier
            .background(Color.Red)
            .layoutId("redbox")) {

        }


}
}

@Composable
fun LazyColumn() {
    androidx.compose.foundation.lazy.LazyColumn {
        items(
            5000
//            listOf("hi","hello","demo","text","love")
        ) {
//                i,s->
            Text(text = "hello$it", fontSize = 24.sp, modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp))

        }
    }
}

@Composable
fun SnackBarExample() {
    val scaffold = rememberScaffoldState()

    var text by remember {
        mutableStateOf("")
    }
    val scope = rememberCoroutineScope()
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        scaffoldState = scaffold
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        , modifier = Modifier.padding(10.dp)
        ) {
            TextField(value =text ,label={
                                         Text(text = "Enter Name")
            },
                onValueChange ={
                    text=it
                }
            , singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = {
                scope.launch {
                    scaffold.snackbarHostState.showSnackbar("hellooo $text")
                }
            }) {
                Text(text = "Click me")
                
            }
            
        }
        
    }
}

@Composable
fun ColorBox(modifier: Modifier=Modifier,updateColor: (Color)-> Unit){
    val colors=  remember {
       mutableStateOf(Color.Gray)
    }

    Box(modifier= modifier
        .background(colors.value)
        .clickable {

            colors.value = (
                    Color(
                        Random.nextFloat(),
                        Random.nextFloat(),
                        Random.nextFloat(),
                        1f
                    )
                    )
            updateColor(colors.value)
        }) {

    }
}

@Composable
fun TextStyleEx() {

    val fontFamily = FontFamily(
        Font(R.font.lexend_black),
        Font(R.font.lexend_bold),
        Font(R.font.lexend_extra_light),
        Font(R.font.lexend_extrabold),
        Font(R.font.lexend_light),
        Font(R.font.lexend_medium),
    )
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF101010))
    ) {
        Text(
            text = buildAnnotatedString {
                                        withStyle(
                                            style = SpanStyle(
                                                color = Color.Blue, fontSize = 50.sp
                                            )
                                        ){
                                            append("K")
                                        }
                append("annan ")
                withStyle(
                    style = SpanStyle(
                        color = Color.Blue, fontSize = 55.sp
                    )
                ){
                    append("pvm")
                }
                append("007")
            },
            fontSize = 16.sp,
            color = Color.White,
            fontFamily = fontFamily,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.Center,
            textDecoration = TextDecoration.Underline
        )

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

