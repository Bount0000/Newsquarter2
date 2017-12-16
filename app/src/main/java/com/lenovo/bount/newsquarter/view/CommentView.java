package com.lenovo.bount.newsquarter.view;

import com.lenovo.bount.newsquarter.bean.ResponsBodyBean;

/**
 * Created by lenovo on 2017/12/14.
 */

public interface CommentView {
    void CommentSuccess(ResponsBodyBean bodyBean);
    void CommentError(String msg);
    void CommentOnFair(String msg);
}
