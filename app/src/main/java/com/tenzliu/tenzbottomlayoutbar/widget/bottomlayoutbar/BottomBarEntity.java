package com.tenzliu.tenzbottomlayoutbar.widget.bottomlayoutbar;

/**
 * Author: TenzLiu
 * Date: 2017-11-09 16:47
 * Description: TODO
 */

public class BottomBarEntity {
    private String text;//标题
    private int normalIconId;//正常图标
    private int selectIconId;//选中图标
    private boolean isShowPoint;//是否显示未读红点
    private int newsCount;//未读数量，大于0显示
    private boolean isCenter;//是否中间凸起

    public boolean isCenter() {
        return isCenter;
    }

    public void setCenter(boolean center) {
        isCenter = center;
    }

    public int getNewsCount() {
        return newsCount;
    }

    public void setNewsCount(int newsCount) {
        this.newsCount = newsCount;
    }

    public boolean isShowPoint() {
        return isShowPoint;
    }

    public void setShowPoint(boolean showPoint) {
        isShowPoint = showPoint;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getNormalIconId() {
        return normalIconId;
    }

    public void setNormalIconId(int normalIconId) {
        this.normalIconId = normalIconId;
    }

    public int getSelectIconId() {
        return selectIconId;
    }

    public void setSelectIconId(int selectIconId) {
        this.selectIconId = selectIconId;
    }
}
