package com.pitipong.android.pigfarm.activity;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.pitipong.android.pigfarm.R;
import com.pitipong.android.pigfarm.adapter.ViewPagerAdapter;
import com.pitipong.android.pigfarm.fragment.BreedFragment;
import com.pitipong.android.pigfarm.fragment.HistoryFragment;
import com.pitipong.android.pigfarm.fragment.MaternityFragment;
import com.pitipong.android.pigfarm.fragment.WeanFragment;
import com.pitipong.android.pigfarm.helper.NonSwipeableViewPager;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @InjectView(R.id.toolbar)
    Toolbar toolbar;
    @InjectView(R.id.nav_view)
    NavigationView navView;
    @InjectView(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    @InjectView(R.id.viewPager)
    NonSwipeableViewPager viewPager;
    @InjectView(R.id.tabs)
    TabLayout tabs;

    private HistoryFragment historyFragment;
    private BreedFragment breedFragment;
    private MaternityFragment maternityFragment;
    private WeanFragment weanFragment;

    ViewPagerAdapter adapter;
    ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        initToolbar();
        initFragment();


    }

    private void initToolbar() {
        setSupportActionBar(toolbar);
        toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navView.setNavigationItemSelectedListener(this);
    }

    private void initFragment() {
        historyFragment = HistoryFragment.newInstance();
        breedFragment = BreedFragment.newInstance();
        maternityFragment = MaternityFragment.newInstance();
        weanFragment = WeanFragment.newInstance();

        setupViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        adapter = new ViewPagerAdapter(getSupportFragmentManager(), MainActivity.this);
        adapter.addFragment(historyFragment, "History");
        adapter.addFragment(breedFragment, "Breed");
        adapter.addFragment(maternityFragment, "Maternity");
        adapter.addFragment(weanFragment, "Wean");
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(4);

        setupTabLayout();
    }

    private void setupTabLayout() {
        tabs.setupWithViewPager(viewPager);
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
