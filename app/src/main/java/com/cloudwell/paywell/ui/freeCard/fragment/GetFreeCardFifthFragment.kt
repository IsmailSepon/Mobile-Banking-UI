package com.cloudwell.paywell.ui.freeCard.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import kotlinx.android.synthetic.main.get_free_card_fifth_fragment.view.*

class GetFreeCardFifthFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View =
            inflater.inflate(R.layout.get_free_card_fifth_fragment, container, false)



        view.email_verify_done_btn.setOnClickListener(View.OnClickListener {
            requireActivity().finish()
        })

        return view
    }
}