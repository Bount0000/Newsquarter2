package com.lenovo.bount.newsquarter.presenter;

import com.lenovo.bount.newsquarter.bean.ResponsBodyBean;
import com.lenovo.bount.newsquarter.model.NicknameModel;
import com.lenovo.bount.newsquarter.view.NickNameView;

/**
 * Created by lenovo on 2017/11/30.
 */

public class NickNamePresenter implements NicknameModel.NicknameInterface{
    private NicknameModel nicknameModel;
    private NickNameView nickNameView;
    public NickNamePresenter(NickNameView mView) {
        nickNameView=mView;
        nicknameModel=new NicknameModel();
        nicknameModel.setNicknameInterface(this);
    }
  public void getnick(String uid,String nickname)
  {
      nicknameModel.getnickname(uid,nickname);
  }
    @Override
    public void Success(ResponsBodyBean value) {
        nickNameView.Success(value);
    }

    @Override
    public void Error(String msg) {
        nickNameView.Error(msg);
    }

    @Override
    public void onFair(Throwable e) {
        nickNameView.onFair(e);
    }
}
