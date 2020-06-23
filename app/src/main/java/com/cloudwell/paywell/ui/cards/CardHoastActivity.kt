package com.cloudwell.paywell.ui.cards

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.cloudwell.paywell.R
import com.cloudwell.paywell.ui.cards.fragment.CardsLimitFragment
import com.cloudwell.paywell.ui.cards.fragment.CardsSecurityFragment
import com.cloudwell.paywell.ui.cards.fragment.PaywellCardsLinkFragment
import com.cloudwell.paywell.ui.cards.fragment.identityCheck.ConfirmDeliveryFragment
import com.cloudwell.paywell.ui.cards.fragment.physicalCard.OrderingPhysicalCardFragment
import com.cloudwell.paywell.utils.FragmentHelper

class CardHoastActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_card_hoast)


        val parent: String? = intent.getStringExtra("cards")

        if (parent.equals("1")) {
            //card link
            FragmentHelper.addFirstFragment(
                PaywellCardsLinkFragment(),
                supportFragmentManager,
                R.id.Cards_container
            )
        } else if (parent.equals("2")) {
            //identy
            FragmentHelper.addFirstFragment(
                ConfirmDeliveryFragment(),
                supportFragmentManager,
                R.id.Cards_container
            )
        } else if (parent.equals("3")) {
            //identy
            FragmentHelper.addFirstFragment(
                OrderingPhysicalCardFragment(),
                supportFragmentManager,
                R.id.Cards_container
            )
        } else if (parent.equals("security")) {
            //identy
            FragmentHelper.addFirstFragment(
                CardsSecurityFragment(),
                supportFragmentManager,
                R.id.Cards_container
            )
        } else if (parent.equals("limit")) {
            //identy
            FragmentHelper.addFirstFragment(
                CardsLimitFragment(),
                supportFragmentManager,
                R.id.Cards_container
            )
        }


    }


    override fun onPause() {
        super.onPause()
        Log.e("Card Host", "pause")
    }

    override fun onResume() {
        super.onResume()
        Log.e("Card Host", "resume")
    }
}