package com.lenovo.bount.newsquarter.presenter;

import com.lenovo.bount.newsquarter.base.BasePresenter;
import com.lenovo.bount.newsquarter.bean.GetVideos;
import com.lenovo.bount.newsquarter.model.GetVideoModel;
import com.lenovo.bount.newsquarter.view.GetVideosView;

/**
 * Created by lenovo on 2017/12/2.
 */

public class GetVideosPresenter extends BasePresenter<GetVideosView> implements GetVideoModel.GetVideosInterface {
    private GetVideosView getVideosView;
    private GetVideoModel getVideoModel;

    public GetVideosPresenter(GetVideosView mView) {
        super(mView);
        getVideosView=mView;
        getVideoModel=new GetVideoModel();
        getVideoModel.setGetVideosInterface(this);
    }
  public void getvideo(String uid,String type,int page)
  {
      getVideoModel.getVideo(uid,type,page);
  }
    @Override
    public void GetVideoSuccess(GetVideos value) {
        getVideosView.GetVideoSuccess(value);
    }

    @Override
    public void GetVideoError(String msg) {
        getVideosView.GetVideoError(msg);
    }

    @Override
    public void GetVideoOnFair(Throwable e) {
        getVideosView.GetVideoOnFair(e);
    }
}
