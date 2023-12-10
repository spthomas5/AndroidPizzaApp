package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CartRecyclerViewAdapter extends RecyclerView.Adapter<CartRecyclerViewAdapter.MyViewHolder> {
    Context context;
    ArrayList<Pizza> cart;

    public CartRecyclerViewAdapter(Context context, ArrayList<Pizza> cart ) {
        this.context = context;
        this.cart = cart;
    }
    @NonNull
    @Override
    public CartRecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.cart_recycler_view_row, parent, false);
        return new CartRecyclerViewAdapter.MyViewHolder(view, this);
    }

    @Override
    public void onBindViewHolder(@NonNull CartRecyclerViewAdapter.MyViewHolder holder, int position) {
        holder.tvName.setText(cart.get(position).getClass().getName().substring(26));
        String toppings = "";
        for (Topping t : cart.get(position).getToppings()) {
            toppings += t.name().toLowerCase();
            toppings = t.name().substring(0, 1).toUpperCase() + t.name().substring(1).toLowerCase();
        }
        holder.tvToppings.setText(toppings);


    }

    @Override
    public int getItemCount() {
        return cart.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView tvName, tvToppings;
        Button btn;
        CartRecyclerViewAdapter adapter;

        public MyViewHolder(@NonNull View itemView, CartRecyclerViewAdapter adapter) {

            super(itemView);

//            imageView = itemView.findViewById(R.id.imageView);
            tvName = itemView.findViewById(R.id.name);
            tvToppings = itemView.findViewById(R.id.toppings);
            btn = itemView.findViewById(R.id.button);

            btn.setOnClickListener(this);

        }

        @Override
        public void onClick(@NonNull View itemView) {
            int position = getAdapterPosition();
            MainActivity.getInstance().getOrder().getCart().remove(position);
            notifyItemRemoved(position);
        }
    }
}
