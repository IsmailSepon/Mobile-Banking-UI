package com.cloudwell.paywell.ui.linkedAccount

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cloudwell.paywell.R
import com.cloudwell.paywell.ui.linkedAccount.introFragment.LinkedAcIntroMainFragment
import com.cloudwell.paywell.ui.vaults.fragment.AddNewVaultFragmetn
import com.cloudwell.paywell.utils.FragmentHelper

class LinkedAccountActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_linked_account)


        FragmentHelper.addFirstFragment(LinkedAcIntroMainFragment(), supportFragmentManager, R.id.linked_account_container)


    }
}