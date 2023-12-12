package com.example.myapplication;

import android.app.Activity;
import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;



public class SpecialtyActivity extends AppCompatActivity {
    CheckBox cbCheese;
    CheckBox cbSauce;
    Button btn;
    NumberPicker np;
    Spinner sizeSpinner;
    String name;
    double price;
    double base;

    TextView tvPrice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specialty);

        name = getIntent().getStringExtra("NAME");
        System.out.println(name);
        String toppings = getIntent().getStringExtra("TOPPINGS");
        int image = getIntent().getIntExtra("IMAGE", 0);
        base = getIntent().getDoubleExtra("BASE", 0);
        System.out.println(base);

        TextView tvName = findViewById(R.id.pizzaName);
        TextView tvToppings = findViewById(R.id.toppings);
        ImageView imageView = findViewById(R.id.imageView);
        tvPrice = findViewById(R.id.price);

        tvName.setText(name);
        tvToppings.setText(toppings);
        imageView.setImageResource(image);
        tvPrice.setText("0.00");

        np = findViewById(R.id.quantityPicker);
        np.setMaxValue(20);
        np.setMinValue(0);
        np.setValue(0);

        cbCheese = findViewById(R.id.extraCheeseCheckbox);
        cbSauce = findViewById(R.id.extraSauceCheckbox);
        btn = findViewById(R.id.submit);
        sizeSpinner = findViewById(R.id.sizeSpinner);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check();
            }
        });

        np.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                updatePrice();
                System.out.println("xx");
            }
        });

        sizeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                updatePrice();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                updatePrice();
            }
        });

        cbCheese.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updatePrice();
            }
        });

        cbSauce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updatePrice();
            }
        });
    }



    private void check () {
        if (np.getValue() == 0) {
            Toast.makeText(this, "Value must be greater than 0", Toast.LENGTH_SHORT).show();
            return;
        }

        MainActivity instance = MainActivity.getInstance();
        for (int i = 0; i < np.getValue(); i++) {
            Pizza pizza = PizzaMaker.createPizza(name.toUpperCase());

            String size = sizeSpinner.getSelectedItem().toString();
            if (size.equals("Small")) {
                pizza.setSize(Size.SMALL);
            }
            if (size.equals("Medium")) {
                pizza.setSize(Size.MEDIUM);
            }
            if (size.equals("Large")){
                pizza.setSize(Size.LARGE);
            }
            pizza.setExtraCheese(cbCheese.isChecked());
            pizza.setExtraSauce(cbSauce.isChecked());
            instance.addToCart(pizza);
        }




        Toast.makeText(this, "Added to cart!", Toast.LENGTH_SHORT).show();
    }

    private void updatePrice() {
        double price = np.getValue() * (base + (cbCheese.isChecked()? 1 : 0) + (cbSauce.isChecked() ? 1 : 0)
        + (sizeSpinner.getSelectedItem().toString().equals("Medium") ? 2 : 0)
        + (sizeSpinner.getSelectedItem().toString().equals("Large") ? 4: 0));

        tvPrice.setText(String.format("Price: $%,.2f", price));

    }

}