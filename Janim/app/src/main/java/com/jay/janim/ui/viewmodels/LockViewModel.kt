package com.jay.janim.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jay.janim.models.dataclass.User
import com.jay.janim.models.repository.UserRepository
import kotlinx.coroutines.launch

class LockViewModel(val userRepository: UserRepository):ViewModel() {
    var username = false
    var password = false
    var users = mutableListOf<User>()
    val userss = MutableLiveData<List<User>>()



    fun adduser(user: User) = viewModelScope.launch {
        userRepository.adduser(user)
    }

    fun getUsername() = userRepository.getusername()
    fun getPassword() = userRepository.getpassword()
    fun getAllUsers() = userRepository.getAllUsers()


}