package com.cloudwell.paywell.ui.cards.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.cloudwell.paywell.R
import com.cloudwell.paywell.consumer.ui.account.pendingPopupDialog.CreateCardPinDialog
import com.cloudwell.paywell.consumer.ui.account.pendingPopupDialog.ViewCardPinDialog
import com.cloudwell.paywell.ui.cards.CardHoastActivity
import com.cloudwell.paywell.ui.cards.fragment.sliderFrg.SliderFragment
import com.cloudwell.paywell.ui.cards.fragment.sliderFrg.SliderFragment2
import com.cloudwell.paywell.ui.cards.fragment.sliderFrg.SliderFragment3
import com.cloudwell.paywell.ui.cards.viewModel.CardsViewModel
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.cards_fragment.view.*


class CardsFragment : Fragment() {


    companion object {
        fun newInstance() =
            CardsFragment()
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
        tab.addOnTabSelectedListener(object : OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                var position: Int = tab.position

                 if (position == 0){
                    root.layout2.visibility = View.GONE
                    root.layout3.visibility = View.GONE
                    root.titile_text?.text = getString(R.string.paywell_cards)

                    root.constraintLayout18.visibility  = View.VISIBLE
                    root.view_pin_layout.visibility  = View.VISIBLE

                }else if (position == 1) {
                    root.layout2.visibility = View.VISIBLE
                    root.layout3.visibility = View.GONE
                    root.titile_text?.text = getString(R.string.paywell_cards)

                    root.constraintLayout18.visibility  = View.GONE
                    root.view_pin_layout.visibility  = View.GONE

                } else if (position == 2) {
                    root.layout2.visibility = View.GONE
                    root.layout3.visibility = View.VISIBLE
                    root.titile_text?.text = "Add new card"


                    root.constraintLayout18.visibility  = View.GONE
                    root.view_pin_layout.visibility  = View.GONE


                }else {
                    root.layout2.visibility = View.GONE
                    root.layout3.visibility = View.GONE
                    root.titile_text?.text = getString(R.string.paywell_cards)
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })

        TabLayoutMediator(tab, viewpager) { tab, position -> }.attach()



        root.layout3.setOnClickListener(View.OnClickListener {
            val intent = Intent(root.context, CardHoastActivity::class.java)
            intent.putExtra("cards", "1")
            root.context.startActivity(intent)

        })

        root.layout2.setOnClickListener(View.OnClickListener {
            val intent = Intent(root.context, CardHoastActivity::class.java)
            intent.putExtra("cards", "2")
            root.context.startActivity(intent)

        })


        root.security_layout.setOnClickListener(View.OnClickListener {
            val intent = Intent(root.context, CardHoastActivity::class.java)
            intent.putExtra("cards", "security")
            root.context.startActivity(intent)
        })

        root.limit_layout.setOnClickListener(View.OnClickListener {
            val intent = Intent(root.context, CardHoastActivity::class.java)
            intent.putExtra("cards", "limit")
            //intent.putExtra(StringEnum().card_limit, StringEnum().card_limit)
            root.context.startActivity(intent)
        })

        root.reset_card_pin.setOnClickListener(View.OnClickListener {
            val newFragment: DialogFragment = CreateCardPinDialog()
            newFragment.show(activity?.supportFragmentManager!!, "CreateCardPinDialog")
        })

        root.view_pin_layout.setOnClickListener(View.OnClickListener {
            val newFragment: DialogFragment = ViewCardPinDialog()
            newFragment.show(activity?.supportFragmentManager!!, "CreateCardPinDialog")
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