package com.cloudwell.paywell.ui.home

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Rect
import android.os.Build
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import com.cloudwell.paywell.base.BaseActivity
import com.cloudwell.paywell.base.Preference
import com.cloudwell.paywell.base.customView.FabBottomNavigationView
import com.cloudwell.paywell.ui.account.fragment.AccountFragment
import com.cloudwell.paywell.ui.budget.fragment.BudgetMainFragment
import com.cloudwell.paywell.ui.cards.fragment.CardsFragment
import com.cloudwell.paywell.ui.dashboard.DashboardFragment
import com.cloudwell.paywell.ui.scan.ScanLandingActivity
import com.cloudwell.paywell.ui.scan.fragment.ScanMainFeg
import com.cloudwell.paywell.uiBusiness.cards.fragment.BusinessCardMainFragment
import com.cloudwell.paywell.uiBusiness.cards.fragment.BusinessCardMenuFragment
import com.cloudwell.paywell.uiCommon.pay.fragment.PaymentsMainFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import jp.wasabeef.blurry.Blurry
import kotlinx.android.synthetic.main.budget_marchent_item.*
import kotlinx.android.synthetic.main.business_main_home.*
import kotlinx.android.synthetic.main.fab_layout_business.*


class BusinessHomeActivity : BaseActivity() {

    var notificationsBadge : View?  = null

    var userType : String? = null

    var mFab : ImageView? = null
   // var mFab: FloatingActionButton? = null
    var fab1: TextView? = null
    var fab2: TextView? = null
    var fab3: TextView? = null
    var rootLayout: LinearLayout? = null
    var framerootLayout: ConstraintLayout? = null

    private var FAB_Status = false

    //Animations
    var show_fab_1: Animation? = null
    var hide_fab_1: Animation? = null
    var show_fab_2: Animation? = null
    var hide_fab_2: Animation? = null
    var show_fab_3: Animation? = null
    var hide_fab_3: Animation? = null



    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.business_main_home)

        val sharePreference : Preference = Preference.getInstance(this)
        userType = sharePreference.getData(getString(R.string.userType))

        rootLayout = findViewById<LinearLayout>(R.id.fab_bg)
        framerootLayout = coordinatorLayout
        val navView: FabBottomNavigationView = findViewById(R.id.nav_view)

        if (userType == "businessAccount"){

            navView.selectedItemId =  0
            loadFragment(BusinessCardMenuFragment())
        }else{


            navView.selectedItemId = R.id.navigation_account
            loadFragment(AccountFragment())
        }



        navView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.navigation_account -> {
                    title = resources.getString(R.string.account)
                    loadFragment(AccountFragment())
                    if (FAB_Status == true) {

                        hideFAB()
                    }
                    return@setOnNavigationItemSelectedListener true
                }

                R.id.navigation_budget -> {
                    title = resources.getString(R.string.budget)
                    loadFragment(BudgetMainFragment())
                    if (FAB_Status == true) {

                        hideFAB()
                    }
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

                R.id.navigation_control -> {
                    title = resources.getString(R.string.control)
                    loadFragment(DashboardFragment())
                    if (FAB_Status == true) {

                        hideFAB()
                    }
                    return@setOnNavigationItemSelectedListener true
                }

                R.id.navigation_business -> {
                    title = resources.getString(R.string.control)
                    loadFragment(BusinessCardMenuFragment())
                    if (FAB_Status == true) {

                        hideFAB()
                    }
                    return@setOnNavigationItemSelectedListener true
                }

                R.id.blank_item ->{


               //     Toast.makeText(this, "che ck", Toast.LENGTH_SHORT).show()
                    FAB_Status = if (FAB_Status  == false) {
                        //Display FAB menu

                        expandFAB()
                        true
                    } else {
                        //Close FAB menu

                        hideFAB()
                        false
                    }

                }

            }
            false

        }

        setBadget("5", R.id.navigation_budget, navView)







        mFab = fab_btn
       // fab.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#mycolor")));
        //fab?.setBackgroundResource(R.drawable.fab_no_border)
       // mFab?.background = getDrawable(R.drawable.fab_no_border)
        //mFab?.setBackgroundTintList(ColorStateList.valueOf(R.drawable.fab_no_border));
      //  mFab?.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.fab_no_border));
            //ColorStateList.valueOf(resources.getDrawable(R.drawable.fab_no_border, null))

        fab1 = fab_1
        fab2 = fab_2
        fab3 = fab_3



        //Animations
        show_fab_1 = AnimationUtils.loadAnimation(application, R.anim.fab1_show)
        hide_fab_1 = AnimationUtils.loadAnimation(application, R.anim.fab1_hide)
        show_fab_2 = AnimationUtils.loadAnimation(application, R.anim.fab2_show)
        hide_fab_2 = AnimationUtils.loadAnimation(application, R.anim.fab2_hide)
        show_fab_3 = AnimationUtils.loadAnimation(application, R.anim.fab3_show)
        hide_fab_3 = AnimationUtils.loadAnimation(application, R.anim.fab3_hide)

        mFab!!.setOnClickListener {
            FAB_Status = if (FAB_Status  == false) {
                //Display FAB menu

                expandFAB()
                true
            } else {
                //Close FAB menu

                hideFAB()
                false
            }


        }
        //fab.setCanceledOnTouchOutside()

        fab1!!.setOnClickListener {
            val intent = Intent(this, ScanLandingActivity :: class.java)
            startActivity(intent)
            hideFAB()
        }

        fab2!!.setOnClickListener {
            loadFragment(PaymentsMainFragment())
            hideFAB()

        }

        fab3!!.setOnClickListener {
          //  Toast.makeText(this, "fab 3", Toast.LENGTH_SHORT).show()

            if (userType==getString(R.string.personalUser)){
                loadFragment(CardsFragment())
            }else{

                loadFragment(BusinessCardMainFragment())
            }
            hideFAB()
        }

    }


    override fun dispatchTouchEvent(ev: MotionEvent): Boolean {
        val viewRect = Rect()
        rootLayout?.getGlobalVisibleRect(viewRect)
        if (!viewRect.contains(ev.rawX.toInt(), ev.rawY.toInt())) {
           // setVisibility(View.GONE)
                    if (FAB_Status == true){

                          hideFAB()
                    }

        }
         return super.dispatchTouchEvent(ev)
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




//
//    @SuppressLint("Range")
//    private fun expandFAB() {
//       // framerootLayout?.alpha = 0.1f
//        FAB_Status = true
//        mFab!!.startAnimation(AnimationUtils.loadAnimation(applicationContext, R.anim.fab_rotate))
//        //floatting button background after click
//        mFab!!.background = application.getDrawable(R.drawable.fab_border)
//        mFab!!.setImageResource(R.drawable.add_ic)
//
//
//      //  rootLayout!!.background = resources.getDrawable(R.drawable.half_moon)
//
//        //Floating Action Button 1
//        val layoutParams = fab1!!.layoutParams as FrameLayout.LayoutParams
//        layoutParams.rightMargin += (fab1!!.width * 1.7).toInt()
//        layoutParams.bottomMargin += (fab1!!.height * 0.8).toInt()
//        fab1!!.layoutParams = layoutParams
//        fab1!!.startAnimation(show_fab_1)
//        fab1!!.isClickable = true
//
//        //Floating Action Button 2
//        val layoutParams2 = fab2!!.layoutParams as FrameLayout.LayoutParams
//        layoutParams2.rightMargin += (fab2!!.width * 0.0).toInt()
//        layoutParams2.bottomMargin += (fab2!!.height * 1.5).toInt()
//        fab2!!.layoutParams = layoutParams2
//        fab2!!.startAnimation(show_fab_2)
//        fab2!!.isClickable = true
//
//        //Floating Action Button 3
//        val layoutParams3 = fab3!!.layoutParams as FrameLayout.LayoutParams
//        layoutParams3.leftMargin+= (fab3!!.width * 1.7).toInt()
//        layoutParams3.bottomMargin += (fab3!!.height * 0.8).toInt()
//        fab3!!.layoutParams = layoutParams3
//        fab3!!.startAnimation(show_fab_3)
//        fab3!!.isClickable = true
//
//        setBlur()
//    }




    @SuppressLint("Range")
    private fun expandFAB() {
       // framerootLayout?.alpha = 0.1f
        FAB_Status = true
        mFab!!.startAnimation(AnimationUtils.loadAnimation(applicationContext, R.anim.fab_rotate))
        //floatting button background after click
        mFab!!.background = application.getDrawable(R.drawable.fab_border)
        mFab!!.setImageResource(R.drawable.add_ic)


      //  rootLayout!!.background = resources.getDrawable(R.drawable.half_moon)

        //Floating Action Button 1
        val layoutParams = fab1!!.layoutParams as FrameLayout.LayoutParams
        layoutParams.rightMargin += (fab1!!.width * 1).toInt()
        layoutParams.bottomMargin += (fab1!!.height * 1.2).toInt()
        fab1!!.layoutParams = layoutParams
        fab1!!.startAnimation(show_fab_1)
        fab1!!.isClickable = true

//        //Floating Action Button 2
//        val layoutParams2 = fab2!!.layoutParams as FrameLayout.LayoutParams
//        layoutParams2.rightMargin += (fab2!!.width * 0.0).toInt()
//        layoutParams2.bottomMargin += (fab2!!.height * 1.5).toInt()
//        fab2!!.layoutParams = layoutParams2
//        fab2!!.startAnimation(show_fab_2)
//        fab2!!.isClickable = true

        //Floating Action Button 3
        val layoutParams3 = fab3!!.layoutParams as FrameLayout.LayoutParams
        layoutParams3.leftMargin+= (fab3!!.width * 1).toInt()
        layoutParams3.bottomMargin += (fab3!!.height * 1.2).toInt()
        fab3!!.layoutParams = layoutParams3
        fab3!!.startAnimation(show_fab_3)
        fab3!!.isClickable = true

        setBlur()
    }



    @SuppressLint("Range")
    private fun hideFAB() {
       // framerootLayout!!.alpha = 100f
        hideBlur()
        FAB_Status = false
        mFab!!.startAnimation(
            AnimationUtils.loadAnimation(
                applicationContext,
                R.anim.fab_rotate_back
            )
        )
        mFab!!.background = application.getDrawable(R.drawable.fab_no_border)
        mFab!!.setImageResource(R.drawable.add_ic_white)

      //  rootLayout!!.background = null//resources.getDrawable(R.drawable.half_moon)

        //Floating Action Button 1
        val layoutParams = fab1!!.layoutParams as FrameLayout.LayoutParams
        layoutParams.rightMargin -= (fab1!!.width * 1).toInt()
        layoutParams.bottomMargin -= (fab1!!.height * 1.2).toInt()
        fab1!!.layoutParams = layoutParams
        fab1!!.startAnimation(hide_fab_1)
        fab1!!.isClickable = false

//        //Floating Action Button 2
//        val layoutParams2 = fab2!!.layoutParams as FrameLayout.LayoutParams
//        layoutParams2.rightMargin -= (fab2!!.width * 0.0).toInt()
//        layoutParams2.bottomMargin -= (fab2!!.height * 1.5).toInt()
//        fab2!!.layoutParams = layoutParams2
//        fab2!!.startAnimation(hide_fab_2)
//        fab2!!.isClickable = false

        //Floating Action Button 3
        val layoutParams3 = fab3!!.layoutParams as FrameLayout.LayoutParams
        layoutParams3.leftMargin -= (fab3!!.width * 1).toInt()
        layoutParams3.bottomMargin -= (fab3!!.height * 1.2).toInt()
        fab3!!.layoutParams = layoutParams3
        fab3!!.startAnimation(hide_fab_3)
        fab3!!.isClickable = false
    }


    private fun setBlur(){

       Blurry.with(this).radius(25).sampling(1).async().onto(framerootLayout)

    }

    private fun hideBlur(){

       Blurry.delete(framerootLayout) //.radius(0).sampling(1).async().onto(framerootLayout)

    }




}
