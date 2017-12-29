package com.tenzliu.tenzbottomlayoutbar.normal;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.widget.TextView;

import com.tenzliu.tenzbottomlayoutbar.R;
import com.tenzliu.tenzbottomlayoutbar.fragment.TabFragment;
import com.tenzliu.tenzbottomlayoutbar.widget.bottomlayoutbar.BottomBarEntity;
import com.tenzliu.tenzbottomlayoutbar.widget.bottomlayoutbar.BottomBarLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: TenzLiu
 * Date: 2017-12-28 10:32
 * Description: TODO
 */

public class NormalActivity extends FragmentActivity {

    private BottomBarLayout bbl_nav;

    private TabFragment homeFragment;
    private TabFragment findFragment;
    private TabFragment shopcarFragment;
    private TabFragment mineFragment;

    //底部导航栏
    private List<BottomBarEntity> bottomBarEntityList;
    private String[] bottomBarTitleList = new String[]{"首页","发现","购物车","我"};
    private int[] bottomBarNormalIcons = new int[]{R.mipmap.tab_home_n,R.mipmap.tab_find_n,R.mipmap.tab_shopcar_n,R.mipmap.tab_mine_n};
    private int[] bottomBarSelectIcons = new int[]{R.mipmap.tab_home_s,R.mipmap.tab_find_s,R.mipmap.tab_shopcar_s,R.mipmap.tab_mine_s};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal);
        initView();
        initData();
    }

    private void initView() {
        bbl_nav = findViewById(R.id.bbl_nav);
        initFragment();
        initBottomLayoutBar();

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

    private void initBottomLayoutBar(){
        bottomBarEntityList = new ArrayList<>();
        for (int i=0;i<bottomBarTitleList.length;i++){
            BottomBarEntity bottomBarEntity = new BottomBarEntity();
            bottomBarEntity.setText(bottomBarTitleList[i]);
            bottomBarEntity.setNormalIconId(bottomBarNormalIcons[i]);
            bottomBarEntity.setSelectIconId(bottomBarSelectIcons[i]);
            if(i==1){
                bottomBarEntity.setShowPoint(true);
            }else{
                bottomBarEntity.setShowPoint(false);
            }
            if(i==2){
                bottomBarEntity.setNewsCount(6);
            }else{
                bottomBarEntity.setNewsCount(0);
            }
            bottomBarEntityList.add(bottomBarEntity);
        }
        bbl_nav.setNormalTextColor(getResources().getColor(R.color.colorAppNormal));
        bbl_nav.setSelectTextColor(getResources().getColor(R.color.colorAppSelect));
        bbl_nav.setTabList(bottomBarEntityList);
        bbl_nav.setOnItemClickListener(new BottomBarLayout.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                switchToFragment(position);
                switch(position){
                    case 0:
                        homeFragment.getTv_fragment().setText("Home");
                        //刷新底部导航栏
                        for (BottomBarEntity bottomBarEntity : bottomBarEntityList){
                            bottomBarEntity.setShowPoint(false);
                            bottomBarEntity.setNewsCount(0);
                        }
                        bbl_nav.notifydatasetchanged(bottomBarEntityList);
                        break;
                    case 1:
                        findFragment.getTv_fragment().setText("Find");
                        break;
                    case 2:
                        shopcarFragment.getTv_fragment().setText("Shopcar");
                        break;
                    case 3:
                        mineFragment.getTv_fragment().setText("Mine");
                        break;
                }
            }
        });
    }

    private void switchToFragment(int position) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        switch (position){
            case 0:
                fragmentTransaction.hide(findFragment);
                fragmentTransaction.hide(shopcarFragment);
                fragmentTransaction.hide(mineFragment);
                fragmentTransaction.show(homeFragment);
                break;
            case 1:
                fragmentTransaction.hide(homeFragment);
                fragmentTransaction.hide(shopcarFragment);
                fragmentTransaction.hide(mineFragment);
                fragmentTransaction.show(findFragment);
                break;
            case 2:
                fragmentTransaction.hide(homeFragment);
                fragmentTransaction.hide(findFragment);
                fragmentTransaction.hide(mineFragment);
                fragmentTransaction.show(shopcarFragment);
                break;
            case 3:
                fragmentTransaction.hide(homeFragment);
                fragmentTransaction.hide(findFragment);
                fragmentTransaction.hide(shopcarFragment);
                fragmentTransaction.show(mineFragment);
                break;
        }
        fragmentTransaction.commitAllowingStateLoss();
    }

}
