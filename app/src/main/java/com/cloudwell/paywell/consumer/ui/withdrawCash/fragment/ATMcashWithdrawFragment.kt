package com.cloudwell.paywell.consumer.ui.withdrawCash.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.consumer.R
import kotlinx.android.synthetic.main.atm_cashwithdraw_layout.view.*

class ATMcashWithdrawFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.atm_cashwithdraw_layout, container, false)


        view.cash_withdraw_done_btn.setOnClickListener(View.OnClickListener {
            activity?.finish()
        })
//        view.scheduleDateBtn.setOnClickListener(View.OnClickListener {
//            FragmentHelper.replaceFragment(
//                ScheduleSelectDoneFragment(),
//                activity?.supportFragmentManager,
//                R.id.schedule_transfer_container
//            )
//        })


        return view
    }


}
