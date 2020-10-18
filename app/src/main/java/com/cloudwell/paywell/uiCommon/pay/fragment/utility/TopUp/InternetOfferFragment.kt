package com.cloudwell.paywell.uiCommon.pay.fragment.utility.TopUp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.cloudwell.paywell.R
import com.cloudwell.paywell.uiCommon.pay.adapter.OfferListAdapter
import kotlinx.android.synthetic.main.internet_offer_layout.view.*

class InternetOfferFragment : Fragment() {

    var continue_btn : Button? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.internet_offer_layout, container, false)


        continue_btn = view.internet_continue_btn
        continue_btn!!.setOnClickListener(View.OnClickListener {

            requireActivity().finish()

        })

        val layoutManager =
            LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false)

        val recycler = view.internet_offer_recycler
        recycler.layoutManager = layoutManager


        val list = ArrayList<String>()
        list.add("35 MB For 3 Days (Tk. 13)")
        list.add("1GB For 72 Hrs (3 Days) (Tk. 46)")
        list.add("4 GB (3GB + 1GB 4G) For 7 Days (Tk. 114)")
        list.add("4 GB (3GB + 1GB 4G) For 7 Days (Tk. 114)")
        list.add("4 GB (3GB + 1GB 4G) For 7 Days (Tk. 114)")
        list.add("4 GB (3GB + 1GB 4G) For 7 Days (Tk. 114)")
        list.add("4 GB (3GB + 1GB 4G) For 7 Days (Tk. 114)")
        list.add("4 GB (3GB + 1GB 4G) For 7 Days (Tk. 114)")
        list.add("4 GB (3GB + 1GB 4G) For 7 Days (Tk. 114)")
        list.add("4 GB (3GB + 1GB 4G) For 7 Days (Tk. 114)")
        list.add("600 Min + 2GB For 30 Days (Tk. 494)")
        list.add("600 Min + 2GB For 30 Days (Tk. 494)")
        list.add("600 Min + 2GB For 30 Days (Tk. 494)")
        list.add("600 Min + 2GB For 30 Days (Tk. 494)")
        list.add("600 Min + 2GB For 30 Days (Tk. 494)")
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
        fun newInstance(sectionNumber: Int): InternetOfferFragment {
            return InternetOfferFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
            }
        }
    }
}
