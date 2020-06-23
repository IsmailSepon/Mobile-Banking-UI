package com.cloudwell.paywell.consumer.ui.dashboard.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.cloudwell.paywell.consumer.ui.dashboard.viewmodel.ProfileHostViewModel

class ProfileHostFactory(private val repository: ProfileRepository) :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ProfileHostViewModel(
            repository
        ) as T
    }
}