package com.example.myapplication;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPagerAdapter extends FragmentStateAdapter {

    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0: return new SpecialtyPizzaFragment();
            case 1: return new BuildYourOwnPizzaFragment();
            case 2: return new ViewCartFragment();
            default: return new SpecialtyPizzaFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
