package com.lenovo.bount.newsquarter.adapter;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.dou361.ijkplayer.listener.OnShowThumbnailListener;
import com.dou361.ijkplayer.widget.PlayStateParams;
import com.dou361.ijkplayer.widget.PlayerView;
import com.lenovo.bount.newsquarter.App;
import com.lenovo.bount.newsquarter.R;
import com.lenovo.bount.newsquarter.activitybao.GuanzhuActivity;
import com.lenovo.bount.newsquarter.bean.Getuser;
import com.lenovo.bount.newsquarter.bean.Userbean2;

import java.util.List;

/**
 * Created by lenovo on 2017/11/29.
 */

public class GetUserVideoAd extends RecyclerView.Adapter<GetUserVideoAd.MyHolder> {
    private int a=0;
    private ObjectAnimator animator;
    private ObjectAnimator fanimator;
    private ObjectAnimator animator1;
    private ObjectAnimator fanimator1;
    private ObjectAnimator animator2;
    private ObjectAnimator fanimator2;
    private ObjectAnimator animator3;
    private ObjectAnimator fanimator3;
    private Context context;
    private Userbean2.DataBean userdata;
    private List<Getuser.DataBean> datalist ;
    private View view3;

    public GetUserVideoAd(Context context,  List<Getuser.DataBean> datalist,Userbean2.DataBean userdata) {
        this.context = context;
        this.datalist = datalist;
        this.userdata=userdata;
    }
    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=View.inflate(context, R.layout.getvedio_item,null);
        return new MyHolder(view);
    }
    @Override
    public void onBindViewHolder(final MyHolder holder, final int position) {
         holder.setIsRecyclable(false);
        holder.iv_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context,GuanzhuActivity.class);
                int uid = datalist.get(position).uid;
                intent.putExtra("uid",uid);
                 context.startActivity(intent);
            }
        });
         holder.itemView.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  Toast.makeText(context, "点击", Toast.LENGTH_SHORT).show();
              }
          });
           holder.tv_time.setText(datalist.get(position).createTime);

           holder.tv_name.setText(userdata.nickname);

        Glide.with(context).load(userdata.icon).asBitmap().centerCrop().into(new BitmapImageViewTarget(holder.iv_icon) {
            @Override
            protected void setResource(Bitmap resource) {
                RoundedBitmapDrawable circularBitmapDrawable =
                        RoundedBitmapDrawableFactory.create(App.context.getResources(), resource);
                circularBitmapDrawable.setCircular(true);
                holder.iv_icon.setImageDrawable(circularBitmapDrawable);
            }
        });
         view3 = View.inflate(context, R.layout.simple_player_view_player,holder.rt_video);
        String videoUrl = datalist.get(position).videoUrl;
        String replace = videoUrl.replace("https://www.zhaoapi.cn", "http://120.27.23.105");
        System.out.println("===videoUrl====="+replace);
        PlayerView playerView=new PlayerView((Activity) context,view3);
        playerView.setTitle("视屏");
        playerView.setScaleType(PlayStateParams.fitparent);
        playerView.hideMenu(true);
        playerView.forbidTouch(false);
        playerView.setPlaySource(replace);
        playerView.startPlay();

        //为视屏添加封面
        playerView.showThumbnail(new OnShowThumbnailListener() {
            @Override
            public void onShowThumbnail(ImageView ivThumbnail) {
              Glide.with(context).load(datalist.get(position).cover).into(ivThumbnail);
            }
        });
        //-----伸出时的动画
        animator = ObjectAnimator.ofFloat(holder.iv_1, "rotation", 0f, 180f);
        animator1 = ObjectAnimator.ofFloat(holder.iv_animation1, "translationX", 0f,-80f);
        animator2 = ObjectAnimator.ofFloat(holder.iv_animation2, "translationX", 0f,-160f);
        animator3 = ObjectAnimator.ofFloat(holder.iv_animation3, "translationX", 0f,-240f);
        //----缩回时的动画
        fanimator = ObjectAnimator.ofFloat(holder.iv_1, "rotation", 0f, -180f);
        fanimator1 = ObjectAnimator.ofFloat(holder.iv_animation1, "translationX", -80f,0f);
        fanimator2 = ObjectAnimator.ofFloat(holder.iv_animation2, "translationX", -160f,0f);
        fanimator3 = ObjectAnimator.ofFloat(holder.iv_animation3, "translationX", -240f,0f);
       //给伸出动画设置监听

        animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                holder.iv_1.setImageResource(R.mipmap.icon_open);//动画结束改变图片
                holder.tv1.setVisibility(View.GONE);
                holder.tv2.setVisibility(View.GONE);
                holder.tv3.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });

       //给缩回动画设置监听

        fanimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                holder.iv_1.setImageResource(R.mipmap.icon_open);//改变图片
                holder.tv1.setVisibility(View.GONE);
                holder.tv2.setVisibility(View.GONE);
                holder.tv3.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
         holder.iv_1.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {

              holder.tv1.setVisibility(View.VISIBLE);
              holder.tv2.setVisibility(View.VISIBLE);
              holder.tv3.setVisibility(View.VISIBLE);
              a++;
              if(a%2==1)
              {
                  AnimatorSet animSet = new AnimatorSet();//动画集合
                  animSet.play(animator).with(animator1).with(animator2).with(animator3);
                  animSet.setDuration(1000);
                  animSet.start();
              }
              else
              {
                  AnimatorSet animSet1 = new AnimatorSet();//动画集合
                  animSet1.play(fanimator).with(fanimator1).with(fanimator2).with(fanimator3);
                  animSet1.setDuration(1000);
                  animSet1.start();
              }
          }
      });
    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }

    class MyHolder extends RecyclerView.ViewHolder
    {

        private final ImageView iv_icon;
        private final TextView tv_time;
        private final TextView tv_name;
        private final TextView tv_cotent;
        private final ImageView iv_1;
        private final LinearLayout iv_animation1;
        private final LinearLayout iv_animation2;
        private final LinearLayout iv_animation3;
        private final TextView tv1;
        private final TextView tv2;
        private final TextView tv3;
        private final RecyclerView rv_2;
        private final RelativeLayout rt_video;

        public MyHolder(View itemView) {
            super(itemView);
            iv_icon= itemView.findViewById(R.id.iv_icon);
            tv_time = itemView.findViewById(R.id.tv_time);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_cotent = itemView.findViewById(R.id.tv_cotent);
            iv_1 = itemView.findViewById(R.id.iv_animation);
            iv_animation1 = itemView.findViewById(R.id.iv_animation1);
            iv_animation2 = itemView.findViewById(R.id.iv_animation2);
            iv_animation3 = itemView.findViewById(R.id.iv_animation3);
            tv1 = itemView.findViewById(R.id.tv1);
            tv2 = itemView.findViewById(R.id.tv2);
            tv3 = itemView.findViewById(R.id.tv3);
            rv_2 = itemView.findViewById(R.id.rv_2);
            rt_video = itemView.findViewById(R.id.rt_video);
        }
    }
}
