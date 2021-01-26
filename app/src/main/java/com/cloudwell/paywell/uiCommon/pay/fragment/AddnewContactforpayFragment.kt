package com.cloudwell.paywell.uiCommon.pay.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import com.cloudwell.paywell.uiCommon.pay.dialog.TextDialog
import com.cloudwell.paywell.utils.FragmentHelper
import kotlinx.android.synthetic.main.add_newcontact_layout.view.*

class AddnewContactforpayFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.add_newcontact_layout, container, false)


        view.addContactOkBtn.setOnClickListener(View.OnClickListener {


            val dialog: TextDialog = TextDialog()
            dialog.show(activity?.supportFragmentManager!!, "TextDialog")


        })






        view.newcontact_back.setOnClickListener(View.OnClickListener {
            FragmentHelper.removeFragment(requireActivity().supportFragmentManager)
        })


        return view
    }


}
