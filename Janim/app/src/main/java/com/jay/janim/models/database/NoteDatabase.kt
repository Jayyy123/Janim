package com.jay.janim.models.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.jay.janim.models.dataclass.Note
import com.jay.janim.models.interfaces.NoteAccessDao

@Database(entities = [Note::class], version = 1)
abstract class NoteDatabase : RoomDatabase() {

    abstract fun getNoteAccessDao() : NoteAccessDao

    companion object{

        @Volatile
        var instance: NoteDatabase? = null
        val noteDatabase = NoteDatabase
        val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: createDatabase(context).also{
                instance = it
            }
        }

        private fun createDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            NoteDatabase::class.java,
            "Notedatabase.db"
        ).build()

    }


}