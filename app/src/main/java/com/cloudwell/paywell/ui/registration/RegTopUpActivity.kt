package com.cloudwell.paywell.ui.registration

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.cloudwell.paywell.R
import kotlinx.android.synthetic.main.activity_reg_top_up.*

class RegTopUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reg_top_up)
        reg_top_up_btn.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {


                startActivity(Intent(this@RegTopUpActivity, RegTopUpSecondActivity::class.java))
            }

        })
    }
}
