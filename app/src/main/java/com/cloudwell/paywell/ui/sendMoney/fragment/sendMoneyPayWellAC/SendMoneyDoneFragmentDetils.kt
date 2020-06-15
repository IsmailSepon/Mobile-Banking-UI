package com.cloudwell.paywell.ui.sendMoney.fragment.sendMoneyPayWellAC

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import kotlinx.android.synthetic.main.send_money_done_detils.view.*

class SendMoneyDoneFragmentDetils : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.send_money_done_detils, container, false)

        view.send_money_done.setOnClickListener(View.OnClickListener {
            val done = SendMoneyDoneFragmentDetils()
            val manager = activity?.supportFragmentManager
            val transaction = manager?.beginTransaction()
            transaction?.replace(R.id.beneficery_host_container, done)
            transaction?.addToBackStack(null)
            transaction?.commit()
        })

//        beneficeryViewModel =
//            ViewModelProviders.of(this).get(BeneficeryViewModel::class.java)
//        val binding : AddaccountLayoutBinding = DataBindingUtil.inflate(inflater, R.layout.addaccount_layout, container, false)
//        binding.beneficeryViewModelxml = beneficeryViewModel
//        binding.lifecycleOwner = this
//        return binding.root

        return view
    }
}
