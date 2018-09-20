package com.zyw.horrarndoo.yizhi.global;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

import com.ego.shadow.Shadow;
import com.tencent.bugly.crashreport.CrashReport;
import com.zyw.horrarndoo.sdk.global.GlobalApplication;
import com.zyw.horrarndoo.yizhi.R;
import com.zyw.horrarndoo.yizhi.ui.activity.MainActivity;

/**
 * Created by Horrarndoo on 2017/9/6.
 * <p>
 */

public class MyApplication extends GlobalApplication {
    //这个key是自己在聚合数据申请的key，需要自己去聚合数据申请
    public static final String JU_HE_APP_KEY = "799b785ba7b97223be80534651dd0d63";
    public static int SCREEN_WIDTH = -1;
    public static int SCREEN_HEIGHT = -1;
    public static float DIMEN_RATE = -1.0F;
    public static int DIMEN_DPI = -1;
    public static MyApplication app;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        //初始化屏幕宽高
        getScreenSize();

        CrashReport.initCrashReport(getApplicationContext(), "c73ecc54da", false);

//        Shadow.image(R.drawable.ic_splash);
        Shadow.image(R.mipmap.bg_flash);
        Shadow.init("michael20180920lhbd", MainActivity.class);
    }

    public void getScreenSize() {
        WindowManager windowManager = (WindowManager) this.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        Display display = windowManager.getDefaultDisplay();
        display.getMetrics(dm);
        DIMEN_RATE = dm.density / 1.0F;
        DIMEN_DPI = dm.densityDpi;
        SCREEN_WIDTH = dm.widthPixels;
        SCREEN_HEIGHT = dm.heightPixels;
        if (SCREEN_WIDTH > SCREEN_HEIGHT) {
            int t = SCREEN_HEIGHT;
            SCREEN_HEIGHT = SCREEN_WIDTH;
            SCREEN_WIDTH = t;
        }
    }
}
