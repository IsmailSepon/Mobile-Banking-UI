package com.cloudwell.paywell.consumer.ui.help.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.cloudwell.paywell.consumer.ui.help.viewModel.UserHelpHostViewModel

class UserHelpHostFactory(private val repository: UserHelpHostRepository) :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return UserHelpHostViewModel(
            repository
        ) as T
    }
}