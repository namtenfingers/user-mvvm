package com.example.usertest.domain.model

data class UserDTO(
    val id: Int,
    val name: String,
    val username: String,
    val email: String,
    val address: Address,
    val phone: String,
    val website: String,
    val company: Company
)

fun UserDTO.toUser(): UserDTO {
    return UserDTO(
        id = id,
        name = name,
        username = username,
        email = email,
        address = address,
        phone = phone,
        website = website,
        company = company
    )
}