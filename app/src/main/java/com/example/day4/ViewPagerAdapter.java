package com.example.day4;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
                return new SeoulFragment();
            case 1:
                return new BusanFragment();
            case 2:
                return new NamyangjuFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;   //아이템 개수 : 3 (fragment)
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position)
        {
            case 0:
                return "Seoul";
            case 1:
                return "Busan";
            case 2:
                return "Namyangju";
        }
        return super.getPageTitle(position);
    }
}
