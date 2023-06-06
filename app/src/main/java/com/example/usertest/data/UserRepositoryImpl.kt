package com.example.usertest.data

import com.example.usertest.domain.model.UserDTO
import com.example.usertest.domain.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(private val api: UserApi) : UserRepository {
    override suspend fun getUsers(id: Int, name: String): UserDTO {
        return api.getUsers(id, name)
    }
}