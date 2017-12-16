package com.lenovo.bount.newsquarter.presenter;

import com.lenovo.bount.newsquarter.base.BasePresenter;
import com.lenovo.bount.newsquarter.bean.ResponsBodyBean;
import com.lenovo.bount.newsquarter.model.CommentModel;
import com.lenovo.bount.newsquarter.view.CommentView;

/**
 * Created by lenovo on 2017/12/14.
 */

public class CommentPresenter extends BasePresenter<CommentView> implements CommentModel.getCommentinterface{

    private  CommentModel commentModel;
    private  CommentView commentView;

    public CommentPresenter(CommentView mView) {
        super(mView);
        commentView=mView;
        commentModel=new CommentModel();
        commentModel.setGetCommentinterface(this);
    }
   public void getcomment(String uid,String wid,String cotent)
   {
       commentModel.getCommnet(uid,wid,cotent);
   }
    @Override
    public void CommentSuccess(ResponsBodyBean bodyBean) {
        commentView.CommentSuccess(bodyBean);
    }

    @Override
    public void CommentError(String msg) {
        commentView.CommentError(msg);
    }

    @Override
    public void CommentOnFair(String msg) {
        commentView.CommentOnFair(msg);
    }
}
