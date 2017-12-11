package com.lenovo.bount.newsquarter.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lenovo.bount.newsquarter.R;
import com.lenovo.bount.newsquarter.bean.SearchBean;

import java.util.List;

/**
 * Created by lenovo on 2017/12/9.
 */

public class SousuoAdapter extends RecyclerView.Adapter<SousuoAdapter.MyHolder2> {
private Context context;
    private List<SearchBean.DataBean> data;

    public SousuoAdapter(Context context, List<SearchBean.DataBean> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public MyHolder2 onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=View.inflate(context, R.layout.sousuo_item_layout,null);
        return new MyHolder2(view);
    }

    @Override
    public void onBindViewHolder(MyHolder2 holder, int position) {
      holder.iv_icon.setImageURI(Uri.parse(data.get(position).icon));
      holder.tv_name.setText(data.get(position).nickname);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyHolder2 extends RecyclerView.ViewHolder
    {

        private final ImageView iv_icon;
        private final TextView tv_name;

        public MyHolder2(View itemView) {
            super(itemView);
            iv_icon = itemView.findViewById(R.id.iv_icon);
            tv_name = itemView.findViewById(R.id.tv_name);
        }
    }
}
