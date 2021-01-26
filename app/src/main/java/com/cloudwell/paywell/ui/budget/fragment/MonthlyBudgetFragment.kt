package com.cloudwell.paywell.ui.budget.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import com.cloudwell.paywell.utils.FragmentHelper
import kotlinx.android.synthetic.main.monthly_budget_layout.view.*

class MonthlyBudgetFragment : Fragment() {


    private val data: ArrayList<String> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.monthly_budget_layout, container, false)







        view.budget_done.setOnClickListener(View.OnClickListener {

            FragmentHelper.replaceFragment(AddNewCatagoryFragment(), requireActivity().supportFragmentManager, R.id.budget_container)


        })


        return view
    }


}
