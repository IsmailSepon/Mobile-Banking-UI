package com.cloudwell.paywell.ui.beneficiary

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cloudwell.paywell.R
import com.cloudwell.paywell.ui.beneficiary.fragment.ChooseTransferTypeFragment
import com.cloudwell.paywell.ui.beneficiary.fragment.FindPayWellUserFrg
import com.cloudwell.paywell.ui.sendMoney.fragment.SendFundTransferTypeFragment
import com.cloudwell.paywell.utils.FragmentHelper

class BeneficeryHostActivity : AppCompatActivity() {
    var type: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_beneficery_host)

        type = intent.getIntExtra(applicationContext.getString(R.string.beneficery_type), 0)

        if (type == 1) {
            FragmentHelper.addFirstFragment(
                SendFundTransferTypeFragment(),
                supportFragmentManager,
                R.id.beneficery_host_container
            )
        } else if (type == 2) {

            FragmentHelper.addFirstFragment(
                FindPayWellUserFrg(),
                supportFragmentManager,
                R.id.beneficery_host_container
            )
        } else if (type == 3) {
            FragmentHelper.addFirstFragment(
                ChooseTransferTypeFragment(),
                supportFragmentManager,
                R.id.beneficery_host_container
            )
        }

//        val beneficiaryFragment = ChooseTransferTypeFragment()
//        val manager = supportFragmentManager
//        val transaction = manager.beginTransaction()
//        transaction.replace(R.id.beneficery_host_container, beneficiaryFragment)
//        transaction.addToBackStack(null)
//        transaction.commit()

//        val binding :  ChooseTransfertypeLayoutBinding  = DataBindingUtil.setContentView(this, R.layout.choose_transfertype_layout)
//        val viewModel = ViewModelProviders.of(this).get(ChooseTransferViewModel::class.java)
//        binding.chooseViewmodelXml = viewModel

    }
}
