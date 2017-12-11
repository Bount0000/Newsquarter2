package com.lenovo.bount.newsquarter.bean;

import java.util.List;

/**
 * Created by lenovo on 2017/12/7.
 */

public class Getuser {

    /**
     * msg : 获取作品列表成功
     * code : 0
     * data : [{"commentNum":null,"cover":"https://www.zhaoapi.cn/images/quarter/151254239806820171206143946.jpg","createTime":"2017-12-06T14:39:58","favoriteNum":null,"latitude":"40","localUri":null,"longitude":"116","playNum":null,"praiseNum":null,"uid":146,"videoUrl":"https://www.zhaoapi.cn/images/quarter/1512542398068video_20171206_143923.mp4","wid":79,"workDesc":"这次"},{"commentNum":null,"cover":"https://www.zhaoapi.cn/images/quarter/151254244560020171206144014.jpg","createTime":"2017-12-06T14:40:45","favoriteNum":null,"latitude":"40","localUri":null,"longitude":"116","playNum":null,"praiseNum":null,"uid":146,"videoUrl":"https://www.zhaoapi.cn/images/quarter/1512542445600video_20171206_143923.mp4","wid":80,"workDesc":"123"},{"commentNum":null,"cover":"https://www.zhaoapi.cn/images/quarter/151254272558420171206144516.jpg","createTime":"2017-12-06T14:45:25","favoriteNum":null,"latitude":"40","localUri":null,"longitude":"116","playNum":null,"praiseNum":null,"uid":146,"videoUrl":"https://www.zhaoapi.cn/images/quarter/1512542725584video_20171206_144430.mp4","wid":81,"workDesc":"这次崩溃了吗？"}]
     */

    public String msg;
    public String code;
    public List<DataBean> data;

    public static class DataBean {
        /**
         * commentNum : null
         * cover : https://www.zhaoapi.cn/images/quarter/151254239806820171206143946.jpg
         * createTime : 2017-12-06T14:39:58
         * favoriteNum : null
         * latitude : 40
         * localUri : null
         * longitude : 116
         * playNum : null
         * praiseNum : null
         * uid : 146
         * videoUrl : https://www.zhaoapi.cn/images/quarter/1512542398068video_20171206_143923.mp4
         * wid : 79
         * workDesc : 这次
         */

        public Object commentNum;
        public String cover;
        public String createTime;
        public Object favoriteNum;
        public String latitude;
        public Object localUri;
        public String longitude;
        public Object playNum;
        public Object praiseNum;
        public int uid;
        public String videoUrl;
        public int wid;
        public String workDesc;
    }
}
