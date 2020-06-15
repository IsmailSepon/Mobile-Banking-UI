package com.cloudwell.paywell.consumer.ui.registration

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.cloudwell.paywell.consumer.R
import kotlinx.android.synthetic.main.activity_account_creattion.*

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
