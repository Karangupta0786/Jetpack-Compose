package com.arjun.repeat

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement.Absolute.Center
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arjun.repeat.ui.theme.RepeatTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RepeatTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                   Dlrcntr()
                }
            }
        }
    }
}

@Composable
fun Dlrcntr() {
    val count = remember {
        mutableStateOf(1)
    }
    Column(
        modifier = Modifier.fillMaxSize().background(Color.Black),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "$${count.value * 100}", style = MaterialTheme.typography.h5,color = Color.White)
        Spacer(modifier = Modifier.height(80.dp))
        Custombutton {
            count.value++
        }
        Spacer(modifier = Modifier.height(40.dp))
        Custombutt2 {
            count.value--
        }
        Spacer(modifier = Modifier.height(45.dp))
        if(count.value>0){
            Text(text = "Thank you sir", style = MaterialTheme.typography.h4, color = Color.White )
        }
        else{
            Text(text = "How poor you are..", style = MaterialTheme.typography.h4, color = Color.White
            )
        }
    }

}

@Composable
fun Custombutton(onclick: () -> Unit) {
    Card(
        modifier = Modifier
            .size(90.dp)
            .clip(CircleShape)
            .clickable {
                onclick.invoke()
            },
        backgroundColor = Color.Green
    ) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text(
                text = "Tap",
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            )

        }

    }
}

@Composable
fun Custombutt2(click:() -> Unit) {
    Surface(modifier = Modifier
        .size(90.dp)
        .clip(CircleShape)
        .clickable { click.invoke() }

//        .background(Color.Red, CircleShape)
    )

    {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Red),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Tap", style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RepeatTheme {
        // Greeting("Android")
    }
}