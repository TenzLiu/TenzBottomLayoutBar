package com.tenzliu.tenzbottomlayoutbar.widget.bottomlayoutbar;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.tenzliu.tenzbottomlayoutbar.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: TenzLiu
 * Date: 2017-11-09 16:47
 * Description: 底部导航栏
 */

public class BottomBarLayout extends LinearLayout implements View.OnClickListener{

    private OnItemClickListener mOnItemClickListener;//item点击事件

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.mOnItemClickListener = onItemClickListener;
    }

    private int normalTextColor;//文本正常色值
    private int selectTextColor;//文本选中色值

    private LinearLayout mLinearLayout;//布局
    private List<BottomBarEntity> tabList;//item对象

    public BottomBarLayout(Context context) {
        super(context);
        init(context);
    }

    public BottomBarLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    /**
     * 初始化
     * @param context
     */
    private void init(Context context) {
        mLinearLayout = (LinearLayout) View.inflate(context, R.layout.layout_bottom_tab_layout,null);
        tabList = new ArrayList<>();
        addView(mLinearLayout);
    }

    /**
     * 设置正常色值
     * @param color
     */
    public void setNormalTextColor(int color){
        this.normalTextColor = color;
    }

    /**
     * 设置选中色值
     * @param color
     */
    public void setSelectTextColor(int color){
        this.selectTextColor = color;
    }

    /**
     * 设置item对象
     * @param tabs
     */
    public void setTabList(List<BottomBarEntity> tabs){
        if(tabs == null || tabs.size() == 0){
            return;
        }
        this.tabList.clear();
        this.tabList.addAll(tabs);
        mLinearLayout.removeAllViews();
        for (int i=0;i<tabs.size();i++) {
            View itemView = null;
            BottomBarEntity itemTab = tabList.get(i);
            itemView = View.inflate(getContext(), R.layout.item_bottom_tab_layout, null);
            itemView.setId(i);
            itemView.setOnClickListener(this);
            TextView text = itemView.findViewById(R.id.tv_title);
            ImageView icon = itemView.findViewById(R.id.iv_icon);
            View redPoint = itemView.findViewById(R.id.red_point);
            TextView number = itemView.findViewById(R.id.tv_count);
            text.setText(itemTab.getText());
            text.setTextColor(normalTextColor);
            icon.setImageResource(itemTab.getNormalIconId());
            if(itemTab.isShowPoint()){
                redPoint.setVisibility(View.VISIBLE);
            }else{
                redPoint.setVisibility(View.GONE);
            }
            if(itemTab.getNewsCount() == 0){
                number.setVisibility(View.GONE);
            }else if(itemTab.getNewsCount()>99){
                number.setVisibility(View.VISIBLE);
                number.setText("99+");
            }else {
                number.setVisibility(View.VISIBLE);
                number.setText(String.format("%d",itemTab.getNewsCount()));
            }
            mLinearLayout.addView(itemView);
            if(i==0){
                showTab(0,itemView);
            }
        }
    }

    @Override
    public void onClick(View view) {
        if(mOnItemClickListener == null){
            return;
        }
        switch(view.getId()){
            case 0:
                mOnItemClickListener.onItemClick(0);
                showTab(0,view);
                break;
            case 1:
                mOnItemClickListener.onItemClick(1);
                showTab(1,view);
                break;
            case 2:
                mOnItemClickListener.onItemClick(2);
                showTab(2,view);
                break;
            case 3:
                mOnItemClickListener.onItemClick(3);
                showTab(3,view);
                break;
            case 4:
                mOnItemClickListener.onItemClick(4);
                showTab(4,view);
                break;
        }
    }

    /**
     * 设置点击item样式
     * @param position
     * @param view
     */
    public void showTab(int position,View view){
        clearStatus();
        TextView text = view.findViewById(R.id.tv_title);
        text.setTextColor(selectTextColor);
        ImageView icon = view.findViewById(R.id.iv_icon);
        icon.setImageResource(tabList.get(position).getSelectIconId());

    }

    /**
     * 清除样式
     */
    private void clearStatus() {
        for (int i=0;i<mLinearLayout.getChildCount();i++){
            View itemView = mLinearLayout.getChildAt(i);
            ImageView icon = itemView.findViewById(R.id.iv_icon);
            TextView text = itemView.findViewById(R.id.tv_title);
            text.setTextColor(normalTextColor);
            icon.setImageResource(tabList.get(i).getNormalIconId());
        }
    }

    /**
     * 刷新未读红点以及未读数量
     * @param tabs
     */
    public void notifydatasetchanged(List<BottomBarEntity> tabs){
        if(tabs == null || tabs.size() == 0){
            return;
        }
        this.tabList.clear();
        this.tabList.addAll(tabs);
        for (int i=0;i<mLinearLayout.getChildCount();i++){
            View itemView = mLinearLayout.getChildAt(i);
            View redPoint = itemView.findViewById(R.id.red_point);
            TextView number = itemView.findViewById(R.id.tv_count);
            if(tabs.get(i).isShowPoint()){
                redPoint.setVisibility(View.VISIBLE);
            }else{
                redPoint.setVisibility(View.GONE);
            }
            if(tabs.get(i).getNewsCount() == 0){
                number.setVisibility(View.GONE);
            }else if(tabs.get(i).getNewsCount()>99){
                number.setVisibility(View.VISIBLE);
                number.setText("99+");
            }else {
                number.setVisibility(View.VISIBLE);
                number.setText(String.format("%d",tabs.get(i).getNewsCount()));
            }
        }
    }

}
