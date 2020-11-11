package com.example.mjc;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class ViewpagerAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> arrayList = new ArrayList<>();
    private ArrayList<String> name = new ArrayList<>();

    public ViewpagerAdapter(@NonNull FragmentManager fm)
    {
        super(fm);
        arrayList.add(new FirstFragment());
        arrayList.add(new SecondFragment());
        arrayList.add(new ThirdFragment());

        name.add("1번 탭");
        name.add("2번 탭");
        name.add("3번 탭");
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position)
    {
        return name.get(position);
    }

    @NonNull
    @Override
    public Fragment getItem(int position)
    {
        return arrayList.get(position);
    }

    @Override
    public int getCount()
    {
        return arrayList.size();
    }

}