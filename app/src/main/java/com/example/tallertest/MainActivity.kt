package com.example.tallertest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import com.example.tallertest.ui.theme.TallerTestTheme

class MainActivity : ComponentActivity() {
    private val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TallerTestTheme {
                val viewObject = viewModel.viewObject().collectAsState().value
                LoginFormScreen(
                    viewObject = viewObject,
                    onUserNameChanged = { viewModel.onUsernameChanged(it) },
                    onPasscodeChanged = { viewModel.onPasscodeChanged(it) },
                    onButtonClick = { viewModel.onSendButtonClick() },
                )
            }
        }
    }
}
