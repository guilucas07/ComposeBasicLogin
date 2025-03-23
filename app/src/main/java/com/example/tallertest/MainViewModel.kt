package com.example.tallertest

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tallertest.data.LoginRepositoryImpl
import com.example.tallertest.domain.Login
import com.example.tallertest.domain.LoginRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val repository: LoginRepository = LoginRepositoryImpl()
    private val viewObject = MutableStateFlow(MainViewObject("", "", true))
    fun viewObject(): StateFlow<MainViewObject> = viewObject

    fun onUsernameChanged(text: String) {
        viewObject.update {
            it.copy(
                username = text,
                isButtonEnabled = isButtonEnabled(username = text, passcode = it.passcode)
            )
        }
    }

    fun onPasscodeChanged(passcode: String) {
        viewObject.update {
            it.copy(
                passcode = passcode,
                isButtonEnabled = isButtonEnabled(username = it.username, passcode = passcode)
            )
        }
    }

    fun onSendButtonClick() {
        viewModelScope.launch {
            showLoading(true)
            repository.login(
                Login(
                    username = viewObject.value.username,
                    passcode = viewObject.value.passcode
                )
            )
            showLoading(false)
        }
    }

    private fun showLoading(isVisible: Boolean) {
        // implement later
    }

    private fun isButtonEnabled(username: String, passcode: String): Boolean =
        username.isNotEmpty() && passcode.isNotEmpty()
}