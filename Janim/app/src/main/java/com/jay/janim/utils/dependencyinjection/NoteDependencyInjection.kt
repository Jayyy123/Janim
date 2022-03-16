package com.jay.janim.utils.dependencyinjection

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jay.janim.models.repository.NoteRepository

class NoteDependencyInjection(val repository: NoteRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val repo = repository
        return repository as T
    }

}