package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class SpecialtyPizzaFragment extends Fragment {

    ArrayList<PizzaModel> pizzaModels = new ArrayList<PizzaModel>();
    int[] pizzaImages = {R.drawable.deluxe, R.drawable.supreme, R.drawable.meatza, R.drawable.seafood, R.drawable.pizzapep};


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    private void setUpPizzaModels() {
        String[] pizzaNames = getResources().getStringArray(R.array.pizza_name);
        String[] toppings = getResources().getStringArray(R.array.toppings);

        for (int i = 0; i < pizzaNames.length; i++) {
            pizzaModels.add(new PizzaModel(pizzaNames[i], toppings[i], pizzaImages[i]));

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_specialty_pizza, container, false);
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerViewSpecialtyPizza);

        setUpPizzaModels();
        PizzaRecyclerViewAdapter adapter = new PizzaRecyclerViewAdapter(requireContext(), pizzaModels);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));

        return rootView;
    }


}