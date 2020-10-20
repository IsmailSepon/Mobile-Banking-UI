package com.cloudwell.paywell.uiCommon.pay.fragment.utility.electricity.polliBiddut

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import com.cloudwell.paywell.uiCommon.pay.dialog.PolliConfirmDialog
import com.cloudwell.paywell.uiCommon.pay.model.UtilityPOjo
import com.google.gson.Gson
import kotlinx.android.synthetic.main.polli_details_layout.view.*


class PolliDetailsFragment : Fragment() {


    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.polli_details_layout, container, false)

        val pojo : String = requireArguments().getString("electronics", "")
        val gson = Gson()

        val utility : UtilityPOjo = gson.fromJson(pojo, UtilityPOjo::class.java)


        view.polli_details.text = "Your "+utility.name+" bill details"
        view.polli_operator_ic.setImageResource(utility.icon!!)

        view.polli_electricity.setOnClickListener(View.OnClickListener {

            val json = gson.toJson(utility)
            val bundle  = Bundle()
            bundle.putString("electronics", json)
            val dialog: PolliConfirmDialog = PolliConfirmDialog()
            dialog.arguments = bundle
            dialog.show(activity?.supportFragmentManager!!, "PolliConfirmDialog")

        })



        return view
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == 111) {



        }
    }


}
