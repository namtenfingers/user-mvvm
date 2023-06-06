package com.example.usertest.domain.usecase

import com.example.usertest.common.Resource
import com.example.usertest.domain.model.UserDTO
import com.example.usertest.domain.model.toUser
import com.example.usertest.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetUsersUseCase @Inject constructor(private val userRepository: UserRepository) {
    operator fun invoke(id: Int, name: String): Flow<Resource<UserDTO>> = flow {
        try {
            emit(Resource.Loading())
            val users = userRepository.getUsers(id, name)
            emit(Resource.Success(users))
        } catch (e: HttpException){
            emit(Resource.Error(e.localizedMessage ?: "An expected error occur"))
        } catch (e: IOException){
            emit(Resource.Error("Couldn't reach server. Check your internet connection"))
        }
    }
}