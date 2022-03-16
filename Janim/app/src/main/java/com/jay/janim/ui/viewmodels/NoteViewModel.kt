package com.jay.janim.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jay.janim.models.dataclass.Note
import com.jay.janim.models.repository.NoteRepository
import kotlinx.coroutines.launch

class NoteViewModel(val noteRepository: NoteRepository): ViewModel() {

    var size = 0
    var usernotes = ArrayList<Note>()
    var notesLiveData = MutableLiveData<List<Note>>()


    fun addNote(note: Note) = viewModelScope.launch {
        noteRepository.addnote(note)
    }

    fun getAllNotes() = noteRepository.getAllNotes()

}