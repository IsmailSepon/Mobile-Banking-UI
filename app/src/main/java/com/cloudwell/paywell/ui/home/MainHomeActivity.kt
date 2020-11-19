package com.cloudwell.paywell.ui.home

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.cloudwell.paywell.R
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainHomeActivity : AppCompatActivity() {

    var notificationsBadge : View?  = null


    @RequiresApi(Build.VERSION_CODES.M)
    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_home)


        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration(
            setOf(
                R.id.navigation_account,
                R.id.navigation_budget,
                R.id.navigation_pay,
                R.id.navigation_cards,
                R.id.navigation_control
            )
        )

        navView.setupWithNavController(navController)

        setBadget("5", R.id.navigation_budget, navView)

        //navigation onclick listner

//        navView.setOnNavigationItemSelectedListener { item: MenuItem ->
//            return@setOnNavigationItemSelectedListener when (item.itemId) {
//                R.id.bottomNavigationAlarmMenuId -> {
//                    toast("Alarm item click")
//                    true
//                }
//                R.id.bottomNavigationClockMenuId -> {
//                    toast("Clock item clicked")
//                    true
//                }
//                R.id.bottomNavigationTimerMenuId -> {
//                    toast("Timer item clicked")
//                    true
//                }
//                R.id.bottomNavigationStopWatchMenuId -> {
//                    toast("stop-watch item clicked")
//                    true
//                }
//                else -> false
//            }
//        }


    }




    @RequiresApi(Build.VERSION_CODES.M)
    fun setBadget(number : String, id : Int, navView: BottomNavigationView){

        val badget = navView.getOrCreateBadge(id)
        badget.isVisible = true
        badget.number = 5
        badget.badgeTextColor = this.getColor(R.color.white) //R.color.white
        badget.horizontalOffset = 15
        badget.verticalOffset = 12

    }


}
