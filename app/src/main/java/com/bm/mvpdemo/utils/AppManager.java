package com.bm.mvpdemo.utils;

import android.app.Activity;

import java.util.Stack;

/**
 * Created by issuser on 2018/3/22.
 */

public class AppManager {
    private static Stack<Activity> activityStack;
    private static AppManager instance;

    private AppManager(){

    }

    public static AppManager getInstance(){
        if(instance==null){
            instance=new AppManager();
        }
        return instance;
    }

    public void addActivity(Activity activity){
        if(activityStack==null){
            activityStack=new Stack<>();
        }
        activityStack.add(activity);
    }

    /**
     * 获取当前栈中的最近一个进入的activity
     * @return
     */
    public Activity currentActivity(){
        Activity activity=activityStack.lastElement();
        return activity;
    }

    public void finishActivity(){
        Activity activity=activityStack.lastElement();
        finishActivity(activity);
    }
    /**
     * 结束指定的Activity
     */
    public void finishActivity(Activity activity) {
        if (activity != null) {
            activityStack.remove(activity);
            activity.finish();
            activity = null;
        }
    }

    public void finishActivity(Class<?> cls){
        Activity activity = null;
        for (Activity a : activityStack) {
            if (a.getClass().equals(cls)) {
                activity = a;
                break;
            }
        }
        if (activity != null)
            finishActivity(activity);
    }
    /**
     * 结束所有Activity
     */
    public void finishAllActivity() {
        for (int i = 0, size = activityStack.size(); i < size; i++) {
            if (null != activityStack.get(i)) {
                activityStack.get(i).finish();
            }
        }
        activityStack.clear();
    }

    /**
     * 退出应用程序
     */
    public void appExit() {
        finishAllActivity();
        System.exit(0);
    }
}
