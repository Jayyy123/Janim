package com.jay.janim.models.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.jay.janim.models.dataclass.User
import com.jay.janim.models.interfaces.UserAccessObject

@Database(entities = [User::class], version = 1)
abstract class UserDatabases: RoomDatabase(){

    abstract fun getUserDao() : UserAccessObject

    companion object{
        @Volatile
        private var instance: UserDatabases? = null

        private val LOCK = Any()

        operator fun invoke(context: Context) = instance?: synchronized(LOCK){

            instance?: createDatabase(context).also{
                instance = it
            }

        }
        private fun createDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            UserDatabases::class.java,
            "UserDatabases.db",
        ).build()

    }

}