package com.cloudwell.paywell.ui.budget.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import kotlinx.android.synthetic.main.budget_main_layout.view.*

class BudgetMainFragment : Fragment() {


    var selection = arrayOf("All", "All", "All")


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.budget_main_layout, container, false)


        view.selection_spinner.onItemSelectedListener
        val aa: ArrayAdapter<*> = ArrayAdapter<Any?>(requireContext(), android.R.layout.simple_spinner_item, selection)
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        view.selection_spinner.adapter = aa




        return view
    }


}
