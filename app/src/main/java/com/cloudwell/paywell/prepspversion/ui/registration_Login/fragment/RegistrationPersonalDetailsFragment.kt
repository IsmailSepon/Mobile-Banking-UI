package com.cloudwell.paywell.prepspversion.ui.registration_Login.fragment

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import com.cloudwell.paywell.base.Preference
import com.cloudwell.paywell.utils.FragmentHelper
import kotlinx.android.synthetic.main.reg_personal_details_fragment.view.*

class RegistrationPersonalDetailsFragment : Fragment() {


    var country = arrayOf("+880", "+9715", "+966", "+699", "+778")


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View =
            inflater.inflate(R.layout.reg_personal_details_fragment, container, false)


        view.pre_country_code_spinner.onItemSelectedListener
        val aa: ArrayAdapter<*> = ArrayAdapter<Any?>(requireContext(), android.R.layout.simple_spinner_item, country)
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        view.pre_country_code_spinner.adapter = aa


        view.pre_lost_access_num.setOnClickListener(View.OnClickListener {



        })


        view.pre_et_phone.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                var phone: String = view.pre_et_phone.text.toString()
                if (phone.length >= 10) {
                    view.pre_login_btn.setBackgroundResource(R.drawable.round_btn_visable)
                    view.pre_login_btn.setOnClickListener(View.OnClickListener {
                       // finish()
                        //startActivity(Intent(applicationContext, MainHomeActivity::class.java))

                        val sharePreference : Preference = Preference.getInstance(requireContext())
                        sharePreference.saveData("userMobileNumber", phone )

//                        startActivity(Intent(requireContext(),
//                                // RegistationMainActivity::class.java      UserAuthenticationHostActivity
//                            SignupPasswordActivity::class.java))
//






                        FragmentHelper.addFirstFragment(OtpCheckFegment(), requireActivity().supportFragmentManager, R.id.pre_psp_auth_container)
                    })
                } else {
                    view.pre_login_btn.setBackgroundResource(R.drawable.round_btn)
                    //et_phone.setError("Input Field!")
                }
            }
        })





        return view
    }
}