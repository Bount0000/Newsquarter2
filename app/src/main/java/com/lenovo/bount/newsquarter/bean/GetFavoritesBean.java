package com.lenovo.bount.newsquarter.bean;

import java.util.List;

/**
 * Created by lenovo on 2017/12/18.
 */

public class GetFavoritesBean {


    /**
     * msg : 获取收藏列表成功
     * code : 0
     * data : [{"commentNum":0,"comments":[],"cover":"https://www.zhaoapi.cn/images/quarter/151338850155520171216094126.jpg","createTime":"2017-12-17T19:20:44","favoriteNum":5,"latitude":"null","localUri":null,"longitude":"null","playNum":0,"praiseNum":3,"uid":170,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1512559990209test.png","nickname":"%E6%9E%97","praiseNum":"null"},"videoUrl":"https://www.zhaoapi.cn/images/quarter/1513388501555VID_20171216_094056.3gp","wid":223,"workDesc":"视频"},{"commentNum":2,"comments":[{"cid":57,"content":"bbj","createTime":"2017-12-16T09:48:56","jid":null,"mvp":null,"nickname":"muzi","praiseNum":0,"uid":188,"wid":222},{"cid":65,"content":"lcc","createTime":"2017-12-16T11:53:05","jid":null,"mvp":null,"nickname":"李灿灿","praiseNum":0,"uid":148,"wid":222}],"cover":"https://www.zhaoapi.cn/images/quarter/15133878221070ffff64b399bee9d0413aee42c886f7e.jpg","createTime":"2017-12-17T19:20:44","favoriteNum":4,"latitude":"0.0","localUri":null,"longitude":"0.0","playNum":0,"praiseNum":4,"uid":150,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1512559990209test.png","nickname":"%E6%9E%97","praiseNum":"null"},"videoUrl":"https://www.zhaoapi.cn/images/quarter/15133878221071512894754287.mp4","wid":222,"workDesc":"卡丁车"}]
     */

    public String msg;
    public String code;
    public List<DataBean> data;

    public static class DataBean {
        /**
         * commentNum : 0
         * comments : []
         * cover : https://www.zhaoapi.cn/images/quarter/151338850155520171216094126.jpg
         * createTime : 2017-12-17T19:20:44
         * favoriteNum : 5
         * latitude : null
         * localUri : null
         * longitude : null
         * playNum : 0
         * praiseNum : 3
         * uid : 170
         * user : {"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1512559990209test.png","nickname":"%E6%9E%97","praiseNum":"null"}
         * videoUrl : https://www.zhaoapi.cn/images/quarter/1513388501555VID_20171216_094056.3gp
         * wid : 223
         * workDesc : 视频
         */

        public int commentNum;
        public String cover;
        public String createTime;
        public int favoriteNum;
        public String latitude;
        public Object localUri;
        public String longitude;
        public int playNum;
        public int praiseNum;
        public int uid;
        public UserBean user;
        public String videoUrl;
        public int wid;
        public String workDesc;
        public List<?> comments;

        public static class UserBean {
            /**
             * age : null
             * fans : null
             * follow : false
             * icon : https://www.zhaoapi.cn/images/1512559990209test.png
             * nickname : %E6%9E%97
             * praiseNum : null
             */

            public Object age;
            public String fans;
            public boolean follow;
            public String icon;
            public String nickname;
            public String praiseNum;
        }
    }
}
