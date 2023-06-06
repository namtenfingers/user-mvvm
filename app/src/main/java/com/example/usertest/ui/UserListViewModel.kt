package com.example.usertest.ui

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.usertest.common.Resource
import com.example.usertest.domain.usecase.GetUsersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class UserListViewModel @Inject constructor(
    private val getUsersUseCase: GetUsersUseCase
) : ViewModel(){

    private val _state = MutableLiveData<UserListViewState>()
    val state: MutableLiveData<UserListViewState>
        get() = _state

    init {
        getUsers(1, "Nam ")
    }

    private fun getUsers(id: Int, name: String) {
        getUsersUseCase(id, name).onEach { result ->
            when(result) {
                is Resource.Success -> {
                    _state.value = UserListViewState(users = result.data)
                }
                is Resource.Error -> {
                    _state.value = UserListViewState(
                        error = result.msg ?: "An expected error occur"
                    )
                }
                is Resource.Loading -> {
                    _state.value = UserListViewState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}