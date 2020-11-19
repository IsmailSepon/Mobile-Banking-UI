package com.cloudwell.paywell.uiBusiness.cards.fragment.expence

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cloudwell.paywell.R
import com.cloudwell.paywell.uiBusiness.cards.adapter.IssuedIRecyclerAdapter
import com.cloudwell.paywell.uiBusiness.cards.model.IssuedPOjo

class ExpenseUpcommingFragment : Fragment(){


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.upcomming_expense_layout, container, false)


        val recyclerView : RecyclerView = view.findViewById(R.id.upcomming_expense_recyclerview)

        val linearLayoutManager: LinearLayoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        recyclerView.layoutManager = linearLayoutManager

        recyclerView.setHasFixedSize(false)


        val item = IssuedPOjo()
        item.name = "Benham Pharmaceuticals"
        item.date = "10 june"
        item.link = "https://bwl.io/i/i8s7qxQ"
        item.profile = "B"

        val item1 = IssuedPOjo()
        item1.name = "MAK Group"
        item1.date = "15 june"
        item1.link = "https://bwl.io/i/i8s7qxQ"
        item1.profile = "M"



        val list = ArrayList<IssuedPOjo>()
        list.add(item)
        list.add(item)
        list.add(item1)
        list.add(item1)


        recyclerView.adapter = IssuedIRecyclerAdapter(requireContext(), list)


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
        fun newInstance(sectionNumber: Int): ExpenseUpcommingFragment {
            return ExpenseUpcommingFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
            }
        }
    }

}
