package com.lenovo.bount.newsquarter.activitybao;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.dou361.ijkplayer.widget.PlayStateParams;
import com.dou361.ijkplayer.widget.PlayerView;
import com.lenovo.bount.newsquarter.R;
import com.lenovo.bount.newsquarter.base.BaseActivity;
import com.lenovo.bount.newsquarter.base.BasePresenter;

import java.util.List;

public class Pbvideo1Activity extends BaseActivity {
    private RelativeLayout iv_play;
    private Button bt_next;
    private String videourl;

    @Override
    public int bindLayout() {
        return R.layout.activity_pbvideo1;
    }

    @Override
    public void setLister() {
        bt_next.setOnClickListener(this);
    }

    @Override
    public void Click(View view) {
    switch (view.getId())
    {
        case R.id.bt_next:
            Intent intent=new Intent(this,PbVideoActivity.class);
            intent.putExtra("videourl",videourl);
            startActivity(intent);
            break;
    }
    }

    @Override
    public void initView() {
        iv_play = findViewById(R.id.iv_play);
        bt_next = findViewById(R.id.bt_next);
    }
    @Override
    public void initDate() {
        Intent intent = getIntent();
        videourl = intent.getStringExtra("videourl");
        View view=View.inflate(this,R.layout.simple_player_view_player,iv_play);
        PlayerView playerView=new PlayerView(this,view);
        playerView.setTitle("视屏");
        playerView.setScaleType(PlayStateParams.fitparent);
        playerView.hideMenu(true);
        playerView.forbidTouch(false);
        playerView.setPlaySource(videourl);
        playerView.startPlay();
    }

    @Override
    public List<BasePresenter> initPresenter() {
        return null;
    }
}
