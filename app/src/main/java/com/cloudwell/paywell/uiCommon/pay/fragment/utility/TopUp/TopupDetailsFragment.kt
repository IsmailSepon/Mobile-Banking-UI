package com.cloudwell.paywell.uiCommon.pay.fragment.utility.TopUp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import com.cloudwell.paywell.uiCommon.pay.dialog.TopupConfirmDialog
import com.cloudwell.paywell.uiCommon.pay.model.UtilityPOjo
import com.google.gson.Gson
import kotlinx.android.synthetic.main.topup_details_layout.view.*


class TopupDetailsFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.topup_details_layout, container, false)

        val pojo : String = requireArguments().getString("topup", "")
        val gson = Gson()

        val utility : UtilityPOjo = gson.fromJson(pojo, UtilityPOjo::class.java)


        view.operator_ic.setImageResource(utility.icon!!)

        Toast.makeText(requireContext(), utility.name, Toast.LENGTH_SHORT).show()


        view.offer_layout.setOnClickListener(View.OnClickListener {

            val i = Intent(activity, TopUpOfferActivity::class.java)
            //i.putExtra("helloString", "helloString")
            this.startActivityForResult(i, 1)

        })



        view.set_topup.setOnClickListener(View.OnClickListener {


            val dialog: TopupConfirmDialog = TopupConfirmDialog()
            dialog.show(activity?.supportFragmentManager!!, "TopupConfirmDialog")

        })



        return view
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == 111) {



        }
    }


}
