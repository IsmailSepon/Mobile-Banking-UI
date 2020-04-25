package com.cloudwell.paywell.consumer.activity.home.ui.account

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.cloudwell.paywell.consumer.R
import com.cloudwell.paywell.consumer.activity.registation.NID_verification.DocumentSubmitActivity
import com.cloudwell.paywell.consumer.activity.registation.RegistationMainActivity
import kotlinx.android.synthetic.main.fragment_home.*
import ss.com.bannerslider.Slider

class AccountFragment : Fragment() {

    private lateinit var homeViewModel: AccountViewModel
    val imageUrl: ArrayList<String> = ArrayList()
    lateinit var adapter : MainSliderAdapter
    private var viewPager: Slider? = null
var image : ImageView? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProviders.of(this).get(AccountViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)

        val btn : Button = root.findViewById(R.id.homeBtnTopup)
        val btn_doc : Button = root.findViewById(R.id.homeBtnUtility)
        btn.setOnClickListener(View.OnClickListener {
            startActivity(Intent(activity, RegistationMainActivity::class.java))
        })
        btn_doc.setOnClickListener(View.OnClickListener {
            startActivity(Intent(activity, DocumentSubmitActivity::class.java))
        })

        image = root.findViewById(R.id.image);
        context?.let {
            Glide
                .with(it)
                .load("https://api.paywellonline.com/retailerPromotionImage/Banner_Bus.9.png")
                .into(image!!)
        }

        imageUrl.add("https://api.paywellonline.com/retailerPromotionImage/Banner_Bus.9.png")
//        val textView: TextView = root.findViewById(R.id.text_home)
//        homeViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })

//        viewPager = root.findViewById(R.id.view_pager_auto)
//        viewPager?.setAdapter(MainSliderAdapter(imageUrl))

//        homeBtnTopup.setOnClickListener(View.OnClickListener {
//            startActivity(Intent(activity, RegistationMainActivity::class.java))
//        })

        return root
    }
}
