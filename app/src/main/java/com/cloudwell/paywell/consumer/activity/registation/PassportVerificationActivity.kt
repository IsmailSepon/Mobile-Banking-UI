package com.cloudwell.paywell.consumer.activity.registation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.cloudwell.paywell.consumer.R
import kotlinx.android.synthetic.main.activity_passport_verification.*

class PassportVerificationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_passport_verification)
        reg_passport_btn.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                Toast.makeText(this@PassportVerificationActivity, "Wait", Toast.LENGTH_SHORT).show()
            }

        })
    }
}
