package com.lenovo.bount.newsquarter.presenter;

import com.lenovo.bount.newsquarter.base.BasePresenter;
import com.lenovo.bount.newsquarter.bean.GetNearVideoBean;
import com.lenovo.bount.newsquarter.model.GetNearVideosModel;
import com.lenovo.bount.newsquarter.view.GetNearVideosView;

/**
 * Created by lenovo on 2017/12/7.
 */

public class GetNearVideosPresenter extends BasePresenter<GetNearVideosView>  implements GetNearVideosModel.GetNearVideosInterface {
    private GetNearVideosView videosView;
    private GetNearVideosModel videosModel;
    public GetNearVideosPresenter(GetNearVideosView mView) {
        super(mView);
        videosView=mView;
        videosModel=new GetNearVideosModel();
        videosModel.setGetNearVideosInterface(this);
    }
     public  void GetNearVideos(int page,String latitude,String longitude)
     {
         videosModel.GetNearVideos(page,latitude,longitude);
     }
    @Override
    public void GetNearSuccess(GetNearVideoBean value) {
        videosView.GetNearSuccess(value);
    }

    @Override
    public void GetNearError(String msg) {
        videosView.GetNearError(msg);
    }

    @Override
    public void GetNearOnFair(String msg) {
        videosView.GetNearOnFair(msg);
    }
}
