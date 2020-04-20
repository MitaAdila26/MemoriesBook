package com.example.memoriesbook;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.io.Serializable;

public class TabFragmentPagerAdapter extends FragmentPagerAdapter {
    private Siswa siswa;
    String[]title=new String[]{"data diri","kenangan","foto"};

    public TabFragmentPagerAdapter(FragmentManager fm, Siswa siswa) {
        super(fm);
        this.siswa=siswa;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                Fragment fragment=new DataFragment();
                Bundle bundle=new Bundle();
                bundle.putSerializable("siswa1", (Serializable) siswa);
                fragment.setArguments(bundle);
                return fragment;

            case 1:
                Fragment fragment2=new KenanganFragment();
                Bundle bundle2=new Bundle();
                bundle2.putSerializable("siswa2", (Serializable) siswa);
                fragment2.setArguments(bundle2);
                return fragment2;
            case 2:
                Fragment fragment3=new FotoFragment();
                Bundle bundle3=new Bundle();
                bundle3.putSerializable("siswa3", (Serializable) siswa);
                fragment3.setArguments(bundle3);
                return fragment3;
        }
        return null;
    }

    @Override
    public int getCount() {
        return title.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }
}
