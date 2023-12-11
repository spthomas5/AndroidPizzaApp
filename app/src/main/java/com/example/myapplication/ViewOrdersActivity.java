package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class ViewOrdersActivity extends AppCompatActivity {

    ArrayList<Order> orders = MainActivity.getInstance().getStoreOrders().getOrders();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_orders);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerViewViewOrders);

        OrdersRecyclerViewAdapter adapter = new OrdersRecyclerViewAdapter(this, orders);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }


}
