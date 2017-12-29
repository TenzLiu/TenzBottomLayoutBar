package com.tenzliu.tenzbottomlayoutbar.widget.bottomlayoutbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.tenzliu.tenzbottomlayoutbar.R;

/**
 * Author: TenzLiu
 * Date: 2017-11-09 16:47
 * Description: TODO
 */

public class BottomBarItemLayout extends LinearLayout {

    private int tabSize;

    public BottomBarItemLayout(Context context) {
        this(context, null);
    }

    public BottomBarItemLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BottomBarItemLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.BottomBarItemLayout);
        tabSize = typedArray.getInteger(R.styleable.BottomBarItemLayout_tabSize, 0);
        typedArray.recycle();  //注意回收
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int heightSize = 0;
        heightSize = MeasureSpec.getSize(heightMeasureSpec);
        setMeasuredDimension(getScreenWidth()/tabSize,heightSize);
    }

    private int getScreenWidth(){
        WindowManager wm = (WindowManager) getContext().getSystemService(
                Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(dm);
        return dm.widthPixels;
    }

}