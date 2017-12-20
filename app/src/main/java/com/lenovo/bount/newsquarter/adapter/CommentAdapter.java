package com.lenovo.bount.newsquarter.adapter;

/**
 * Created by lenovo on 2017/11/29.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lenovo.bount.newsquarter.R;
import com.lenovo.bount.newsquarter.bean.GetVideos;

import java.util.List;

/**
 * Adapter
 * Created by Yancy on 2015/12/4.
 */
public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.ViewHolder> {

    private Context context;
   private List<GetVideos.DataBean.CommentsBean> commentsList;
    private final static String TAG = "Adapter";

    public CommentAdapter(Context context, List<GetVideos.DataBean.CommentsBean> commentsList) {
        this.context = context;
        this.commentsList=commentsList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View view=View.inflate(context,R.layout.commtentitem_layout, null);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.tv_name.setText(commentsList.get(position).nickname+" :");
        holder.tv_commtent.setText(commentsList.get(position).content);
    }

    @Override
    public int getItemCount() {
        return commentsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView tv_name;
        private final TextView tv_commtent;

        public ViewHolder(View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_commtent = itemView.findViewById(R.id.tv_commtent);
        }

    }


}