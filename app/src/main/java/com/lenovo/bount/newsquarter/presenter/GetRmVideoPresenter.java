package com.lenovo.bount.newsquarter.presenter;

import com.lenovo.bount.newsquarter.base.BasePresenter;
import com.lenovo.bount.newsquarter.bean.RmSpBean;
import com.lenovo.bount.newsquarter.model.GetRmVideoModel;
import com.lenovo.bount.newsquarter.view.GetRmVideoView;

/**
 * Created by lenovo on 2017/12/6.
 */

public class GetRmVideoPresenter extends BasePresenter<GetRmVideoView> implements GetRmVideoModel.GetRmSpinterface{
    private GetRmVideoView getRmVideoView;
    private GetRmVideoModel getRmVideoModel;
    public GetRmVideoPresenter(GetRmVideoView mView) {
        super(mView);
        getRmVideoView=mView;
        getRmVideoModel=new GetRmVideoModel();
        getRmVideoModel.setGetRmSpinterface(this);
    }

    public void getRmsp(int page)
    {
        getRmVideoModel.getRmVideoModel(page);
    }
    @Override
    public void RmSpSuccess(RmSpBean rmSpBean) {
        getRmVideoView.RmSpSuccess(rmSpBean);
    }

    @Override
    public void RmSpError(String msg) {
        getRmVideoView.RmSpError(msg);
    }

    @Override
    public void RmSpOnFair(String msg) {
        getRmVideoView.RmSpOnFair(msg);
    }
}
