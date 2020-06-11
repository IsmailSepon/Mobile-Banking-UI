package com.cloudwell.paywell.consumer.ui.account.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
import com.cloudwell.paywell.consumer.ui.account.viewModel.AccountViewModel
import com.cloudwell.paywell.consumer.ui.spiltBill.fragment.SpiltBillHoastActivity
import kotlinx.android.synthetic.main.fragment_home.view.*


class AccountFragment : Fragment() {

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

//        val btn : Button = root.findViewById(R.id.homeBtnTopup)
//       // val btn_doc : Button = root.findViewById(R.id.homeBtnUtility)
//        btn.setOnClickListener(View.OnClickListener {
//            startActivity(Intent(activity, RegistationMainActivity::class.java))
//        })
////        btn_doc.setOnClickListener(View.OnClickListener {
////            startActivity(Intent(activity, DocumentSubmitActivity::class.java))
////        })
//
//        image = root.findViewById(R.id.image);
//        context?.let {
//            Glide
//                .with(it)
//                .load("https://api.paywellonline.com/retailerPromotionImage/Banner_Bus.9.png")
//                .into(image!!)
//        }
//
//        imageUrl.add("https://api.paywellonline.com/retailerPromotionImage/Banner_Bus.9.png")
//        val textView: TextView = root.findViewById(R.id.text_home)
//        homeViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })

//        viewPager = root.findViewById(R.id.view_pager_auto)
//        viewPager?.setAdapter(MainSliderAdapter(imageUrl))

//        homeBtnTopup.setOnClickListener(View.OnClickListener {
//            startActivity(Intent(activity, RegistationMainActivity::class.java))
//        })

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
            android.R.color.holo_red_light,
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
            android.R.color.holo_green_light,
            object : SwipeHelper.UnderlayButtonClickListener {
                override fun onClick() {

                    val intent = Intent(activity, SpiltBillHoastActivity::class.java)
                    intent.putExtra("spilt", "1")
                    startActivity(intent)
                }
            })
    }

}
