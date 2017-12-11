package com.lenovo.bount.newsquarter.presenter;

import com.lenovo.bount.newsquarter.base.BasePresenter;
import com.lenovo.bount.newsquarter.bean.Getuser;
import com.lenovo.bount.newsquarter.model.GetUservideoMode;
import com.lenovo.bount.newsquarter.view.GetUservideoView;

/**
 * Created by lenovo on 2017/12/7.
 */

public class GetUservideo extends BasePresenter<GetUservideoView> implements GetUservideoMode.GetVideoUserInterface{
   private GetUservideoView uservideoView;
    private GetUservideoMode getUservideoMode;
    public GetUservideo(GetUservideoView mView) {
        super(mView);
        uservideoView=mView;
        getUservideoMode=new GetUservideoMode();
        getUservideoMode.setGetVideoUserInterface(this);
    }
    public  void getUservideo(String uid,int page)
    {
        getUservideoMode.getUserVideo(uid,page);
    }
    @Override
    public void getUserSuccess(Getuser value) {
        uservideoView.getUserSuccess(value);
    }

    @Override
    public void getUserError(String msg) {
        uservideoView.getUserError(msg);
    }

    @Override
    public void getUsermsOnFair(String msg) {
        uservideoView.getUsermsOnFair(msg);
    }
}
