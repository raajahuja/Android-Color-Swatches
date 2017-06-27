package com.example.raaj.acs;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Toolbar toolbar;
    RecyclerView mRecyclerView;
    List<Color_Holder> mWebsites;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setBackgroundColor(ContextCompat.getColor(this, R.color.ndmi_color_red_toolbar));
        toolbar.setTitle(getResources().getString(R.string.ndmi_title_red));
        toolbar.setTitleTextColor(Color.BLACK);
        setSupportActionBar(toolbar);

        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setItemIconTintList(null);   //Set This for getting your Own Color
        navigationView.getMenu().getItem(0).setChecked(true);

        mWebsites = new ArrayList();
        fill_Data(R.array.reds);

        RecyclerViewAdapter_ListingColors adapter = new RecyclerViewAdapter_ListingColors(mWebsites, this);
        mRecyclerView.setAdapter(adapter);

    }

    private void fill_Data(int c) {
        if (c == R.array.browns || c == R.array.greys || c == R.array.blue_greys) {
            for (int i = 0; i < 10; i++) {
                String id = getResources().getStringArray(R.array.Color_identifier)[i];
                String color = "Hex:  #" + Integer.toHexString((getResources().getIntArray(c)[i])).substring(2);

                int color1 = getResources().getIntArray(c)[i];
                int r = Color.red(color1);
                int g = Color.green(color1);
                int b = Color.blue(color1);
                String rgb = "RGB: " + "(" + r + "," + g + "," + b + ")";

                mWebsites.add(new Color_Holder(id, color, getResources().getIntArray(c)[i], rgb));
            }
        } else {
            for (int i = 0; i < 14; i++) {
                String id = getResources().getStringArray(R.array.Color_identifier)[i];
                String color = "Hex:  #" + Integer.toHexString((getResources().getIntArray(c)[i])).substring(2);

                int color1 = getResources().getIntArray(c)[i];
                int r = Color.red(color1);
                int g = Color.green(color1);
                int b = Color.blue(color1);
                String rgb = "RGB: " + "(" + r + "," + g + "," + b + ")";

                mWebsites.add(new Color_Holder(id, color, getResources().getIntArray(c)[i], rgb));
            }
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        mWebsites = new ArrayList();

        if (id == R.id.nav_red) {
            toolbar.setBackgroundColor(ContextCompat.getColor(this, R.color.ndmi_color_red_toolbar));
            toolbar.setTitle(getResources().getString(R.string.ndmi_title_red));
            toolbar.setTitleTextColor(Color.BLACK);
            fill_Data(R.array.reds);
        } else if (id == R.id.nav_pink) {
            toolbar.setBackgroundColor(ContextCompat.getColor(this, R.color.ndmi_color_pink_toolbar));
            toolbar.setTitle(getResources().getString(R.string.ndmi_title_pink));
            toolbar.setTitleTextColor(Color.BLACK);
            fill_Data(R.array.pinks);
        } else if (id == R.id.nav_purple) {
            toolbar.setBackgroundColor(ContextCompat.getColor(this, R.color.ndmi_color_purple_toolbar));
            toolbar.setTitle(getResources().getString(R.string.ndmi_title_purple));
            toolbar.setTitleTextColor(Color.BLACK);
            fill_Data(R.array.purples);
        } else if (id == R.id.nav_deep_purple) {
            toolbar.setBackgroundColor(ContextCompat.getColor(this, R.color.ndmi_color_deep_purple_toolbar));
            toolbar.setTitle(getResources().getString(R.string.ndmi_title_deep_purple));
            toolbar.setTitleTextColor(Color.BLACK);
            fill_Data(R.array.deep_purples);
        } else if (id == R.id.nav_indigo) {
            toolbar.setBackgroundColor(ContextCompat.getColor(this, R.color.ndmi_color_indigo_toolbar));
            toolbar.setTitle(getResources().getString(R.string.ndmi_title_indigo));
            toolbar.setTitleTextColor(Color.BLACK);
            fill_Data(R.array.indigos);
        } else if (id == R.id.nav_blue) {
            toolbar.setBackgroundColor(ContextCompat.getColor(this, R.color.ndmi_color_blue_toolbar));
            toolbar.setTitle(getResources().getString(R.string.ndmi_title_blue));
            toolbar.setTitleTextColor(Color.BLACK);
            fill_Data(R.array.blues);
        } else if (id == R.id.nav_light_blue) {
            toolbar.setBackgroundColor(ContextCompat.getColor(this, R.color.ndmi_color_light_blue_toolbar));
            toolbar.setTitle(getResources().getString(R.string.ndmi_title_light_blue));
            toolbar.setTitleTextColor(Color.BLACK);
            fill_Data(R.array.light_blues);
        } else if (id == R.id.nav_cyan) {
            toolbar.setBackgroundColor(ContextCompat.getColor(this, R.color.ndmi_color_cyan_toolbar));
            toolbar.setTitle(getResources().getString(R.string.ndmi_title_cyan));
            toolbar.setTitleTextColor(Color.BLACK);
            fill_Data(R.array.cyans);
        } else if (id == R.id.nav_teal) {
            toolbar.setBackgroundColor(ContextCompat.getColor(this, R.color.ndmi_color_teal_toolbar));
            toolbar.setTitle(getResources().getString(R.string.ndmi_title_teal));
            toolbar.setTitleTextColor(Color.BLACK);
            fill_Data(R.array.teals);
        } else if (id == R.id.nav_green) {
            toolbar.setBackgroundColor(ContextCompat.getColor(this, R.color.ndmi_color_green_toolbar));
            toolbar.setTitle(getResources().getString(R.string.ndmi_title_green));
            toolbar.setTitleTextColor(Color.BLACK);
            fill_Data(R.array.greens);
        } else if (id == R.id.nav_light_green) {
            toolbar.setBackgroundColor(ContextCompat.getColor(this, R.color.ndmi_color_light_green_toolbar));
            toolbar.setTitle(getResources().getString(R.string.ndmi_title_light_green));
            toolbar.setTitleTextColor(Color.BLACK);
            fill_Data(R.array.light_greens);
        } else if (id == R.id.nav_lime) {
            toolbar.setBackgroundColor(ContextCompat.getColor(this, R.color.ndmi_color_lime_toolbar));
            toolbar.setTitle(getResources().getString(R.string.ndmi_title_lime));
            toolbar.setTitleTextColor(Color.BLACK);
            fill_Data(R.array.limes);
        } else if (id == R.id.nav_yellow) {
            toolbar.setBackgroundColor(ContextCompat.getColor(this, R.color.ndmi_color_yellow_toolbar));
            toolbar.setTitle(getResources().getString(R.string.ndmi_title_yellow));
            toolbar.setTitleTextColor(Color.BLACK);
            fill_Data(R.array.yellows);
        } else if (id == R.id.nav_amber) {
            toolbar.setBackgroundColor(ContextCompat.getColor(this, R.color.ndmi_color_amber_toolbar));
            toolbar.setTitle(getResources().getString(R.string.ndmi_title_amber));
            toolbar.setTitleTextColor(Color.BLACK);
            fill_Data(R.array.ambers);
        } else if (id == R.id.nav_orange) {
            toolbar.setBackgroundColor(ContextCompat.getColor(this, R.color.ndmi_color_orange_toolbar));
            toolbar.setTitle(getResources().getString(R.string.ndmi_title_orange));
            toolbar.setTitleTextColor(Color.BLACK);
            fill_Data(R.array.oranges);
        } else if (id == R.id.nav_deep_orange) {
            toolbar.setBackgroundColor(ContextCompat.getColor(this, R.color.ndmi_color_deep_orange_toolbar));
            toolbar.setTitle(getResources().getString(R.string.ndmi_title_deep_orange));
            toolbar.setTitleTextColor(Color.BLACK);
            fill_Data(R.array.deep_oranges);
        } else if (id == R.id.nav_brown) {
            toolbar.setBackgroundColor(ContextCompat.getColor(this, R.color.ndmi_color_brown_toolbar));
            toolbar.setTitle(getResources().getString(R.string.ndmi_title_brown));
            toolbar.setTitleTextColor(Color.BLACK);
            fill_Data(R.array.browns);
        } else if (id == R.id.nav_grey) {
            toolbar.setBackgroundColor(ContextCompat.getColor(this, R.color.ndmi_color_grey_toolbar));
            toolbar.setTitle(getResources().getString(R.string.ndmi_title_grey));
            toolbar.setTitleTextColor(Color.BLACK);
            fill_Data(R.array.greys);
        } else if (id == R.id.nav_blue_grey) {
            toolbar.setBackgroundColor(ContextCompat.getColor(this, R.color.ndmi_color_blue_grey_toolbar));
            toolbar.setTitle(getResources().getString(R.string.ndmi_title_blue_grey));
            toolbar.setTitleTextColor(Color.BLACK);
            fill_Data(R.array.blue_greys);
        }


        RecyclerViewAdapter_ListingColors adapter = new RecyclerViewAdapter_ListingColors(mWebsites, this);
        mRecyclerView.setAdapter(adapter);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
