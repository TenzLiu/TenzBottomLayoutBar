package com.tenzliu.tenzbottomlayoutbar.util;

import android.content.Context;
import android.util.DisplayMetrics;

import com.tenzliu.tenzbottomlayoutbar.app.AppApplication;


/**
 * User: Tenz Liu
 * Date: 2017-08-23
 * Time: 20-36
 * Description: 显示器工具类
 */

public class PixelUtil {

    public static Context mContext = AppApplication.getAppContext();

    /**
     * 获取屏幕宽度
     * @return
     */
    public static int getWindowWidth(){
        DisplayMetrics displayMetrics = mContext.getResources().getDisplayMetrics();
        int widthPixels = displayMetrics.widthPixels;
        return widthPixels;
    }

    /**
     * 获取屏幕高度
     * @return
     */
    public static int getWindowHeight(){
        DisplayMetrics displayMetrics = mContext.getResources().getDisplayMetrics();
        int heightPixels = displayMetrics.heightPixels;
        return heightPixels;
    }

    /**
     * px转dp
     * @param value
     * @return
     */
    public static int px2dp(int value){
        float scale = mContext.getResources().getDisplayMetrics().density;
        return (int) (value / scale + 0.5f);
    }

    /**
     * dp转px
     * @param value
     * @return
     */
    public static int dp2px(int value){
        float scale = mContext.getResources().getDisplayMetrics().density;
        return (int) (value * scale + 0.5f );
    }

    /**
     * px转sp
     * @param value
     * @return
     */
    public static int px2sp(int value){
        float scale = mContext.getResources().getDisplayMetrics().scaledDensity;
        return (int) (value / scale + 0.5f);
    }

    /**
     * sp转px
     * @param value
     * @return
     */
    private static int sp2px(int value){
        float scale = mContext.getResources().getDisplayMetrics().scaledDensity;
        return (int) (value * scale + 0.5f);
    }

}
