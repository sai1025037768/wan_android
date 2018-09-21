package com.zs.wanandroid.component;

import android.app.Activity;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Administrator
 * @name wanandroid
 * @time 2018/9/21 14:02
 * @class acvitity 统一管理类，一键退出app
 */
public class ActivityCollector {

    private static ActivityCollector activityCollector;

    public synchronized static ActivityCollector getInstance() {
        if (activityCollector == null) {
            activityCollector = new ActivityCollector();
        }

        return activityCollector;
    }

    private Set<Activity> allActivities;

    /**
     * 添加activity
     * @param activity
     */
    public void addActivity(Activity activity) {
        if (allActivities == null) {
            allActivities = new HashSet<>();
        }

        allActivities.add(activity);
    }

    /**
     * 移除指定activity
     * @param activity
     */
    public void removeActivity(Activity activity){
        if (allActivities != null){
            allActivities.remove(activity);
        }
    }

    /**
     * 退出app
     */
    public void exitApp(){
        if(allActivities != null){
            synchronized (allActivities) {
                for (Activity activity : allActivities) {
                    activity.finish();
                }
            }
        }

        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(0);
    }
}
