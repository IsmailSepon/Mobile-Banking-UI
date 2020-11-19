package com.cloudwell.paywell.ui.sendMoney


import android.content.Intent
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.cloudwell.paywell.R
import com.cloudwell.paywell.base.BaseActivity
import com.cloudwell.paywell.databinding.ActivitySendMoneyHostBinding
import com.cloudwell.paywell.uiBusiness.sendFund.fragment.BusinessSendFundFragment
import com.cloudwell.paywell.ui.beneficiary.BeneficeryHostActivity
import com.cloudwell.paywell.ui.sendMoney.view.SendMoneyFactory
import com.cloudwell.paywell.ui.sendMoney.viewmodel.SendMoneyViewModel
import com.cloudwell.paywell.utils.FragmentHelper
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class SendMoneyHostActivity : BaseActivity(), KodeinAware {

    override val kodein by kodein()

    private val factory: SendMoneyFactory by instance<SendMoneyFactory>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_send_money_host)

        val binding: ActivitySendMoneyHostBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_send_money_host)
        viewModel = ViewModelProviders.of(this, factory).get(SendMoneyViewModel::class.java)
        binding.viewModel = viewModel as SendMoneyViewModel

        (viewModel as SendMoneyViewModel).addBankAccountValue.observe(this, object : Observer<Int> {
            override fun onChanged(t: Int) {
                startActivity(t)
            }
        })
        setViewModelObserver()


//        FragmentHelper.addFirstFragment(
//            BeneficiaryFragment(),
//            supportFragmentManager,
//            R.id.send_money_container
//        )

        //for Business Send fund

        FragmentHelper.addFirstFragment(
            BusinessSendFundFragment(),
            supportFragmentManager,
            R.id.send_money_container
        )

    }

    fun startActivity(type: Int) {
        val intent = Intent(this, BeneficeryHostActivity::class.java)
        intent.putExtra(this.getString(R.string.beneficery_type), type)
        this.startActivity(intent)
    }
}
