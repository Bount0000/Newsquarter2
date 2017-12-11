package com.lenovo.bount.newsquarter.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.lenovo.bount.newsquarter.R;
import com.lenovo.bount.newsquarter.activitybao.ShipinXqActivity;
import com.lenovo.bount.newsquarter.bean.GetNearVideoBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by lenovo on 2017/12/1.
 */

public class GetNearAdapter extends RecyclerView.Adapter<GetNearAdapter.MyHolder> {
    private Context context;
    private List<GetNearVideoBean.DataBean> dataBeanList;
    private  List<Integer> heightList;
    public GetNearAdapter(Context context, List<GetNearVideoBean.DataBean> dataBeanList){
        this.context = context;
        this.dataBeanList = dataBeanList;
        heightList = new ArrayList<>();
        for (int i = 0; i < dataBeanList.size(); i++) {
            int height = new Random().nextInt(500) + 300;//[100,300)的随机数
            heightList.add(height);
        }
        }
        //刷新
  public void  refreshData(List<GetNearVideoBean.DataBean> list)
  {
      if(dataBeanList!=null)
      {
          dataBeanList.clear();
          dataBeanList.addAll(list);
          notifyDataSetChanged();
      }
  }
        //更多
        public void loadData(List<GetNearVideoBean.DataBean> list)
    {
    if(dataBeanList!=null)
     {
         dataBeanList.addAll(list);
         notifyDataSetChanged();
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
        final String videoUrl = dataBeanList.get(position).videoUrl;
        final String replace = videoUrl.replace("https://www.zhaoapi.cn", "http://120.27.23.105");
        ViewGroup.LayoutParams params = holder.rl_play.getLayoutParams();
        try {
            params.height=heightList.get(position);
        } catch (Exception e) {
            e.printStackTrace();
        }
        holder.rl_play.setLayoutParams(params);
        Glide.with(context).load(dataBeanList.get(position).cover).into(holder.rl_play);
        holder.rl_play.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context, ShipinXqActivity.class);
                intent.putExtra("videoUrl",replace);
                intent.putExtra("icon",dataBeanList.get(position).user.icon);
                context.startActivity(intent);
            }
        });
    }
    @Override
    public int getItemCount() {
        return dataBeanList.size();
    }

    class  MyHolder extends RecyclerView.ViewHolder
    {
        private final ImageView rl_play;
        public MyHolder(View itemView) {
            super(itemView);
            rl_play = itemView.findViewById(R.id.rl_play);
        }
    }
}
