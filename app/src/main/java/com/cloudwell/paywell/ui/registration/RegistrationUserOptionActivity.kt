package com.cloudwell.paywell.ui.registration

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.cloudwell.paywell.R
import kotlinx.android.synthetic.main.activity_registration_user_option.*

class RegistrationUserOptionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration_user_option)


        personal_layout.setOnClickListener(View.OnClickListener {
            finish()
            //startActivity(Intent(applicationContext, MainHomeActivity::class.java))
            startActivity(
                Intent(applicationContext, RegistationMainActivity::class.java)
            )
        })


    }
}