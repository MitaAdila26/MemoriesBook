package com.example.memoriesbook;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
//import android.support.v7.widget.Toolbar;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

//import android.widget.Toolbar;

public class DetailActivity extends AppCompatActivity {
    public static String KEY_ACTIVITY="msg_activity" ;
    private Siswa siswa;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private Toolbar toolbar;
    TabFragmentPagerAdapter pagerAdapter;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tab);
        Intent i = getIntent();
        siswa = (Siswa) i.getSerializableExtra(KEY_ACTIVITY);
        getSupportActionBar().setTitle(siswa.getNama());

        pagerAdapter = new TabFragmentPagerAdapter(getSupportFragmentManager(), siswa);
        viewPager.setAdapter(pagerAdapter);

        tabLayout.setTabTextColors(getResources().getColor(R.color.colorItem2), getResources().getColor(R.color.tool));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
    }



    public Siswa getSiswa() {
        return siswa;
    }


}
