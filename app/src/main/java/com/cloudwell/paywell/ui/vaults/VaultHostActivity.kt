package com.cloudwell.paywell.ui.vaults

import android.os.Bundle
import android.widget.FrameLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.cloudwell.paywell.R
import com.cloudwell.paywell.ui.vaults.fragment.VaultViewFragment
import com.cloudwell.paywell.utils.FragmentHelper
import kotlinx.android.synthetic.main.activity_vault_host.*

class VaultHostActivity : AppCompatActivity() {

    var continer : FrameLayout? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vault_host)


        continer = vault_container



        FragmentHelper.replaceFragment(VaultViewFragment(), supportFragmentManager, R.id.vault_container)





    }


    override fun recreate() {
        super.recreate()

        Toast.makeText(this, "reCrate", Toast.LENGTH_SHORT).show()


    }


}