package com.lenovo.bount.newsquarter.bean;

/**
 * Created by lenovo on 2017/12/4.
 */

public class GetVideoBean {
  private  String createTime ;
    private String icon ;
    private String nickname ;
    private String cover;
    private String videoUrl;

    public GetVideoBean() {
    }

    public GetVideoBean(String createTime, String icon, String nickname, String cover, String videoUrl) {

        this.createTime = createTime;
        this.icon = icon;
        this.nickname = nickname;
        this.cover = cover;
        this.videoUrl = videoUrl;
    }

    @Override
    public String toString() {
        return "GetVideoBean{" +
                "createTime='" + createTime + '\'' +
                ", icon='" + icon + '\'' +
                ", nickname='" + nickname + '\'' +
                ", cover='" + cover + '\'' +
                ", videoUrl='" + videoUrl + '\'' +
                '}';
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }
}
