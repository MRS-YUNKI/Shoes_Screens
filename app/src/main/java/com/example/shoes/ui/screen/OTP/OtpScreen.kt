package com.example.shoes.ui.screen.OTP

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun OtpScreen() {

}

@Composable
fun testOtpTextField(){
    val text = remember { mutableListOf("") }
    OtpTextField(text.value, 4, modifier = Modifier.fillMaxWidth().height(100.dp)) {
        text.value = it
    }
}

@Composable
fun OtpTextField(
    value: String,
    length: Int,
    modifier: Modifier = Modifier,
    keyboardOptions: KeyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
    keyboardActions: KeyboardActions = KeyboardActions(),
    onValueChanged: (String) -> Unit,
) {
    BasicTextField(
        value = value,
        modifier = modifier,
        keyboardActions = keyboardActions,
        keyboardOptions = keyboardOptions,
        decorationBox = {
            val spaceBoxBetween = 12.dp
            Row(modifier = Modifier
                .fillMaxWidth()
                .height(100.dp),
                horizontalArrangement = Arrangement.spacedBy(spaceBoxBetween)
            ) {

            }
        }

    )
}