package com.cloudwell.paywell.myFavorite.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.cloudwell.paywell.services.R;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by Kazi Md. Saidul Email: Kazimdsaidul@gmail.com  Mobile: +8801675349882 on 2/1/19.
 */
class ItemViewHolder extends RecyclerView.ViewHolder {
    TextView itemContent;
    ImageView ivIcon;
    ImageView ivAdded;
    ConstraintLayout rootLiarLayout;


    ItemViewHolder(View itemView) {
        super(itemView);
        itemContent = itemView.findViewById(R.id.item_content);
        ivIcon = itemView.findViewById(R.id.ivIcon);
        ivAdded = itemView.findViewById(R.id.ivAdded);
        rootLiarLayout = itemView.findViewById(R.id.rootLinarLayout);
    }
}