package com.lenovo.bount.newsquarter.presenter;

import com.lenovo.bount.newsquarter.base.BasePresenter;
import com.lenovo.bount.newsquarter.bean.ResponsBodyBean;
import com.lenovo.bount.newsquarter.model.PublishVideoModel;
import com.lenovo.bount.newsquarter.view.PublishVedioView;

import java.io.File;

/**
 * Created by lenovo on 2017/12/4.
 */

public class PbVedioPresenter extends BasePresenter<PublishVedioView> implements PublishVideoModel.GetPublishInterface {

    private PublishVideoModel videoModel;
    private PublishVedioView vedioView;

    public PbVedioPresenter(PublishVedioView mView) {
        super(mView);
        vedioView=mView;
        videoModel=new PublishVideoModel();
        videoModel.setGetPublishInterface(this);
    }
    public void getpbvedio(String uid,File videoFile,File coverFile,String videoDesc,String latitude,String longitude)
    {
        videoModel.getpbvideo(uid,videoFile,coverFile,videoDesc,latitude,longitude);
    }

    @Override
    public void PbVideoSuccess(ResponsBodyBean bodyBean) {
        vedioView.Success(bodyBean);
    }

    @Override
    public void PbVideoError(String msg) {
        vedioView.Error(msg);
    }

    @Override
    public void PbVideoOnFair(String msg) {
        vedioView.onFair(msg);
    }
}
