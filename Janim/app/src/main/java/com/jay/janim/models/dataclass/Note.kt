package com.jay.janim.models.dataclass
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note")
data class Note (
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val username:String,
    val title:String,
    val description:String,
    val status: Boolean,
        )
