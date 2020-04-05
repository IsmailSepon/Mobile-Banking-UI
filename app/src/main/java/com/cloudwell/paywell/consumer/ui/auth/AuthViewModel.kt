package com.cloudwell.paywell.consumer.ui.auth

import android.content.Intent
import android.util.Log
import android.view.View
import androidx.biometric.BiometricManager
import com.cloudwell.paywell.consumer.activity.registation.FingerAuthActivity
import com.cloudwell.paywell.consumer.activity.thirdActivity
import com.cloudwell.paywell.consumer.base.BaseViewModel
import com.cloudwell.paywell.consumer.data.repository.UserRepository
import com.cloudwell.paywell.consumer.ui.auth.view.IAuthViewListener.IAuthListener
import com.cloudwell.paywell.consumer.utils.Coroutines
import com.cloudwell.paywell.consumer.utils.exception.ApiException
import com.cloudwell.paywell.consumer.utils.exception.NoInternetException

/**
 * Created by Kazi Md. Saidul Email: Kazimdsaidul@gmail.com  Mobile: +8801675349882 on 2019-09-01.
 */
class AuthViewModel(
   private val userRepository: UserRepository
) : BaseViewModel() {

    var userName: String = "test"
    var password: String = ""

    var iAuthListener: IAuthListener? = null

    fun userLoginClick(view: View) {
        iAuthListener?.showProgress()

        if (userName.isEmpty() || password.isEmpty()) {
            iAuthListener?.hiddenProgress()
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

    fun onSignupClick(view: View){
        Intent(view.context, thirdActivity::class.java).also {
            view.context.startActivity(it)
        }
    }


    fun onFingerClick(view: View){

        val biometricManager = BiometricManager.from(view.context)
        when (biometricManager.canAuthenticate()) {
            BiometricManager.BIOMETRIC_SUCCESS ->   // do success======
                Intent(view.context, FingerAuthActivity::class.java).also {
                    view.context.startActivity(it)
                    Log.d("PayWell Consumer", "App can authenticate using biometrics.")
                }
            BiometricManager.BIOMETRIC_ERROR_NO_HARDWARE ->
                Log.e("PayWell Consumer", "No biometric features available on this device.")
            BiometricManager.BIOMETRIC_ERROR_HW_UNAVAILABLE ->
                Log.e("PayWell Consumer", "Biometric features are currently unavailable.")
            BiometricManager.BIOMETRIC_ERROR_NONE_ENROLLED ->
                Log.e("PayWell Consumer", "The user hasn't associated " +
                        "any biometric credentials with their account.")
        }


    }
}