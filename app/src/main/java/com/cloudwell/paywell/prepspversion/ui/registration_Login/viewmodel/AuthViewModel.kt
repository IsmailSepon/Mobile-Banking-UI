package com.cloudwell.paywell.prepspversion.ui.registration_Login.viewmodel

import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModel
import com.cloudwell.paywell.prepspversion.ui.registration_Login.model.RegistrationRequest
import com.cloudwell.paywell.prepspversion.ui.registration_Login.model.User
import com.cloudwell.paywell.prepspversion.ui.registration_Login.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


/**
 * Created by MD ISMAIL HOSSAIN SEPON on 03-Jun-21.
 * ismailhossainsepon@gmail.com
 */


class AuthViewModel(private val repository: UserRepository) : ViewModel() {

    suspend fun userSignup(
        reg : RegistrationRequest
    ) = withContext(Dispatchers.IO) { repository.userSignup(reg) }


    suspend fun getRegToken( user : User) = withContext(Dispatchers.IO){
        repository.getToken(user)

    }
}