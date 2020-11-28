package com.cloudwell.paywell.uiCommon.pay.fragment

import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import com.cloudwell.paywell.consumer.ui.requestMoney.fragment.nearMe.PaymentNearMeSearchFragment
import com.cloudwell.paywell.utils.FragmentHelper
import kotlinx.android.synthetic.main.location_access_layout.view.*


class RequestMoneyLocationAccessFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.location_access_layout, container, false)


        view.payment_allow_location.setOnClickListener(View.OnClickListener {

            val sharedPreferences: SharedPreferences = requireContext().getSharedPreferences("TextHolder", 0)
            val editor = sharedPreferences.edit()
            editor.putInt("nearMeContainer", R.id.payment_container).apply()

            FragmentHelper.replaceFragment(
                PaymentNearMeSearchFragment(),
                requireActivity().supportFragmentManager,
                R.id.payment_container
            )



        })



        view.imageView296.setOnClickListener(View.OnClickListener {
            activity?.finish() //FragmentHelper.removeFragment(requireActivity().supportFragmentManager)
        })

        return view
    }


}
