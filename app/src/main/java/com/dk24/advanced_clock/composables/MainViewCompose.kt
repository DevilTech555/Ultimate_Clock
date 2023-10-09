package com.dk24.advanced_clock.composables

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.dk24.advanced_clock.ui.theme.Advanced_ClockTheme

@Composable
fun MainViewCompose() {

}


@Preview(showBackground = true, device = Devices.PIXEL_4_XL)
@Composable
fun MainViewComposePreview() {
    Advanced_ClockTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            MainViewCompose()
        }
    }
}
