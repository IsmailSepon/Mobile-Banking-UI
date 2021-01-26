package com.cloudwell.paywell.ui.budget

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cloudwell.paywell.R
import com.cloudwell.paywell.base.`interface`.FrgBackPressed
import com.cloudwell.paywell.ui.budget.`interface`.BudgetBackPressed
import com.cloudwell.paywell.ui.budget.budgetIntro.BudgetIntroMainFragment
import com.cloudwell.paywell.ui.budget.fragment.BudgetSpendingFragment
import com.cloudwell.paywell.ui.cards.fragment.physicalCard.OrderingPhysicalCardFragment
import com.cloudwell.paywell.utils.FragmentHelper

class BudgetHostActivity : AppCompatActivity() {


    var destination :Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_budget_host)


        val intent : Intent = intent
        destination  = intent.getIntExtra("budget",0)



        if (destination== 1){

             FragmentHelper.addFirstFragment(BudgetIntroMainFragment(), supportFragmentManager, R.id.budget_container)

        }else{
            FragmentHelper.addFirstFragment(BudgetSpendingFragment(), supportFragmentManager, R.id.budget_container)
        }

    }


    override fun onResume() {
        super.onResume()

        implementation()

    }

    fun implementation(){


    }


}
