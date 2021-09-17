package com.cloudwell.paywell.ui.scan.fragment

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import com.cloudwell.paywell.ui.registration.fragment.RegOneFeg
import com.cloudwell.paywell.utils.FragmentHelper
import kotlinx.android.synthetic.main.scan_main_layout.*
import kotlinx.android.synthetic.main.scan_main_layout.scan_et
import kotlinx.android.synthetic.main.scan_main_layout.view.*

/**
 * Created by Sepon on 4/15/2020.
 */
class ScanMainFeg : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.scan_main_layout, container, false)


        view.scan_et.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {

                scan_btn.setBackgroundResource(R.drawable.round_btn_visable)

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })

        view.scan_btn.setOnClickListener(View.OnClickListener {
            FragmentHelper.replaceFragment(ScanPaymentDetailsFeg(), requireActivity().supportFragmentManager, R.id.scan_host_container)
        })


        view.imageView98.setOnClickListener(View.OnClickListener {

            requireActivity().finish()

        })

        return view
    }

    companion object {
        fun newInstance(): RegOneFeg {
            return RegOneFeg()
        }
    }
}