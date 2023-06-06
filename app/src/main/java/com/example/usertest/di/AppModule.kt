package com.example.usertest.di

import com.example.usertest.common.Constants.BASE_URL
import com.example.usertest.data.UserApi
import com.example.usertest.data.UserRepositoryImpl
import com.example.usertest.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideUsersApi() : UserApi{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(UserApi::class.java)
    }

    @Provides
    @Singleton
    fun provideUsersRepository(api: UserApi): UserRepository {
        return UserRepositoryImpl(api)
    }

}