package com.cloudwell.paywell.uiCommon.pay.fragment.utility.TopUp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.cloudwell.paywell.R
import com.cloudwell.paywell.uiCommon.pay.adapter.OfferListAdapter
import kotlinx.android.synthetic.main.talk_time_offer_layout.view.*

class TalkTimeOfferFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.talk_time_offer_layout, container, false)



        val layoutManager =
            LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false)

        val recycler = view.talktime_offer_recycler
        recycler.layoutManager = layoutManager


        val list = ArrayList<String>()
        list.add("21 Min (Any Operator) For 16 Hrs (Tk. 14)")
        list.add("600 Min + 2GB For 30 Days (Tk. 494)")
        list.add("600 Min + 2GB For 30 Days (Tk. 494)")
        list.add("77 Min (Any Operator) + 50 SMS For 7 Days (Tk. 53)")
        list.add("77 Min (Any Operator) + 50 SMS For 7 Days (Tk. 53)")
        list.add("77 Min (Any Operator) + 50 SMS For 7 Days (Tk. 53)")
        list.add("600 Min + 2GB For 30 Days (Tk. 494)")


        recycler.adapter  = activity?.applicationContext?.let { OfferListAdapter(it, list) }


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
        fun newInstance(sectionNumber: Int): TalkTimeOfferFragment {
            return TalkTimeOfferFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
            }
        }
    }
}
