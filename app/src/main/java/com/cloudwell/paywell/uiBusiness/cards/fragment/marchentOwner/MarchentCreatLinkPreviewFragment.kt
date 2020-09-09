package com.cloudwell.paywell.uiBusiness.cards.fragment.marchentOwner

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import com.cloudwell.paywell.utils.FragmentHelper
import kotlinx.android.synthetic.main.marchent_create_link_preview_layout.view.*

class MarchentCreatLinkPreviewFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.marchent_create_link_preview_layout, container, false)


        view.copy_link.setOnClickListener(View.OnClickListener {

            FragmentHelper.replaceFragment(
                MarchentPaymentRequestFragment(),
                requireActivity().supportFragmentManager,
                R.id.bu_Cards_container
            )

        })


        return view
    }


}
