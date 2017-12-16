package com.lenovo.bount.newsquarter.presenter;

import com.lenovo.bount.newsquarter.base.BasePresenter;
import com.lenovo.bount.newsquarter.bean.GetWorkInfoBean;
import com.lenovo.bount.newsquarter.model.GetWorkInfoModel;
import com.lenovo.bount.newsquarter.view.GetWorkInfoView;

/**
 * Created by lenovo on 2017/12/15.
 */

public class GetWorkInfoPresenter extends BasePresenter<GetWorkInfoView> implements GetWorkInfoModel.GetWorkInfoInterface {
    private GetWorkInfoModel getWorkInfoModel;
    private GetWorkInfoView getWorkInfoView;

    public GetWorkInfoPresenter(GetWorkInfoView mView) {
        super(mView);
        getWorkInfoView = mView;
        getWorkInfoModel = new GetWorkInfoModel();
        getWorkInfoModel.setGetWorkInfoInterface(this);
    }

    public void getGetWorkInfo(String uid)
    {
        getWorkInfoModel.getWorkInfo(uid);
    }
    @Override
    public void Success(GetWorkInfoBean bean) {
        getWorkInfoView.Success(bean);
    }

    @Override
    public void Error(String msg) {
        getWorkInfoView.Error(msg);
    }

    @Override
    public void OnFair(String msg) {
        getWorkInfoView.OnFair(msg);
    }
}
