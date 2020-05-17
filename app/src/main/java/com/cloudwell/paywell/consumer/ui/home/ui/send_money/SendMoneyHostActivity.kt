package com.cloudwell.paywell.consumer.ui.home.ui.send_money


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.cloudwell.paywell.consumer.R
import com.cloudwell.paywell.consumer.databinding.ActivitySendMoneyHostBinding
import com.cloudwell.paywell.consumer.ui.home.ui.beneficiary.BeneficiaryFragment

class SendMoneyHostActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_send_money_host)

        val binding: ActivitySendMoneyHostBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_send_money_host)
        val viewModel = ViewModelProviders.of(this).get(SendMoneyViewModel::class.java)
        binding.viewModel = viewModel


        val beneficiaryFragment = BeneficiaryFragment()
        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        transaction.replace(R.id.send_money_container, beneficiaryFragment)
        transaction.addToBackStack(null)
        transaction.commit()


    }

}
