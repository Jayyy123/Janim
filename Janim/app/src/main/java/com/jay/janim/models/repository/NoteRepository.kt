package com.jay.janim.models.repository

import com.jay.janim.models.database.NoteDatabase
import com.jay.janim.models.dataclass.Note

class NoteRepository(val database: NoteDatabase) {

    suspend fun addnote(note:Note) = database.getNoteAccessDao().addnote(note)

    fun getAllNotes() = database.getNoteAccessDao().getallNotes()

}