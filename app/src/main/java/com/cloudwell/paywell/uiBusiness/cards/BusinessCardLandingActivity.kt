package com.cloudwell.paywell.uiBusiness.cards


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cloudwell.paywell.R
import com.cloudwell.paywell.uiBusiness.cards.fragment.BusinessCardMainFragment
import com.cloudwell.paywell.uiBusiness.cards.fragment.bulk.EnterBulkPaymentFragment
import com.cloudwell.paywell.uiBusiness.cards.fragment.expence.BuCardClaimExpenceFragment
import com.cloudwell.paywell.uiBusiness.cards.fragment.expence.ExpenseManageMainFragment
import com.cloudwell.paywell.uiBusiness.cards.fragment.invoice.BuInvoiceSliderFragment
import com.cloudwell.paywell.uiBusiness.cards.fragment.invoice.NewInvoiceDetailsFragment
import com.cloudwell.paywell.uiBusiness.cards.fragment.manageCustomers.BuManageCustomersFragment
import com.cloudwell.paywell.uiBusiness.cards.fragment.manageLink.BuPaymentLinkFragment
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
        }else if (parent.equals("3")) {
            //card link
            FragmentHelper.addFirstFragment(
                EnterBulkPaymentFragment(),
                supportFragmentManager,
                R.id.bu_Cards_container
            )
        }else if (parent.equals("4")) {
            //card link
            FragmentHelper.addFirstFragment(
                BuPaymentLinkFragment(),
                supportFragmentManager,
                R.id.bu_Cards_container
            )
        }else if (parent.equals("5")) {
            //card link
            FragmentHelper.addFirstFragment(
                BuInvoiceSliderFragment(),
                supportFragmentManager,
                R.id.bu_Cards_container
            )
        }else if (parent.equals("6")) {
            //card link
            FragmentHelper.addFirstFragment(
                BuManageCustomersFragment(),
                supportFragmentManager,
                R.id.bu_Cards_container
            )
        }else if (parent.equals("7")) {
            //card link
            FragmentHelper.addFirstFragment(
                NewInvoiceDetailsFragment(),
                supportFragmentManager,
                R.id.bu_Cards_container
            )
        }else if (parent.equals("8")) {
            //card link
            FragmentHelper.addFirstFragment(
                BuCardClaimExpenceFragment(),
                supportFragmentManager,
                R.id.bu_Cards_container
            )
        }else if (parent.equals("9")) {
            //card link
            FragmentHelper.addFirstFragment(
                ExpenseManageMainFragment(),
                supportFragmentManager,
                R.id.bu_Cards_container
            )
        }

    }
}