package com.tenzliu.tenzbottomlayoutbar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.tenzliu.tenzbottomlayoutbar.adapter.MainAdapter;
import com.tenzliu.tenzbottomlayoutbar.fragment.TabFragment;
import com.tenzliu.tenzbottomlayoutbar.newview.NewViewActivity;
import com.tenzliu.tenzbottomlayoutbar.newviewcenter.NewViewCenterActivity;
import com.tenzliu.tenzbottomlayoutbar.normal.NormalActivity;
import com.tenzliu.tenzbottomlayoutbar.normalcenter.NormalCenterActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainAdapter.OnItemClickListener {

    private RecyclerView rcv_main;
    private MainAdapter mainAdapter;
    private List<String> mList = new ArrayList<>();
    String[] stringArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initView() {
        rcv_main = findViewById(R.id.rcv_main);
        rcv_main.setLayoutManager(new LinearLayoutManager(this));
        mainAdapter = new MainAdapter(this, mList, this);
        rcv_main.setAdapter(mainAdapter);

    }

    private void initData() {
        stringArray = getResources().getStringArray(R.array.main_list);
        for (int i = 0; i < stringArray.length; i++) {
            mList.add(stringArray[i]);
        }
        mainAdapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(int position) {
        String str = mList.get(position);
        if(str.equals(stringArray[0])){
            //普通底部导航栏(normal_bottom_layout_bar)
            startActivity(new Intent(this, NormalActivity.class));
        }else if(str.equals(stringArray[1])){
            //普通底部导航栏（中间悬浮）(normal_bottom_layout_bar_center)
            startActivity(new Intent(this, NormalCenterActivity.class));
        }else if(str.equals(stringArray[2])){
            //新控件底部导航栏(new_bottom_layout_bar)
            startActivity(new Intent(this, NewViewActivity.class));
        }else if(str.equals(stringArray[3])){
            //新控件底部导航栏（中间悬浮）(new_bottom_layout_bar_center)
            startActivity(new Intent(this, NewViewCenterActivity.class));
        }
    }

}
