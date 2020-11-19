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
import kotlinx.android.synthetic.main.combo_offer_layout.view.*

class ComboOfferFragment : Fragment(), OfferListAdapter.OfferClickListener {

    var continue_btn : Button? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.combo_offer_layout, container, false)


        continue_btn = view.combo_continue_btn
        continue_btn!!.setOnClickListener(View.OnClickListener {

            requireActivity().finish()

        })

        val layoutManager =
            LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false)

        val recycler = view.combo_offer_recycler
        recycler.layoutManager = layoutManager


        val list = ArrayList<String>()
        list.add("600 Min + 2GB For 30 Days (Tk. 494)")
        list.add("600 Min + 2GB For 30 Days (Tk. 494)")
        list.add("600 Min + 2GB For 30 Days (Tk. 494)")
        list.add("600 Min + 2GB For 30 Days (Tk. 494)")
        list.add("600 Min + 2GB For 30 Days (Tk. 494)")
        list.add("600 Min + 2GB For 30 Days (Tk. 494)")
        list.add("600 Min + 2GB For 30 Days (Tk. 494)")
        list.add("600 Min + 2GB For 30 Days (Tk. 494)")
        list.add("600 Min + 2GB For 30 Days (Tk. 494)")
        list.add("600 Min + 2GB For 30 Days (Tk. 494)")
        list.add("600 Min + 2GB For 30 Days (Tk. 494)")
        list.add("600 Min + 2GB For 30 Days (Tk. 494)")
        list.add("600 Min + 2GB For 30 Days (Tk. 494)")
        list.add("600 Min + 2GB For 30 Days (Tk. 494)")
        list.add("600 Min + 2GB For 30 Days (Tk. 494)")
        list.add("600 Min + 2GB For 30 Days (Tk. 494)")
        list.add("600 Min + 2GB For 30 Days (Tk. 494)")
        list.add("600 Min + 2GB For 30 Days (Tk. 494)")


        val adapter : OfferListAdapter = OfferListAdapter(requireContext(), list)
        recycler.adapter  = adapter
        adapter.setClickListener(this)


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
        fun newInstance(sectionNumber: Int): ComboOfferFragment {
            return ComboOfferFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
            }
        }
    }

    override fun onClick(pojo: String) {

        //Toast.makeText(requireContext(), pojo, Toast.LENGTH_SHORT).show()
       //continue_btn!!.background = R.drawable.round_btn_visable

        continue_btn!!.background = this.resources.getDrawable(R.drawable.round_btn_visable)

    }
}
