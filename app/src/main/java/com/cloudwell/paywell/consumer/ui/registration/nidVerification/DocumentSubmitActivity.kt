package com.cloudwell.paywell.consumer.ui.registration.nidVerification

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.cloudwell.paywell.consumer.R
import kotlinx.android.synthetic.main.activity_document_submit.*

class DocumentSubmitActivity : AppCompatActivity() {

    var country = arrayOf("India", "USA", "China", "Japan", "Other")
    var doc = arrayOf("Select Document","Passport", "Visa", "Invitation")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_document_submit)


        val aa: ArrayAdapter<*> = ArrayAdapter<Any?>(this, android.R.layout.simple_spinner_item, country)
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        country_spinner.adapter = aa


        val aa2: ArrayAdapter<*> = ArrayAdapter<Any?>(this, android.R.layout.simple_spinner_item, doc)
        aa2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        document_spinner.adapter = aa2


        document_spinner?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                if (position != 0){
                    continue_btn.setBackgroundResource(R.drawable.round_btn_visable)
                    continue_btn.setOnClickListener(View.OnClickListener {

                        startActivity(Intent(this@DocumentSubmitActivity, NIDfrontsideActivity::class.java))
                    })
                }

            }

        }
    }
}
