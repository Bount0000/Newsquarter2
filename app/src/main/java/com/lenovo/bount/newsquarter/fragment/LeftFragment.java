package com.lenovo.bount.newsquarter.fragment;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.lenovo.bount.newsquarter.R;
import com.lenovo.bount.newsquarter.bean.ResponsBodyBean;
import com.lenovo.bount.newsquarter.bean.Userbean;
import com.lenovo.bount.newsquarter.presenter.PresonPresenter;
import com.lenovo.bount.newsquarter.utils.SpUtils;
import com.lenovo.bount.newsquarter.view.PresonView;

import static com.lenovo.bount.newsquarter.App.context;

/**
 * Created by lenovo on 2017/11/23.
 */

public class LeftFragment extends Fragment implements PresonView {

    private ImageView iv;
    private TextView tv_name;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=View.inflate(getContext(), R.layout.cehua_layout,null);
        return view;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        initData();
    }

    private void initData() {
        SpUtils utils=new SpUtils(getContext(),"Login");
        String uid=utils.getString("uid", "");
        String token = utils.getString("token", "");
        System.out.println("==sptoken=="+token);
        PresonPresenter presonPresenter=new PresonPresenter(this);
        presonPresenter.getuser(uid,token);
    }

    private void initView() {
        iv = getView().findViewById(R.id.iv);
        tv_name = getView().findViewById(R.id.tv_name);
    }

    @Override
    public void Success(ResponsBodyBean<Userbean> userbean) {
        Toast.makeText(getContext(), userbean.msg, Toast.LENGTH_SHORT).show();
        String icon = userbean.data.icon;
        String username = userbean.data.username;
        System.out.println("==username=="+username);
        Glide.with(context).load(icon).asBitmap().centerCrop().into(new BitmapImageViewTarget(iv) {
            @Override
            protected void setResource(Bitmap resource) {
                RoundedBitmapDrawable circularBitmapDrawable =
                        RoundedBitmapDrawableFactory.create(context.getResources(), resource);
                circularBitmapDrawable.setCircular(true);
                iv.setImageDrawable(circularBitmapDrawable);
            }
        });
        tv_name.setText(username);
    }

    @Override
    public void Error() {
        Toast.makeText(getContext(), "失败", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFair(Throwable e) {
        Toast.makeText(getContext(),"失败", Toast.LENGTH_SHORT).show();
    }
}
