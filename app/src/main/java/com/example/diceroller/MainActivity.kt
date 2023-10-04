package com.example.diceroller

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.diceroller.ui.theme.DiceRollerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiceRollerTheme {
                DiceRollerApp()
            }
        }
    }
}

@Preview
@Composable
fun DiceRollerApp() {
    DiceWithButtonAndImage(modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center))
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DiceWithButtonAndImage(modifier: Modifier = Modifier) {
    var resultForDiceOne by remember { mutableStateOf(1) }
    var resultForDiceTwo by remember { mutableStateOf(1) }

    var imageResourceForDiceOne = when (resultForDiceOne) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }

    var imageResourceForDiceTwo = when (resultForDiceTwo) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }

    TopAppBar(title = { Text(text = "Dice Roller") },
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = Color(0xFFf0ad4e),
            titleContentColor = Color.White,
        ),)

    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Row {
            Image(painter = painterResource(imageResourceForDiceOne), contentDescription = resultForDiceOne.toString())
            Image(painter = painterResource(imageResourceForDiceTwo), contentDescription = resultForDiceTwo.toString())
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { resultForDiceOne = (1..6).random()
            resultForDiceTwo = (1..6).random() }) {
            Text(stringResource(R.string.roll), modifier = Modifier.padding(6.dp),
                style = TextStyle(
                    color = Color.Yellow,
                    fontSize = 16.sp
                )
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "You rolled: ${resultForDiceOne + resultForDiceTwo}")
    }

}

