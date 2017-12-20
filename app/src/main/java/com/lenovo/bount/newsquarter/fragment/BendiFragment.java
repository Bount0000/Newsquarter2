package com.lenovo.bount.newsquarter.fragment;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import com.lenovo.bount.newsquarter.R;
import com.lenovo.bount.newsquarter.adapter.GetWorkInfoAdapter;
import com.lenovo.bount.newsquarter.bean.GetWorkInfoBean;
import com.lenovo.bount.newsquarter.interceptor.MyInterceptor;
import com.lenovo.bount.newsquarter.presenter.GetWorkInfoPresenter;
import com.lenovo.bount.newsquarter.view.GetWorkInfoView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by lenovo on 2017/12/15.
 */

public class BendiFragment extends Fragment implements GetWorkInfoView, View.OnClickListener {
    @BindView(R.id.rv_my)
    RecyclerView rvMy;
    Unbinder unbinder;
    @BindView(R.id.img_c)
    ImageView imgC;
    @BindView(R.id.img_d)
    ImageView imgD;
    @BindView(R.id.img_e)
    ImageView imgE;
    @BindView(R.id.img_a)
    ImageView imgA;
    @BindView(R.id.rl)
    FrameLayout rl;
    private int[] res = {R.id.img_a, R.id.img_c, R.id.img_d, R.id.img_e};
    private List<ImageView> list_img = new ArrayList<>();
    private boolean flag=true;
    private View view;
    private ImageView img;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = View.inflate(getContext(), R.layout.getworkinfo_layout, null);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        iniView();
        initData();
    }

    private void initData() {
        for (int i = 0; i < res.length; i++) {
            img = view.findViewById(res[i]);
            img.setOnClickListener(this);
            list_img.add(img);
        }
        imgA.setOnClickListener(this);
        GetWorkInfoPresenter presenter = new GetWorkInfoPresenter(this);
        presenter.getGetWorkInfo(MyInterceptor.uid);
    }

    private void iniView() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void Success(GetWorkInfoBean bean) {
        Toast.makeText(getActivity(), bean.msg, Toast.LENGTH_SHORT).show();
        List<GetWorkInfoBean.DataBean.WorksEntitiesBean> worksEntities = bean.data.worksEntities;
        GridLayoutManager manager = new GridLayoutManager(getActivity(), 3);
        rvMy.setLayoutManager(manager);
        GetWorkInfoAdapter adapter = new GetWorkInfoAdapter(getActivity(), worksEntities);
        rvMy.setAdapter(adapter);
    }

    private void closeAnim(){
        for(int i =1;i<res.length;i++){
//给出一个沿Y轴移动的动画
            ObjectAnimator animator = ObjectAnimator.ofFloat(
                    list_img.get(i),"translationY",(res.length-i-1)*50f,0f );
//给出一个沿X轴移动的动画
            ObjectAnimator animator1 = ObjectAnimator.ofFloat(
                    list_img.get(i),"translationX",(i-1)*50f,0f );
            //定义属性动画集合的对象
            AnimatorSet animSet = new AnimatorSet();
            //通过with方法，让两个动画同时进行
            animSet.play(animator).with(animator1);
            //设置延迟时间,让菜单内容相继弹出
            animSet.setStartDelay(500);
            animSet.start();
            //然后，设置flag为true，当再次点击的时候，收回菜单
            flag = true;
        }
    }

    //两种方法的内容大体相同，只是动画属性的参数相反
    private void startAnim() {
        for(int i =1;i<res.length;i++){
            ObjectAnimator animator = ObjectAnimator.ofFloat(
                    list_img.get(i),"translationY",
                    0f,(res.length-i-1)*50f );
            ObjectAnimator animator1 = ObjectAnimator.ofFloat(
                    list_img.get(i),"translationX", 0f , (i-1)*50f );
            AnimatorSet animSet = new AnimatorSet();
            animSet.play(animator).with(animator1);
            animSet.setStartDelay(500);
            animSet.start();
            flag = false;
        }
    }

    @Override
    public void Error(String msg) {
        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void OnFair(String msg) {
        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_a:
                if (flag) {
                    startAnim();
                    imgA.setImageResource(R.mipmap.lanxing);
                } else {
                    closeAnim();
                    imgA.setImageResource(R.mipmap.hongxing);
                }
                break;
        }
    }
}
