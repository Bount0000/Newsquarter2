package com.lenovo.bount.newsquarter.activitybao;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.RelativeLayout;

import com.lenovo.bount.newsquarter.R;
import com.lenovo.bount.newsquarter.base.BaseActivity;
import com.lenovo.bount.newsquarter.base.BasePresenter;
import com.lenovo.bount.newsquarter.bean.BanbenUpdate;
import com.lenovo.bount.newsquarter.presenter.UpdataPresenter;
import com.lenovo.bount.newsquarter.view.UpdateView;

import java.util.ArrayList;
import java.util.List;

public class ShezhiActivity extends BaseActivity implements UpdateView{
    private RelativeLayout rt_banben;
    private UpdataPresenter presenter;

    @Override
    public int bindLayout() {
        return R.layout.activity_shezhi;
    }

    @Override
    public void setLister() {
        rt_banben.setOnClickListener(this);
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
                   }
               });
               alerdialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
               @Override
               public void onClick(DialogInterface dialogInterface, int i) {

               }
           });
            alerdialog.create().show();
               break;
       }
    }

    @Override
    public void initView()
    {
        setshowActionBar(false);
        rt_banben = findViewById(R.id.rt_banben);
    }

    @Override
    public void initDate() {
        presenter = new UpdataPresenter(ShezhiActivity.this);
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
        String apkUrl = data.apkUrl;
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
