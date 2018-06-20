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

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.pitipong.android.pigfarm.dal.Constant.MENU_CHECK_DATA;
import static com.pitipong.android.pigfarm.dal.Constant.MENU_INSERT_DATA;
import static com.pitipong.android.pigfarm.dal.Constant.MENU_LIST;
import static com.pitipong.android.pigfarm.dal.Constant.MENU_SETTING;

public class MainActivity extends BaseActivity{

    TabLayout tabs;
    ViewPager viewPager;
    NavigationView navView;
    DrawerLayout drawerLayout;
    View selectorInsertData, selectorCheckData, selectorList, selectorSetting;
    LinearLayout menuInsertData, menuCheckData, menuList, menuSetting;
    ImageView iconDrawerMenu;

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
        viewPager = findViewById(R.id.viewPager);
        tabs = findViewById(R.id.tabLayout);
        drawerLayout = findViewById(R.id.drawer_layout);
        navView = findViewById(R.id.nav_view);

        // Drawer menu
        iconDrawerMenu = findViewById(R.id.icDrawerMenu);

        selectorInsertData = findViewById(R.id.selected1);
        selectorCheckData = findViewById(R.id.selected2);
        selectorList = findViewById(R.id.selected3);
        selectorSetting = findViewById(R.id.selected4);

        menuInsertData = findViewById(R.id.linearLayoutMenu1);
        menuCheckData = findViewById(R.id.linearLayoutMenu2);
        menuList = findViewById(R.id.linearLayoutMenu3);
        menuSetting = findViewById(R.id.linearLayoutMenu4);

        bindSelectorView(MENU_INSERT_DATA);

        initOnClickMenuEvent();
    }

    private void initOnClickMenuEvent(){
        iconDrawerMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                    drawerLayout.closeDrawer(GravityCompat.START);
                } else {
                    drawerLayout.openDrawer(GravityCompat.START);
                }
            }
        });
        menuInsertData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bindSelectorView(MENU_INSERT_DATA);
            }
        });
        menuCheckData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bindSelectorView(MENU_CHECK_DATA);
            }
        });
        menuList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bindSelectorView(MENU_LIST);
            }
        });
        menuSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bindSelectorView(MENU_SETTING);
            }
        });

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

    private void bindSelectorView(int position){
        selectorInsertData.setVisibility(View.INVISIBLE);
        selectorCheckData.setVisibility(View.INVISIBLE);
        selectorList.setVisibility(View.INVISIBLE);
        selectorSetting.setVisibility(View.INVISIBLE);
        switch (position){
            case MENU_INSERT_DATA:
                selectorInsertData.setVisibility(View.VISIBLE);
                break;
            case MENU_CHECK_DATA:
                selectorCheckData.setVisibility(View.VISIBLE);
                break;
            case MENU_LIST:
                selectorList.setVisibility(View.VISIBLE);
                break;
            case MENU_SETTING:
                selectorSetting.setVisibility(View.VISIBLE);
                break;

        }
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
