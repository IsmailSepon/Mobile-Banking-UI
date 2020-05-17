package com.cloudwell.paywell.consumer.ui.home.ui.beneficiary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.cloudwell.paywell.consumer.R
import com.cloudwell.paywell.consumer.databinding.ChooseTransfertypeLayoutBinding
import kotlinx.android.synthetic.main.choose_transfertype_layout.*

class BeneficeryHostActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_beneficery_host)

        val beneficiaryFragment = ChooseTransferTypeFragment()
        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        transaction.replace(R.id.beneficery_host_container, beneficiaryFragment)
        transaction.addToBackStack(null)
        transaction.commit()


//        val binding :  ChooseTransfertypeLayoutBinding  = DataBindingUtil.setContentView(this, R.layout.choose_transfertype_layout)
//        val viewModel = ViewModelProviders.of(this).get(ChooseTransferViewModel::class.java)
//        binding.chooseViewmodelXml = viewModel

    }
}
