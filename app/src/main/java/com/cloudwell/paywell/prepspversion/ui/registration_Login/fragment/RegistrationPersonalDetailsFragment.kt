package com.cloudwell.paywell.prepspversion.ui.registration_Login.fragment

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.cloudwell.paywell.R
import com.cloudwell.paywell.databinding.RegPersonalDetailsFragmentBinding
import com.cloudwell.paywell.prepspversion.ui.registration_Login.factory.AuthViewModelFactory
import com.cloudwell.paywell.prepspversion.ui.registration_Login.model.DeviceProfile
import com.cloudwell.paywell.prepspversion.ui.registration_Login.model.RegistrationRequest
import com.cloudwell.paywell.prepspversion.ui.registration_Login.model.TokenResponse
import com.cloudwell.paywell.prepspversion.ui.registration_Login.model.User
import com.cloudwell.paywell.prepspversion.ui.registration_Login.viewmodel.AuthViewModel
import com.cloudwell.paywell.retrofit.ApiUtils
import com.cloudwell.paywell.utils.FragmentHelper
import kotlinx.android.synthetic.main.activity_finger_auth.*
import kotlinx.android.synthetic.main.reg_personal_details_fragment.view.*
import kotlinx.coroutines.launch
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein
import org.kodein.di.generic.instance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegistrationPersonalDetailsFragment : Fragment() , KodeinAware {

    override val kodein by kodein()
    private val factory : AuthViewModelFactory by  instance()

    var country = arrayOf("+880", "+9715", "+966", "+699", "+778")
    var name : String? = null
    var number : String? = null
    var countryCode : String? = null
    var dateofbirth : String? = null





    private lateinit var binding: RegPersonalDetailsFragmentBinding
    private lateinit var viewmodel: AuthViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.reg_personal_details_fragment, container, false)
        viewmodel = ViewModelProvider(this, factory).get(AuthViewModel::class.java)



        initilizeViews(binding.root)

        return binding.root
    }



    private fun userSignup() {
        val name = binding.root.fullname.text.toString().trim()
        val number = binding.root.pre_et_phone.text.toString().trim()
        val dateofbirth = binding.root.date_of_birth.text.toString().trim()

        val reg = RegistrationRequest()
        val profile = DeviceProfile()
        profile.androidId = "test Sepon by API"
        profile.deviceName = "test Sepon by API"
        profile.apiLevel = "test Sepon by API"
        profile.osName = "test Sepon by API"
        profile.refId = "test Sepon by API"
        profile.model = "test Sepon by API"
        profile.appVersionNo = "test Sepon by API"

        val user = User()
        user.password = "12345"
        user.username = name

        reg.deviceProfile = profile
        reg.user = user


//        ApiUtils.getConsumerAPI().userRegister(reg).enqueue(object : Callback<ResponseBody>{
//            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
//
//
//                if ( response.isSuccessful ){
//                    Toast.makeText(requireContext(), response.body().toString(), Toast.LENGTH_SHORT).show()
//                }else{
//
//                    Toast.makeText(requireContext(), "Not Success!"+response.code() + " / "+ response.body(), Toast.LENGTH_SHORT).show()
//                }
//
//            }
//
//            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
//
//            }
//        })

        val user1 = User()
        user1.password = "cloudwell"
        user1.username = "faizshiraji"
//
        ApiUtils.getConsumerAPI().userToken(user1).enqueue(object : Callback<TokenResponse> {
            override fun onResponse(call: Call<TokenResponse>, response: Response<TokenResponse>) {

                if ( response.isSuccessful ){
                    Toast.makeText(requireContext(), response.body()?.jwttoken.toString(), Toast.LENGTH_SHORT).show()
                }else{

                    Toast.makeText(requireContext(), "Not Success!"+response.code() + " / "+ response.body(), Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<TokenResponse>, t: Throwable) {
                Toast.makeText(requireContext(), t.message.toString(), Toast.LENGTH_SHORT).show()
                Log.e("Error", t.message)
            }
        })




//        lifecycleScope.launch {
//            try {
//                val authResponse = viewmodel.userSignup(reg)
//                Log.e("response", authResponse.toString())
//                Toast.makeText(requireContext(), authResponse.toString(), Toast.LENGTH_SHORT).show()
//
////                if (authResponse.isSuccessful == true) {
////                    //viewmodel.saveLoggedInUser(authResponse.user)
////                    FragmentHelper.addFirstFragment(OtpCheckFegment(), requireActivity().supportFragmentManager, R.id.pre_psp_auth_container)
////                } else {
////                //    binding.root.snackbar(authResponse.message!!)
////                }
//            } catch (e: ApiException) {
//                e.printStackTrace()
//            } catch (e: NoInternetException) {
//                e.printStackTrace()
//            }catch (e : Exception){
//                Log.e("ecxception", e.toString())
//            }
//        }


        lifecycleScope.launch {
            try {

                val token = viewmodel.getRegToken(user1)
                Log.e("API TOKEN", token.jwttoken)
                Toast.makeText(requireContext(), token.jwttoken.toString(), Toast.LENGTH_SHORT).show()

            }catch (e : Exception){


            }
        }

    }



    private fun initilizeViews(view: View) {
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

                } else {
                    view.pre_login_btn.setBackgroundResource(R.drawable.round_btn)
                    //et_phone.setError("Input Field!")
                }
            }
        })



        view.pre_login_btn.setOnClickListener(View.OnClickListener {

//
            val name = binding.root.fullname.text.toString().trim()
            val number = binding.root.pre_et_phone.text.toString().trim()

            if(name.isEmpty()){
                binding.root.fullname.setError("required")
            }else if (number.isEmpty()){
                binding.root.pre_et_phone.setError("required")
            }else{
                val bundle = Bundle()
                bundle.putString("userName", name)
                bundle.putString("userNumber", number)
                val addressFrg = AddressFregment()
                addressFrg.setArguments(bundle)

                FragmentHelper.addFirstFragment(addressFrg, requireActivity().supportFragmentManager, R.id.pre_psp_auth_container)

            }





        //    userSignup()



        })




    }
}