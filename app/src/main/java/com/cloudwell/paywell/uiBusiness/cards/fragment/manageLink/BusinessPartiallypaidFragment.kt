package com.cloudwell.paywell.uiBusiness.cards.fragment.manageLink

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cloudwell.paywell.R
import com.cloudwell.paywell.uiBusiness.cards.adapter.PartiallyPaidIRecyclerAdapter
import com.cloudwell.paywell.uiBusiness.cards.model.PaidExpencePOjo

class BusinessPartiallypaidFragment : Fragment(){


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.partially_paid_layout, container, false)


        val recyclerView : RecyclerView = view.findViewById(R.id.patially_paid_recyclerview)

        val linearLayoutManager: LinearLayoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        recyclerView.layoutManager = linearLayoutManager

        recyclerView.setHasFixedSize(false)


        val item = PaidExpencePOjo()
        item.name = "AK. Bulbul"
        item.date = "10 june"
        item.amount = "৳6,000"



        var list = ArrayList<PaidExpencePOjo>()
        list.add(item)
        list.add(item)
        list.add(item)


        recyclerView.adapter = PartiallyPaidIRecyclerAdapter(requireContext(), list)




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
        fun newInstance(sectionNumber: Int): BusinessPartiallypaidFragment {
            return BusinessPartiallypaidFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
            }
        }
    }

}
