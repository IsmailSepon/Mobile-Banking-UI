package com.cloudwell.paywell.ui.home

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import com.cloudwell.paywell.base.Preference
import com.cloudwell.paywell.base.customView.FabBottomNavigationView
import com.cloudwell.paywell.ui.account.fragment.AccountFragment
import com.cloudwell.paywell.ui.budget.fragment.BudgetMainFragment
import com.cloudwell.paywell.ui.dashboard.DashboardFragment
import com.cloudwell.paywell.uiBusiness.cards.fragment.BusinessCardMenuFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main_home.*
import kotlinx.android.synthetic.main.budget_marchent_item.*
import kotlinx.android.synthetic.main.fab_layout.*


class MainHomeActivity : AppCompatActivity() {

    var notificationsBadge : View?  = null

    var userType : String? = null

    var fab: ImageView? = null
    //var fab: FloatingActionButton? = null
    var fab1: TextView? = null
    var fab2: TextView? = null
    var fab3: TextView? = null
    var rootLayout: LinearLayout? = null


    private var FAB_Status = false

    //Animations
    var show_fab_1: Animation? = null
    var hide_fab_1: Animation? = null
    var show_fab_2: Animation? = null
    var hide_fab_2: Animation? = null
    var show_fab_3: Animation? = null
    var hide_fab_3: Animation? = null



    @RequiresApi(Build.VERSION_CODES.M)
    @SuppressLint("ResourceAsColor", "Range")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_home)

        val sharePreference : Preference = Preference.getInstance(this)
        userType = sharePreference.getData(getString(R.string.userType))
        rootLayout = findViewById<LinearLayout>(R.id.linearLayout35)


        val navView: FabBottomNavigationView = findViewById(R.id.nav_view)
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

//                R.id.navigation_pay-> {
//                    title=resources.getString(R.string.pay)
//                    loadFragment(PaymentsMainFragment())
//                    return@setOnNavigationItemSelectedListener true
//                }
//
//                R.id.navigation_cards-> {
//
//                    loadFragment(CardsFragment())
//
//
////                    title=resources.getString(R.string.cards)
////                    if (userType==getString(R.string.personalUser)){
////
////                    }else{
////
////                        loadFragment(BusinessCardMenuFragment())
////                    }
//                    return@setOnNavigationItemSelectedListener true
//                }

                R.id.navigation_control-> {
                    title=resources.getString(R.string.control)
                    loadFragment(DashboardFragment())
                    return@setOnNavigationItemSelectedListener true
                }

                R.id.navigation_business-> {
                    title=resources.getString(R.string.control)
                    loadFragment(BusinessCardMenuFragment())
                    return@setOnNavigationItemSelectedListener true
                }

            }
            false

        }

        setBadget("5", R.id.navigation_budget, navView)



        fab = fab_btn
        fab1 = fab_1
        fab2 = fab_2
        fab3 = fab_3

        //Animations

        //Animations
        show_fab_1 = AnimationUtils.loadAnimation(application, R.anim.fab1_show)
        hide_fab_1 = AnimationUtils.loadAnimation(application, R.anim.fab1_hide)
        show_fab_2 = AnimationUtils.loadAnimation(application, R.anim.fab2_show)
        hide_fab_2 = AnimationUtils.loadAnimation(application, R.anim.fab2_hide)
        show_fab_3 = AnimationUtils.loadAnimation(application, R.anim.fab3_show)
        hide_fab_3 = AnimationUtils.loadAnimation(application, R.anim.fab3_hide)

        fab!!.setOnClickListener {
            FAB_Status = if (FAB_Status  == false) {
                //Display FAB menu
                fab!!.startAnimation(AnimationUtils.loadAnimation(applicationContext, R.anim.fab_rotate))
                fab!!.background = application.getDrawable(R.drawable.fab_border)
                fab!!.setImageResource(R.drawable.add_ic)

                expandFAB()
                true
            } else {
                //Close FAB menu
                fab!!.startAnimation(AnimationUtils.loadAnimation(applicationContext, R.anim.fab_rotate_back))
                fab!!.background = application.getDrawable(R.drawable.fab_no_border)
                fab!!.setImageResource(R.drawable.add_ic_white)

                hideFAB()
                false
            }



        }

        fab1!!.setOnClickListener {
            Toast.makeText(
                application,
                "Floating Action Button 1",
                Toast.LENGTH_SHORT
            ).show()

            rootLayout!!.alpha = 100f
        }

        fab2!!.setOnClickListener {
            Toast.makeText(
                application,
                "Floating Action Button 2",
                Toast.LENGTH_SHORT
            ).show()

            rootLayout!!.alpha = 100f
        }

        fab3!!.setOnClickListener {
            Toast.makeText(
                application,
                "Floating Action Button 3",
                Toast.LENGTH_SHORT
            ).show()

            rootLayout!!.alpha = 100f
        }

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





    private fun expandFAB() {
        rootLayout!!.alpha = 0.1f

        //Floating Action Button 1
        val layoutParams = fab1!!.layoutParams as FrameLayout.LayoutParams
        layoutParams.rightMargin += (fab1!!.width * 1.7).toInt()
        layoutParams.bottomMargin += (fab1!!.height * 1.0).toInt()
        fab1!!.layoutParams = layoutParams
        fab1!!.startAnimation(show_fab_1)
        fab1!!.isClickable = true

        //Floating Action Button 2
        val layoutParams2 = fab2!!.layoutParams as FrameLayout.LayoutParams
        layoutParams2.rightMargin += (fab2!!.width * 0.0).toInt()
        layoutParams2.bottomMargin += (fab2!!.height * 1.8).toInt()
        fab2!!.layoutParams = layoutParams2
        fab2!!.startAnimation(show_fab_2)
        fab2!!.isClickable = true

        //Floating Action Button 3
        val layoutParams3 = fab3!!.layoutParams as FrameLayout.LayoutParams
        layoutParams3.leftMargin+= (fab3!!.width * 1.7).toInt()
        layoutParams3.bottomMargin += (fab3!!.height * 1.00).toInt()
        fab3!!.layoutParams = layoutParams3
        fab3!!.startAnimation(show_fab_3)
        fab3!!.isClickable = true
    }

    @SuppressLint("Range")
    private fun hideFAB() {
        rootLayout!!.alpha = 100f

        //Floating Action Button 1
        val layoutParams = fab1!!.layoutParams as FrameLayout.LayoutParams
        layoutParams.rightMargin -= (fab1!!.width * 1.7).toInt()
        layoutParams.bottomMargin -= (fab1!!.height * 1.0).toInt()
        fab1!!.layoutParams = layoutParams
        fab1!!.startAnimation(hide_fab_1)
        fab1!!.isClickable = false

        //Floating Action Button 2
        val layoutParams2 = fab2!!.layoutParams as FrameLayout.LayoutParams
        layoutParams2.rightMargin -= (fab2!!.width * 0.0).toInt()
        layoutParams2.bottomMargin -= (fab2!!.height * 1.8).toInt()
        fab2!!.layoutParams = layoutParams2
        fab2!!.startAnimation(hide_fab_2)
        fab2!!.isClickable = false

        //Floating Action Button 3
        val layoutParams3 = fab3!!.layoutParams as FrameLayout.LayoutParams
        layoutParams3.leftMargin -= (fab3!!.width * 1.7).toInt()
        layoutParams3.bottomMargin -= (fab3!!.height * 1.0).toInt()
        fab3!!.layoutParams = layoutParams3
        fab3!!.startAnimation(hide_fab_3)
        fab3!!.isClickable = false
    }



}
