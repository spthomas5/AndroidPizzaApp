package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PizzaRecyclerViewAdapter extends RecyclerView.Adapter<PizzaRecyclerViewAdapter.MyViewHolder> {
    private final RecyclerViewInterface recyclerViewInterface;
    Context context;
    ArrayList<PizzaModel> pizzaModels;

    public PizzaRecyclerViewAdapter(Context context, ArrayList<PizzaModel> pizzaModels, RecyclerViewInterface recyclerViewInterface) {
        this.context = context;
        this.pizzaModels = pizzaModels;
        this.recyclerViewInterface = recyclerViewInterface;
    }
    @NonNull
    @Override
    public PizzaRecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_view_row, parent, false);
        return new PizzaRecyclerViewAdapter.MyViewHolder(view, recyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull PizzaRecyclerViewAdapter.MyViewHolder holder, int position) {
        holder.tvName.setText(pizzaModels.get(position).getPizzaName());
        holder.tvToppings.setText(pizzaModels.get(position).getToppings());
        holder.imageView.setImageResource(pizzaModels.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return pizzaModels.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView tvName, tvToppings;
        NumberPicker np;

        Button btn;

        public MyViewHolder(@NonNull View itemView, RecyclerViewInterface recyclerViewInterface) {
            super(itemView);

            MainActivity instance = MainActivity.getInstance();

            np = itemView.findViewById(R.id.quantityPicker);
            np.setMaxValue(20);
            np.setMinValue(0);
            np.setValue(0);

            imageView = itemView.findViewById(R.id.imageView);
            tvName = itemView.findViewById(R.id.name);
            tvToppings = itemView.findViewById(R.id.toppings);
            btn = itemView.findViewById(R.id.submit);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (recyclerViewInterface != null) {
                        int pos = getAdapterPosition();

                        if (pos != RecyclerView.NO_POSITION) {
                            recyclerViewInterface.onItemClick(pos);
                        }
                    }
                }
            });
        }

        public void submit() {

        }
    }
}
