package com.cloudwell.paywell.uiBusiness.cards.fragment.marchentOwner

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import com.cloudwell.paywell.uiBusiness.cards.dialog.SuccessfullPaymentDialog
import com.cloudwell.paywell.utils.FragmentHelper
import kotlinx.android.synthetic.main.marchent_payment_request_layout.view.*

class MarchentPaymentRequestFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.marchent_payment_request_layout, container, false)


        view.pay_btn.setOnClickListener(View.OnClickListener {

//
            FragmentHelper.replaceFragment(
                MarchentPaymentMediaFragment(),
                requireActivity().supportFragmentManager,
                R.id.bu_Cards_container
            )

        })

        view.show_payment_history_txt.setOnClickListener(View.OnClickListener {



            val dialog: SuccessfullPaymentDialog = SuccessfullPaymentDialog()
            dialog.show(activity?.supportFragmentManager!!, "SuccessfullPaymentDialog")

        })


        return view
    }


}
