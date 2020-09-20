package com.cloudwell.paywell.uiBusiness.cards.fragment.marchentOwner

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import com.cloudwell.paywell.utils.FragmentHelper
import kotlinx.android.synthetic.main.marchent_create_link_preview_layout.view.*


class MarchentCreatLinkPreviewFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.marchent_create_link_preview_layout, container, false)


        view.copy_link.setOnClickListener(View.OnClickListener {
            Toast.makeText(requireContext(), "Copied!", Toast.LENGTH_SHORT).show()

            FragmentHelper.replaceFragment(
                MarchentPaymentRequestFragment(),
                requireActivity().supportFragmentManager,
                R.id.bu_Cards_container
            )

        })



        view.share_link.setOnClickListener(View.OnClickListener {
            shareMenu()
        })

        return view
    }


    fun shareMenu(){
        val sharingIntent = Intent(Intent.ACTION_SEND)
        sharingIntent.type = "text/plain"
        val shareBody = "Here is the share content body"
        sharingIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject Here")
        sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody)
        startActivity(Intent.createChooser(sharingIntent, "Share via"))
    }

}
