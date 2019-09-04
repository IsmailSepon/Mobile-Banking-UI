package com.cloudwell.paywell.consumer.ui.auth

import android.view.View
import androidx.lifecycle.ViewModel
import com.cloudwell.paywell.consumer.repository.UserRepository
import com.cloudwell.paywell.consumer.ui.auth.view.IAuthViewListener.IAuthListener
import com.cloudwell.paywell.consumer.utils.Coroutines
import com.cloudwell.paywell.consumer.utils.exception.ApiException
import com.cloudwell.paywell.consumer.utils.exception.NoInternetException

/**
 * Created by Kazi Md. Saidul Email: Kazimdsaidul@gmail.com  Mobile: +8801675349882 on 2019-09-01.
 */
class AuthViewModel(
   private val userRepository: UserRepository
) : ViewModel() {

    var userName: String = "test"
    var password: String = ""

    var iAuthListener: IAuthListener? = null

    fun userLoginClick(view: View) {
        iAuthListener?.showProgress()

        if (userName.isEmpty() || password.isEmpty()) {
            iAuthListener?.HiddenProgress()
            iAuthListener?.onFailure("Invalid userName or password")

        }else{
            Coroutines.main{
                try {
                    val userLoginRespose = userRepository.userLogin(userName, password)
                    userLoginRespose.user?.let { userRepository.saveUser(it) }
                    iAuthListener?.onSuccess(userLoginRespose)

                }catch (e: ApiException){
                    iAuthListener?.onFailure(e.message)
                }catch (e: NoInternetException){
                    iAuthListener?.noInternetConnectionFound()
                }

            }

        }
    }


}