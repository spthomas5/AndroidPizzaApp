package com.example.myapplication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageButton;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BuildYourOwnPizzaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BuildYourOwnPizzaFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BuildYourOwnPizzaFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BuildYourOwnPizzaFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BuildYourOwnPizzaFragment newInstance(String param1, String param2) {
        BuildYourOwnPizzaFragment fragment = new BuildYourOwnPizzaFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root =  inflater.inflate(R.layout.fragment_build_your_own_pizza, container, false);
        // Inflate the layout for this fragment

        Pair<CheckBox, ImageButton>[] pairArray = getPairs(root);

        for (Pair<CheckBox, ImageButton> checkBoxImageButtonPair : pairArray) {
            checkBoxImageButtonPair.second.setOnClickListener(e ->{
                checkBoxImageButtonPair.first.toggle();
            });
        }


        return root;
    }

    @NonNull
    private static Pair<CheckBox, ImageButton>[] getPairs(View root) {
        Pair<CheckBox, ImageButton> onionPair = new Pair<CheckBox, ImageButton>
                (root.findViewById(R.id.onion_check), root.findViewById(R.id.onion_img));
        Pair<CheckBox, ImageButton> crabPair = new Pair<CheckBox, ImageButton>
                (root.findViewById(R.id.crab_check), root.findViewById(R.id.crab_img));
        Pair<CheckBox, ImageButton> chickenPair = new Pair<>
                (root.findViewById(R.id.chicken_check), root.findViewById(R.id.chicken_img));
        Pair<CheckBox, ImageButton> beefPair = new Pair<>
                (root.findViewById(R.id.beef_check), root.findViewById(R.id.beef_img));
        Pair<CheckBox, ImageButton> hamPair = new Pair<>
                (root.findViewById(R.id.ham_check), root.findViewById(R.id.ham_img));
        Pair<CheckBox, ImageButton> jalapenoPair = new Pair<>(
                root.findViewById(R.id.jalapeno_check), root.findViewById(R.id.jalapeno_img));
        Pair<CheckBox, ImageButton> fishPair = new Pair<>(
                root.findViewById(R.id.fish_check), root.findViewById(R.id.fish_img));
        Pair<CheckBox, ImageButton> mushroomsPair = new Pair<>(
                root.findViewById(R.id.mushrooms_check), root.findViewById(R.id.mushrooms_img));
        Pair<CheckBox, ImageButton> olivesPair = new Pair<>(
                root.findViewById(R.id.olives_check), root.findViewById(R.id.olives_img));
        Pair<CheckBox, ImageButton> pepperoniPair = new Pair<>(
                root.findViewById(R.id.pepperoni_check), root.findViewById(R.id.pepperoni_img));
        Pair<CheckBox, ImageButton> peppersPair = new Pair<>(
                root.findViewById(R.id.peppers_check), root.findViewById(R.id.peppers_img));
        Pair<CheckBox, ImageButton> sausagesPair = new Pair<>(
                root.findViewById(R.id.sausages_check), root.findViewById(R.id.sausages_img));
        Pair<CheckBox, ImageButton> shrimpPair = new Pair<>(
                root.findViewById(R.id.shrimp_check), root.findViewById(R.id.shrimp_img));
        Pair<CheckBox, ImageButton> squidPair = new Pair<>(
                root.findViewById(R.id.squid_check), root.findViewById(R.id.squid_image));
        return new Pair[]{onionPair,crabPair,chickenPair,
                jalapenoPair, fishPair, mushroomsPair, olivesPair, beefPair, hamPair, peppersPair,
                pepperoniPair, sausagesPair, shrimpPair, squidPair};
    }
}