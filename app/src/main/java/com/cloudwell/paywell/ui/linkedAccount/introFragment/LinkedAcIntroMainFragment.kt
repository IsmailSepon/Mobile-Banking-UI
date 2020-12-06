package com.cloudwell.paywell.ui.linkedAccount.introFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.cloudwell.paywell.R
import com.cloudwell.paywell.ui.addMoney.fragment.AddMoneyBankLisFragment
import com.cloudwell.paywell.ui.linkedAccount.fragment.LinkedACBankListFragment
import com.cloudwell.paywell.ui.vaults.fragment.AddNewVaultFragmetn
import com.cloudwell.paywell.utils.FragmentHelper
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.linkedac_intro_main_layout.view.*
import kotlinx.android.synthetic.main.vault_intro_main_layout.view.*
import kotlinx.android.synthetic.main.vault_intro_main_layout.view.skip_intro
import kotlinx.android.synthetic.main.vault_intro_main_layout.view.vault_viewpager

class LinkedAcIntroMainFragment : Fragment() {


//    var  viewPager  : ViewPager2? = null
    lateinit var viewPager: ViewPager2
    var position : Int = -1


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        val view: View = inflater.inflate(R.layout.linkedac_intro_main_layout, container, false)

        viewPager = view.linked_ac_viewpager

        val pagerAdapter = ScreenSlidePagerAdapter(this)
        viewPager.adapter = pagerAdapter
        viewPager.isUserInputEnabled = false


        val tab: TabLayout = view.linked_ac_tab_layout        //root.into_tab_layout
        TabLayoutMediator(tab, viewPager) { tab, position -> }.attach()

        view.linked_ac_intro_btn.setOnClickListener(View.OnClickListener {
            var position : Int  = viewPager.currentItem
            if (position==0){
                viewPager.currentItem = 1
            }else if (position==1){
                viewPager.currentItem = 2
            }else if (position==2){
                viewPager.currentItem = 3
                FragmentHelper.replaceFragment(LinkedACBankListFragment(), requireActivity().supportFragmentManager, R.id.linked_account_container)
            }
        })


        view.linked_acskip_intro.setOnClickListener(View.OnClickListener {

            FragmentHelper.replaceFragment(LinkedACBankListFragment(), requireActivity().supportFragmentManager, R.id.linked_account_container)
        })

        return view
    }

    private inner class ScreenSlidePagerAdapter(fa: Fragment) : FragmentStateAdapter(fa) {
        override fun getItemCount(): Int = 4

        val root = view

        override fun createFragment(position: Int): Fragment {

            if (position == 0) {
                return LinkedIntroOneFragment()
            } else if (position == 1) {
                return LinkedIntroTwoFragment()
            } else if (position == 2) {
                return LinkedIntroThreeFragment()
            }else if (position == 3) {
                return LinkedIntroFourFragment()
            }

            return LinkedIntroOneFragment()
        }

        //  override fun createFragment(position: Int): Fragment = SliderFragment()

    }
}