package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class ViewCartFragment extends Fragment {

    ArrayList<Pizza> cart = MainActivity.getInstance().getOrder().getCart();

    CartRecyclerViewAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public void onResume() {
        super.onResume();

        adapter.notifyDataSetChanged();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        System.out.println("7686766");
        View rootView = inflater.inflate(R.layout.fragment_view_cart, container, false);

        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerViewViewCart);

        adapter = new CartRecyclerViewAdapter(requireContext(), cart);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));

        return rootView;
    }
}