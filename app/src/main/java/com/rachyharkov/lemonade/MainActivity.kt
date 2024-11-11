package com.rachyharkov.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rachyharkov.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LemonadeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    LemonadeApp()
                }
            }
        }
    }
}

@Composable
fun LemonadeImage(image: Int, cd: Int) {
    Image(
        painter = painterResource(image),
        contentDescription = stringResource(cd),
        modifier = Modifier.padding(16.dp)
    )
}

@Composable
fun LemonadeApp() {

    var tapping = remember { mutableIntStateOf(0) }
    var step = remember { mutableIntStateOf(0) }
    var image = R.drawable.lemon_tree
    var imageCd = R.string.image_cd_1
    var message = R.string.message_1

    when(step.intValue) {
        0 -> {
            image = R.drawable.lemon_tree
            imageCd = R.string.image_cd_1
            message = R.string.message_1
        }
        1 -> {
            image = R.drawable.lemon_squeeze
            imageCd = R.string.image_cd_2
            message = R.string.message_2
        }
        2 -> {
            image = R.drawable.lemon_drink
            imageCd = R.string.image_cd_3
            message = R.string.message_3
        }
        3 -> {
            image = R.drawable.lemon_restart
            imageCd = R.string.image_cd_4
            message = R.string.message_4
        }
    }

    Surface (
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = {
                    if(step.intValue == 3) {
                        step.intValue = 0
                        return@Button
                    }
                    step.intValue++
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF5AF3AE),
                )
            ) {
                LemonadeImage(image, imageCd)
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = stringResource(message)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppPreview() {
    LemonadeTheme {
        LemonadeApp()
    }
}