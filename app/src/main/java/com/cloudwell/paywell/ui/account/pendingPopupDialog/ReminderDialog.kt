package com.cloudwell.paywell.ui.account.pendingPopupDialog

import android.app.DatePickerDialog
import android.app.Dialog
import android.app.TimePickerDialog
import android.app.TimePickerDialog.OnTimeSetListener
import android.content.DialogInterface
import android.content.DialogInterface.OnShowListener
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.cloudwell.paywell.R
import com.cloudwell.paywell.base.BaseDialog
import kotlinx.android.synthetic.main.reminder_dialog.view.*
import java.text.SimpleDateFormat
import java.util.*


class ReminderDialog : BaseDialog() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = layoutInflater.inflate(R.layout.reminder_dialog, null)



        view.date_pick_btn.setOnClickListener(View.OnClickListener {

            datepicker()

        })

        view.time_pick_btn.setOnClickListener(View.OnClickListener {
            timepicker()
        })


        return view
    }

    fun datepicker() {

        val calendar = Calendar.getInstance()
        val datePickerDialog = DatePickerDialog(
            requireActivity(), R.style.DatePickerDialogTheme,
            DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
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
        datePickerDialog.setButton(
            DialogInterface.BUTTON_POSITIVE,
            "Finished"
        ) { dialog, which ->
            //Your code
        }
        datePickerDialog.setOnShowListener(OnShowListener { // This is hiding the "Cancel" button:
            datePickerDialog.getButton(Dialog.BUTTON_NEGATIVE).visibility = View.GONE
        })
        datePickerDialog.show()

    }


    fun timepicker() {

        val mcurrentTime = Calendar.getInstance()
        val hour = mcurrentTime[Calendar.HOUR_OF_DAY]
        val minute = mcurrentTime[Calendar.MINUTE]
        val mTimePicker: TimePickerDialog
        mTimePicker = TimePickerDialog(
            requireActivity(), R.style.DatePickerDialogTheme,
            OnTimeSetListener { timePicker, selectedHour, selectedMinute ->
                // eReminderTime.setText("$selectedHour:$selectedMinute")
            },
            hour,
            minute,
            false
        ) //Yes 24 hour time
        mTimePicker.setButton(
            DialogInterface.BUTTON_POSITIVE,
            "Finished"
        ) { dialog, which ->
            //Your code
        }
        mTimePicker.setOnShowListener(OnShowListener { // This is hiding the "Cancel" button:
            mTimePicker.getButton(Dialog.BUTTON_NEGATIVE).visibility = View.GONE
        })
        mTimePicker.show()

    }


}