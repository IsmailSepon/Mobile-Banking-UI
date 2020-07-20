package com.cloudwell.paywell.ui.authentication.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.cloudwell.paywell.ui.authentication.viewModel.UserAuthenticationHostViewModel

class UserAuthenticationHostFactory(private val repository: UserAuthenticationHostRepository) :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return UserAuthenticationHostViewModel(
            repository
        ) as T
    }
}