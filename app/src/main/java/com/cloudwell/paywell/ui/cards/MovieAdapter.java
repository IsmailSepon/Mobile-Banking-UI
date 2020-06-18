package com.cloudwell.paywell.ui.cards;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cloudwell.paywell.R;
import com.github.islamkhsh.CardSliderAdapter;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class MovieAdapter extends CardSliderAdapter<MovieAdapter.CardsViewHolder> {

    private ArrayList<String> movies;

    public MovieAdapter(ArrayList<String> movies) {
        this.movies = movies;
    }


    @Override
    public void bindVH(@NotNull CardsViewHolder cardsViewHolder, int i) {

    }

    @NonNull
    @Override
    public CardsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cards_item_page, parent, false);
        return new CardsViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class CardsViewHolder extends RecyclerView.ViewHolder {
        public CardsViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
