package com.cloudwell.paywell.uiBusiness.sendFund.utility.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cloudwell.paywell.R;
import com.cloudwell.paywell.ui.account.adapter.CoursesItem;

import java.util.List;


/**
 * Created by Sepon on 3/20/2020.
 */
public class SendfundUpcomingAdapter extends RecyclerView.Adapter<SendfundUpcomingAdapter.ViewHolder> {

    private static final int UNSELECTED = -1;

    private RecyclerView recyclerView;
    private int selectedItem = UNSELECTED;

    Context mContext;


    private List<CoursesItem> courselist;


    public SendfundUpcomingAdapter(Context mContext, List<CoursesItem> courselist) {

        this.mContext = mContext;
        this.courselist = courselist;
    }

    @NonNull
    @Override
    public SendfundUpcomingAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.bu_sendfund_upcoming_item, parent, false);
        return new ViewHolder(itemView);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull SendfundUpcomingAdapter.ViewHolder holder, int position) {


    }

    @Override
    public int getItemCount() {
        return courselist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        public ViewHolder(View itemView) {
            super(itemView);



        }

    }

}
