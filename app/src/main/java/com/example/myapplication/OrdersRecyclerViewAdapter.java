package com.example.myapplication;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.method.ScrollingMovementMethod;
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
        holder.order.setMovementMethod(new ScrollingMovementMethod());

    }

    @Override
    public int getItemCount() {
        return orders.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView order;
        Button btn;
        OrdersRecyclerViewAdapter adapter;

        public MyViewHolder(@NonNull View itemView, OrdersRecyclerViewAdapter adapter) {

            super(itemView);

            order = itemView.findViewById(R.id.order);
            btn = itemView.findViewById(R.id.button);

            btn.setOnClickListener(this);
        }

        @Override
        public void onClick(@NonNull View itemView) {
            // Create the object of AlertDialog Builder class
            AlertDialog.Builder builder = new AlertDialog.Builder(context);

            builder.setMessage("Are you sure you want to delete this order?");
            builder.setTitle("Alert!");
            builder.setCancelable(false);

            builder.setPositiveButton("Yes", (DialogInterface.OnClickListener) (dialog, which) -> {
                int position = getAdapterPosition();
                MainActivity.getInstance().getStoreOrders().getOrders().remove(position);
                notifyItemRemoved(position);
            });

            builder.setNegativeButton("No", (DialogInterface.OnClickListener) (dialog, which) -> {
                dialog.cancel();
            });

            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        }
    }
}
