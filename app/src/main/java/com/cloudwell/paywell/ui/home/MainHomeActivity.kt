package com.cloudwell.paywell.ui.home

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import com.cloudwell.paywell.base.Preference
import com.cloudwell.paywell.ui.account.fragment.AccountFragment
import com.cloudwell.paywell.ui.budget.fragment.BudgetMainFragment
import com.cloudwell.paywell.ui.cards.fragment.CardsFragment
import com.cloudwell.paywell.ui.dashboard.DashboardFragment
import com.cloudwell.paywell.uiBusiness.cards.fragment.BusinessCardMenuFragment
import com.cloudwell.paywell.uiCommon.pay.fragment.PaymentsMainFragment
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainHomeActivity : AppCompatActivity() {

    var notificationsBadge : View?  = null

    var userType : String? = null

    @RequiresApi(Build.VERSION_CODES.M)
    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_home)

        val sharePreference : Preference = Preference.getInstance(this)
        userType = sharePreference.getData(getString(R.string.userType))


        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        navView.selectedItemId = 0
        loadFragment(AccountFragment())

        navView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.navigation_account-> {
                    title=resources.getString(R.string.account)
                    loadFragment(AccountFragment())
                    return@setOnNavigationItemSelectedListener true
                }

                R.id.navigation_budget-> {
                    title=resources.getString(R.string.budget)
                    loadFragment(BudgetMainFragment())
                    return@setOnNavigationItemSelectedListener true
                }

                R.id.navigation_pay-> {
                    title=resources.getString(R.string.pay)
                    loadFragment(PaymentsMainFragment())
                    return@setOnNavigationItemSelectedListener true
                }

                R.id.navigation_cards-> {
                    title=resources.getString(R.string.cards)
                    if (userType==getString(R.string.personalUser)){

                        loadFragment(CardsFragment())
                    }else{

                        loadFragment(BusinessCardMenuFragment())
                    }
                    return@setOnNavigationItemSelectedListener true
                }

                R.id.navigation_control-> {
                    title=resources.getString(R.string.control)
                    loadFragment(DashboardFragment())
                    return@setOnNavigationItemSelectedListener true
                }

            }
            false

        }

        setBadget("5", R.id.navigation_budget, navView)



    }


    private fun loadFragment(fragment: Fragment) {
        // load fragment
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.nav_host_fragment, fragment)
        transaction.commit()

    }


    @RequiresApi(Build.VERSION_CODES.M)
    fun setBadget(number: String, id: Int, navView: BottomNavigationView){

        val badget = navView.getOrCreateBadge(id)
        badget.isVisible = true
        badget.number = 5
        badget.badgeTextColor = this.getColor(R.color.white) //R.color.white
        badget.horizontalOffset = 15
        badget.verticalOffset = 12

    }


}
