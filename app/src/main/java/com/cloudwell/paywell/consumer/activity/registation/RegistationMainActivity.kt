package com.cloudwell.paywell.consumer.activity.registation

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import com.cloudwell.paywell.consumer.R
import com.cloudwell.paywell.consumer.activity.registation.fragment.*
import kotlinx.android.synthetic.main.activity_registation_main.*


class RegistationMainActivity : AppCompatActivity() {

    var pager: ViewPager2? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registation_main)


        val adapter = ScreenSlidePagerAdapter(this)
        reg_view_pager.adapter = adapter
        reg_view_pager.isUserInputEnabled = false

        reg_view_pager.registerOnPageChangeCallback(object : OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)


                val t = 100 / adapter.itemCount
                val p = position + 1
                registation_progressBar.progress = p*t

            }
        })

        reg_back_btn.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                Toast.makeText(this@RegistationMainActivity, "Parent activity Not found", Toast.LENGTH_SHORT).show()
            }
        })
    }


    private class ScreenSlidePagerAdapter(fa: FragmentActivity?) :
        FragmentStateAdapter(fa!!) {

        override fun createFragment(position: Int): Fragment {
            when (position) {
                0 -> return RegOneFeg()
                1 -> return RegTwoFeg()
                2 -> return RegThreeFeg()
                3 -> return PersonalDetilsFreg()
                4 -> return PersonalDetilsFullFreg()
                5 -> return RegEmailFreg()
            }
            return RegOneFeg()

        }

        override fun getItemCount(): Int {
            return 6
        }
    }

    fun setPagerFragment(a: Int) {
        reg_view_pager.currentItem = a
    }


}
