package com.cloudwell.paywell.ui.profile.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.cloudwell.paywell.ui.profile.viewmodel.ProfileHostViewModel

class ProfileHostFactory(private val repository: ProfileHostRepository) :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ProfileHostViewModel(
            repository
        ) as T
    }
}