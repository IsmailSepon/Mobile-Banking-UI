package com.cloudwell.paywell.consumer.ui.requestMoney.fragment.creat_link

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.consumer.R
import kotlinx.android.synthetic.main.request_link_finish_layout.view.*

class RequestLinkFinishFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.request_link_finish_layout, container, false)


        view.request_finished.setOnClickListener(View.OnClickListener {

            activity?.finish()
        })


        return view
    }


}
