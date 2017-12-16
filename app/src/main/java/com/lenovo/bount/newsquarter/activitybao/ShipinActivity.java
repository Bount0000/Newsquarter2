package com.lenovo.bount.newsquarter.activitybao;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.lenovo.bount.newsquarter.R;
import com.lenovo.bount.newsquarter.base.BaseActivity;
import com.lenovo.bount.newsquarter.base.BasePresenter;

import java.util.List;

public class ShipinActivity extends BaseActivity {

    private ImageView iv_start;
    private ImageView iv_tu;
    private Uri uri;
    @Override
    public int bindLayout() {
        return R.layout.activity_shipin;
    }

    @Override
    public void setLister() {
        iv_start.setOnClickListener(this);
    }

    @Override
    public void Click(View view) {
    switch (view.getId())
    {
        case R.id.iv_start:
            Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
            intent.putExtra(MediaStore.EXTRA_VIDEO_QUALITY, 1);
            intent.putExtra(MediaStore.EXTRA_DURATION_LIMIT, 10);
            startActivityForResult(intent, 1);

            break;
    }
    }

    @Override
    public void initView() {
        setshowActionBar(false);
        iv_start = findViewById(R.id.iv_start);
        iv_tu = findViewById(R.id.iv_play);
    }

    @Override
    public void initDate() {
        Glide.with(this).load(R.drawable.dongtu).into(iv_tu);
    }

    @Override
    public List<BasePresenter> initPresenter() {
        return null;
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == ShipinActivity.RESULT_OK) {
                uri = null;
                if (data != null) {
                    uri = data.getData();//可以通过这个播放
                    Bundle bundle=new Bundle();
                    String[] proj = { MediaStore.Images.Media.DATA };
                    Cursor actualimagecursor = managedQuery(uri,proj,null,null,null);
                    int actual_image_column_index = actualimagecursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
                    actualimagecursor.moveToFirst();
                    String img_path = actualimagecursor.getString(actual_image_column_index);

                    Intent intent=new Intent(this,Pbvideo1Activity.class);
                    intent.putExtra("videourl",img_path);

                    startActivity(intent);
                    System.out.println("+++++++++视频路径+++++++++"+uri);
                    System.out.println("+++++++++视频路径+++++++++"+img_path);

                }
            }
        }
    }

}
