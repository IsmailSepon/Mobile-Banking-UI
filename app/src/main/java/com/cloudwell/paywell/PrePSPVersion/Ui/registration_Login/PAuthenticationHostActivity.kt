package com.cloudwell.paywell.PrePSPVersion.Ui.registration_Login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cloudwell.paywell.PrePSPVersion.Ui.registration_Login.fragment.OtpCheckFegment
import com.cloudwell.paywell.PrePSPVersion.Ui.registration_Login.fragment.RegistrationPersonalDetailsFragment
import com.cloudwell.paywell.R
import com.cloudwell.paywell.uiCommon.pay.fragment.PaymentsMainFragment
import com.cloudwell.paywell.utils.FragmentHelper

/**
 * Created by Sepon on 26/1/2021.
 * ==============================Don't extend "BaseActivity" =================
 */

class PAuthenticationHostActivity : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_p_authentication_host)




       // FragmentHelper.addFirstFragment(RegistrationPersonalDetailsFragment(), supportFragmentManager, R.id.pre_psp_auth_container)
        FragmentHelper.addFirstFragment(PaymentsMainFragment(), supportFragmentManager, R.id.pre_psp_auth_container)



    }
}