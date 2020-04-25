package com.cloudwell.paywell.consumer.activity.registation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import com.cloudwell.paywell.consumer.R
import kotlinx.android.synthetic.main.activity_reg_top_up_second.*

class RegTopUpSecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reg_top_up_second)

        amount_et.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(s: Editable?) {
             if (amount_et.text.length == 3){
                 reg_second_topup_btn.setBackgroundResource(R.drawable.round_btn_visable);
                 reg_second_topup_btn.setOnClickListener(object : View.OnClickListener{
                     override fun onClick(v: View?) {
                         startActivity(Intent(this@RegTopUpSecondActivity, PassportVerificationActivity::class.java))
                     }

                 })
             }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
        })


    }
}
