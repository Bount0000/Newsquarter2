package com.lenovo.bount.newsquarter.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.dou361.ijkplayer.listener.OnShowThumbnailListener;
import com.dou361.ijkplayer.widget.PlayStateParams;
import com.dou361.ijkplayer.widget.PlayerView;
import com.lenovo.bount.newsquarter.R;
import com.lenovo.bount.newsquarter.bean.RmSpBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by lenovo on 2017/12/1.
 */

public class SpRemenAdapter extends RecyclerView.Adapter<SpRemenAdapter.MyHolder> {
    private Context context;
    private List<RmSpBean.DataBean> dataBeanList;
    private  List<Integer> heightList;

    public SpRemenAdapter(Context context, List<RmSpBean.DataBean> dataBeanList){
        this.context = context;
        this.dataBeanList = dataBeanList;
        heightList = new ArrayList<>();
        for (int i = 0; i < dataBeanList.size(); i++) {
            int height = new Random().nextInt(400) + 100;//[100,300)的随机数
            heightList.add(height);
        }
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=View.inflate(context,R.layout.spitem_layout,null);
        return new MyHolder(view);

    }
    @Override
    public void onBindViewHolder(MyHolder holder, final int position) {
        System.out.println(dataBeanList.size()+"++++++++++++++++++++++++++++++");
        View view=View.inflate(context,R.layout.simple_player_view_player,holder.rl_play);
        String videoUrl = dataBeanList.get(position).videoUrl;
        String replace = videoUrl.replace("https://www.zhaoapi.cn", "http://120.27.23.105");
        System.out.println("=====获取热门视屏Adapter======"+videoUrl);
        ViewGroup.LayoutParams params = holder.rl_play.getLayoutParams();
        params.height=heightList.get(position);
        holder.rl_play.setLayoutParams(params);
        PlayerView playerView=new PlayerView((Activity) context,view);
        playerView.setTitle("视屏");
        playerView.setScaleType(PlayStateParams.fitparent);
        playerView.hideMenu(true);
        playerView.forbidTouch(false);
        playerView.setPlaySource(replace);
        playerView.startPlay();
        playerView.showThumbnail(new OnShowThumbnailListener() {
            @Override
            public void onShowThumbnail(ImageView ivThumbnail) {
                Glide.with(context).load(dataBeanList.get(position).cover).into(ivThumbnail);
            }
        });
    }
    @Override
    public int getItemCount() {
        return dataBeanList.size();
    }

    class  MyHolder extends RecyclerView.ViewHolder
    {
        private final RelativeLayout rl_play;
        public MyHolder(View itemView) {
            super(itemView);
            rl_play = itemView.findViewById(R.id.rl_play);
        }
    }
}
