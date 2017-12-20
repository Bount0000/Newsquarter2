package com.lenovo.bount.newsquarter.activitybao;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lenovo.bount.newsquarter.R;
import com.lenovo.bount.newsquarter.base.BaseActivity;
import com.lenovo.bount.newsquarter.base.BasePresenter;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.List;
import java.util.Map;

/**
 * Created by lenovo on 2017/12/16.
 */

public class QQsanActivity extends BaseActivity {

    private Button btn_jicheng;
    private UMAuthListener umAuthListener;
    private ImageView iv;
    private TextView tv_name;

    @Override
    public int bindLayout() {
        return R.layout.qqsan_layout;
    }

    @Override
    public void setLister() {
        btn_jicheng.setOnClickListener(this);
    }

    @Override
    public void Click(View view) {
        switch (view.getId())
        {
            case R.id.btn_jicheng:
                UMShareAPI.get(QQsanActivity.this).getPlatformInfo(QQsanActivity.this, SHARE_MEDIA.QQ,umAuthListener);
                umAuthListener = new UMAuthListener() {
                    @Override public void onStart(SHARE_MEDIA share_media) {
                    }
                    @Override public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {
                        String name=map.get("name");
                        String iconurl=map.get("iconurl");
                        System.out.printf("=====name====="+name);
                        System.out.printf("=====iconurl====="+iconurl);
                        tv_name.setText(name);
                        Glide.with(QQsanActivity.this).load(iconurl).into(iv);
                    }
                    @Override public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {
                    }
                    @Override public void onCancel(SHARE_MEDIA share_media, int i) {
                    }
                };
                break;
        }
    }

    @Override
    public void initView() {
        iv = findViewById(R.id.iv);
        tv_name = findViewById(R.id.tv_name);
        btn_jicheng = findViewById(R.id.btn_jicheng);
    }
    @Override
    public void initDate() {

    }

    @Override
    public List<BasePresenter> initPresenter() {
        return null;
    }
    @Override
      protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }
}
