package com.cloudwell.paywell.ui.BusinessUI.cards.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import com.cloudwell.paywell.ui.BusinessUI.cards.BusinessCardLandingActivity
import com.cloudwell.paywell.ui.cards.CardHoastActivity
import kotlinx.android.synthetic.main.business_card_menu_layout.view.*

class BusinessCardMenuFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.business_card_menu_layout, container, false)

        view.create_new_card_btn.setOnClickListener(View.OnClickListener {
            val intent = Intent(view.context, BusinessCardLandingActivity::class.java)
            intent.putExtra("bu_cards", "1")
            view.context.startActivity(intent)
        })


        return view
    }


}
