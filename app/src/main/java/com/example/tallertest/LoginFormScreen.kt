package com.example.tallertest

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tallertest.ui.theme.TallerTestTheme

@Composable
fun LoginFormScreen(
    viewObject: MainViewObject,
    onButtonClick: () -> Unit,
    onUserNameChanged: (String) -> Unit,
    onPasscodeChanged: (String) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = viewObject.username,
            onValueChange = { onUserNameChanged(it) },
            label = { Text("Username") }
        )
        TextField(
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            value = viewObject.passcode,
            onValueChange = { onPasscodeChanged(it) },
            label = { Text("Password") }
        )
        Spacer(Modifier.height(16.dp))
        Button(onClick = onButtonClick, enabled = viewObject.isButtonEnabled) {
            Text("Send")
        }
    }
}

@Preview
@Composable
private fun LoginFormScreenPreview() {
    TallerTestTheme {
        LoginFormScreen(
            onButtonClick = {},
            onPasscodeChanged = {},
            onUserNameChanged = {},
            viewObject = MainViewObject(
                username = "",
                passcode = "",
                isButtonEnabled = true
            )
        )
    }
}