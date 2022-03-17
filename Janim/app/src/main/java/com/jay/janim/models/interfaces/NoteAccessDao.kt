package com.jay.janim.models.interfaces

import androidx.lifecycle.LiveData
import androidx.room.*
import com.jay.janim.models.dataclass.Note
import retrofit2.http.DELETE

@Dao
interface NoteAccessDao {

    @Query("select * from note")
    fun getallNotes() : LiveData<List<Note>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addnote(note:Note): Long

    @Delete
    suspend fun deletenote(note: Note)

}