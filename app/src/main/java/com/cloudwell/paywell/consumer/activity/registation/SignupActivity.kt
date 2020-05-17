package com.cloudwell.paywell.consumer.activity.registation

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.cloudwell.paywell.consumer.R
import com.cloudwell.paywell.consumer.ui.home.MainHomeActivity
import kotlinx.android.synthetic.main.activity_signup.*


/**
 * Created by Sepon on 4/1/2020.
 * ==============================Don't extend "BaseActivity" =================
 */

class SignupActivity : AppCompatActivity() {

    var country = arrayOf("+880", "+9715", "+966", "+699", "+778")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        country_code_spinner.onItemSelectedListener
        val aa: ArrayAdapter<*> =
            ArrayAdapter<Any?>(this, android.R.layout.simple_spinner_item, country)
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        country_code_spinner.adapter = aa

        et_phone.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(s: Editable?) {}

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            var phone : String = et_phone.text.toString()
               if (phone.length >= 4){
                   login_btn.setBackgroundResource(R.drawable.round_btn_visable)
                   login_btn.setOnClickListener(View.OnClickListener {
                       finish()
                       startActivity(Intent(applicationContext, MainHomeActivity::class.java))
                   })
               }else{
                   login_btn.setBackgroundResource(R.drawable.round_btn)
                   //et_phone.setError("Input Field!")
               }
            }
        })



    }

}
