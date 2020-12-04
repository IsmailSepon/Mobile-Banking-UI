package com.cloudwell.paywell.ui.vaults.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cloudwell.paywell.R
import com.cloudwell.paywell.ui.vaults.fragment.PersonilizeVaultFragmetn
import com.cloudwell.paywell.ui.vaults.fragment.VaultProfileFragmetn
import com.cloudwell.paywell.ui.vaults.vaultIntro.VaultIntroMainFragment
import com.cloudwell.paywell.utils.FragmentHelper

class VaultAddActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vault_add)


        val intent = intent
        val menu = intent.getIntExtra("vaultMenu", 0)

        if (menu == 0){

            FragmentHelper.replaceFragment(VaultIntroMainFragment(), supportFragmentManager, R.id.vault_intro_container)
        }else if (menu == 1){

            FragmentHelper.replaceFragment(PersonilizeVaultFragmetn(), supportFragmentManager, R.id.vault_intro_container)
        }else if (menu == 2){

            FragmentHelper.replaceFragment(VaultProfileFragmetn(), supportFragmentManager, R.id.vault_intro_container)
        }



    }
}