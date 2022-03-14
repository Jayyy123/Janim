package com.jay.janim.models.dataclass


import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "user")
data class User(
    @PrimaryKey(autoGenerate = true)
    var id:Int,
    var firstname:String,
    var lastname:String,
    var username:String,
    var password:String
)
