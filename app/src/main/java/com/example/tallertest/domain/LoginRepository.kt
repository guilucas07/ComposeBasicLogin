package com.example.tallertest.domain

interface LoginRepository {
    suspend fun login(data: Login): Boolean
}

