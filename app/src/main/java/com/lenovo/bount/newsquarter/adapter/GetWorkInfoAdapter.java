package com.lenovo.bount.newsquarter.adapter;

/**
 * Created by lenovo on 2017/11/29.
 */

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.lenovo.bount.newsquarter.R;
import com.lenovo.bount.newsquarter.bean.GetWorkInfoBean;

import java.util.List;

/**
 * Adapter
 * Created by Yancy on 2015/12/4.
 */
public class GetWorkInfoAdapter extends RecyclerView.Adapter<GetWorkInfoAdapter.ViewHolder> {

    private Context context;
    private LayoutInflater mLayoutInflater;
    List<GetWorkInfoBean.DataBean.WorksEntitiesBean> worksEntities;
    private final static String TAG = "Adapter";

    public GetWorkInfoAdapter(Context context,  List<GetWorkInfoBean.DataBean.WorksEntitiesBean> worksEntities) {
        mLayoutInflater = LayoutInflater.from(context);
        this.context = context;
        this.worksEntities = worksEntities;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(mLayoutInflater.inflate(R.layout.iitem_layout2, null));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Glide.with(context)
                .load(worksEntities.get(position).cover)
                .into(holder.image);
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                AlertDialog.Builder builder=new AlertDialog.Builder(context);
                builder.setMessage("放弃上传这张图片吗？");
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        worksEntities.remove(position);
                        notifyDataSetChanged();
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                builder.create().show();
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return worksEntities.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        public ViewHolder(View itemView) {
            super(itemView);
            image =itemView.findViewById(R.id.image);
        }

    }


}