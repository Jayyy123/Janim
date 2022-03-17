package com.jay.janim.models.interfaces

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.jay.janim.models.dataclass.User






@Dao
interface UserAccessObject {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun adduser(user:User):Long

    @Query("select username from user")
    fun getusername(): LiveData<List<String>>

    @Query("select password from user")
    fun getpassword(): LiveData<List<String>>

    @Query("select * from user")
    fun getAllUsers():LiveData<List<User>>
}