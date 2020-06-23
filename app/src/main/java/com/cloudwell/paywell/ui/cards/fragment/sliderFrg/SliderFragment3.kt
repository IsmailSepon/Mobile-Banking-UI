package com.cloudwell.paywell.ui.cards.fragment.sliderFrg

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import com.cloudwell.paywell.ui.cards.CardHoastActivity
import kotlinx.android.synthetic.main.demo3.view.*

class SliderFragment3 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.demo3, container, false)


        view.virtual_card.setOnClickListener(View.OnClickListener {
            Toast.makeText(activity?.applicationContext, "vitual", Toast.LENGTH_LONG).show()
        })

        view.physical_card.setOnClickListener(View.OnClickListener {
            val intent = Intent(view.context, CardHoastActivity::class.java)
            intent.putExtra("cards", "3")
            view.context.startActivity(intent)
        })


        return view
    }
}

