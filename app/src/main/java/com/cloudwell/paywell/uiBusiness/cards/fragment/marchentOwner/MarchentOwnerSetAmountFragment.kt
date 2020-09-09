package com.cloudwell.paywell.uiBusiness.cards.fragment.marchentOwner

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import com.cloudwell.paywell.utils.FragmentHelper
import kotlinx.android.synthetic.main.marchent_owner_amount_layout.view.*

class MarchentOwnerSetAmountFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.marchent_owner_amount_layout, container, false)


        view.marchent_amount_done.setOnClickListener(View.OnClickListener {

            FragmentHelper.replaceFragment(
                MarchentCreatLinkFragment(),
                requireActivity().supportFragmentManager,
                R.id.bu_Cards_container
            )

        })


        return view
    }


}
