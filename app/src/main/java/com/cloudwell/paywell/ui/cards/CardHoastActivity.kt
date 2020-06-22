package com.cloudwell.paywell.ui.cards

import android.os.Bundle
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
            FragmentHelper.replaceFragment(
                PaywellCardsLinkFragment(),
                supportFragmentManager,
                R.id.Cards_container
            )
        } else if (parent.equals("2")) {
            //identy
            FragmentHelper.replaceFragment(
                ConfirmDeliveryFragment(),
                supportFragmentManager,
                R.id.Cards_container
            )
        } else if (parent.equals("3")) {
            //identy
            FragmentHelper.replaceFragment(
                OrderingPhysicalCardFragment(),
                supportFragmentManager,
                R.id.Cards_container
            )
        } else if (parent.equals("security")) {
            //identy
            FragmentHelper.replaceFragment(
                CardsSecurityFragment(),
                supportFragmentManager,
                R.id.Cards_container
            )
        } else if (parent.equals("limit")) {
            //identy
            FragmentHelper.replaceFragment(
                CardsLimitFragment(),
                supportFragmentManager,
                R.id.Cards_container
            )
        }


    }
}