package com.cloudwell.paywell.ui.budget

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cloudwell.paywell.R
import com.cloudwell.paywell.ui.budget.budgetIntro.BudgetIntroMainFragment
import com.cloudwell.paywell.utils.FragmentHelper

class BudgetHostActivity : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_budget_host)


        FragmentHelper.replaceFragment(BudgetIntroMainFragment(), supportFragmentManager, R.id.budget_container)
//        FragmentHelper.addFirstFragment(
//            BudgetMainFragment(),
//            supportFragmentManager,
//            R.id.budget_container
//        )


    }
}
