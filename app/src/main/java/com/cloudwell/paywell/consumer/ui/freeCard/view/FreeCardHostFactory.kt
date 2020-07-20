package com.cloudwell.paywell.consumer.ui.freeCard.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.cloudwell.paywell.consumer.ui.freeCard.viewModel.FreeCardHostViewModel

class FreeCardHostFactory(private val repository: FreeCardHostRepository) :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return FreeCardHostViewModel(
            repository
        ) as T
    }
}