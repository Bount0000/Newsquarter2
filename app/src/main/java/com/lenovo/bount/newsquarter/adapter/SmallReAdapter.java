package com.lenovo.bount.newsquarter.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.lenovo.bount.newsquarter.R;

import java.util.List;

/**
 * Created by lenovo on 2017/11/30.
 */
public class SmallReAdapter extends RecyclerView.Adapter<SmallReAdapter.MyHolder> {
    private Context context;
    //private List<GetJokeBean.DataBean> list;
    private String imgUrls;
    private ViewGroup.LayoutParams layoutParams;
    private int mImageWidth2;
    private int mImageWidth3;
   private List<String> list2;

    public SmallReAdapter(Context context, List<String> list2) {
        this.context = context;
        this.list2 = list2;

    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View view=View.inflate(context, R.layout.smallitem_layout,null);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position){
       if(list2.size()==1)
       {
         holder.small_iv.setVisibility(View.VISIBLE);
         Glide.with(context).load(list2.get(position)).into(holder.small_iv);
       }
       else if(list2.size()==2)
       {
           holder.small_iv2.setVisibility(View.VISIBLE);
           Glide.with(context).load(list2.get(position)).into(holder.small_iv2);
       }
       else
       {
           holder.small_iv3.setVisibility(View.VISIBLE);
           Glide.with(context).load(list2.get(position)).into(holder.small_iv3);
       }
    }
    @Override
    public int getItemCount() {
        return list2.size();
    }

    class MyHolder extends RecyclerView.ViewHolder
    {
        private final ImageView small_iv;
        private final ImageView small_iv2;
        private final ImageView small_iv3;
        public MyHolder(View itemView) {
            super(itemView);
            small_iv = itemView.findViewById(R.id.small_iv);
            small_iv2 = itemView.findViewById(R.id.small_iv2);
            small_iv3 = itemView.findViewById(R.id.small_iv3);
        }
    }
}
