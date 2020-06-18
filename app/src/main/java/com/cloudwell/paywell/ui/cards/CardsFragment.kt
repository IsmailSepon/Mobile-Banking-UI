package com.cloudwell.paywell.ui.cards

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.cloudwell.paywell.R
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.cards_fragment.view.*


class CardsFragment : Fragment() {

    companion object {
        fun newInstance() = CardsFragment()
    }

    private lateinit var viewModel: CardsViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root: View = inflater.inflate(R.layout.cards_fragment, container, false)

        var viewpager: ViewPager2 = root.card_viewpager
        viewpager.clipToPadding = false
        viewpager.clipChildren = false
        viewpager.offscreenPageLimit = 3
        viewpager.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER
        var list: ArrayList<CradsItem> = ArrayList()
        var card = CradsItem()
        var card1 = CradsItem()
        card.image = R.drawable.paywell_card_1
        card1.image = R.drawable.paywell_card_2
        list.add(card)
        list.add(card1)
        list.add(card)

        var adapter: CardSliderAdapter =
            CardSliderAdapter(list, viewpager, activity?.applicationContext!!)
        viewpager.adapter = adapter


        var compositePageTransformer: CompositePageTransformer = CompositePageTransformer()
        compositePageTransformer.addTransformer(MarginPageTransformer(30))
        compositePageTransformer.addTransformer(object : ViewPager2.PageTransformer {
            override fun transformPage(page: View, position: Float) {
                var r = 1 - Math.abs(position)
                page.scaleY = 0.85f + r * 0.15f
            }
        })
        viewpager.setPageTransformer(compositePageTransformer)

        var tab: TabLayout = root.into_tab_layout
        tab.addOnTabSelectedListener(object : OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                var position: Int = tab.position

                if (position == 1) {
                    root.layout2.visibility = View.VISIBLE
                    root.layout3.visibility = View.GONE
                } else if (position == 2) {
                    root.layout2.visibility = View.GONE
                    root.layout3.visibility = View.VISIBLE
                } else {
                    root.layout2.visibility = View.GONE
                    root.layout3.visibility = View.GONE
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })


        TabLayoutMediator(tab, viewpager) { tab, position -> }.attach()






        return root

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(CardsViewModel::class.java)

    }

}