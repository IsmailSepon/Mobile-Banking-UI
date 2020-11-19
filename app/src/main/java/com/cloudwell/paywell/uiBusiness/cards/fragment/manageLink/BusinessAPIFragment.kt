package com.cloudwell.paywell.uiBusiness.cards.fragment.manageLink

import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import kotlinx.android.synthetic.main.business_api_layout.view.*


class BusinessAPIFragment : Fragment(){


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.business_api_layout, container, false)



        val text = "<font color=#7E8996>You can start using PayWell merchant account API in your application \n" +
                "using API key below. Please refer to </font> <font color=#0066CB>API documentation </font><font color=#7E8996>for details.</font>"
        view.api_details.text = Html.fromHtml(text)


        val text1 = "<font color=#00203f>Please</font> <font color=#f15a24> keep your production API key private. </font>"
        view.production_txt.text = Html.fromHtml(text1)



        return view
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
        fun newInstance(sectionNumber: Int): BusinessAPIFragment {
            return BusinessAPIFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
            }
        }
    }

}
