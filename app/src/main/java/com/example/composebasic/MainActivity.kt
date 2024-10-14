package com.example.composebasic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composebasic.ui.theme.ComposeBasicTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeBasicTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "許閔慈",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    var x = remember { mutableStateOf(0) }

    Box(
        modifier = modifier.fillMaxSize()
    ) {

        Column(
            modifier = Modifier.padding(start = 16.dp, bottom = 16.dp),
            horizontalAlignment = Alignment.Start
        ) {

            Button(
                onClick = {
                    x.value = 0
                },
                modifier = Modifier.padding(bottom = 16.dp)
            ) {
                Text("歸零")
                Image(
                    painter = painterResource(id = R.drawable.dog3),
                    contentDescription = "犬~",
                    modifier = modifier.size(20.dp)
                )
            }

            Text(
                text = x.value.toString(),
                fontSize = 50.sp,
                modifier = modifier.clickable {
                    x.value++
                }
            )


            Button(
                onClick = { x.value *= 2 },
                modifier = Modifier.padding(top = 16.dp)
            ) {
                Text("乘以2")
            }

            Text(
                text = stringResource(R.string.author),
                color = Color.Black,
                fontSize = 50.sp,
                fontFamily = FontFamily(Font(R.font.hand)),
                modifier = modifier.padding(top = 16.dp)
            )
        }

        Image(
            painter = painterResource(id = R.drawable.dog),
            contentDescription = "薩摩耶犬~",
            alpha = 0.7f,
            modifier = Modifier
                .align(Alignment.TopEnd)
                .clip(CircleShape)
        )

        Image(
            painter = painterResource(id = R.drawable.dog2),
            contentDescription = "黃金獵犬~",
            alpha = 0.7f,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .clip(CircleShape)
                .padding(bottom = 16.dp)
        )
    }
}










@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeBasicTheme {
        Greeting("Android")
    }
}