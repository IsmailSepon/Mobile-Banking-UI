package com.cloudwell.paywell.uiBusiness.cards


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cloudwell.paywell.R
import com.cloudwell.paywell.uiBusiness.cards.fragment.BusinessCardMainFragment
import com.cloudwell.paywell.uiBusiness.cards.fragment.marchentOwner.MarchentOwnerSetAmountFragment
import com.cloudwell.paywell.utils.FragmentHelper

class BusinessCardLandingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_business_card_landing)

       // FragmentHelper.addFirstFragment( BusinessCardMenuFragment(), supportFragmentManager, R.id.bu_Cards_container)
        val parent: String? = intent.getStringExtra("bu_cards")

        if (parent.equals("1")) {
            //card link
            FragmentHelper.addFirstFragment(
                BusinessCardMainFragment(),
                supportFragmentManager,
                R.id.bu_Cards_container
            )
        }else if (parent.equals("2")) {
            //card link
            FragmentHelper.addFirstFragment(
                MarchentOwnerSetAmountFragment(),
                supportFragmentManager,
                R.id.bu_Cards_container
            )
        }

    }
}