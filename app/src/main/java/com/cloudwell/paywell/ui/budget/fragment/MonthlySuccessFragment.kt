package com.cloudwell.paywell.ui.budget.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import kotlinx.android.synthetic.main.budget_success_layout.view.*

class MonthlySuccessFragment : Fragment() {


    private val data: ArrayList<String> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.budget_success_layout, container, false)







        view.success_done.setOnClickListener(View.OnClickListener {


            requireActivity().finish()

         //   FragmentHelper.removeFragment(requireActivity().supportFragmentManager)


        })


        return view
    }


}
