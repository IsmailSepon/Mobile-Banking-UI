package com.cloudwell.paywell.ui.beneficiary.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.cloudwell.paywell.R
import com.cloudwell.paywell.ui.beneficiary.viewModel.FindPayWellUserFrgViewModel
import com.cloudwell.paywell.ui.sendMoney.fragment.SendMoneyFragment
import com.cloudwell.paywell.utils.FragmentHelper
import kotlinx.android.synthetic.main.find_pay_well_user_frg_fragment.view.*

class FindPayWellUserFrg : Fragment() {

    companion object {
        fun newInstance() =
            FindPayWellUserFrg()
    }

    private lateinit var viewModel: FindPayWellUserFrgViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View =
            inflater.inflate(R.layout.find_pay_well_user_frg_fragment, container, false)

        view.continue_btn_findpaywellUser.setOnClickListener(View.OnClickListener {
            FragmentHelper.replaceFragment(
                SendMoneyFragment(),
                activity?.supportFragmentManager,
                R.id.beneficery_host_container
            )
        })


        view.beneficery_back_btn.setOnClickListener(View.OnClickListener {
            activity?.finish()
        })

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(FindPayWellUserFrgViewModel::class.java)


    }

}
