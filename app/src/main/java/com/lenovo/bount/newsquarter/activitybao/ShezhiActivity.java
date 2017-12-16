package com.lenovo.bount.newsquarter.activitybao;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lenovo.bount.newsquarter.R;
import com.lenovo.bount.newsquarter.base.BaseActivity;
import com.lenovo.bount.newsquarter.base.BasePresenter;
import com.lenovo.bount.newsquarter.bean.BanbenUpdate;
import com.lenovo.bount.newsquarter.presenter.UpdataPresenter;
import com.lenovo.bount.newsquarter.utils.ClearCacheUtils;
import com.lenovo.bount.newsquarter.view.UpdateView;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import okhttp3.internal.Version;

public class ShezhiActivity extends BaseActivity implements UpdateView{
    private RelativeLayout rt_banben;
    private UpdataPresenter presenter;
    private Version version;
    private String apkUrl;
    private Callback.Cancelable cancelable;//请求任务对象
    private ProgressDialog progress;
    private int qianversionCode;
    private RelativeLayout clear_rt;
    private TextView she_tv_hcnum;
    private ClearCacheUtils clearCacheUtils;
    private String totalCacheSize;

    @Override
    public int bindLayout() {
        return R.layout.activity_shezhi;
    }

    @Override
    public void setLister() {
        rt_banben.setOnClickListener(this);
        clear_rt.setOnClickListener(this);
    }
    @Override
    public void Click(View view) {
       switch (view.getId())
       {
           case R.id.rt_banben:
               AlertDialog.Builder alerdialog=new AlertDialog.Builder(this);
               alerdialog.setMessage("是否更新下载");
               alerdialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialogInterface, int i) {
                       presenter.getupdate();
                       System.out.println("===走====");
                       downloadApk();
                     /*  if(MyInterceptor.versioncode < qianversionCode)
                       {
                           //下载服务器的Apk
                       }*/
                   }
               });
               alerdialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
               @Override
               public void onClick(DialogInterface dialogInterface, int i) {

               }
           });
            alerdialog.create().show();
               break;
           case R.id.clear_rt:
               final AlertDialog.Builder clearBuilder = new AlertDialog.Builder(this);
               clearBuilder.setTitle("清理缓存");
               clearBuilder.setMessage("确定要清理缓存？");
               clearBuilder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialogInterface, int i) {

                   }
               });
               clearBuilder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialogInterface, int i) {
                       //清除缓存功能
                       clearCacheUtils.clearAllCache(ShezhiActivity.this);
                       try {
                           totalCacheSize = clearCacheUtils.getTotalCacheSize(ShezhiActivity.this);
                       } catch (Exception e) {
                           e.printStackTrace();
                       }
                       she_tv_hcnum.setText(totalCacheSize);
                   }
               });

               clearBuilder.show();

               break;
       }
    }

    @Override
    public void initView()
    {
        setshowActionBar(false);
        rt_banben = findViewById(R.id.rt_banben);
        clear_rt = findViewById(R.id.clear_rt);
        she_tv_hcnum = findViewById(R.id.she_tv_hcnum);










    }
    @Override
    public void initDate() {
        presenter = new UpdataPresenter(ShezhiActivity.this);
        initProgerss();

        clearCacheUtils = new ClearCacheUtils();
        //获取缓存大小
        try {
            totalCacheSize = clearCacheUtils.getTotalCacheSize(this);
            she_tv_hcnum.setText(totalCacheSize);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void initProgerss() {
        progress = new ProgressDialog(this);
        progress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progress.setButton(ProgressDialog.BUTTON_NEGATIVE, "暂停", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //取消下载任务
                cancelable.cancel();
            }
        });
    }
    @Override
    public List<BasePresenter> initPresenter() {
        List<BasePresenter> presenterList=new ArrayList<>();
        presenterList.add(presenter);
        return presenterList;
    }

    @Override
    public void Success(BanbenUpdate value) {
        showToast(value.msg);
        BanbenUpdate.DataBean data = value.data;
        apkUrl = data.apkUrl;
        String versionCode = data.versionCode;
        qianversionCode = Integer.parseInt(versionCode);
        System.out.println("==qianversionCode===="+qianversionCode);
    }
    private void install(File file) {
        //调用系统安装器
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setDataAndType(Uri.parse("file://" + file.getAbsolutePath()), "application/vnd.android.package-archive");
        startActivity(intent);
    }
    private void downloadApk() {
        RequestParams param=new RequestParams(apkUrl);
        param.setAutoRename(true);//设置是否支持断点下载
        param.setCancelFast(true);//设置是否立即取消
        cancelable= x.http().get(param, new Callback.ProgressCallback<File>() {
            @Override
            public void onSuccess(File result) {
                 progress.dismiss();
                 install(result);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }

            @Override
            public void onWaiting() {

            }

            @Override
            public void onStarted() {
                progress.show();
            }

            @Override
            public void onLoading(long total, long current, boolean isDownloading) {
             if(isDownloading)
             {
                progress.setMax((int) total);
                progress.setProgress((int) current);
             }
            }
        });

    }

    @Override
    public void Error(String msg) {
           showToast(msg);
    }

    @Override
    public void onFair(Throwable e) {
        showToast(e.toString());
    }

    @Override
    public void Token(String msg) {
        showToast(msg);
    }
}
