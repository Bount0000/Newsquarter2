package com.lenovo.bount.newsquarter.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.lenovo.bount.newsquarter.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by lenovo on 2017/12/1.
 */

public class SpRemenAdapter extends RecyclerView.Adapter<SpRemenAdapter.MyHolder> {
    private Context context;
    private List<Integer> pictuerlist;
    private View view;
    private List<Integer> heightList;//装产出的随机数
    public SpRemenAdapter(Context context, List<Integer> pictuerlist) {
        this.context = context;
        this.pictuerlist = pictuerlist;
        heightList=new ArrayList<>();
        for (int i = 0; i < pictuerlist.size(); i++) {
            int height = new Random().nextInt(200) + 100;//[100,300)的随机数
            heightList.add(height);
        }
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View rootView  = inflater.inflate(R.layout.spitem_layout,parent,false);
        return new MyHolder(rootView);
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        System.out.println(pictuerlist.size()+"++++++++++++++++++++++++++++++");
        //Integer integer = pictuerlist.get(position);
        //System.out.println("==integer===="+integer);
        ViewGroup.LayoutParams params = holder.small_iv.getLayoutParams();
        params.height=heightList.get(position);
        holder.small_iv.setLayoutParams(params);
        Picasso.with(context).load(pictuerlist.get(position)).into(holder.small_iv);

    }

    @Override
    public int getItemCount() {
        return pictuerlist.size();
    }

    class  MyHolder extends RecyclerView.ViewHolder
    {

        private final ImageView small_iv;

        public MyHolder(View itemView) {
            super(itemView);
            small_iv = itemView.findViewById(R.id.sp_iv);
        }
    }
}
