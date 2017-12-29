package com.tenzliu.tenzbottomlayoutbar.newview;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.MenuItem;
import android.view.View;

import com.tenzliu.tenzbottomlayoutbar.R;
import com.tenzliu.tenzbottomlayoutbar.fragment.TabFragment;
import com.tenzliu.tenzbottomlayoutbar.util.BottomNavigationViewHelper;
import com.tenzliu.tenzbottomlayoutbar.widget.bottomlayoutbar.BottomNavigationViewEx;

import q.rorbin.badgeview.Badge;
import q.rorbin.badgeview.QBadgeView;

/**
 * Author: TenzLiu
 * Date: 2017-12-28 10:32
 * Description: TODO
 */

public class NewViewActivity extends FragmentActivity {

    private BottomNavigationViewEx bnv_bottom_layoutbar;

    private TabFragment homeFragment;
    private TabFragment findFragment;
    private TabFragment addFragment;
    private TabFragment shopcarFragment;
    private TabFragment mineFragment;

    private Badge badge;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newview);
        initView();
        initData();
    }

    private void initView() {
        bnv_bottom_layoutbar = findViewById(R.id.bnv_bottom_layoutbar);
        BottomNavigationViewHelper.disableShiftMode(bnv_bottom_layoutbar);
        initFragment();
        bnv_bottom_layoutbar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.menu_home:
                        homeFragment.getTv_fragment().setText("Home");
                        switchToFragment(0);
                        badge.setBadgeNumber(0).hide(true);
                        break;
                    case R.id.menu_find:
                        findFragment.getTv_fragment().setText("Find");
                        switchToFragment(1);
                        break;
                    case R.id.menu_add:
                        addFragment.getTv_fragment().setText("Add");
                        switchToFragment(2);
                        break;
                    case R.id.menu_shopcar:
                        shopcarFragment.getTv_fragment().setText("Shopcar");
                        switchToFragment(3);
                        break;
                    case R.id.menu_mine:
                        mineFragment.getTv_fragment().setText("Mine");
                        switchToFragment(4);
                        break;
                }
                return true;
            }
        });
        badge = new QBadgeView(this).bindTarget(bnv_bottom_layoutbar.getBottomNavigationItemView(3))
                .setBadgeNumber(5).setOnDragStateChangedListener(new Badge.OnDragStateChangedListener() {
                    @Override
                    public void onDragStateChanged(int dragState, Badge badge, View targetView) {

                    }
                });
    }

    private void initData() {

    }

    private void initFragment(){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        if(homeFragment == null){
            homeFragment = new TabFragment();
            fragmentTransaction.add(R.id.fl_container,homeFragment);
        }
        if(findFragment == null){
            findFragment = new TabFragment();
            fragmentTransaction.add(R.id.fl_container,findFragment);
        }
        if(addFragment == null){
            addFragment = new TabFragment();
            fragmentTransaction.add(R.id.fl_container,addFragment);
        }
        if(shopcarFragment == null){
            shopcarFragment = new TabFragment();
            fragmentTransaction.add(R.id.fl_container,shopcarFragment);
        }
        if(mineFragment == null){
            mineFragment = new TabFragment();
            fragmentTransaction.add(R.id.fl_container,mineFragment);
        }
        fragmentTransaction.commit();
        switchToFragment(0);
    }

    private void switchToFragment(int position) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        switch (position){
            case 0:
                fragmentTransaction.hide(findFragment);
                fragmentTransaction.hide(addFragment);
                fragmentTransaction.hide(shopcarFragment);
                fragmentTransaction.hide(mineFragment);
                fragmentTransaction.show(homeFragment);
                break;
            case 1:
                fragmentTransaction.hide(homeFragment);
                fragmentTransaction.hide(addFragment);
                fragmentTransaction.hide(shopcarFragment);
                fragmentTransaction.hide(mineFragment);
                fragmentTransaction.show(findFragment);
                break;
            case 2:
                fragmentTransaction.hide(homeFragment);
                fragmentTransaction.hide(findFragment);
                fragmentTransaction.hide(shopcarFragment);
                fragmentTransaction.hide(mineFragment);
                fragmentTransaction.show(addFragment);
                break;
            case 3:
                fragmentTransaction.hide(homeFragment);
                fragmentTransaction.hide(findFragment);
                fragmentTransaction.hide(addFragment);
                fragmentTransaction.hide(mineFragment);
                fragmentTransaction.show(shopcarFragment);
                break;
            case 4:
                fragmentTransaction.hide(homeFragment);
                fragmentTransaction.hide(findFragment);
                fragmentTransaction.hide(addFragment);
                fragmentTransaction.hide(shopcarFragment);
                fragmentTransaction.show(mineFragment);
                break;
        }
        fragmentTransaction.commitAllowingStateLoss();
    }

}
