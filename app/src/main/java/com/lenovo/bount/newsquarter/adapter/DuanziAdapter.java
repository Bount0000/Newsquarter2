package com.lenovo.bount.newsquarter.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.lenovo.bount.newsquarter.R;
import com.lenovo.bount.newsquarter.bean.GetJokeBean;

import java.util.List;

/**
 * Created by lenovo on 2017/11/28.
 */

public class DuanziAdapter extends RecyclerView.Adapter<DuanziAdapter.MyHolder>{
   private Context context;
   private List<GetJokeBean.DataBean> data;

    public DuanziAdapter(Context context, List<GetJokeBean.DataBean> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.duanzi_item, null);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyHolder holder, int position) {
        holder.tv_name.setText(data.get(position).user.nickname);
        holder.tv_cotent.setText(data.get(position).content);
        holder.tv_time.setText(data.get(position).createTime);
        Glide.with(context).load(data.get(position).user.icon).asBitmap().centerCrop().into(new BitmapImageViewTarget(holder.iv_icon) {
            @Override
            protected void setResource(Bitmap resource) {
                RoundedBitmapDrawable circularBitmapDrawable =
                        RoundedBitmapDrawableFactory.create(context.getResources(), resource);
                circularBitmapDrawable.setCircular(true);
                holder.iv_icon.setImageDrawable(circularBitmapDrawable);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyHolder extends RecyclerView.ViewHolder
{
    private final ImageView iv_icon;
    private final TextView tv_name;
    private final TextView tv_time;
    private final TextView tv_cotent;

    public MyHolder(View itemView) {
        super(itemView);
        tv_name = itemView.findViewById(R.id.tv_name);
         tv_time= itemView.findViewById(R.id.tv_time);
         tv_cotent= itemView.findViewById(R.id.tv_cotent);
         iv_icon= itemView.findViewById(R.id.iv_icon);
    }
}
}
