package com.lenovo.bount.newsquarter.presenter;

import com.lenovo.bount.newsquarter.base.BasePresenter;
import com.lenovo.bount.newsquarter.bean.ResponsBodyBean;
import com.lenovo.bount.newsquarter.model.PublishVideoModel;
import com.lenovo.bount.newsquarter.view.PublishVedioView;

import java.util.List;

/**
 * Created by lenovo on 2017/12/4.
 */

public class PbVedioPresenter extends BasePresenter<PublishVedioView> implements PublishVideoModel.PublishVideoInterface {
    private PublishVideoModel videoModel;
    private PublishVedioView vedioView;

    public PbVedioPresenter(PublishVedioView mView) {
        super(mView);
        vedioView=mView;
        videoModel=new PublishVideoModel();
        videoModel.setPublishVideoInterface(this);
    }
    public void getpbvedio(String uid, String laungitude, String longitude, List<String> videoFile, List<String> coverFile)
    {
        videoModel.getpbvideo(uid,laungitude,longitude,videoFile,coverFile);
    }
    @Override
    public void Success(ResponsBodyBean bodyBean) {
        vedioView.Success(bodyBean);
    }

    @Override
    public void Error(String msg) {
        vedioView.Error(msg);
    }

    @Override
    public void onFair(String msg) {
        vedioView.onFair(msg);
    }
}
