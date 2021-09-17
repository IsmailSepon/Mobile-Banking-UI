package com.cloudwell.paywell.ui.scan.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import com.cloudwell.paywell.ui.registration.fragment.RegOneFeg
import kotlinx.android.synthetic.main.paywell_done_layout.view.*

/**
 * Created by Sepon on 4/15/2020.
 */
class PaymentDoneFeg : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.paywell_done_layout, container, false)




        view.scan_done.setOnClickListener(View.OnClickListener {
            requireActivity().finish()
        })



        return view
    }

    companion object {
        fun newInstance(): RegOneFeg {
            return RegOneFeg()
        }
    }
}