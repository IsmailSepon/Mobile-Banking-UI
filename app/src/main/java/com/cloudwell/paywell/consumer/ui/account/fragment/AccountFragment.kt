package com.cloudwell.paywell.consumer.ui.account.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import com.cloudwell.paywell.consumer.R
import com.cloudwell.paywell.consumer.databinding.FragmentHomeBinding
import com.cloudwell.paywell.consumer.ui.account.adapter.CoursesItem
import com.cloudwell.paywell.consumer.ui.account.adapter.SwipeHelper
import com.cloudwell.paywell.consumer.ui.account.adapter.TestAdapter
import com.cloudwell.paywell.consumer.ui.account.pendingPopupDialog.RequestProfileDialog
import com.cloudwell.paywell.consumer.ui.account.view.IaccountVIew
import com.cloudwell.paywell.consumer.ui.account.viewModel.AccountViewModel
import com.cloudwell.paywell.consumer.ui.spiltBill.fragment.SpiltBillHoastActivity
import kotlinx.android.synthetic.main.fragment_home.view.*


class AccountFragment : Fragment(), IaccountVIew {

    private lateinit var homeViewModel: AccountViewModel


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel = ViewModelProviders.of(this).get(AccountViewModel::class.java)
        val binding: FragmentHomeBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        // val viewmodel = ViewModelProviders.of(this).get(AccountViewModel::class.java)
        binding.viewmode = homeViewModel
        binding.lifecycleOwner = this

        binding.root.pendding_req.setOnClickListener(View.OnClickListener {
            Toast.makeText(activity?.applicationContext, "click", Toast.LENGTH_LONG).show()
            val dialog: RequestProfileDialog = RequestProfileDialog()
            activity?.supportFragmentManager?.let { it1 ->
                dialog.show(
                    it1,
                    "RequestProfileDialog"
                )
            }

        })

        val linearLayoutManager: LinearLayoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        binding.root.spilt_bill_recyclerview.layoutManager = linearLayoutManager
        val item = CoursesItem()
        item.amount = "300"
        var list = ArrayList<CoursesItem>()
        list.add(item)
        binding.root.spilt_bill_recyclerview.adapter =
            TestAdapter(activity?.applicationContext, list)

        val itemTouchHelper =
            ItemTouchHelper(object : SwipeHelper(binding.root.spilt_bill_recyclerview) {
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

        itemTouchHelper.attachToRecyclerView(binding.root.spilt_bill_recyclerview)

        return binding.root
    }


    private fun deleteButton(position: Int): SwipeHelper.UnderlayButton {
        return SwipeHelper.UnderlayButton(
            activity?.applicationContext!!,
            "Hide",
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
            "Split bill",
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

    override fun startAccountPopupDialog() {
//        Toast.makeText(activity?.applicationContext, "click", Toast.LENGTH_LONG).show()
//        val dialog: RequestProfileDialog = RequestProfileDialog()
//        activity?.supportFragmentManager?.let { it1 -> dialog.show(it1, "RequestProfileDialog") }

    }


    override fun noInternetConnectionFound() {
        TODO("Not yet implemented")
    }

    override fun showProgress() {
        TODO("Not yet implemented")
    }

    override fun hiddenProgress() {
        TODO("Not yet implemented")
    }

    override fun onFailure(message: String?) {
        TODO("Not yet implemented")
    }

}
