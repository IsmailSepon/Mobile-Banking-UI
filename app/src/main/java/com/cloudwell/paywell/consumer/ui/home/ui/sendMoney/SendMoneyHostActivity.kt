package com.cloudwell.paywell.consumer.ui.home.ui.sendMoney


import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.cloudwell.paywell.consumer.R
import com.cloudwell.paywell.consumer.base.BaseActivity
import com.cloudwell.paywell.consumer.databinding.ActivitySendMoneyHostBinding
import com.cloudwell.paywell.consumer.ui.home.ui.beneficiary.BeneficeryHostActivity
import com.cloudwell.paywell.consumer.ui.home.ui.beneficiary.BeneficiaryFragment
import com.cloudwell.paywell.consumer.ui.home.ui.sendMoney.view.IsendMoneyVIew
import com.cloudwell.paywell.consumer.ui.home.ui.sendMoney.view.SendMoneyFactory
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.android.x.kodein
import org.kodein.di.generic.instance

class SendMoneyHostActivity : BaseActivity(), IsendMoneyVIew, KodeinAware {

    override val kodein by kodein()

    private val factory: SendMoneyFactory by instance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_send_money_host)

        val binding: ActivitySendMoneyHostBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_send_money_host)
        val viewModel = ViewModelProviders.of(this, factory).get(SendMoneyViewModel::class.java)
        viewModel.setView(this)
        binding.viewModel = viewModel


        val beneficiaryFragment = BeneficiaryFragment()
        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        transaction.replace(R.id.send_money_container, beneficiaryFragment)
        transaction.addToBackStack(null)
        transaction.commit()


    }

    override fun startBeneficeryHostActivity(i: Int) {
        startActivity(i)
    }

    fun startActivity(type: Int) {
        val intent = Intent(this, BeneficeryHostActivity::class.java)
        intent.putExtra(this.getString(R.string.beneficery_type), type)
        this.startActivity(intent)


    }
}
