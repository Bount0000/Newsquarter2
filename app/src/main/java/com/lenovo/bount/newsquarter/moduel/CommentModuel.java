package com.lenovo.bount.newsquarter.moduel;

import com.lenovo.bount.newsquarter.view.CommentView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by lenovo on 2017/12/14.
 */
@Module
public class CommentModuel {
    private CommentView view;

    public CommentModuel(CommentView view) {
        this.view = view;
    }
    @Provides
    CommentView prvoidesView()
    {
        return view;
    }
}
