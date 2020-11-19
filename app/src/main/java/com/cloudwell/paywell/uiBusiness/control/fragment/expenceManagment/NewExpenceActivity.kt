package com.cloudwell.paywell.uiBusiness.control.fragment.expenceManagment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.cloudwell.paywell.R
import kotlinx.android.synthetic.main.activity_new_expence.*

class NewExpenceActivity : AppCompatActivity() {


    var pager: ViewPager2? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_expence)


        val adapter = ScreenSlidePagerAdapter(this)
        pager = expence_view_pager
        pager?.adapter = adapter
        pager?.isUserInputEnabled = false

        pager?.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)


                val t = 100 / adapter.itemCount
                val p = position + 1
                expence_progressBar.progress = p * t

            }
        })

    }


    private class ScreenSlidePagerAdapter(fa: FragmentActivity?) :
        FragmentStateAdapter(fa!!) {

        override fun createFragment(position: Int): Fragment {
            when (position) {
                0 -> return OrginizeChartFragment()
                1 -> return OrginizeApprovalFragment()
                2 -> return BuClaimentProfileFragment()
            }
            return OrginizeChartFragment()

        }

        override fun getItemCount(): Int {
            return 3
        }
    }

    fun setPagerFrg(a: Int) {
        expence_view_pager.currentItem = a
    }

}