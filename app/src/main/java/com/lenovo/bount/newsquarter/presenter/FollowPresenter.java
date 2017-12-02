package com.lenovo.bount.newsquarter.presenter;

import com.lenovo.bount.newsquarter.base.BasePresenter;
import com.lenovo.bount.newsquarter.bean.ResponsBodyBean;
import com.lenovo.bount.newsquarter.model.FollowModel;
import com.lenovo.bount.newsquarter.view.FollowView;

/**
 * Created by lenovo on 2017/12/1.
 */

public class FollowPresenter extends BasePresenter<FollowView> implements FollowModel.FollowInterface {
    private   FollowView followView;
    private   FollowModel followModel;

    public FollowPresenter(FollowView mView) {
        super(mView);
        followView=mView;
        followModel=new FollowModel();
        followModel.setFollowInterface(this);
    }
    public void getfollow(String uid,String followId)
    {
        followModel.getfollow(uid,followId);
    }
    @Override
    public void Success(ResponsBodyBean value) {
        followView.Success(value);
    }

    @Override
    public void Error(String msg) {
        followView.Error(msg);
    }

    @Override
    public void OnFair(Throwable e) {
        followView.OnFair(e);
    }
}
