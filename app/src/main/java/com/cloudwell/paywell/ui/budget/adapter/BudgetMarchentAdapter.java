package com.cloudwell.paywell.ui.budget.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cloudwell.paywell.R;
import com.cloudwell.paywell.ui.budget.model.BudgetMachentPOjo;
import com.cloudwell.paywell.ui.spiltBill.fragment.SpiltBillHoastActivity;

import java.util.List;


/**
 * Created by Sepon on 3/20/2020.
 */
public class BudgetMarchentAdapter extends RecyclerView.Adapter<BudgetMarchentAdapter.ViewHolder> {

    private static final int UNSELECTED = -1;

    private RecyclerView recyclerView;
    private final int selectedItem = UNSELECTED;

    Context mContext;


    private final List<BudgetMachentPOjo> courselist;


    public BudgetMarchentAdapter(Context mContext, List<BudgetMachentPOjo> courselist) {

        this.mContext = mContext;
        this.courselist = courselist;
    }

    @NonNull
    @Override
    public BudgetMarchentAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.budget_marchent_item, parent, false);
        return new ViewHolder(itemView);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull BudgetMarchentAdapter.ViewHolder holder, int position) {

        holder.amount.setText(courselist.get(position).getAmount());
        holder.title.setText(courselist.get(position).getTitle());
        holder.transcation.setText(courselist.get(position).getTranscation());
        holder.persentage.setText(courselist.get(position).getPersentage());
        holder.icon.setImageResource(courselist.get(position).getIcon());

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
        TextView title;
        TextView transcation;
        TextView persentage;
        ImageView icon;

        public ViewHolder(View itemView) {
            super(itemView);

            amount = itemView.findViewById(R.id.marchent_amount);
            title = itemView.findViewById(R.id.marchent_title);
            transcation = itemView.findViewById(R.id.transcation);
            persentage = itemView.findViewById(R.id.persentage);
            icon = itemView.findViewById(R.id.icon);


        }

    }

}
