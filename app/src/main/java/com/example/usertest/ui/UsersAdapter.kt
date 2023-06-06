package com.example.usertest.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.usertest.databinding.ItemUserBinding
import com.example.usertest.domain.model.Address
import com.example.usertest.domain.model.UserDTO

class UsersAdapter :
    ListAdapter<UserDTO, UserViewHolder>(UsersDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = ItemUserBinding.inflate(inflater, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class UserViewHolder(private val binding: ItemUserBinding) : RecyclerView.ViewHolder(binding.root) {
    @SuppressLint("SetTextI18n")
    fun bind(user: UserDTO){

        val address = user.address
        val geo = address.geo
        val company = user.company

        binding.apply {
            tvName.text = user.name
            tvUserName.text = "(${user.username})"
            tvEmail.text = user.email
            tvStreet.text = address.street
            tvSuite.text = address.suite
            tvCity.text = address.city
            tvZipcode.text = address.zipcode
            tvLat.text = geo.lat
            tvLng.text = geo.lng
            tvPhone.text = user.phone
            tvWebsite.text = user.website
            tvCompanyName.text = company.name
            tvCatchPhrase.text = company.catchPhrase
            tvBs.text = company.bs
        }
    }
}


class UsersDiffCallback : DiffUtil.ItemCallback<UserDTO>() {
    override fun areItemsTheSame(oldItem: UserDTO, newItem: UserDTO): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: UserDTO, newItem: UserDTO): Boolean {
        return oldItem == newItem
    }
}