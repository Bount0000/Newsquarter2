package com.lenovo.bount.newsquarter.adapter;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.lenovo.bount.newsquarter.bean.GetJokeBean;

import java.util.List;

/**
 * Created by lenovo on 2017/11/30.
 */

public  class GrideViewAdapter extends BaseAdapter {

// 上下文对象

    private Context context;

// 图片数组

    private List<GetJokeBean.DataBean> url;

    private ViewGroup.LayoutParams layoutParams;

    private int mImageWidth2;

    private int mImageWidth3;


    public GrideViewAdapter(Context context, List<GetJokeBean.DataBean>  url) {

        this.context = context;

        this.url = url;

        WindowManager wm = (WindowManager) context

                .getSystemService(Context.WINDOW_SERVICE);

        DisplayMetrics outMetrics = new DisplayMetrics();

        wm.getDefaultDisplay().getMetrics(outMetrics);

        mImageWidth3 = (int) ((outMetrics.widthPixels -12* outMetrics.density)/3);

        mImageWidth2 = (int) ((outMetrics.widthPixels -12* outMetrics.density)/2);

// layoutParams = new GridView.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

// layoutParams.setMargins(1,1,1,1);//4个参数按顺序分别是左上右下

    }


    public int getCount() {

        return url == null ? 0 : url.size();

    }


    public Object getItem(int item) {

        return item;

    }


    public long getItemId(int id) {

        return id;

    }


// 创建View方法

    public View getView(int position, View convertView, ViewGroup parent) {

        ImageView imageView;

        if (convertView == null) {

            imageView = new ImageView(context);

            switch (url.size()) {

                case 1:

                    imageView.setLayoutParams(new GridView.LayoutParams(GridView.LayoutParams.WRAP_CONTENT,GridView.LayoutParams.WRAP_CONTENT));// 设置ImageView对象布局

                    break;

                case 2:

                    imageView.setLayoutParams(new GridView.LayoutParams(mImageWidth2,mImageWidth2));

                    break;

                case 4:

                    imageView.setLayoutParams(new GridView.LayoutParams(mImageWidth2,mImageWidth2));

                    break;

                default:

                    imageView.setLayoutParams(new GridView.LayoutParams(mImageWidth3,mImageWidth3));// 设置ImageView对象布局

                    break;

            }

            imageView.setAdjustViewBounds(false);// 设置边界对齐

            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);// 设置刻度的类型

// imageView.setPadding(4, 4, 4, 4);// 设置间距

        }
        else {

            imageView = (ImageView) convertView;

        }
        String imgUrls = url.get(position).imgUrls;
        if(imgUrls!=null)
        {
            String[] split = imgUrls.split("\\|");
            Glide.with(context).load(split[0]).into(imageView);
        }
        return imageView;
    }

}
