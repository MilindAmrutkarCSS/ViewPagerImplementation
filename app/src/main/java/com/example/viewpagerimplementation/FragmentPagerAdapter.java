package com.example.viewpagerimplementation;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class FragmentPagerAdapter extends androidx.fragment.app.FragmentPagerAdapter {

    public static int NUM_ITEMS = 3;

    public FragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return ImageFragment.newInstance(R.drawable.clipboard);

            case 1:
                return ImageFragment.newInstance(R.drawable.doctor_bag);

            case 2:
                return ImageFragment.newInstance(R.drawable.hospital);

            default:
                return null;

        }
    }

    @Override
    public int getCount() {
        return NUM_ITEMS;
    }
}
