package com.cloudwell.paywell.ui.cards.fragment.physicalCard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.cloudwell.paywell.R
import com.cloudwell.paywell.ui.cards.fragment.sliderFrg.SliderFragment
import com.cloudwell.paywell.ui.cards.fragment.sliderFrg.SliderFragment2
import com.cloudwell.paywell.ui.cards.fragment.sliderFrg.SliderFragment3
import com.cloudwell.paywell.ui.cards.viewModel.CardsViewModel
import com.cloudwell.paywell.utils.FragmentHelper
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.ordering_physical_card_layout.view.*


class OrderingPhysicalCardFragment : Fragment() {


    companion object {
        fun newInstance() =
            OrderingPhysicalCardFragment()
    }

    private lateinit var viewModel: CardsViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root: View = inflater.inflate(R.layout.ordering_physical_card_layout, container, false)

        var viewpager: ViewPager2 = root.card_viewpager


        viewpager.clipToPadding = false
        viewpager.clipChildren = false
        viewpager.offscreenPageLimit = 3

        val pagerAdapter = ScreenSlidePagerAdapter(this)
        viewpager.adapter = pagerAdapter

        var compositePageTransformer: CompositePageTransformer = CompositePageTransformer()
        compositePageTransformer.addTransformer(MarginPageTransformer(30))
        compositePageTransformer.addTransformer(object : ViewPager2.PageTransformer {
            override fun transformPage(page: View, position: Float) {
                var r = 1 - Math.abs(position)
                page.scaleY = 0.85f + r * 0.15f
            }
        })
        viewpager.setPageTransformer(compositePageTransformer)
//
        var tab: TabLayout = root.into_tab_layout



        TabLayoutMediator(tab, viewpager) { tab, position -> }.attach()



        root.ordering_physical_card_btn.setOnClickListener(View.OnClickListener {
            FragmentHelper.replaceFragment(
                CardUsageTermsFragment(),
                activity?.supportFragmentManager,
                R.id.Cards_container
            )
        })


        root.physicar_card_back.setOnClickListener(View.OnClickListener {
            activity?.finish()
        })


        return root

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(CardsViewModel::class.java)

    }

    private inner class ScreenSlidePagerAdapter(fa: Fragment) : FragmentStateAdapter(fa) {
        override fun getItemCount(): Int = 3

        val root = view

        override fun createFragment(position: Int): Fragment {

            if (position == 0) {
                return SliderFragment()
            } else if (position == 1) {
                return SliderFragment2()
            } else if (position == 2) {
                return SliderFragment3()
            }

            return SliderFragment()
        }

        //  override fun createFragment(position: Int): Fragment = SliderFragment()

    }
}