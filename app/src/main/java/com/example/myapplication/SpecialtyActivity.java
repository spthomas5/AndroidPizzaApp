package com.example.myapplication;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.TextView;

import androidx.core.view.WindowCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.myapplication.databinding.ActivitySpecialtyBinding;

public class SpecialtyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specialty);

        String name = getIntent().getStringExtra("NAME");
        String toppings = getIntent().getStringExtra("TOPPINGS");
        int image = getIntent().getIntExtra("IMAGE", 0);

        TextView tvName = findViewById(R.id.pizzaName);
        TextView tvToppings = findViewById(R.id.toppings);
        ImageView imageView = findViewById(R.id.imageView);

        tvName.setText(name);
        tvToppings.setText(toppings);
        imageView.setImageResource(image);

        NumberPicker np = findViewById(R.id.quantityPicker);
        np.setMaxValue(20);
        np.setMinValue(0);
        np.setValue(0);
    }

}