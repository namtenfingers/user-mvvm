package com.example.usertest.domain.repository

import com.example.usertest.domain.model.UserDTO

interface UserRepository {

    suspend fun getUsers(id: Int, name: String): UserDTO

}