package com.lenovo.bount.newsquarter.presenter;

import com.lenovo.bount.newsquarter.base.BasePresenter;
import com.lenovo.bount.newsquarter.bean.GetJokeBean;
import com.lenovo.bount.newsquarter.model.GetJokesModel;
import com.lenovo.bount.newsquarter.view.GetJokeView;

/**
 * Created by lenovo on 2017/11/28.
 */

public class GetJokePresenter extends BasePresenter<GetJokeView> implements GetJokesModel.GetJokeInterface {

    private GetJokesModel getJokesModel;
    private GetJokeView getJokeView;
    public GetJokePresenter(GetJokeView mView) {
        super(mView);
        this.getJokeView=mView;
        getJokesModel=new GetJokesModel();
        getJokesModel.setGetJokeInterface(this);
    }
  public void getjoke(String page)
  {
      getJokesModel.getJokes(page);
  }
    @Override
    public void Success(GetJokeBean value) {
        getJokeView.Success(value);
    }

    @Override
    public void Error() {
        getJokeView.Error();
    }

    @Override
    public void onFair(Throwable e) {
        getJokeView.onFair(e);
    }
}
