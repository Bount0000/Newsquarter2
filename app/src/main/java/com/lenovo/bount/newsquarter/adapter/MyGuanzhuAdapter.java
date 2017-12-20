package com.lenovo.bount.newsquarter.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lenovo.bount.newsquarter.R;
import com.lenovo.bount.newsquarter.activitybao.GuanzhuActivity;
import com.lenovo.bount.newsquarter.bean.GetFollowUsersBean;

import java.util.List;

/**
 * Created by lenovo on 2017/12/9.
 */

public class MyGuanzhuAdapter extends RecyclerView.Adapter<MyGuanzhuAdapter.MyHolder2> {

    private Context context;
    private List<GetFollowUsersBean.DataBean> data;

    public MyGuanzhuAdapter(Context context, List<GetFollowUsersBean.DataBean> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public MyHolder2 onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.myguanzhu_item_layout, null);
        return new MyHolder2(view);
    }

    @Override
    public void onBindViewHolder(MyHolder2 holder, int position) {
        final int uid = data.get(position).uid;
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                 Intent intent=new Intent(context, GuanzhuActivity.class);
                 intent.putExtra("guanzhuuid",uid);
                 context.startActivity(intent);
            }
        });

        holder.iv_icon.setImageURI(Uri.parse(data.get(position).icon));
        holder.tv_name.setText(data.get(position).nickname);
        holder.tv_time.setText(data.get(position).createtime);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyHolder2 extends RecyclerView.ViewHolder {
        private final ImageView iv_icon;
        private final TextView tv_name;
        private final TextView tv_time;

        public MyHolder2(View itemView) {
            super(itemView);
            iv_icon = itemView.findViewById(R.id.iv_icon);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_time = itemView.findViewById(R.id.tv_time);
        }
    }
}
