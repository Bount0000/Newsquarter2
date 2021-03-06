package com.lenovo.bount.newsquarter.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.lenovo.bount.newsquarter.App;
import com.lenovo.bount.newsquarter.R;
import com.lenovo.bount.newsquarter.activitybao.MyShoucangActivity;
import com.lenovo.bount.newsquarter.activitybao.MyguanzhuActivity;
import com.lenovo.bount.newsquarter.activitybao.ProductionActivity;
import com.lenovo.bount.newsquarter.activitybao.ShezhiActivity;
import com.lenovo.bount.newsquarter.activitybao.SousuoActivity;
import com.lenovo.bount.newsquarter.activitybao.UserActivity;
import com.lenovo.bount.newsquarter.bean.Userbean2;
import com.lenovo.bount.newsquarter.presenter.PresonPresenter;
import com.lenovo.bount.newsquarter.utils.SpUtils;
import com.lenovo.bount.newsquarter.view.PresonView;

/**
 * Created by lenovo on 2017/11/23.
 */

public class LeftFragment extends Fragment implements PresonView,View.OnClickListener{

    private ImageView iv;
    private TextView tv_name;
    private ImageView iv_7;
    private ImageView iv_tou;
    private String icon;
    private String nickname;
    private RelativeLayout rt_sousuo;
    private View view;
    private RelativeLayout rt_myzp;
    private RelativeLayout rt_guanzhu;
    private RelativeLayout rt_shoucang;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

          view = View.inflate(getContext(), R.layout.cehua_layout,null);
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
        final String token = utils.getString("token", "");
        System.out.println("==信息token=="+token);
        PresonPresenter presonPresenter=new PresonPresenter(this);
        presonPresenter.getuser(uid);
        iv_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               startActivity(new Intent(getContext(), ShezhiActivity.class));
            }
        });
    }

    private void initView() {
        iv = getView().findViewById(R.id.iv_tou);
        tv_name = getView().findViewById(R.id.tv_name);
        iv_7 = getView().findViewById(R.id.iv_7);
        rt_sousuo = getView().findViewById(R.id.rt_sousuo);
        rt_myzp = getView().findViewById(R.id.rt_myzp);
        iv_tou = getView().findViewById(R.id.iv_tou);
        rt_guanzhu = getView().findViewById(R.id.rt_guanzhu);
        rt_shoucang = getView().findViewById(R.id.rt_shoucang);
        iv_tou.setOnClickListener(this);
        rt_sousuo.setOnClickListener(this);
        rt_myzp.setOnClickListener(this);
        rt_guanzhu.setOnClickListener(this);
        rt_shoucang.setOnClickListener(this);

    }
    @Override
    public void Success(Userbean2 userbean) {
        Toast.makeText(App.context,userbean.msg, Toast.LENGTH_SHORT).show();
        icon = userbean.data.icon;
        String username = userbean.data.username;
        nickname = userbean.data.nickname;
        SpUtils utils=new SpUtils(App.context,"Chuan");
        utils.putString("icon",icon);
        iv_tou.setImageURI(Uri.parse(icon));
    /*    Glide.with(this).load(icon).asBitmap().centerCrop().into(new BitmapImageViewTarget(iv_tou) {
            @Override
            protected void setResource(Bitmap resource) {
                RoundedBitmapDrawable circularBitmapDrawable =
                        RoundedBitmapDrawableFactory.create(App.context.getResources(), resource);
                circularBitmapDrawable.setCircular(true);
                iv_tou.setImageDrawable(circularBitmapDrawable);
            }
        });*/
        tv_name.setText(username);
    }

    @Override
    public void Error(String msg) {
        Toast.makeText(getContext(),msg, Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onFair(Throwable e) {
        Toast.makeText(getActivity(),e.toString(), Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.iv_tou:
                Intent intent=new Intent(getActivity(),UserActivity.class);
                intent.putExtra("icon",icon);
                System.out.println("----------"+icon);
                intent.putExtra("nickname",nickname);
                startActivity(intent);
                break;
            case R.id.rt_sousuo:
                Intent intent2=new Intent(getActivity(),SousuoActivity.class);
                startActivity(intent2);
                break;
            case R.id.rt_myzp:
                Intent intent3=new Intent(getActivity(),ProductionActivity.class);
                startActivity(intent3);
                break;
            case R.id.rt_guanzhu:
                Intent intent4=new Intent(getActivity(),MyguanzhuActivity.class);
                startActivity(intent4);
             break;
            case R.id.rt_shoucang:
                Intent intent5=new Intent(getActivity(),MyShoucangActivity.class);
                startActivity(intent5);
                break;
        }
    }
}
