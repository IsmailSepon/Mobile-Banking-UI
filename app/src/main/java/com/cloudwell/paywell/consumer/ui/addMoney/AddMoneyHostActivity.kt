package com.cloudwell.paywell.consumer.ui.addMoney

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.cloudwell.paywell.consumer.R
import com.cloudwell.paywell.consumer.base.BaseActivity
import com.cloudwell.paywell.consumer.databinding.ActivityAddMoneyHostBinding
import com.cloudwell.paywell.consumer.ui.addMoney.fragment.AddMoneyFragment
import com.cloudwell.paywell.consumer.ui.addMoney.view.IaddMoneyVIew
import com.cloudwell.paywell.consumer.ui.addMoney.viewModel.AddMoneyViewModel
import com.cloudwell.paywell.consumer.ui.sendMoney.view.SendMoneyFactory
import com.cloudwell.paywell.consumer.utils.FragmentHelper
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class AddMoneyHostActivity : AppCompatActivity() {

    //IaddMoneyVIew, KodeinAware entended
    // override val kodein by kodein()

    //private val factory: SendMoneyFactory by instance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_money_host)


//        val binding: ActivityAddMoneyHostBinding = DataBindingUtil.setContentView(this, R.layout.activity_add_money_host)
//        val viewModel = ViewModelProviders.of(this).get(AddMoneyViewModel::class.java)
//        viewModel.setView(this)
//        binding.addMoneyViewModel = viewModel

        FragmentHelper.replaceFragment(
            AddMoneyFragment(),
            supportFragmentManager,
            R.id.add_money_container
        )


    }
}
