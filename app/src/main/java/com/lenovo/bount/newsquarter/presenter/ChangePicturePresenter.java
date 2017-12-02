package com.lenovo.bount.newsquarter.presenter;

import com.lenovo.bount.newsquarter.base.BasePresenter;
import com.lenovo.bount.newsquarter.bean.ResponsBodyBean;
import com.lenovo.bount.newsquarter.model.ChangePictureModel;
import com.lenovo.bount.newsquarter.view.ChangePictureView;

import java.io.File;

/**
 * Created by lenovo on 2017/12/1.
 */

public class ChangePicturePresenter extends BasePresenter<ChangePictureView>  implements ChangePictureModel.ChageTxInterface{
    private ChangePictureView changePictureView;
    private ChangePictureModel changePictureModel;

    public ChangePicturePresenter(ChangePictureView mView) {
        super(mView);
        changePictureView=mView;
        changePictureModel=new ChangePictureModel();
        changePictureModel.setChageTxInterface(this);
    }

  public void getChange(String uid, File file)
  {
      changePictureModel.getchage(uid,file);
  }

    @Override
    public void ChageTxSuccess(ResponsBodyBean value) {
        changePictureView.ChageTxSuccess(value);
    }

    @Override
    public void ChageTxError(String msg) {
        changePictureView.ChageTxError(msg);
    }

    @Override
    public void ChageTxonFair(Throwable e) {
        changePictureView.ChageTxonFair(e);
    }
}
