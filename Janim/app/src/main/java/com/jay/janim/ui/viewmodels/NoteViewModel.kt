package com.jay.janim.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jay.janim.models.dataclass.Note
import com.jay.janim.models.repository.NoteRepository
import com.jay.janim.utils.Constants
import com.jay.janim.utils.Constants.appuserf
import com.jay.janim.utils.Constants.status
import kotlinx.coroutines.launch

class NoteViewModel(val noteRepository: NoteRepository): ViewModel() {

    var size = 0
    var usernotes = ArrayList<Note>()
    var notesLiveData = MutableLiveData<List<Note>>()
    val appuser = appuserf
    val status = Constants.status


    fun addNote(note: Note) = viewModelScope.launch {
        noteRepository.addnote(note)
    }

    fun getAllNotes() = noteRepository.getAllNotes()

}