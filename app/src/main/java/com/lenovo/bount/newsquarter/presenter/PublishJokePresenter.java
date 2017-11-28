package com.lenovo.bount.newsquarter.presenter;

import com.lenovo.bount.newsquarter.base.BasePresenter;
import com.lenovo.bount.newsquarter.bean.ResponsBodyBean;
import com.lenovo.bount.newsquarter.model.PublishJokeModel;
import com.lenovo.bount.newsquarter.view.PublishJokeView;

/**
 * Created by lenovo on 2017/11/28.
 */

public class PublishJokePresenter extends BasePresenter<PublishJokeView> implements PublishJokeModel.publishJokeinterface {
    private PublishJokeModel publishJokeModel;
    private PublishJokeView publishJokeView;
    public PublishJokePresenter(PublishJokeView mView) {
        super(mView);
        this.publishJokeView=mView;
        publishJokeModel=new PublishJokeModel();
        publishJokeModel.setPublishJokeinterface(this);
    }

    public void getpublish(String uid,String content)
    {
        publishJokeModel.publishJoke(uid,content);
    }

    @Override
    public void Success(ResponsBodyBean bodyBean) {
        System.out.println("===段子===="+bodyBean.msg);
        publishJokeView.Success(bodyBean);
    }

    @Override
    public void Error() {
        publishJokeView.Error();
    }

    @Override
    public void onFair(Throwable e) {
        publishJokeView.onFair(e);
    }
}
