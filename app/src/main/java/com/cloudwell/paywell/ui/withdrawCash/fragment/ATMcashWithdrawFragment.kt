package com.cloudwell.paywell.ui.withdrawCash.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import com.cloudwell.paywell.utils.FragmentHelper
import kotlinx.android.synthetic.main.atm_cashwithdraw_layout.view.*
import android.content.Intent




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


        view.atm_withdraw_back.setOnClickListener(View.OnClickListener {
            FragmentHelper.removeFragment(activity?.supportFragmentManager)
        })

        view.share_bn.setOnClickListener(View.OnClickListener {

            val sharingIntent = Intent(Intent.ACTION_SEND)
            sharingIntent.type = "text/plain"
            val shareBody = "Here is the share content body"
            sharingIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject Here")
            sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody)
            startActivity(Intent.createChooser(sharingIntent, "Share via"))
        })

        return view
    }


}
