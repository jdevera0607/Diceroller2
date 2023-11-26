package com.example.diceroller
                                                                                                        //import statements
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.diceroller.ui.theme.DiceRollerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiceRollerTheme {
                Surface(

                    modifier = Modifier.fillMaxSize(),                                                  // Accepts modifier, allows for background to fill for the screen
                    color = MaterialTheme.colorScheme.background
                ) {
                    DiceRollerApp()                                                                     //Calls DiceRollerApp function
                }
            }
        }
    }
}

@Preview
@Composable
fun DiceRollerApp() {
    DiceWithButtonAndImage(modifier = Modifier                                                          //Preview function for design, calls DiceWithButtonAndImage function
        .fillMaxSize()                                                                                  //max size modifier to occupy available space
        .wrapContentSize(Alignment.Center)                                                              //Wrap modifier content to center
    )
}

@Composable
fun DiceWithButtonAndImage(modifier: Modifier = Modifier) {
    var result by remember { mutableStateOf( 1) }                                                       //remembers a result then accepts a result variable,
    val imageResource = when(result) {                                                                  //then picks a possible corresponding drawable
                                                                                                        //Imported drawables
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }
    //Creates a vertical layout
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {   //passes modifier argument  horizontal alignment to column and sets value
        Image(painter = painterResource(imageResource), contentDescription = result.toString())       //to ensure column are centered to the device screen

        Button(
            onClick = { result = (1..6).random() },                                             //Clickable roll button to cycle through dice images
        ) {
            Text(text = stringResource(R.string.roll), fontSize = 24.sp)                               //Gets string resource from strings.xml and passes result to text composable
        }
    }
}