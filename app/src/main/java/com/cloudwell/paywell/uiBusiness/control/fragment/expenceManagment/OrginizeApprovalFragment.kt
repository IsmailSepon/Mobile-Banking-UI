package com.cloudwell.paywell.uiBusiness.control.fragment.expenceManagment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import kotlinx.android.synthetic.main.orginize_approval_fragment.view.*

class OrginizeApprovalFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View =
            inflater.inflate(R.layout.orginize_approval_fragment, container, false)


        view.orginize_app_btn.setOnClickListener(View.OnClickListener {

            val parent = activity as NewExpenceActivity?
            parent?.setPagerFrg(2)


        })

        return view
    }
}