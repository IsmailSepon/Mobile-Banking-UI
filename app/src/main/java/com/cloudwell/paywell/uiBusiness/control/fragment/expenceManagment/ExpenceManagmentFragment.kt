package com.cloudwell.paywell.uiBusiness.control.fragment.expenceManagment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.cloudwell.paywell.R
import com.cloudwell.paywell.utils.FragmentHelper
import kotlinx.android.synthetic.main.expence_managment_layout.view.*

class ExpenceManagmentFragment : Fragment(){

    var pager: ViewPager2? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View =
            inflater.inflate(R.layout.expence_managment_layout, container, false)




        val adapter = ScreenSlidePagerAdapter(activity)
        pager = view.expence_view_pager
        pager?.adapter = adapter
        pager?.isUserInputEnabled = false

        pager?.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)


                val t = 100 / adapter.itemCount
                val p = position + 1
                view.expence_progressBar.progress = p * t

            }
        })



        view.imageView211.setOnClickListener(View.OnClickListener {
            FragmentHelper.removeFragment(requireActivity().supportFragmentManager)
        })

        return view
    }

    class ScreenSlidePagerAdapter(fa: FragmentActivity?) :
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
        pager?.currentItem = a
    }




}