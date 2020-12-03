package com.cloudwell.paywell.ui.account.fragment

import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import com.cloudwell.paywell.R
import com.cloudwell.paywell.databinding.FragmentHomeBinding
import com.cloudwell.paywell.ui.account.adapter.CoursesItem
import com.cloudwell.paywell.ui.account.adapter.SwipeHelper
import com.cloudwell.paywell.ui.account.adapter.TestAdapter
import com.cloudwell.paywell.ui.account.pendingPopupDialog.RequestProfileDialog
import com.cloudwell.paywell.ui.account.view.IaccountVIew
import com.cloudwell.paywell.ui.account.viewModel.AccountViewModel
import com.cloudwell.paywell.ui.spiltBill.fragment.SpiltBillHoastActivity
import kotlinx.android.synthetic.main.fragment_home.view.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList


class AccountFragment : Fragment(), IaccountVIew, DatePickerDialog.OnDateSetListener {

    private lateinit var homeViewModel: AccountViewModel
    val DATEPICKER_TAG = "datepicker"

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel = ViewModelProviders.of(this).get(AccountViewModel::class.java)
        val binding: FragmentHomeBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
//         val viewmodel = ViewModelProviders.of(this).get(AccountViewModel::class.java)
        binding.viewmode = homeViewModel
        binding.lifecycleOwner = this

//
//        val dialog: SendFundlDialog = SendFundlDialog()
//        dialog.show(activity?.supportFragmentManager!!, "SendFundlDialog")


        binding.root.pendding_req.setOnClickListener(View.OnClickListener {

            pendindProfilePopup()
        })

        val linearLayoutManager: LinearLayoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        binding.root.spilt_bill_recyclerview.layoutManager = linearLayoutManager

        binding.root.spilt_bill_recyclerview.setHasFixedSize(false)
        val item = CoursesItem()
        item.amount = "300"
        var list = ArrayList<CoursesItem>()
        list.add(item)
        binding.root.spilt_bill_recyclerview.adapter = TestAdapter(activity?.applicationContext, list)

        val itemTouchHelper = ItemTouchHelper(object : SwipeHelper(binding.root.spilt_bill_recyclerview) {
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

    private fun showCustomDatepicker() {
// for use this add liberary+ Ondateset below
//        val calendar = Calendar.getInstance()
//        val datePickerDialog =
//            com.oginotihiro.datepicker.DatePickerDialog.newInstance(
//                this,
//                calendar[Calendar.YEAR],
//                calendar[Calendar.MONTH],
//                calendar[Calendar.DAY_OF_MONTH]
//            )
//        datePickerDialog.setVibrate(false)
//        datePickerDialog.setYearRange(1990, 2020)
//        datePickerDialog.setCloseOnSingleTapDay(true)
//
//        datePickerDialog.setColor(R.color.keypad_text_clr);
//        datePickerDialog.setDarkColor(R.color.colorPrimary);
//
//        datePickerDialog.show(
//            activity?.supportFragmentManager!!,
//            DATEPICKER_TAG
//        )
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

    }

    override fun showProgress() {
    }

    override fun hiddenProgress() {
    }

    override fun onFailure(message: String?) {
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {

    }


    fun datepicker() {

        val calendar = Calendar.getInstance()
        val datePickerDialog = DatePickerDialog(
            requireActivity(),
            R.style.DatePickerDialogTheme,
            OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                val newDate = Calendar.getInstance()
                newDate[year, monthOfYear] = dayOfMonth
                val simpleDateFormat =
                    SimpleDateFormat("dd-MM-yyyy")
                val date = simpleDateFormat.format(newDate.time)
                Toast.makeText(activity?.applicationContext, date + "", Toast.LENGTH_LONG).show()
            },
            calendar[Calendar.YEAR],
            calendar[Calendar.MONTH],
            calendar[Calendar.DAY_OF_MONTH]
        )
        datePickerDialog.show()

    }

    fun pendindProfilePopup() {

        val newFragment: DialogFragment = RequestProfileDialog()
        newFragment.show(activity?.supportFragmentManager!!, "Date Picker")


    }


}
