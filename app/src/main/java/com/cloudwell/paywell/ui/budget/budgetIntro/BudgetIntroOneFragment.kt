package com.cloudwell.paywell.ui.budget.budgetIntro

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import kotlinx.android.synthetic.main.budget_intro_one_layout.view.*

class BudgetIntroOneFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View =
            inflater.inflate(R.layout.budget_intro_one_layout, container, false)



        view.intro_one_btn.setOnClickListener(View.OnClickListener {



        })


        return view
    }
}