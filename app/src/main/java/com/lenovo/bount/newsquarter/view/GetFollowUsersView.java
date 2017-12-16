package com.lenovo.bount.newsquarter.view;

import com.lenovo.bount.newsquarter.bean.GetFollowUsersBean;

/**
 * Created by lenovo on 2017/12/14.
 */

public interface GetFollowUsersView
{
    void FollowSucces(GetFollowUsersBean getFollowUsersBean);
    void FollowError(String msg);
    void FollowOnFrair(String msg);
}
