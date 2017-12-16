package com.lenovo.bount.newsquarter.adapter;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
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
import com.lenovo.bount.newsquarter.bean.GetVideos;
import com.lenovo.bount.newsquarter.bean.ResponsBodyBean;
import com.lenovo.bount.newsquarter.interceptor.MyInterceptor;
import com.lenovo.bount.newsquarter.presenter.CommentPresenter;
import com.lenovo.bount.newsquarter.presenter.DianzanPresenter;
import com.lenovo.bount.newsquarter.view.CommentView;
import com.lenovo.bount.newsquarter.view.DianzanView;

import java.util.List;

/**
 * Created by lenovo on 2017/11/29.
 */

public class GetVideoAdapter extends RecyclerView.Adapter<GetVideoAdapter.MyHolder> implements View.OnClickListener,DianzanView,CommentView
{
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
    List<GetVideos.DataBean> dataBeanList;
    private View view3;
    private CommentPresenter commentPresenter;
    private int wid;
    private View view1;
    private PopupWindow popupwindow;
    private TextView pop_pass;
    private DianzanPresenter dianzanPresenter;

    public GetVideoAdapter(Context context, List<GetVideos.DataBean> dataBeanList) {
        this.context = context;
        this.dataBeanList = dataBeanList;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=View.inflate(context, R.layout.getvedio_item,null);
        return new MyHolder(view);

    }
    @Override
    public void onBindViewHolder(final MyHolder holder, final int position) {
        dianzanPresenter = new DianzanPresenter(this);
        commentPresenter=new CommentPresenter(this);
        wid = dataBeanList.get(position).wid;
        holder.iv_pinglun.setOnClickListener(this);
        holder.iv_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view1 = View.inflate(context, R.layout.zhuanfa_layout,null);
                popupwindow = new PopupWindow(view1);
                popupwindow.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
                popupwindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
                popupwindow.showAsDropDown(view1,120,800);
                popupwindow.showAtLocation(holder.rt_item,Gravity.BOTTOM,30,20);
            }
        });
       pop_pass.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               popupwindow.dismiss();
           }
       });
       holder.setIsRecyclable(false);

        holder.iv_aixin.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 dianzanPresenter.getDaianzan(MyInterceptor.uid,wid+"");
                 holder.iv_aixin.setImageResource(R.mipmap.x2);
             }
         });
        holder.iv_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context,GuanzhuActivity.class);
                int uid = dataBeanList.get(position).uid;
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
          holder.tv_time.setText(dataBeanList.get(position).createTime);
          holder.tv_name.setText(dataBeanList.get(position).user.nickname+"");

        Glide.with(context).load(dataBeanList.get(position).user.icon).asBitmap().centerCrop().into(new BitmapImageViewTarget(holder.iv_icon) {
            @Override
            protected void setResource(Bitmap resource) {
                RoundedBitmapDrawable circularBitmapDrawable =
                        RoundedBitmapDrawableFactory.create(App.context.getResources(), resource);
                circularBitmapDrawable.setCircular(true);
                holder.iv_icon.setImageDrawable(circularBitmapDrawable);
            }
        });
        view3 = View.inflate(context, R.layout.simple_player_view_player,holder.rt_video);
        String videoUrl = dataBeanList.get(position).videoUrl;
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
              Glide.with(context).load(dataBeanList.get(position).cover).into(ivThumbnail);
            }
        });

        holder.iv_animation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //-----伸出时的动画
                animator = ObjectAnimator.ofFloat(holder.iv_animation, "rotation", 0f, 180f);
                animator1 = ObjectAnimator.ofFloat(holder.iv_animation1, "translationX", 0f,-80f);
                animator2 = ObjectAnimator.ofFloat(holder.iv_animation2, "translationX", 0f,-160f);
                animator3 = ObjectAnimator.ofFloat(holder.iv_animation3, "translationX", 0f,-240f);
                holder.iv_shutdown.setVisibility(View.VISIBLE);
                holder.iv_animation.setVisibility(View.GONE);
                AnimatorSet set=new AnimatorSet();
                set.play(animator).with(animator1).with(animator2).with(animator3);
                set.setDuration(500);
                set.start();

                holder.tv1.setVisibility(View.VISIBLE);
                holder.tv2.setVisibility(View.VISIBLE);
                holder.tv3.setVisibility(View.VISIBLE);
            }
        });
       holder.iv_shutdown.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               holder.iv_shutdown.setVisibility(View.GONE);
               holder.iv_animation.setVisibility(View.VISIBLE);
               //----缩回时的动画
               fanimator = ObjectAnimator.ofFloat(holder.iv_animation, "rotation", 0f, -180f);
               fanimator1 = ObjectAnimator.ofFloat(holder.iv_animation1, "translationX", -80f,0f);
               fanimator2 = ObjectAnimator.ofFloat(holder.iv_animation2, "translationX", -160f,0f);
               fanimator3 = ObjectAnimator.ofFloat(holder.iv_animation3, "translationX", -240f,0f);

               AnimatorSet set2 = new AnimatorSet();
               set2.play(fanimator).with(fanimator1).with(fanimator2).with(fanimator3);
               set2.setDuration(500);
               set2.start();

               holder.tv1.setVisibility(View.GONE);
               holder.tv2.setVisibility(View.GONE);
               holder.tv3.setVisibility(View.GONE);
           }
       });
        }

    @Override
    public int getItemCount() {
        return dataBeanList.size();
    }

    @Override
    public void Success(ResponsBodyBean bodyBean) {

        Toast.makeText(context, bodyBean.msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void Error(String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void OnFair(String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }
    /*
     *点击事件
     */
    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.iv_pinglun:
                final EditText editText=new EditText(context);
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("说点什么吧......").setIcon(android.R.drawable.ic_dialog_info).setView(editText)
                        .setNegativeButton("取消", null);
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        String content = editText.getText().toString();
                        commentPresenter.getcomment(MyInterceptor.uid,wid+"",content);
                    }
                });
                builder.show();
                break;
            case R.id.pop_pass:
                break;

        }
    }

    @Override
    public void CommentSuccess(ResponsBodyBean bodyBean) {

        Toast.makeText(context, bodyBean.msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void CommentError(String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void CommentOnFair(String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

    class MyHolder extends RecyclerView.ViewHolder
    {

        private final ImageView iv_icon;
        private final TextView tv_time;
        private final TextView tv_name;
        private final ImageView iv_animation;

        private final LinearLayout iv_animation1;
        private final LinearLayout iv_animation2;
        private final LinearLayout iv_animation3;
        private final TextView tv1;
        private final TextView tv2;
        private final TextView tv3;
        private final RelativeLayout rt_video;
        private final ImageView iv_shutdown;
        private final ImageView iv_aixin;
        private final ImageView iv_xing;
        private final TextView tv_aixin;
        private final TextView tv_xing;
        private final ImageView iv_pinglun;
        private final ImageView iv_share;
        private final RelativeLayout rt_item;


        public MyHolder(View itemView) {
            super(itemView);
            iv_icon= itemView.findViewById(R.id.iv_icon);
            tv_time = itemView.findViewById(R.id.tv_time);
            tv_name = itemView.findViewById(R.id.tv_name);
            iv_animation = itemView.findViewById(R.id.iv_animation);
            iv_animation1 = itemView.findViewById(R.id.iv_animation1);
            iv_animation2 = itemView.findViewById(R.id.iv_animation2);
            iv_animation3 = itemView.findViewById(R.id.iv_animation3);
            iv_shutdown = itemView.findViewById(R.id.iv_shutdown);
            tv1 = itemView.findViewById(R.id.tv1);
            tv2 = itemView.findViewById(R.id.tv2);
            tv3 = itemView.findViewById(R.id.tv3);
            rt_video = itemView.findViewById(R.id.rt_video);
            iv_aixin = itemView.findViewById(R.id.iv_aixin);
            iv_xing = itemView.findViewById(R.id.iv_xing);
            tv_aixin = itemView.findViewById(R.id.tv_aixin);
            tv_xing = itemView.findViewById(R.id.tv_xing);
            iv_pinglun = itemView.findViewById(R.id.iv_pinglun);
            iv_share = itemView.findViewById(R.id.iv_share);
            rt_item = itemView.findViewById(R.id.rt_item);
            pop_pass = view1.findViewById(R.id.pop_pass);

        }
    }
}
