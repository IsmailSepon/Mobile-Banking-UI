package com.cloudwell.paywell.ui.sendMoney


import android.content.Intent
import android.os.Bundle
import com.cloudwell.paywell.R
import com.cloudwell.paywell.base.BaseActivity
import com.cloudwell.paywell.base.Preference
import com.cloudwell.paywell.ui.beneficiary.BeneficeryHostActivity
import com.cloudwell.paywell.ui.beneficiary.fragment.BeneficiaryFragment
import com.cloudwell.paywell.ui.sendMoney.view.SendMoneyFactory
import com.cloudwell.paywell.uiBusiness.sendFund.fragment.BusinessSendFundFragment
import com.cloudwell.paywell.utils.FragmentHelper
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class SendMoneyHostActivity : BaseActivity(), KodeinAware {

    override val kodein by kodein()

    private val factory: SendMoneyFactory by instance<SendMoneyFactory>()


    var userType : String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_send_money_host)

//        val binding: ActivitySendMoneyHostBinding =
//            DataBindingUtil.setContentView(this, R.layout.activity_send_money_host)
//        viewModel = ViewModelProviders.of(this, factory).get(SendMoneyViewModel::class.java)
//        binding.viewModel = viewModel as SendMoneyViewModel
//
//        (viewModel as SendMoneyViewModel).addBankAccountValue.observe(this, object : Observer<Int> {
//            override fun onChanged(t: Int) {
//                startActivity(t)
//            }
//        })


        val sharePreference : Preference = Preference.getInstance(this)
        userType = sharePreference.getData(getString(R.string.userType))



     //   setViewModelObserver()

        if (userType==getString(R.string.personalUser)){

        FragmentHelper.addFirstFragment(BeneficiaryFragment(), supportFragmentManager, R.id.send_money_container)

        }else{

            FragmentHelper.addFirstFragment(BusinessSendFundFragment(), supportFragmentManager, R.id.send_money_container)
        }





    }

    fun startActivity(type: Int) {
        val intent = Intent(this, BeneficeryHostActivity::class.java)
        intent.putExtra(this.getString(R.string.beneficery_type), type)
        this.startActivity(intent)
    }
}
