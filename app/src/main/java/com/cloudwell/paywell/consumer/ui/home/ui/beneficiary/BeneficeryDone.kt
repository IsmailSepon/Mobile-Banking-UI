package com.cloudwell.paywell.consumer.ui.home.ui.beneficiary

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.consumer.R
import com.cloudwell.paywell.consumer.databinding.AddaccountLayoutBinding
import com.cloudwell.paywell.consumer.ui.home.ui.sendMoney.SendMoneyFragment
import kotlinx.android.synthetic.main.beneficery_done.view.*

class BeneficeryDone : Fragment() {

    private lateinit var beneficeryViewModel: BeneficeryViewModel


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.beneficery_done, container, false)

        view.done.setOnClickListener(View.OnClickListener {
            val done = SendMoneyFragment()
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
