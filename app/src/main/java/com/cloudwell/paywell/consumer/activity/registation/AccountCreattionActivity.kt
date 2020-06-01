package com.cloudwell.paywell.consumer.activity.registation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.cloudwell.paywell.consumer.R
import kotlinx.android.synthetic.main.activity_account_creattion.*
import kotlinx.android.synthetic.main.activity_email_verification.*

class AccountCreattionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account_creattion)


        ac_created_btn.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {


                startActivity(Intent(this@AccountCreattionActivity, RegTopUpActivity::class.java))
            }

        })
    }
}
