package com.cloudwell.paywell.ui.registration.nidVerification

import android.graphics.Bitmap
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.cloudwell.paywell.R
import com.cloudwell.paywell.ui.registration.nidVerification.ocr.nidOCR.model.User
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_nid_front_second.*

class NIDfrontSecondActivity : AppCompatActivity() {


    private var isNID: Boolean = false
    private var isMissingPage: Boolean = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nid_front_second)


        val string = intent.extras?.getString("data")
        isNID = intent.extras?.getBoolean("isNID", false)!!
        isMissingPage = intent.extras?.getBoolean("isMissingPage", false)!!

        val nidSecondPage = intent.getParcelableExtra("nidSecondPage") as Bitmap
        nid_back_side.setImageBitmap(nidSecondPage)

        val user = Gson().fromJson(string, User::class.java)
        nid_address.text = user.address


        nid_second_next.setOnClickListener(View.OnClickListener {

        })

    }
}
