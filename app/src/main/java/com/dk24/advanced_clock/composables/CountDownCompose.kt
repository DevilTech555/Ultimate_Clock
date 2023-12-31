package com.dk24.advanced_clock.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dk24.advanced_clock.R
import com.dk24.advanced_clock.ui.theme.Advanced_ClockTheme


private val timeList = arrayListOf(10, 15, 20, 25, 30)
private var timeTxt = mutableStateOf("00 : 00")

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun CountDownCompose(timeList : ArrayList<Int>, timeTxt : MutableState<String>) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 16.dp, start = 16.dp, end = 16.dp, bottom = 16.dp)
    ) {
        Spacer(modifier = Modifier.weight(1f))
        CircularProgressBarWithTextInMiddle(timeTxt)
        Spacer(modifier = Modifier.weight(1f))
        FlowRow(
            horizontalArrangement = Arrangement.Center
        ) {
            for (time in timeList) {
                DefaultButton(onClick = { timeTxt.value = "00 : $time" }, text = "$time min")
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        TimerControls()
    }
}

@Composable
fun DefaultButton(onClick: () -> Unit, text: String) {
    ElevatedButton(
        onClick = onClick,
        modifier = Modifier
            .defaultMinSize(minWidth = 100.dp)
            .padding(8.dp)
    ) {
        Text(text = text)
    }
}

@Composable
fun TimerControls() {
    Row(
        modifier = Modifier.padding(start = 26.dp, end = 26.dp, bottom = 26.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        IconButton(
            modifier = Modifier
                .background(
                    color = MaterialTheme.colorScheme.secondary,
                    shape = CircleShape
                )
                .defaultMinSize(minWidth = 48.dp, minHeight = 48.dp), onClick = { }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_pause),
                contentDescription = "",
                modifier = Modifier.padding(15.dp),
                tint = colorResource(id = R.color.white)
            )
        }
        IconButton(
            modifier = Modifier
                .background(
                    color = MaterialTheme.colorScheme.primary,
                    shape = CircleShape
                )
                .defaultMinSize(minWidth = 90.dp, minHeight = 90.dp), onClick = { }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_play),
                contentDescription = "",
                modifier = Modifier.padding(
                    start = 20.dp,
                    end = 10.dp,
                    top = 15.dp,
                    bottom = 15.dp
                ),
                tint = colorResource(id = R.color.white)
            )
        }
        IconButton(
            modifier = Modifier
                .background(
                    color = MaterialTheme.colorScheme.secondary,
                    shape = CircleShape
                )
                .defaultMinSize(minWidth = 48.dp, minHeight = 48.dp), onClick = { }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_reset),
                contentDescription = "",
                modifier = Modifier.padding(15.dp),
                tint = colorResource(id = R.color.white)
            )
        }
    }
}

@Composable
fun CircularProgressBarWithTextInMiddle(timeTxt: MutableState<String>) {
    Box(
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(
            modifier = Modifier
                .width(300.dp)
                .height(300.dp),
            color = MaterialTheme.colorScheme.primary,
            strokeWidth = 5.dp,
            progress = 1f
        )
        Text(text = timeTxt.value, fontSize = 56.sp)
    }
}

@Preview(showBackground = true, device = Devices.PIXEL_4_XL)
@Composable
fun CountDownComposePreview() {
    Advanced_ClockTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            CountDownCompose(timeList, timeTxt)
        }
    }
}
