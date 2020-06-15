package com.cloudwell.paywell.ui.addMoney

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cloudwell.paywell.R
import com.cloudwell.paywell.ui.addMoney.fragment.AddMoneyFragment
import com.cloudwell.paywell.utils.FragmentHelper

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
