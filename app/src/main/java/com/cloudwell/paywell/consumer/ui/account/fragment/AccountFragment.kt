package com.cloudwell.paywell.consumer.ui.account.fragment

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import com.cloudwell.paywell.consumer.R
import com.cloudwell.paywell.consumer.databinding.FragmentHomeBinding
import com.cloudwell.paywell.consumer.ui.account.adapter.CoursesItem
import com.cloudwell.paywell.consumer.ui.account.adapter.SwipeHelper
import com.cloudwell.paywell.consumer.ui.account.adapter.TestAdapter
import com.cloudwell.paywell.consumer.ui.account.pendingPopupDialog.DatePickerFragment
import com.cloudwell.paywell.consumer.ui.account.pendingPopupDialog.DatepickerDialog
import com.cloudwell.paywell.consumer.ui.account.view.IaccountVIew
import com.cloudwell.paywell.consumer.ui.account.viewModel.AccountViewModel
import com.cloudwell.paywell.consumer.ui.spiltBill.fragment.SpiltBillHoastActivity
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog
import kotlinx.android.synthetic.main.fragment_home.view.*
import java.util.*
import kotlin.collections.ArrayList


class AccountFragment : Fragment(), IaccountVIew, DatePickerDialog.OnDateSetListener {

    private lateinit var homeViewModel: AccountViewModel
    private var dpd: DatePickerDialog? = null

    var calendar: Calendar? = null

    //var datePickerDialog: DatePickerDialog? = null
    var Year = 0
    var Month: Int = 0
    var Day: Int = 0

    @RequiresApi(Build.VERSION_CODES.N)
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

            val dialog: DatepickerDialog = DatepickerDialog()
            activity?.supportFragmentManager?.let { it1 ->
                dialog.show(
                    it1,
                    "ReminderDialog"
                )
            }

//            calendar = Calendar.getInstance();
//
//            var datePickerDialog: DatePickerDialog = DatePickerDialog.newInstance(AccountFragment(), Year, Month, Day);
//
//            datePickerDialog.setThemeDark(false);
//
//            datePickerDialog.showYearPickerFirst(false);
//
//            datePickerDialog.setAccentColor(Color.parseColor("#0072BA"));
//
//            datePickerDialog.setTitle("Select Date From DatePickerDialog");
//
//            datePickerDialog.show(activity?.supportFragmentManager!!, "DatePickerDialog");

            // datepicker2()
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

    }

    override fun showProgress() {
    }

    override fun hiddenProgress() {
    }

    override fun onFailure(message: String?) {
    }


    @SuppressLint("ResourceAsColor")
    fun datepicker() {
        val now = Calendar.getInstance()
        now.add(Calendar.DATE, 7)

        if (dpd == null) {

            dpd = DatePickerDialog.newInstance(
                AccountFragment(),
                now[Calendar.YEAR],
                now[Calendar.MONTH],
                now[Calendar.DAY_OF_MONTH]
            )
        } else {
            dpd!!.initialize(
                AccountFragment(),
                now[Calendar.YEAR],
                now[Calendar.MONTH],
                now[Calendar.DAY_OF_MONTH]
            )
        }
        dpd!!.setCancelColor("#00203f")
        dpd!!.setCancelText("Finished")
        dpd!!.setOkColor(R.color.transparent)
        dpd!!.vibrate(true)
        dpd!!.version =
            if (false) DatePickerDialog.Version.VERSION_2 else DatePickerDialog.Version.VERSION_1

        dpd!!.setOnCancelListener(DialogInterface.OnCancelListener { dialog: DialogInterface? ->
            Log.d("DatePickerDialog", "Dialog was cancelled")
            dpd = null
        })
        dpd!!.show(requireFragmentManager(), "Datepickerdialog")
    }

    override fun onDateSet(view: DatePickerDialog?, year: Int, monthOfYear: Int, dayOfMonth: Int) {

    }


    fun datepicker2() {

        val newFragment: DialogFragment = DatePickerFragment()
        newFragment.show(activity?.supportFragmentManager!!, "Date Picker")
    }


}
