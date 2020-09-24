package com.cloudwell.paywell.uiBusiness.cards.fragment.expence

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.cloudwell.paywell.R
import com.cloudwell.paywell.uiBusiness.cards.dialog.ExpenseApproveDialog
import com.cloudwell.paywell.uiBusiness.cards.dialog.ExpenseRejectDialog
import com.cloudwell.paywell.uiBusiness.cards.dialog.ExpenseReturnDialog
import kotlinx.android.synthetic.main.activity_expense_details.*


class ExpenseDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_expense_details)



        cardView9.setOnClickListener(View.OnClickListener {
            val intent: Intent = Intent(this, ExpenceMemoPictureActivity::class.java)
            startActivity(intent)
        })


        approve_btn.setOnClickListener(View.OnClickListener {

            val dialog: ExpenseApproveDialog = ExpenseApproveDialog()
            dialog.show(supportFragmentManager, "ExpenseApproveDialog")

        })

        return_btn.setOnClickListener(View.OnClickListener {

            val dialog: ExpenseReturnDialog = ExpenseReturnDialog()
            dialog.show(supportFragmentManager, "ExpenseReturnDialog")


        })

        reject_btn.setOnClickListener(View.OnClickListener {

            val dialog: ExpenseRejectDialog = ExpenseRejectDialog()
            dialog.show(supportFragmentManager, "ExpenseRejectDialog")


        })


    }


}