package com.cloudwell.paywell.ui.cards

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cloudwell.paywell.R
import com.cloudwell.paywell.ui.cards.fragment.PaywellCardsLinkFragment
import com.cloudwell.paywell.utils.FragmentHelper

class CardHoastActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_card_hoast)

        FragmentHelper.replaceFragment(
            PaywellCardsLinkFragment(),
            supportFragmentManager,
            R.id.Cards_container
        )
    }
}