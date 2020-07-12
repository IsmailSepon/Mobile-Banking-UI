package com.cloudwell.paywell.ui.registration.nidVerification

import android.content.Intent
import android.graphics.Bitmap
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.cloudwell.paywell.R
import com.cloudwell.paywell.ui.registration.nidVerification.ocr.nidOCR.model.User
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_n_i_dfrontside.*


class NIDfrontsideActivity : AppCompatActivity() {


    private var isNID: Boolean = false
    private var isMissingPage: Boolean = false

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_n_i_dfrontside)

//        assert(supportActionBar != null)
//        if (supportActionBar != null) {
//            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
//            val spannablerTitle = SpannableString("NID front side")
//            spannablerTitle.setSpan(
//                ForegroundColorSpan(applicationContext.getColor(R.color.white)),
//                0,
//                spannablerTitle.length,
//                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
//            )
//            supportActionBar!!.title = spannablerTitle
//        }
//      //  getApplicationContext().getResources().getColor(R.color.white)


        val string = intent.extras?.getString("data")
        isNID = intent.extras?.getBoolean("isNID", false)!!
        isMissingPage = intent.extras?.getBoolean("isMissingPage", false)!!
        val nidFirstPage = intent.getParcelableExtra("nidFirstPage") as Bitmap
        val nidSecondPage = intent.getParcelableExtra("nidSecondPage") as Bitmap

        nid_first_side.setImageBitmap(nidFirstPage)

        val user = Gson().fromJson(string, User::class.java)
        nid_id_number.text = user.nid
        nid_name.text = user.name
        nid_father_name.text = user.fatherName
        nid_mother_name.text = user.motherName
        nid_birthday_date.text = user.birthday
        // etUserAddress.setText(user.address)

        next_side.setOnClickListener(View.OnClickListener {
            val intent = Intent(applicationContext, NIDfrontSecondActivity::class.java)
            intent.putExtra("data", Gson().toJson(user))
            intent.putExtra("isNID", isNID)
            intent.putExtra("isMissingPage", isMissingPage)
            intent.putExtra("nidSecondPage", nidSecondPage)
            startActivity(intent)

            // startActivity(Intent(this, NIDfrontSecondActivity::class.java))
        })
    }

}
