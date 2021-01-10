package com.cloudwell.paywell.ui.vaults.dialog

import android.os.Bundle
import android.view.*
import androidx.fragment.app.DialogFragment
import com.cloudwell.paywell.R
import com.cloudwell.paywell.base.BaseDialog
import com.cloudwell.paywell.ui.vaults.fragment.bottomsheet.VaultBottomSheetFragment
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.schedule_select_contact_layout.view.*
import kotlinx.android.synthetic.main.vault_bottom_sheet_layout.*
import kotlinx.android.synthetic.main.vault_bottom_sheet_layout.view.*
import kotlinx.android.synthetic.main.vault_repeat_dialog.view.*


class VaultRepeatDialog : BaseDialog() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = layoutInflater.inflate(R.layout.vault_repeat_dialog, null)
        this.dialog?.setCanceledOnTouchOutside(true)

        val day = view.vault_everyday
        val week = view.vault_everyweek
        val month = view.vault_everymonth

        val day_layout = view.vault_everyday_lay
        val week_layout = view.vault_everyweek_lay
        val month_layout = view.vault_everymonth_lay

        val daySelected = view.vault_everyday_selected
        val weekSelected = view.vault_everyweek_selected
        val monthSelected = view.vault_everymonth_selected


        day_layout.setOnClickListener(View.OnClickListener {
            day.setTextColor(resources.getColor(R.color.text_link_clr))
            week.setTextColor(resources.getColor(R.color.keypad_text_clr))
            month.setTextColor(resources.getColor(R.color.keypad_text_clr))


            daySelected.visibility = View.VISIBLE
            weekSelected.visibility = View.INVISIBLE
            monthSelected.visibility = View.INVISIBLE


            dismiss()
            showBottomSheet()

        })
        week_layout.setOnClickListener(View.OnClickListener {
            day.setTextColor(resources.getColor(R.color.keypad_text_clr))
            week.setTextColor(resources.getColor(R.color.text_link_clr))
            month.setTextColor(resources.getColor(R.color.keypad_text_clr))

            daySelected.visibility = View.INVISIBLE
            weekSelected.visibility = View.VISIBLE
            monthSelected.visibility = View.INVISIBLE

            dismiss()
            showBottomSheet()

        })
        month_layout.setOnClickListener(View.OnClickListener {
            day.setTextColor(resources.getColor(R.color.keypad_text_clr))
            week.setTextColor(resources.getColor(R.color.keypad_text_clr))
            month.setTextColor(resources.getColor(R.color.text_link_clr))

            daySelected.visibility = View.INVISIBLE
            weekSelected.visibility = View.INVISIBLE
            monthSelected.visibility = View.VISIBLE

            dismiss()
            showBottomSheet()

        })

        return view
    }


    private fun showBottomSheet() {

//        val view: View = layoutInflater.inflate(R.layout.vault_bottom_sheet_layout, null)
//
//        val dialog = BottomSheetDialog(requireContext())
//        dialog.setContentView(view)
//        dialog.vault_bottomsheet_btn.setOnClickListener(View.OnClickListener {
//            dialog.dismiss()
//        })
//        dialog.show()

            val bottomsheer = VaultBottomSheetFragment()
            bottomsheer.show(
                requireActivity().supportFragmentManager, bottomsheer.tag
            )


    }


}