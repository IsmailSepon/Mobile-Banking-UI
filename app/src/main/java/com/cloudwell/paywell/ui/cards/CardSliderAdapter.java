package com.cloudwell.paywell.ui.cards;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.cloudwell.paywell.R;

import java.util.List;

public class CardSliderAdapter extends RecyclerView.Adapter<CardSliderAdapter.CardsViewHolder> {

    private List<CradsItem> cards;
    private Context context;
    private ViewPager2 viewPager2;

    public CardSliderAdapter(List<CradsItem> cards, ViewPager2 viewPager2, Context context) {
        this.cards = cards;
        this.viewPager2 = viewPager2;
        this.context = context;
    }

    @NonNull
    @Override
    public CardsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cards_item_page, parent, false);
        return new CardSliderAdapter.CardsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardsViewHolder holder, int position) {

        holder.setImage(cards.get(position));
    }

    @Override
    public int getItemCount() {
        return cards.size();
    }

    class CardsViewHolder extends RecyclerView.ViewHolder {
        private ImageView cardImage;

        public CardsViewHolder(@NonNull View itemView) {
            super(itemView);

            cardImage = itemView.findViewById(R.id.imageviewcard);

        }

        void setImage(CradsItem cradsItem) {

            cardImage.setImageResource(cradsItem.getImage());
        }
    }
}
