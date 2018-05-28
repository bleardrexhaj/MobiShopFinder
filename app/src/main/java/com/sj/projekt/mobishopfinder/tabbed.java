package com.sj.projekt.mobishopfinder;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class tabbed extends AppCompatActivity {


    private SectionsPagerAdapter mSectionsPagerAdapter;
    private String Emri;
    private double Latitude,Longitude;

    private ViewPager mViewPager;

    public String nrTel = "049271704";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabbed);


        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + nrTel ));
                startActivity(intent);
            }
        });



        Intent getIntent = getIntent();
        Emri = getIntent.getStringExtra("Emri");
        Latitude = getIntent.getDoubleExtra("Latitude",0);
        Longitude = getIntent.getDoubleExtra("Longitude",0);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tabbed, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                     Tab1Location tab1 = new  Tab1Location();
                     Bundle args = new Bundle();
                     Intent getIntent = getIntent();

                     args.putString("Emri",Emri);
                     args.putDouble("Latitude",Latitude);
                     args.putDouble("Longitude",Longitude);

                     tab1.setArguments(args);
                     return tab1;
                case 1:
                    Tab2Phones tab2 = new Tab2Phones();

                    return tab2;
                case 2:
                    Tab3Information tab3 = new Tab3Information();
                    return tab3;
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {

            return 3;
        }
    }
}
