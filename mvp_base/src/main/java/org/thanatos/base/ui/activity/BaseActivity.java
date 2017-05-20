package org.thanatos.base.ui.activity;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;

import org.thanatos.base.manager.DeviceManager;
import org.thanatos.base.model.SharePreferenceManager;
import org.thanatos.base.model.SharePreferenceManager.ApplicationSetting;
import org.thanatos.base.model.SharePreferenceManager.ApplicationSetting.ApplicationTheme;

import java.text.SimpleDateFormat;
import java.util.Date;

import nucleus.presenter.Presenter;
import nucleus.view.NucleusActivity;

public abstract class BaseActivity<P extends Presenter> extends NucleusActivity<P> {

    public String ClassName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ClassName="BaseActivity";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Log.d("AlertMessage","Activity "+ClassName+"正在执行onCreate 被创建了  时间:"+formatter.format(new Date()));
        super.onCreate(savedInstanceState);

        // 主题选择
        SharedPreferences preferences = SharePreferenceManager.getApplicationSetting(this);

        int theme = preferences.getInt(ApplicationSetting.KEY_THEME, ApplicationTheme.LIGHT.getKey());

        if (theme == ApplicationTheme.LIGHT.getKey()){
            setTheme(ApplicationTheme.LIGHT.getResId());
        }else if(theme == ApplicationTheme.DARK.getKey()){
            setTheme(ApplicationTheme.DARK.getResId());
        }

        // 方向锁定
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Log.d("AlertMessage","Activity "+ClassName+"完成执行onCreate 时间:"+formatter.format(new Date()));
    }

    @Override
    protected void onPause() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Log.d("AlertMessage","Activity "+ClassName+"正在执行onPause 看不到了 时间:"+formatter.format(new Date()));
        super.onPause();
        if (isFinishing()){
            DeviceManager.hideSoftInput(this, getCurrentFocus());
        }
        Log.d("AlertMessage","Activity "+ClassName+"完成执行onResume 时间:"+formatter.format(new Date()));
    }

    @Override
    protected void onDestroy() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Log.d("AlertMessage","Activity "+ClassName+"正在执行onDestroy 被销毁了  时间:"+formatter.format(new Date()));
        super.onDestroy();
        Log.d("AlertMessage","Activity "+ClassName+"完成执行onDestroy 时间:"+formatter.format(new Date()));
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Log.d("AlertMessage","Activity "+ClassName+"正在执行onRestoreInstanceState 正在恢复数据  时间:"+formatter.format(new Date()));
        super.onRestoreInstanceState(savedInstanceState);
        Log.d("AlertMessage","Activity "+ClassName+" 完成恢复数据  时间:"+formatter.format(new Date()));
    }

    @Override
    protected void onResume() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Log.d("AlertMessage","Activity "+ClassName+"正在执行onResume 正要已经出现  时间:"+formatter.format(new Date()));
        super.onResume();
        Log.d("AlertMessage","Activity "+ClassName+"完成执行onResume 时间:"+formatter.format(new Date()));
    }

    @Override
    protected void onStop() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Log.d("AlertMessage","Activity "+ClassName+"正在执行onStop 退出前台了  时间:"+formatter.format(new Date()));
        super.onStop();
        Log.d("AlertMessage","Activity "+ClassName+"完成执行onStop 时间:"+formatter.format(new Date()));
    }

    @Override
    protected void onStart() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Log.d("AlertMessage","Activity "+ClassName+"正在执行onStart 正在显示出来  时间:"+formatter.format(new Date()));
        super.onStart();
        Log.d("AlertMessage","Activity "+ClassName+"完成执行onStart 时间:"+formatter.format(new Date()));
    }
}
