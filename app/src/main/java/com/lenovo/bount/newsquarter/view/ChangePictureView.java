package com.lenovo.bount.newsquarter.view;

import com.lenovo.bount.newsquarter.bean.ResponsBodyBean;

/**
 * Created by lenovo on 2017/12/1.
 */

public interface ChangePictureView {
    void ChageTxSuccess(ResponsBodyBean value);
    void ChageTxError(String msg);
    void ChageTxonFair(Throwable e);
}
