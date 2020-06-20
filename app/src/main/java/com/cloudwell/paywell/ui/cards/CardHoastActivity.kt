package com.cloudwell.paywell.ui.cards

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cloudwell.paywell.R
import com.cloudwell.paywell.ui.cards.fragment.PaywellCardsLinkFragment
import com.cloudwell.paywell.ui.cards.fragment.identityCheck.ConfirmDeliveryFragment
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
        }


    }
}