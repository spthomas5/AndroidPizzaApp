package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Order order = new Order(StoreOrders.id);
    private StoreOrders storeOrders = new StoreOrders();
    private static MainActivity instance = new MainActivity();
    public static MainActivity getInstance() {
        return instance;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        this.storeOrders = new StoreOrders();

        Button newOrder = findViewById(R.id.newOrder);

        newOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Button clicked", Toast.LENGTH_SHORT).show();
                System.out.println("new order");
                Intent intent = new Intent(MainActivity.this, OrderActivity.class);
                startActivity(intent);
            }
        });

        Button viewOrder = findViewById(R.id.viewOrder);

        viewOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("view order");
                Intent intent = new Intent(MainActivity.this, OrderActivity.class);
                startActivity(intent);
            }
        });


    }

    /**
     * Resets the current order by removing all items from the cart.
     */
    public void resetOrder() {
        this.order = new Order(StoreOrders.id);
    }

    /**
     * Retrieves the current order.
     *
     * @return the current order.
     */
    public Order getOrder(){
        return this.order;
    }

    /**
     * Retrieves the store orders.
     *
     * @return the store orders.
     */
    public StoreOrders getStoreOrders() {
        return this.storeOrders;
    }

    /**
     * Adds a pizza to the current order's cart.
     *
     * @param pizza the pizza to be added to the cart.
     */
    public void addToCart(Pizza pizza) {
        this.order.addToCart(pizza);
    }

    /**
     * Adds an order to the store orders.
     *
     * @param order the order to be added to the store.
     */
    public void addOrder(Order order) {
        this.storeOrders.addOrder(order);
    }



//    public void click (View view) {
//        Intent intent = new Intent(MainActivity.this, Order.class);
//        startActivity(intent);
//        System.out.println("switch");
//    }
}
