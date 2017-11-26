package com.lenovo.bount.newsquarter;

import android.app.Application;
import android.content.Context;

import com.igexin.sdk.PushManager;
import com.squareup.leakcanary.LeakCanary;
import com.umeng.analytics.MobclickAgent;
/**
 * Created by lenovo on 2017/11/14.
 */
public class App extends Application{

    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
       // CrashReport.initCrashReport(getApplicationContext(), "19cd30b564", false);
        //友盟统计
        MobclickAgent.setScenarioType(getApplicationContext(), MobclickAgent.EScenarioType.E_UM_NORMAL);
        MobclickAgent. startWithConfigure(new MobclickAgent.UMAnalyticsConfig(this, "5a0a9488a40fa371720000c4", "Channel ID"));
        //检测内存泄漏
         LeakCanary.install(this);
         //个推
         PushManager.getInstance().initialize(this.getApplicationContext(),DemoPushService.class);
         PushManager.getInstance().registerPushIntentService(this.getApplicationContext(), DemoIntentService.class);
    }
}
