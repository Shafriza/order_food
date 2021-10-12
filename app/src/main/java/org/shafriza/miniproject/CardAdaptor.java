package org.shafriza.miniproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class CardAdaptor extends RecyclerView.Adapter<CardAdaptor.CardViewHolder>{
    Context context;

    private ArrayList<Card> listCard;

    public CardAdaptor(Context context,ArrayList<Card> listCard) {
        this.listCard = listCard;
        this.context = context;
    }

    @NonNull
    @Override
    public CardAdaptor.CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.card_view, parent,false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        holder.tvTitle.setText(listCard.get(position).getTitle());
        holder.tvDc.setText(listCard.get(position).getDescription());
        holder.pict.setImageResource(listCard.get(position).getImg());
    }

    @Override
    public int getItemCount() {
        return (listCard != null)? listCard.size() : 0;
    }

    public class CardViewHolder extends RecyclerView.ViewHolder{
        private ImageView pict;
        private TextView tvTitle, tvDc;


        public CardViewHolder (View view){
            super(view);

            tvTitle = view.findViewById(R.id.tvTitle);
            tvDc = view.findViewById(R.id.tvDc);
            pict = view.findViewById(R.id.imageView);


        }
    }
}
