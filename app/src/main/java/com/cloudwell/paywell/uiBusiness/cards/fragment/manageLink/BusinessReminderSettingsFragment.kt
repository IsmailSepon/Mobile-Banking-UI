package com.cloudwell.paywell.uiBusiness.cards.fragment.manageLink

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import android.widget.Spinner
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import kotlinx.android.synthetic.main.business_reminder_setting_layout.view.*

class BusinessReminderSettingsFragment : Fragment(){


    private var addexpirFlag = 0
    private var expairelayouy : LinearLayout?= null

    private var withoutexpirFlag = 0
    private var withoutexpairelayouy : LinearLayout?= null



    private var inf: LayoutInflater? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.business_reminder_setting_layout, container, false)


        expairelayouy = view.expair_link_layout
        withoutexpairelayouy = view.withoutexpair_link_layout
        inf = layoutInflater




        addexpairLinkc()
        addexpairLinkc()

        withoutexpairLinkc()
        withoutexpairLinkc()


//        view.add_expire_btn.setOnClickListener(View.OnClickListener {
//            addexpairLinkc()
//        })



        return view
    }

    private fun addexpairLinkc() {
        ++addexpirFlag
        val paywellACview: View = inf!!.inflate(R.layout.expire_link, null)

        val sp : Spinner = paywellACview.findViewById(R.id.expair_sp)

        var country = arrayOf("21 days before expiry date", "5 days before expiry date", "14 days after issued date")
        sp.onItemSelectedListener
        val aa: ArrayAdapter<*> = ArrayAdapter<Any?>(requireContext(), R.layout.spinner_item, country)
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        sp.adapter = aa
        sp.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            }
        }

        expairelayouy?.addView(paywellACview)
    }

    private fun withoutexpairLinkc() {
        ++withoutexpirFlag
        val paywellACview: View = inf!!.inflate(R.layout.expire_link, null)


        val sp : Spinner = paywellACview.findViewById(R.id.expair_sp)

        var country = arrayOf("21 days before expiry date", "5 days before expiry date", "14 days after issued date")
        sp.onItemSelectedListener
        val aa: ArrayAdapter<*> = ArrayAdapter<Any?>(requireContext(), R.layout.spinner_item, country)
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        sp.adapter = aa
        sp.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            }
        }


        withoutexpairelayouy?.addView(paywellACview)
    }

    companion object {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private const val ARG_SECTION_NUMBER = "section_number"

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        @JvmStatic
        fun newInstance(sectionNumber: Int): BusinessReminderSettingsFragment {
            return BusinessReminderSettingsFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
            }
        }
    }

}
