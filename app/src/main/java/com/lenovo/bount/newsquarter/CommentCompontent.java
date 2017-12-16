package com.lenovo.bount.newsquarter;

import com.lenovo.bount.newsquarter.adapter.GetVideoAdapter;
import com.lenovo.bount.newsquarter.moduel.CommentModuel;

import dagger.Component;

/**
 * Created by lenovo on 2017/12/14.
 */
@Component (modules = CommentModuel.class)
public interface CommentCompontent {
    void inject(GetVideoAdapter adapter);
}
