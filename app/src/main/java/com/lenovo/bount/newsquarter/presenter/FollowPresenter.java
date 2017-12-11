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
    public void FollowSuccess(ResponsBodyBean value) {
        followView.FollowSuccess(value);
    }

    @Override
    public void FollowError(String msg) {
        followView.FollowError(msg);
    }

    @Override
    public void FollowOnFair(Throwable e) {
        followView.FollowOnFair(e);
    }
}
