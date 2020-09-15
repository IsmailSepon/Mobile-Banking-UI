package com.cloudwell.paywell.uiBusiness.cards.fragment.invoice

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
import com.cloudwell.paywell.uiBusiness.cards.adapter.DraftRecyclerAdapter
import com.cloudwell.paywell.uiBusiness.cards.model.IssuedPOjo
import kotlinx.android.synthetic.main.invoice_expaire_layout.view.*

class InvoiceExpairedFragment : Fragment(){


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.invoice_expaire_layout, container, false)


        val recyclerView : RecyclerView = view.findViewById(R.id.invoice_expaire_recyclerview)

        val linearLayoutManager: LinearLayoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        recyclerView.layoutManager = linearLayoutManager

        recyclerView.setHasFixedSize(false)


        val item = IssuedPOjo()
        item.name = "Square Pharmaceuticals"
        item.date = "10 june"
        item.link = "Expired at 03:55 PM"
        item.profile = "B"

        val item1 = IssuedPOjo()
        item1.name = "Najnin Farjana"
        item1.date = "15 june"
        item1.link = "Expired at 03:55 PM"
        item1.profile = "M"



        var list = ArrayList<IssuedPOjo>()
        list.add(item)
        list.add(item)
        list.add(item1)
        list.add(item1)


        recyclerView.adapter = DraftRecyclerAdapter(requireContext(), list)



        val itemTouchHelper =
            ItemTouchHelper(object : SwipeHelper(view.invoice_expaire_recyclerview) {
                override fun instantiateUnderlayButton(position: Int): List<UnderlayButton> {
                    var buttons = listOf<UnderlayButton>()
                    val deleteButton = deleteButton(position)
                    val markAsUnreadButton = markAsUnreadButton(position)
                    val downlode = downlodeButton(position)
                    val share = shareButton(position)
                    buttons = listOf(  deleteButton, markAsUnreadButton)

                    return buttons
                }
            })

        itemTouchHelper.attachToRecyclerView(view.invoice_expaire_recyclerview)


        return view
    }


    private fun deleteButton(position: Int): SwipeHelper.UnderlayButton {
        return SwipeHelper.UnderlayButton(
            activity?.applicationContext!!,
            "Delete",
            12.0f,
            //android.R.color.darker_gray,
            R.color.colorPrimaryDark,
            object : SwipeHelper.UnderlayButtonClickListener {
                override fun onClick() {

                }
            })
    }

    private fun markAsUnreadButton(position: Int): SwipeHelper.UnderlayButton {
        return SwipeHelper.UnderlayButton(
            activity?.applicationContext!!,
            "Re-issue",
            12.0f,
            //android.R.color.holo_orange_dark,
            R.color.recycler_swipe_gray,
            object : SwipeHelper.UnderlayButtonClickListener {
                override fun onClick() {

                    val intent = Intent(activity, SpiltBillHoastActivity::class.java)
                    intent.putExtra("spilt", "1")
                    startActivity(intent)
                }
            })
    }

    private fun downlodeButton(position: Int): SwipeHelper.UnderlayButton {
        return SwipeHelper.UnderlayButton(
            activity?.applicationContext!!,
            "Download",
            12.0f,
            //android.R.color.holo_orange_dark,
            R.color.recycler_swipe_gray,
            object : SwipeHelper.UnderlayButtonClickListener {
                override fun onClick() {


                }
            })
    }

    private fun shareButton(position: Int): SwipeHelper.UnderlayButton {
        return SwipeHelper.UnderlayButton(
            activity?.applicationContext!!,
            "Share",
            12.0f,
            //android.R.color.holo_orange_dark,
            R.color.colorPrimaryDark,
            object : SwipeHelper.UnderlayButtonClickListener {
                override fun onClick() {


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
        fun newInstance(sectionNumber: Int): InvoiceExpairedFragment {
            return InvoiceExpairedFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
            }
        }
    }

}
