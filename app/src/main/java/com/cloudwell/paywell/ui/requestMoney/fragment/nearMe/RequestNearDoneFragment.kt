package com.cloudwell.paywell.consumer.ui.requestMoney.fragment.nearMe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import kotlinx.android.synthetic.main.request_near_done_frg_layout.view.*

class RequestNearDoneFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.request_near_done_frg_layout, container, false)

        val textHolder = requireActivity().getSharedPreferences("TextHolder", 0).getInt("nearMeContainer", 0)

        if (textHolder!=0){

            view.textView10.text = "Payment to Amzad Hossain is\nsuccessful"
        }

        view.req_near_done.setOnClickListener(View.OnClickListener {
            activity?.finish()
        })


        return view
    }


}
