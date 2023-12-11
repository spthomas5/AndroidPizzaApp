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

public class OrdersRecyclerViewAdapter extends RecyclerView.Adapter<OrdersRecyclerViewAdapter.MyViewHolder> {
    Context context;
    ArrayList<Order> orders;

    public OrdersRecyclerViewAdapter(Context context, ArrayList<Order> orders) {
        this.context = context;
        this.orders = orders;
    }
    @NonNull
    @Override
    public OrdersRecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.orders_recycler_view_row, parent, false);
        return new OrdersRecyclerViewAdapter.MyViewHolder(view, this);
    }

    @Override
    public void onBindViewHolder(@NonNull OrdersRecyclerViewAdapter.MyViewHolder holder, int position) {
        holder.order.setText(orders.get(position).toString());
//        String toppings = "";
//        for (Topping t : cart.get(position).getToppings()) {
//            toppings += t.name().toLowerCase();
//            toppings = t.name().substring(0, 1).toUpperCase() + t.name().substring(1).toLowerCase();
//        }
//        holder.tvToppings.setText(toppings);


    }

    @Override
    public int getItemCount() {
        return orders.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView order, cart;
        Button btn;
        OrdersRecyclerViewAdapter adapter;

        public MyViewHolder(@NonNull View itemView, OrdersRecyclerViewAdapter adapter) {

            super(itemView);

//            imageView = itemView.findViewById(R.id.imageView);
            order = itemView.findViewById(R.id.order);
            cart = itemView.findViewById(R.id.cart);
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
