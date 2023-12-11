package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class SpecialtyPizzaFragment extends Fragment implements RecyclerViewInterface{

    ArrayList<PizzaModel> pizzaModels = new ArrayList<PizzaModel>();
    int[] pizzaImages = {R.drawable.deluxe, R.drawable.supreme, R.drawable.meatza,
            R.drawable.seafood, R.drawable.pizzapep, R.drawable.italiano, R.drawable.fire,
            R.drawable.veggie, R.drawable.shrimppizza, R.drawable.seanadam};


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
        PizzaRecyclerViewAdapter adapter = new PizzaRecyclerViewAdapter(requireContext(), pizzaModels, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));

        return rootView;
    }


    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(getActivity(), SpecialtyActivity.class);

        intent.putExtra("NAME", pizzaModels.get(position).getPizzaName());
        intent.putExtra("TOPPINGS", pizzaModels.get(position).getToppings());
        intent.putExtra("IMAGE", pizzaModels.get(position).getImage());

        startActivity(intent);
    }
}