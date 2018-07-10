package com.pitipong.android.pigfarm.activity;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.pitipong.android.pigfarm.R;
import com.pitipong.android.pigfarm.adapter.ViewPagerAdapter;
import com.pitipong.android.pigfarm.fragment.BreedFragment;
import com.pitipong.android.pigfarm.fragment.HistoryFragment;
import com.pitipong.android.pigfarm.fragment.MaternityFragment;
import com.pitipong.android.pigfarm.fragment.WeanFragment;
import com.pitipong.android.pigfarm.helper.NonSwipeableViewPager;


import static com.pitipong.android.pigfarm.dal.Constant.MENU_CHECK_DATA;
import static com.pitipong.android.pigfarm.dal.Constant.MENU_INSERT_DATA;
import static com.pitipong.android.pigfarm.dal.Constant.MENU_LIST;
import static com.pitipong.android.pigfarm.dal.Constant.MENU_SETTING;

public class MainActivity extends BaseActivity{

    TabLayout tabs;
    ViewPager viewPager;
    ImageView imageViewBack;

    private HistoryFragment historyFragment;
    private BreedFragment breedFragment;
    private MaternityFragment maternityFragment;
    private WeanFragment weanFragment;

    ViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initFragment();
    }

    private void initView(){
        imageViewBack = findViewById(R.id.imageViewBack);
        viewPager = findViewById(R.id.viewPager);
        tabs = findViewById(R.id.tabLayout);

        imageViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        bindDataToView();
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
        adapter.addFragment(historyFragment, getString(R.string.main_tab_1_history));
        adapter.addFragment(breedFragment, getString(R.string.main_tab_2_breed));
        adapter.addFragment(maternityFragment, getString(R.string.main_tab_3_maternity));
        adapter.addFragment(weanFragment, getString(R.string.main_tab_4_wean));
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(4);
        setupTabLayout();
    }

    private void setupTabLayout() {
        tabs.setupWithViewPager(viewPager);
    }


    private void bindDataToView(){

    }

    @Override
    public void onBackPressed() {
       backToExitApp();
    }
}