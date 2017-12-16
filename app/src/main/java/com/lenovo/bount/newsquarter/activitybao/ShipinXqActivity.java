package com.lenovo.bount.newsquarter.activitybao;

import android.content.Intent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.dou361.ijkplayer.widget.PlayStateParams;
import com.dou361.ijkplayer.widget.PlayerView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.lenovo.bount.newsquarter.R;
import com.lenovo.bount.newsquarter.base.BaseActivity;
import com.lenovo.bount.newsquarter.base.BasePresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShipinXqActivity extends BaseActivity {

    @BindView(R.id.iv_icon)
    SimpleDraweeView ivUsertx;
    @BindView(R.id.rl_1)
    RelativeLayout rl1;
    @BindView(R.id.rl_player)
    RelativeLayout rlPlayer;
    @BindView(R.id.tv_1)
    TextView tv1;
    @BindView(R.id.tv_2)
    TextView tv2;
    @Override
    public int bindLayout() {
        return R.layout.activity_shipin_xq;
    }

    @Override
    public void setLister() {

    }

    @Override
    public void Click(View view) {

    }

    @Override
    public void initView() {
        setshowActionBar(false);
        ButterKnife.bind(this);
    }

    @Override
    public void initDate() {
        Intent intent = getIntent();
        String videoUrl = intent.getStringExtra("videoUrl");
        String icon = intent.getStringExtra("icon");
        View view=View.inflate(this,R.layout.simple_player_view_player,rlPlayer);
        PlayerView playerView=new PlayerView(this,view);
        playerView.setTitle("视屏");
        playerView.setScaleType(PlayStateParams.fitparent);
        playerView.hideMenu(true);
        playerView.forbidTouch(false);
        playerView.setPlaySource(videoUrl);
        playerView.startPlay();
        ivUsertx.setImageURI(icon);
    }

    @Override
    public List<BasePresenter> initPresenter() {
        return null;
    }

}
