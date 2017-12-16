package com.lenovo.bount.newsquarter;

import com.lenovo.bount.newsquarter.adapter.GetVideoAdapter;

import dagger.Component;

/**
 * Created by lenovo on 2017/12/12.
 */
@Component
public interface DianzanComponent {

    void inject(GetVideoAdapter getVideoAdapter);
}
