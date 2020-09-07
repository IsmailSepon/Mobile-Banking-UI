package com.cloudwell.paywell.uiBusiness.control.fragment.expenceManagment.slider

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import com.cloudwell.paywell.uiBusiness.control.fragment.expenceManagment.NewExpenceActivity
import kotlinx.android.synthetic.main.slider_three_layout.view.*

class ExpenceSliderthreeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View =
            inflater.inflate(R.layout.slider_three_layout, container, false)



        view.slider_3.setOnClickListener(View.OnClickListener {

            Intent(view.context, NewExpenceActivity::class.java).also {
                view.context.startActivity(it)
            }

//            FragmentHelper.replaceFragment(
//                ExpenceManagmentFragment(),
//                requireActivity().supportFragmentManager,
//                R.id.bu_Control_container
//            )
        })


        return view
    }
}