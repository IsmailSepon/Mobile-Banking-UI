package com.cloudwell.paywell.uiBusiness.cards.fragment.marchentOwner

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cloudwell.paywell.R
import com.cloudwell.paywell.uiBusiness.cards.adapter.CardAdapter
import com.cloudwell.paywell.uiBusiness.cards.model.CardPOjo
import com.cloudwell.paywell.utils.FragmentHelper
import kotlinx.android.synthetic.main.marchent_payment_media_layout.view.*


class MarchentPaymentMediaFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.marchent_payment_media_layout, container, false)


        val recyclerView : RecyclerView = view.findViewById(R.id.card_recyclerview)
        val banking_recyclerView : RecyclerView = view.findViewById(R.id.banking_recyclerview)
        val mobile_recyclerView : RecyclerView = view.findViewById(R.id.mobile_recyclerview)

        val linearLayoutManager: LinearLayoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        val linearLayoutManager1: LinearLayoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        val linearLayoutManager2: LinearLayoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.layoutManager = linearLayoutManager
        banking_recyclerView.layoutManager = linearLayoutManager1
        mobile_recyclerView.layoutManager = linearLayoutManager2


        val pojo :CardPOjo = CardPOjo()
        pojo.name = "Visa"
        pojo.icon = R.drawable.visa_small_ic

        val pojo1 :CardPOjo = CardPOjo()
        pojo1.name = "Mastercard"
        pojo1.icon = R.drawable.mastercard_image

        val b1 :CardPOjo = CardPOjo()
        b1.name = "BRAC Bank"
        b1.icon = R.drawable.brack

        val b2 :CardPOjo = CardPOjo()
        b2.name = "Islami Bank"
        b2.icon = R.drawable.islami_bank

        val b3 :CardPOjo = CardPOjo()
        b3.name = "AB Bank"
        b3.icon = R.drawable.ab_bank_ic

        val b4 :CardPOjo = CardPOjo()
        b4.name = "Pubali Bank"
        b4.icon = R.drawable.pubali_bank

        val b5 :CardPOjo = CardPOjo()
        b5.name = "The Ctiy Bank"
        b5.icon = R.drawable.city

        val list = ArrayList<CardPOjo>()
        list.add(pojo)
        list.add(pojo1)

        val banklist = ArrayList<CardPOjo>()
        banklist.add(b1)
        banklist.add(b2)
        banklist.add(b3)
        banklist.add(b4)
        banklist.add(b5)

        recyclerView.adapter  = activity?.applicationContext?.let { CardAdapter(it, list) }
        banking_recyclerView.adapter  = activity?.applicationContext?.let { CardAdapter(it, banklist) }
        mobile_recyclerView.adapter  = activity?.applicationContext?.let { CardAdapter(it, list) }



        view.edit_txt.setOnClickListener(View.OnClickListener {

            FragmentHelper.replaceFragment(
                EnterPaymentDetailsFragment(),
                requireActivity().supportFragmentManager,
                R.id.bu_Cards_container
            )

        })




        return view
    }


}
