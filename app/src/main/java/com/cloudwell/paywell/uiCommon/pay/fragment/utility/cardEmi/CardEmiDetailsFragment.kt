package com.cloudwell.paywell.uiCommon.pay.fragment.utility.cardEmi

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import com.cloudwell.paywell.uiCommon.pay.dialog.CardEmiConfirmDialog
import kotlinx.android.synthetic.main.card_emi_details_layout.view.*


class CardEmiDetailsFragment : Fragment() {


    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.card_emi_details_layout, container, false)

//        val pojo : String = requireArguments().getString("water", "")
//        val gson = Gson()
//
//        val utility : UtilityPOjo = gson.fromJson(pojo, UtilityPOjo::class.java)
//
//
//        view.water_details.text = "Your "+utility.name+" bill details"
//
//        view.operator_ic.setImageResource(utility.icon!!)




        val country = arrayOf("Issuer bank name","Dutch Bangla Bank")
        val sp : Spinner = view.banklist_sp
        sp.onItemSelectedListener
        val aa: ArrayAdapter<*> = ArrayAdapter<Any?>(requireContext(), R.layout.spinner_item, country)
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        sp.adapter = aa
        sp.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            }
        }

//
//
//        val country1 = arrayOf("2020", "2019")
//        val sp1 : Spinner = view.year_sp
//        sp.onItemSelectedListener
//        val aa1: ArrayAdapter<*> = ArrayAdapter<Any?>(requireContext(), R.layout.spinner_item, country1)
//        aa1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
//        sp1.adapter = aa1
//        sp1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
//            override fun onNothingSelected(parent: AdapterView<*>?) {
//            }
//            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
//            }
//        }


        view.set_card_emi.setOnClickListener(View.OnClickListener {


            val dialog: CardEmiConfirmDialog = CardEmiConfirmDialog()
            dialog.show(activity?.supportFragmentManager!!, "CardEmiConfirmDialog")

        })



        return view
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == 111) {



        }
    }


}
