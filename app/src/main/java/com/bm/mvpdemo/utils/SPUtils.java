package com.bm.mvpdemo.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.bm.mvpdemo.App;

/**
 * 共享参数类
 */
public class SPUtils {

    private static final String CONFIG = "config";
    private static final String CONFIG_SAVE ="config_save";

    public static void putGoodsString(String key,String value){
            SharedPreferences.Editor editor =getSharedPreference(CONFIG_SAVE).edit();
            editor.putString(key,value).apply();
    }

    public static String getGoodsString(String key,String defValue){
        SharedPreferences sharedPreferences =getSharedPreference(CONFIG_SAVE);
        return sharedPreferences.getString(key,defValue);
    }

    private static SharedPreferences getSharedPreference(String fileName){
        return App.getInstance().getSharedPreferences(fileName, Context.MODE_PRIVATE);
    }

    public static void putString(String key,String value){
        SharedPreferences.Editor editor =getSharedPreference(CONFIG).edit();
        editor.putString(key,value).apply();
    }

    public static String getString(String key,String defValue){
        SharedPreferences sharedPreference = getSharedPreference(CONFIG);
        return sharedPreference.getString(key, defValue);
    }
}
