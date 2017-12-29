package com.tenzliu.tenzbottomlayoutbar.normalcenter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tenzliu.tenzbottomlayoutbar.R;
import com.tenzliu.tenzbottomlayoutbar.fragment.TabFragment;

/**
 * Author: TenzLiu
 * Date: 2017-12-28 10:32
 * Description: TODO
 */

public class NormalCenterActivity extends FragmentActivity implements View.OnClickListener {

    private LinearLayout ll_home,ll_find,ll_add,ll_shopcar,ll_mine;
    private ImageView iv_home,iv_find,iv_add,iv_shopcar,iv_mine;
    private TextView tv_home,tv_find,tv_add,tv_shopcar,tv_mine;
    private TabFragment homeFragment;
    private TabFragment findFragment;
    private TabFragment addFragment;
    private TabFragment shopcarFragment;
    private TabFragment mineFragment;

    //底部导航栏
    private String[] bottomBarTitleList = new String[]{"首页","发现","添加","购物车","我"};
    private int[] bottomBarNormalIcons = new int[]{R.mipmap.tab_home_n,R.mipmap.tab_find_n,R.mipmap.tab_center,R.mipmap.tab_shopcar_n,R.mipmap.tab_mine_n};
    private int[] bottomBarSelectIcons = new int[]{R.mipmap.tab_home_s,R.mipmap.tab_find_s,R.mipmap.tab_center,R.mipmap.tab_shopcar_s,R.mipmap.tab_mine_s};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal_center);
        initView();
        initData();
    }

    private void initView() {
        ll_home = findViewById(R.id.ll_home);
        ll_find = findViewById(R.id.ll_find);
        ll_add = findViewById(R.id.ll_add);
        ll_shopcar = findViewById(R.id.ll_shopcar);
        ll_mine = findViewById(R.id.ll_mine);
        iv_home = findViewById(R.id.iv_home);
        iv_find = findViewById(R.id.iv_find);
        iv_add = findViewById(R.id.iv_add);
        iv_shopcar = findViewById(R.id.iv_shopcar);
        iv_mine = findViewById(R.id.iv_mine);
        tv_home = findViewById(R.id.tv_home);
        tv_find = findViewById(R.id.tv_find);
        tv_add = findViewById(R.id.tv_add);
        tv_shopcar = findViewById(R.id.tv_shopcar);
        tv_mine = findViewById(R.id.tv_mine);
        ll_home.setOnClickListener(this);
        ll_find.setOnClickListener(this);
        ll_add.setOnClickListener(this);
        ll_shopcar.setOnClickListener(this);
        ll_mine.setOnClickListener(this);
        initFragment();

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

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ll_home:
                choseTab(0);
                homeFragment.getTv_fragment().setText("Home");
                break;
            case R.id.ll_find:
                choseTab(1);
                findFragment.getTv_fragment().setText("Find");
                break;
            case R.id.ll_add:
                choseTab(2);
                addFragment.getTv_fragment().setText("Add");
                break;
            case R.id.ll_shopcar:
                choseTab(3);
                shopcarFragment.getTv_fragment().setText("Shopcar");
                break;
            case R.id.ll_mine:
                choseTab(4);
                mineFragment.getTv_fragment().setText("Mine");
                break;
        }
    }

    private void choseTab(int position) {
        switchToFragment(position);
        clearTab();
        switch (position){
            case 0:
                iv_home.setImageResource(bottomBarSelectIcons[position]);
                tv_home.setTextColor(getResources().getColor(R.color.colorAppSelect));
                break;
            case 1:
                iv_find.setImageResource(bottomBarSelectIcons[position]);
                tv_find.setTextColor(getResources().getColor(R.color.colorAppSelect));
                break;
            case 2:
                iv_add.setImageResource(bottomBarSelectIcons[position]);
                tv_add.setTextColor(getResources().getColor(R.color.colorAppSelect));
                break;
            case 3:
                iv_shopcar.setImageResource(bottomBarSelectIcons[position]);
                tv_shopcar.setTextColor(getResources().getColor(R.color.colorAppSelect));
                break;
            case 4:
                iv_mine.setImageResource(bottomBarSelectIcons[position]);
                tv_mine.setTextColor(getResources().getColor(R.color.colorAppSelect));
                break;
        }
    }

    private void clearTab(){
        iv_home.setImageResource(bottomBarNormalIcons[0]);
        iv_find.setImageResource(bottomBarNormalIcons[1]);
        iv_add.setImageResource(bottomBarNormalIcons[2]);
        iv_shopcar.setImageResource(bottomBarNormalIcons[3]);
        iv_mine.setImageResource(bottomBarNormalIcons[4]);
        tv_home.setTextColor(getResources().getColor(R.color.colorAppNormal));
        tv_find.setTextColor(getResources().getColor(R.color.colorAppNormal));
        tv_add.setTextColor(getResources().getColor(R.color.colorAppNormal));
        tv_shopcar.setTextColor(getResources().getColor(R.color.colorAppNormal));
        tv_mine.setTextColor(getResources().getColor(R.color.colorAppNormal));
    }

}
