package com.lenovo.bount.newsquarter.presenter;

import com.lenovo.bount.newsquarter.base.BasePresenter;
import com.lenovo.bount.newsquarter.bean.GetFollowUsersBean;
import com.lenovo.bount.newsquarter.model.getFollowUsersModel;
import com.lenovo.bount.newsquarter.view.GetFollowUsersView;

/**
 * Created by lenovo on 2017/12/14.
 */

public class FollowUsersPresenter extends BasePresenter<GetFollowUsersView> implements getFollowUsersModel.FollowUsersInterFace{
    private getFollowUsersModel followModel;
    private GetFollowUsersView followUsersView;

    public FollowUsersPresenter(GetFollowUsersView mView) {
        super(mView);
        followUsersView=mView;
        followModel=new getFollowUsersModel();
        followModel.setFollowUsersInterFace(this);

    }
 public void getFollowUser(String uid)
 {
     followModel.getFollowUsers(uid);
 }

    @Override
    public void FollowSucces(GetFollowUsersBean getFollowUsersBean) {
        followUsersView.FollowSucces(getFollowUsersBean);
    }

    @Override
    public void FollowError(String msg) {
        followUsersView.FollowError(msg);
    }

    @Override
    public void FollowOnFrair(String msg) {
        followUsersView.FollowOnFrair(msg);
    }
}
