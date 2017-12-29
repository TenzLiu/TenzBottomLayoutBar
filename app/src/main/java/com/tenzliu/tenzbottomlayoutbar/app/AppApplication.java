package com.tenzliu.tenzbottomlayoutbar.app;

import android.app.Application;
import android.content.Context;

/**
 * Author: TenzLiu
 * Date: 2017-11-10 00:47
 * Description: TODO
 */

public class AppApplication extends Application {

    private static AppApplication appApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        appApplication = this;
    }

    public static Context getAppContext(){
        return appApplication;
    }

}
