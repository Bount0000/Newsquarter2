package com.lenovo.bount.newsquarter.presenter;

import com.lenovo.bount.newsquarter.base.BasePresenter;
import com.lenovo.bount.newsquarter.bean.ResponsBodyBean;
import com.lenovo.bount.newsquarter.model.GetFollowModel;
import com.lenovo.bount.newsquarter.view.GetFollowView;

/**
 * Created by lenovo on 2017/12/1.
 */

public class GetFollowPresenter extends BasePresenter<GetFollowView> implements GetFollowModel.GetFollowInterface {
    private   GetFollowView getFollowView;
    private   GetFollowModel getFollowModel;


    public GetFollowPresenter(GetFollowView mView) {
        super(mView);
        getFollowView=mView;
        getFollowModel=new GetFollowModel();
        getFollowModel.setGetFollowInterface(this);
    }

   public void getFollowlist(String uid)
   {
       getFollowModel.getfollowlist(uid);
   }
    @Override
    public void Success(ResponsBodyBean value) {
        getFollowView.Success(value);
    }

    @Override
    public void Error(String msg) {
        getFollowView.Error(msg);
    }

    @Override
    public void OnFair(Throwable e) {
        getFollowView.OnFair(e);
    }
}
