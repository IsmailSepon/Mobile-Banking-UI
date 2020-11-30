package com.cloudwell.paywell.ui.vaults.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cloudwell.paywell.R
import com.cloudwell.paywell.ui.vaults.vaultIntro.VaultIntroMainFragment
import com.cloudwell.paywell.utils.FragmentHelper

class VaultAddActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vault_add)



        FragmentHelper.replaceFragment(VaultIntroMainFragment(), supportFragmentManager, R.id.vault_intro_container)


    }
}