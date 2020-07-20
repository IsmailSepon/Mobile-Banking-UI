package com.cloudwell.paywell.consumer.ui.switchAccount.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.cloudwell.paywell.consumer.ui.profile.view.ProfileHostRepository
import com.cloudwell.paywell.consumer.ui.switchAccount.viewModel.SwitchAccountHostViewModel

class SwitchAccountHostFactory(private val repository: SwitchAccountHostRepository) :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return SwitchAccountHostViewModel(
            repository
        ) as T
    }
}