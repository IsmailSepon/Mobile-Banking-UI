package com.cloudwell.paywell.ui.registration

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.cloudwell.paywell.R
import com.cloudwell.paywell.base.Preference
import com.cloudwell.paywell.ui.authentication.UserAuthenticationHostActivity
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
        val aa: ArrayAdapter<*> = ArrayAdapter<Any?>(this, android.R.layout.simple_spinner_item, country)
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        country_code_spinner.adapter = aa


        lost_access_num.setOnClickListener(View.OnClickListener {

            val intent = Intent(this, UserAuthenticationHostActivity::class.java)
            // intent.putExtra("lostAccess", "lostAccess")
            startActivity(intent)

        })


        et_phone.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                var phone: String = et_phone.text.toString()
                if (phone.length >= 10) {
                    login_btn.setBackgroundResource(R.drawable.round_btn_visable)
                    login_btn.setOnClickListener(View.OnClickListener {
                        finish()
                        //startActivity(Intent(applicationContext, MainHomeActivity::class.java))

                        val sharePreference : Preference = Preference.getInstance(this@SignupActivity)
                        sharePreference.saveData("userMobileNumber", phone )
                        startActivity(
                            Intent(
                                applicationContext,
                                // RegistationMainActivity::class.java      UserAuthenticationHostActivity
                                SignupPasswordActivity::class.java
                            )
                        )
                    })
                } else {
                    login_btn.setBackgroundResource(R.drawable.round_btn)
                    //et_phone.setError("Input Field!")
                }
            }
        })



    }

}
