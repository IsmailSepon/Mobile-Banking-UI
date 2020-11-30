package com.cloudwell.paywell.ui.vaults.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cloudwell.paywell.R;
import com.cloudwell.paywell.ui.spiltBill.fragment.SpiltBillHoastActivity;
import com.cloudwell.paywell.ui.vaults.vaultPOjo.VaulttPojo;

import java.util.List;


/**
 * Created by Sepon on 3/20/2020.
 */
public class VaultAdapter extends RecyclerView.Adapter<VaultAdapter.ViewHolder> {

    private static final int UNSELECTED = -1;

    private RecyclerView recyclerView;
    private final int selectedItem = UNSELECTED;

    Context mContext;


    private final List<VaulttPojo> courselist;


    public VaultAdapter(Context mContext, List<VaulttPojo> courselist) {

        this.mContext = mContext;
        this.courselist = courselist;
    }

    @NonNull
    @Override
    public VaultAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.vault_item, parent, false);
        return new ViewHolder(itemView);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull VaultAdapter.ViewHolder holder, int position) {

        holder.name.setText(courselist.get(position).getName());
        holder.costAmount.setText(courselist.get(position).getCostAmount());
        holder.cost.setText(courselist.get(position).getCost());

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

        TextView name;
        TextView cost;
        TextView costAmount;

        public ViewHolder(View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.vault_name);
            cost = itemView.findViewById(R.id.vault_cost2);
            costAmount = itemView.findViewById(R.id.vault_cost);


        }

    }

}
