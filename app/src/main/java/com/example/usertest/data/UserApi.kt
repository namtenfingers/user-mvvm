package com.example.usertest.data

import com.example.usertest.domain.model.UserDTO
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface UserApi {

    @GET("/users/{id}")
    suspend fun getUsers(
        @Path("id") id: Int,
        @Query("name") name: String
    ): UserDTO

}