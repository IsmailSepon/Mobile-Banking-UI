package com.cloudwell.paywell.ui.account.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cloudwell.paywell.R;
import com.cloudwell.paywell.ui.spiltBill.fragment.SpiltBillHoastActivity;

import java.util.List;


/**
 * Created by Sepon on 3/20/2020.
 */
public class TestAdapter extends RecyclerView.Adapter<TestAdapter.ViewHolder> {

    private static final int UNSELECTED = -1;

    private RecyclerView recyclerView;
    private int selectedItem = UNSELECTED;

    Context mContext;


    private List<CoursesItem> courselist;


    public TestAdapter(Context mContext, List<CoursesItem> courselist) {

        this.mContext = mContext;
        this.courselist = courselist;
    }

    @NonNull
    @Override
    public TestAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.spilit_item, parent, false);
        return new ViewHolder(itemView);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull TestAdapter.ViewHolder holder, int position) {

        holder.amount.setText(courselist.get(position).getAmount());
        holder.amount.setText("-" + Html.fromHtml(Html.fromHtml("&#2547").toString()) + " " + courselist.get(position).getAmount());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(mContext, SpiltBillHoastActivity.class);
                intent.putExtra("spilt", "2");
                mContext.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return courselist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView amount;

        public ViewHolder(View itemView) {
            super(itemView);

            amount = itemView.findViewById(R.id.amount_txt);


        }

    }

}
