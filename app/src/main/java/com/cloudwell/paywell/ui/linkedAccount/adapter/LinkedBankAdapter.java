package com.cloudwell.paywell.ui.linkedAccount.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cloudwell.paywell.R;
import com.cloudwell.paywell.ui.linkedAccount.model.BankListPojo;
import com.cloudwell.paywell.ui.vaults.vaultPOjo.VaulttPojo;

import java.util.List;


/**
 * Created by Sepon on 3/20/2020.
 */
public class LinkedBankAdapter extends RecyclerView.Adapter<LinkedBankAdapter.ViewHolder> {

    private static final int UNSELECTED = -1;
    private RecyclerView recyclerView;
    private final int selectedItem = UNSELECTED;
    public BankListItemClickListener clickListener;

    Context mContext;


    private final List<BankListPojo> courselist;


    public LinkedBankAdapter(Context mContext, List<BankListPojo> courselist) {

        this.mContext = mContext;
        this.courselist = courselist;
    }

    @NonNull
    @Override
    public LinkedBankAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.bank_list_item, parent, false);
        return new ViewHolder(itemView);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull LinkedBankAdapter.ViewHolder holder, int position) {

        holder.name.setText(courselist.get(position).getName());
        holder.icon.setImageResource(courselist.get(position).getIcon());

       holder.itemView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               clickListener.onBanklistClick(courselist.get(position));
           }
       });

    }

    @Override
    public int getItemCount() {
        return courselist.size();
    }

    public void setClickListener( BankListItemClickListener itemClickListener) {
        clickListener = itemClickListener;
    }



    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        ImageView icon;

        public ViewHolder(View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.banklist_name);
            icon = itemView.findViewById(R.id.bank_list_ic);


        }

    }



    public interface BankListItemClickListener {
        void  onBanklistClick(BankListPojo bankListPojo);
    }
}
