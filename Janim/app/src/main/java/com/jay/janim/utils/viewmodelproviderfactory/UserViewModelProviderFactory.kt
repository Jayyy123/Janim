package com.jay.janim.utils.viewmodelproviderfactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jay.janim.models.repository.UserRepository
import com.jay.janim.ui.viewmodels.LockViewModel

class UserViewModelProviderFactory(val userRepository: UserRepository):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return LockViewModel(userRepository) as T
    }
}