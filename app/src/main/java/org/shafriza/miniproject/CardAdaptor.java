package org.shafriza.miniproject;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import java.io.ByteArrayOutputStream;
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



        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClickListener(View v, int position) {
                String gTitle = listCard.get(position).getTitle();
                String gDesc = listCard.get(position).getDescription();
//                int bytes = models.get(position).getImg();
//                BitmapDrawable bitmapDrawable = (BitmapDrawable)Myholder.mImageView.getDrawable();
////
//                Bitmap bitmap = bitmapDrawable.getBitmap();
////
//                ByteArrayOutputStream stream = new ByteArrayOutputStream();
////
//                bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
////
//                byte[] bytes = stream.toByteArray();

                Intent intent = new Intent(context,Details.class);
                intent.putExtra("iTitle",gTitle);
                intent.putExtra("iDesc",gDesc);
                intent.putExtra("iImage", listCard.get(position).getImg());
                intent.putExtra("price","Rp."+listCard.get(position).getPrice());

                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return (listCard != null)? listCard.size() : 0;
    }

    void setFilter(ArrayList<Card> filterList){
        listCard = new ArrayList<>();
        listCard.addAll(filterList);
        notifyDataSetChanged();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private ImageView pict;
        private TextView tvTitle, tvDc,price;
        private ItemClickListener itemClickListener;
        private CardView cv;

        public CardViewHolder (View view){
            super(view);

            tvTitle = view.findViewById(R.id.tvTitle);
            tvDc = view.findViewById(R.id.tvDc);
            pict = view.findViewById(R.id.imageView);

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            this.itemClickListener.onItemClickListener(view,getLayoutPosition());
        }
        public void setItemClickListener(ItemClickListener ic){
            this.itemClickListener = ic;
        }
    }
}
