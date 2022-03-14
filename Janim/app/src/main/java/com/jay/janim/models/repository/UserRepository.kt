package com.jay.janim.models.repository

import com.jay.janim.models.database.UserDatabases
import com.jay.janim.models.dataclass.User

class UserRepository(val users:UserDatabases) {

    fun getusername() = users.getUserDao().getusername()
    fun getpassword() = users.getUserDao().getpassword()
    fun getAllUsers() = users.getUserDao().getAllUsers()

    suspend fun adduser(user:User ) = users.getUserDao().adduser(user)

}