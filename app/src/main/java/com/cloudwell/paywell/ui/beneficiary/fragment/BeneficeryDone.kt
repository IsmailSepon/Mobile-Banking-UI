package com.cloudwell.paywell.ui.beneficiary.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import com.cloudwell.paywell.ui.beneficiary.BeneficeryHostActivity
import com.cloudwell.paywell.ui.beneficiary.viewModel.BeneficeryViewModel
import com.cloudwell.paywell.ui.scheduledTransfer.fragment.ScheduleSelectAmountFragment
import com.cloudwell.paywell.ui.sendMoney.fragment.SendMoneyFragment
import kotlinx.android.synthetic.main.beneficery_done.view.*

class BeneficeryDone : Fragment() {

    private lateinit var beneficeryViewModel: BeneficeryViewModel


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.beneficery_done, container, false)

        var type = (activity as? BeneficeryHostActivity)?.type

        view.done.setOnClickListener(View.OnClickListener {

            if (type == 3) {
                val done = ScheduleSelectAmountFragment()
                val manager = activity?.supportFragmentManager
                val transaction = manager?.beginTransaction()
                transaction?.replace(R.id.beneficery_host_container, done)
                transaction?.addToBackStack(null)
                transaction?.commit()

            } else {
                val done = SendMoneyFragment()
                val manager = activity?.supportFragmentManager
                val transaction = manager?.beginTransaction()
                transaction?.replace(R.id.beneficery_host_container, done)
                transaction?.addToBackStack(null)
                transaction?.commit()
            }


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
