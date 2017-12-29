package com.tenzliu.tenzbottomlayoutbar.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tenzliu.tenzbottomlayoutbar.R;

/**
 * Author: TenzLiu
 * Date: 2017-12-27 23:06
 * Description: TODO
 */

public class TabFragment extends Fragment {

    private TextView tv_fragment;

    public TextView getTv_fragment() {
        return tv_fragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab,container,false);
        initView(view);
        initData();
        return view;
    }

    private void initView(View view) {
        tv_fragment = view.findViewById(R.id.tv_fragment);
    }

    private void initData() {

    }

}
