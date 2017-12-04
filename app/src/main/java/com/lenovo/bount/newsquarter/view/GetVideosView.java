package com.lenovo.bount.newsquarter.view;

import com.lenovo.bount.newsquarter.bean.GetVideos;

/**
 * Created by lenovo on 2017/12/2.
 */

public interface GetVideosView {
    void GetVideoSuccess(GetVideos value);
    void GetVideoError(String msg);
    void GetVideoOnFair(Throwable e);
}
