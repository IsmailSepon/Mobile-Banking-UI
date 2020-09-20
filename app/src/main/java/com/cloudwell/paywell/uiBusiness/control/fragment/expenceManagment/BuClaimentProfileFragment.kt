package com.cloudwell.paywell.uiBusiness.control.fragment.expenceManagment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import com.cloudwell.paywell.R
import com.cloudwell.paywell.ui.account.adapter.SwipeHelper
import com.cloudwell.paywell.uiBusiness.control.fragment.expenceManagment.adapter.ClaimAdapter
import com.cloudwell.paywell.uiBusiness.control.fragment.expenceManagment.model.ClaimModel
import kotlinx.android.synthetic.main.claiment_fragment.view.*


class BuClaimentProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.claiment_fragment, container, false)

        val linearLayoutManager: LinearLayoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        view.claim_recyclerview.layoutManager = linearLayoutManager

        view.claim_recyclerview.setHasFixedSize(false)


        val item = ClaimModel()
        item.name = "AK. Bulbul"
        item.reportingBy = "Reporting to Tokee Mesbah"
        item.accounting = "Accounting by Saiful Islam"



        val list = ArrayList<ClaimModel>()
        list.add(item)
        list.add(item)
        list.add(item)


        view.claim_recyclerview.adapter =
            ClaimAdapter(requireContext(), list)

        view.claim_recyclerview.addItemDecoration(
            DividerItemDecoration(
                view.claim_recyclerview.context,
                DividerItemDecoration.VERTICAL
            )
        )

        val itemTouchHelper =
            ItemTouchHelper(object : SwipeHelper(view.claim_recyclerview) {
                override fun instantiateUnderlayButton(position: Int): List<UnderlayButton> {
                    var buttons = listOf<UnderlayButton>()
                    val deleteButton = deleteButton(position)
                    val markAsUnreadButton = markAsUnreadButton(position)
                    buttons = listOf(markAsUnreadButton, deleteButton)
//                when (position) {
//                    1 -> buttons = listOf(deleteButton)
//                    2 -> buttons = listOf(deleteButton, markAsUnreadButton)
//                    3 -> buttons = listOf(deleteButton, markAsUnreadButton, archiveButton)
//                    else -> Unit
//                }
                    return buttons
                }
            })

        itemTouchHelper.attachToRecyclerView(view.claim_recyclerview)


        return view
    }





    private fun deleteButton(position: Int): SwipeHelper.UnderlayButton {
        return SwipeHelper.UnderlayButton(
            activity?.applicationContext!!,
            "Edit",
            12.0f,
            R.color.recycler_swipe_gray,
            object : SwipeHelper.UnderlayButtonClickListener {
                override fun onClick() {
                    val intent : Intent = Intent(requireContext(), ClaimentProfileDetailsActivity::class.java)
                    startActivity(intent)
                }
            })
    }

    private fun markAsUnreadButton(position: Int): SwipeHelper.UnderlayButton {
        return SwipeHelper.UnderlayButton(
            activity?.applicationContext!!,
            "Delete",
            12.0f,
            R.color.colorPrimaryDark,
            object : SwipeHelper.UnderlayButtonClickListener {
                override fun onClick() {


                }
            })
    }





}