package com.cloudwell.paywell.consumer.ui.home.ui.account

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.cloudwell.paywell.consumer.R
import com.cloudwell.paywell.consumer.databinding.FragmentHomeBinding


class AccountFragment : Fragment() {

    private lateinit var homeViewModel: AccountViewModel


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel = ViewModelProviders.of(this).get(AccountViewModel::class.java)
        val binding: FragmentHomeBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        // val viewmodel = ViewModelProviders.of(this).get(AccountViewModel::class.java)
        binding.viewmode = homeViewModel
        binding.lifecycleOwner = this

//        val btn : Button = root.findViewById(R.id.homeBtnTopup)
//       // val btn_doc : Button = root.findViewById(R.id.homeBtnUtility)
//        btn.setOnClickListener(View.OnClickListener {
//            startActivity(Intent(activity, RegistationMainActivity::class.java))
//        })
////        btn_doc.setOnClickListener(View.OnClickListener {
////            startActivity(Intent(activity, DocumentSubmitActivity::class.java))
////        })
//
//        image = root.findViewById(R.id.image);
//        context?.let {
//            Glide
//                .with(it)
//                .load("https://api.paywellonline.com/retailerPromotionImage/Banner_Bus.9.png")
//                .into(image!!)
//        }
//
//        imageUrl.add("https://api.paywellonline.com/retailerPromotionImage/Banner_Bus.9.png")
//        val textView: TextView = root.findViewById(R.id.text_home)
//        homeViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })

//        viewPager = root.findViewById(R.id.view_pager_auto)
//        viewPager?.setAdapter(MainSliderAdapter(imageUrl))

//        homeBtnTopup.setOnClickListener(View.OnClickListener {
//            startActivity(Intent(activity, RegistationMainActivity::class.java))
//        })


        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }
}
