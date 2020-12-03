package com.cloudwell.paywell.ui.vaults.fragment

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.cloudwell.paywell.R
import com.cloudwell.paywell.ui.vaults.activity.VaultAddActivity
import com.cloudwell.paywell.ui.vaults.adapter.VaultAdapter
import com.cloudwell.paywell.ui.vaults.vaultPOjo.VaulttPojo
import com.cloudwell.paywell.utils.FragmentHelper
import com.yanzhenjie.recyclerview.*
import kotlinx.android.synthetic.main.fragment_home.view.*
import kotlinx.android.synthetic.main.vault_main_layout.view.*

class VaultViewFragment : Fragment() {


    private val data: ArrayList<String> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.vault_main_layout, container, false)



        var   vaultRecycler : SwipeRecyclerView = view.vault_recycler



        setVaultRecycler(view, vaultRecycler)




        view.add_vault_lay.setOnClickListener(View.OnClickListener {

            //  requireContext().startActivity(Intent(requireContext(), VaultAddActivity::class.java))
            val intent : Intent = Intent(requireContext(), VaultAddActivity::class.java)
            intent.putExtra("vaultMenu", 0)
            requireContext().startActivity(intent)
        })




        return view
    }


    private fun setVaultRecycler(view: View?, vaultRecycler: SwipeRecyclerView) {

        val linearLayoutManager: LinearLayoutManager = LinearLayoutManager(
            activity,
            LinearLayoutManager.VERTICAL,
            false
        )
        vaultRecycler.layoutManager = linearLayoutManager

        var pojo = VaulttPojo()
        pojo.name = "Savings"
        pojo.cost = "of ৳ 20,000"
        pojo.costAmount = "৳ 6,500"


        var pojo1 = VaulttPojo()
        pojo1.name = "India Trip"
        pojo1.cost = "of ৳ 20,000"
        pojo1.costAmount = "৳ 6,500"


        var list = ArrayList<VaulttPojo>()
        list.add(pojo)
        list.add(pojo1)

        vaultRecycler.setSwipeMenuCreator(swipeMenuCreator)
        vaultRecycler.setOnItemMenuClickListener(mMenuItemClickListener)
        vaultRecycler.adapter = VaultAdapter(requireContext(), list)



    }


    private val swipeMenuCreator: SwipeMenuCreator = object : SwipeMenuCreator {
        override fun onCreateMenu(
            swipeLeftMenu: SwipeMenu,
            swipeRightMenu: SwipeMenu,
            position: Int
        ) {
            val width = resources.getDimensionPixelSize(R.dimen._65dp)
            val height = ViewGroup.LayoutParams.MATCH_PARENT
            run {
                val addItem: SwipeMenuItem = SwipeMenuItem(requireContext()).setBackground(R.color.colorPrimaryDark)
                        .setImage(R.drawable.cross_white)
                        .setText("Close")
                        .setTextColor(Color.WHITE)
                        .setWidth(width)
                        .setHeight(height)
                swipeRightMenu.addMenuItem(addItem)
                val closeItem: SwipeMenuItem = SwipeMenuItem(requireContext()).setBackground(R.color.keypad_text_clr)
                        .setImage(R.drawable.add_wbite)
                        .setText("Fund")
                        .setTextColor(Color.WHITE)
                        .setWidth(width)
                        .setHeight(height)
                swipeRightMenu.addMenuItem(closeItem)
            }


        }
    }


    private val mMenuItemClickListener =
        OnItemMenuClickListener { menuBridge, position ->
            menuBridge.closeMenu()
            val direction = menuBridge.direction
            val menuPosition = menuBridge.position
            if (direction == SwipeRecyclerView.RIGHT_DIRECTION) {

                if (menuPosition == 0){
                    Toast.makeText(requireContext(), "Close", Toast.LENGTH_SHORT).show()
                }else if (menuPosition == 1){
                    Toast.makeText(requireContext(), "Fund", Toast.LENGTH_SHORT).show()
                    val intent : Intent = Intent(requireContext(), VaultAddActivity::class.java)
                    intent.putExtra("vaultMenu", 1)
                    requireContext().startActivity(intent)
                }

            }
        }

}
