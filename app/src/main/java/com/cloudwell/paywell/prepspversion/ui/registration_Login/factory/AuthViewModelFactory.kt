package com.cloudwell.paywell.prepspversion.ui.registration_Login.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.cloudwell.paywell.prepspversion.ui.registration_Login.repository.UserRepository
import com.cloudwell.paywell.prepspversion.ui.registration_Login.viewmodel.AuthViewModel


/**
 * Created by MD ISMAIL HOSSAIN SEPON on 07-Jun-21.
 * ismailhossainsepon@gmail.com
 */

@Suppress("UNCHECKED_CAST")
class AuthViewModelFactory(private val repository: UserRepository)  : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return AuthViewModel(repository) as T
    }
}