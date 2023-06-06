package com.example.usertest.ui

import com.example.usertest.domain.model.UserDTO

data class UserListViewState (
    val isLoading: Boolean = false,
    val users: UserDTO? = null,
    val error: String = ""
)