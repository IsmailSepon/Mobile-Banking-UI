package com.cloudwell.paywell.ui.vaults.vaultIntro

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.cloudwell.paywell.R
import com.cloudwell.paywell.ui.vaults.fragment.AddNewVaultFragmetn
import com.cloudwell.paywell.utils.FragmentHelper
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.vault_intro_main_layout.view.*

class VaultIntroMainFragment : Fragment() {


//    var  viewPager  : ViewPager2? = null
    lateinit var viewPager: ViewPager2
    var position : Int = -1


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        val view: View = inflater.inflate(R.layout.vault_intro_main_layout, container, false)

        viewPager = view.vault_viewpager

        val pagerAdapter = ScreenSlidePagerAdapter(this)
        viewPager.adapter = pagerAdapter
        viewPager.isUserInputEnabled = false


        val tab: TabLayout = view.vault_tab_layout        //root.into_tab_layout
        TabLayoutMediator(tab, viewPager) { tab, position -> }.attach()

        view.vault_intro_btn.setOnClickListener(View.OnClickListener {
            var position : Int  = viewPager.currentItem
            if (position==0){
                viewPager.currentItem = 1
            }else if (position==1){
                viewPager.currentItem = 2
            }else if (position==2){
                FragmentHelper.replaceFragment(AddNewVaultFragmetn(), requireActivity().supportFragmentManager, R.id.vault_intro_container)
            }
        })


        view.skip_intro.setOnClickListener(View.OnClickListener {

            FragmentHelper.replaceFragment(AddNewVaultFragmetn(), requireActivity().supportFragmentManager, R.id.vault_intro_container)
        })

        return view
    }

    private inner class ScreenSlidePagerAdapter(fa: Fragment) : FragmentStateAdapter(fa) {
        override fun getItemCount(): Int = 3

        val root = view

        override fun createFragment(position: Int): Fragment {

            if (position == 0) {
                return VultIntroOneFragment()
            } else if (position == 1) {
                return VultIntroTwoFragment()
            } else if (position == 2) {
                return VultIntroThreeFragment()
            }

            return VultIntroOneFragment()
        }

        //  override fun createFragment(position: Int): Fragment = SliderFragment()

    }
}