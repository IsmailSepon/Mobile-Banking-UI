package com.cloudwell.paywell.ui.registration

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.cloudwell.paywell.R
import kotlinx.android.synthetic.main.activity_email_verification.*

class EmailVerificationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_email_verification)


        email_verification_btn.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {


                startActivity(Intent(this@EmailVerificationActivity, AccountCreattionActivity::class.java))
            }

        })
    }
}
