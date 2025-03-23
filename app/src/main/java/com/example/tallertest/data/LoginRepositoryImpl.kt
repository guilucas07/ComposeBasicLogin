package com.example.tallertest.data

import com.example.tallertest.domain.Login
import com.example.tallertest.domain.LoginRepository
import kotlinx.coroutines.delay

class LoginRepositoryImpl : LoginRepository {
    override suspend fun login(data: Login): Boolean {
        delay(1000)
        return true
    }
}