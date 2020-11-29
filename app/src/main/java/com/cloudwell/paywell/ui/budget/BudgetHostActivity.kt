package com.cloudwell.paywell.ui.budget

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cloudwell.paywell.R
import com.cloudwell.paywell.ui.budget.budgetIntro.BudgetIntroMainFragment
import com.cloudwell.paywell.ui.budget.fragment.BudgetSpendingFragment
import com.cloudwell.paywell.utils.FragmentHelper

class BudgetHostActivity : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_budget_host)


        val intent : Intent = intent
        val destination :Int = intent.getIntExtra("budget",0)
        if (destination== 1){

            FragmentHelper.replaceFragment(BudgetIntroMainFragment(), supportFragmentManager, R.id.budget_container)

        }else{
            FragmentHelper.replaceFragment(BudgetSpendingFragment(), supportFragmentManager, R.id.budget_container)
        }

    }
}
