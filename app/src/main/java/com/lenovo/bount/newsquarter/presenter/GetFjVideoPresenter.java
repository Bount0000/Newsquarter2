package com.lenovo.bount.newsquarter.presenter;

import com.lenovo.bount.newsquarter.base.BasePresenter;
import com.lenovo.bount.newsquarter.bean.RmSpBean;
import com.lenovo.bount.newsquarter.model.GetFjVideoModel;
import com.lenovo.bount.newsquarter.view.GetFjVideoView;

/**
 * Created by lenovo on 2017/12/6.
 */

public class GetFjVideoPresenter extends BasePresenter<GetFjVideoView> implements GetFjVideoModel.GetFjSpinterface{
    private GetFjVideoView videoView;
    private GetFjVideoModel videoModel;
    public GetFjVideoPresenter(GetFjVideoView mView) {
        super(mView);
        videoView=mView;
        videoModel=new GetFjVideoModel();
        videoModel.setGetFjSpinterface(this);
    }


    @Override
    public void FjSpSuccess(RmSpBean rmSpBean) {
        videoView.RmSpSuccess(rmSpBean);
    }

    @Override
    public void FjSpError(String msg) {
        videoView.RmSpError(msg);
    }

    @Override
    public void FjSpOnFair(String msg) {
        videoView.RmSpOnFair(msg);
    }
}
