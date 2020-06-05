package com.cloudwell.paywell.consumer.ui.sendMoney


import android.content.Intent
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.cloudwell.paywell.consumer.R
import com.cloudwell.paywell.consumer.base.BaseActivity
import com.cloudwell.paywell.consumer.databinding.ActivitySendMoneyHostBinding
import com.cloudwell.paywell.consumer.ui.beneficiary.BeneficeryHostActivity
import com.cloudwell.paywell.consumer.ui.beneficiary.fragment.BeneficiaryFragment
import com.cloudwell.paywell.consumer.ui.sendMoney.view.SendMoneyFactory
import com.cloudwell.paywell.consumer.ui.sendMoney.viewmodel.SendMoneyViewModel
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


        val beneficiaryFragment = BeneficiaryFragment()
        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        transaction.replace(R.id.send_money_container, beneficiaryFragment)
        transaction.addToBackStack(null)
        transaction.commit()


    }

    fun startActivity(type: Int) {
        val intent = Intent(this, BeneficeryHostActivity::class.java)
        intent.putExtra(this.getString(R.string.beneficery_type), type)
        this.startActivity(intent)
    }
}
