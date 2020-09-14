package com.cloudwell.paywell.uiBusiness.cards.fragment.manageLink

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cloudwell.paywell.R
import com.cloudwell.paywell.ui.account.adapter.SwipeHelper
import com.cloudwell.paywell.ui.spiltBill.fragment.SpiltBillHoastActivity
import com.cloudwell.paywell.uiBusiness.cards.adapter.PaidIRecyclerAdapter
import com.cloudwell.paywell.uiBusiness.cards.model.PaidExpencePOjo
import kotlinx.android.synthetic.main.business_paid_layout.view.*

class BusinessPaidFragment : Fragment(){


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.business_paid_layout, container, false)


        val recyclerView : RecyclerView = view.findViewById(R.id.business_paid_recyclerview)

        val linearLayoutManager: LinearLayoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        recyclerView.layoutManager = linearLayoutManager

        recyclerView.setHasFixedSize(false)


        val item = PaidExpencePOjo()
        item.name = "AK. Bulbul"
        item.date = "10 june"
        item.amount = "600"

        val item1 = PaidExpencePOjo()
        item1.name = "AK. Bulbul"
        item1.date = "16 june"
        item1.amount = "600"



        var list = ArrayList<PaidExpencePOjo>()
        list.add(item)
        list.add(item)
        list.add(item)
        list.add(item1)
        list.add(item1)
        list.add(item1)


        recyclerView.adapter = PaidIRecyclerAdapter(requireContext(), list)

//        recyclerView.addItemDecoration(
//            DividerItemDecoration(
//                recyclerView.context,
//                DividerItemDecoration.VERTICAL
//            )
//        )

        val itemTouchHelper =
            ItemTouchHelper(object : SwipeHelper(view.business_paid_recyclerview) {
                override fun instantiateUnderlayButton(position: Int): List<UnderlayButton> {
                    var buttons = listOf<UnderlayButton>()
                    val deleteButton = deleteButton(position)
                    val markAsUnreadButton = markAsUnreadButton(position)
                    buttons = listOf(deleteButton, markAsUnreadButton)
//                when (position) {
//                    1 -> buttons = listOf(deleteButton)
//                    2 -> buttons = listOf(deleteButton, markAsUnreadButton)
//                    3 -> buttons = listOf(deleteButton, markAsUnreadButton, archiveButton)
//                    else -> Unit
//                }
                    return buttons
                }
            })

        itemTouchHelper.attachToRecyclerView(view.business_paid_recyclerview)


        return view
    }


    private fun deleteButton(position: Int): SwipeHelper.UnderlayButton {
        return SwipeHelper.UnderlayButton(
            activity?.applicationContext!!,
            "Edit",
            12.0f,
            //android.R.color.darker_gray,
            R.color.recycler_swipe_gray,
            object : SwipeHelper.UnderlayButtonClickListener {
                override fun onClick() {

                }
            })
    }

    private fun markAsUnreadButton(position: Int): SwipeHelper.UnderlayButton {
        return SwipeHelper.UnderlayButton(
            activity?.applicationContext!!,
            "Delete",
            12.0f,
            //android.R.color.holo_orange_dark,
            R.color.colorPrimaryDark,
            object : SwipeHelper.UnderlayButtonClickListener {
                override fun onClick() {

                    val intent = Intent(activity, SpiltBillHoastActivity::class.java)
                    intent.putExtra("spilt", "1")
                    startActivity(intent)
                }
            })
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
        fun newInstance(sectionNumber: Int): BusinessPaidFragment {
            return BusinessPaidFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
            }
        }
    }

}
