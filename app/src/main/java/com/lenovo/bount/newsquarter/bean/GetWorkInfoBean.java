package com.lenovo.bount.newsquarter.bean;

import java.util.List;

/**
 * Created by lenovo on 2017/12/15.
 */

public class GetWorkInfoBean {

    /**
     * msg : 获取作品列表成功
     * code : 0
     * data : {"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1512559990209test.png","nickname":"%E6%9E%97","praiseNum":"null"},"worksEntities":[{"commentNum":null,"cover":"https://www.zhaoapi.cn/images/quarter/1512464846443007.jpg","createTime":"2017-12-05T17:07:26","favoriteNum":null,"latitude":"40","localUri":null,"longitude":"116","playNum":null,"praiseNum":null,"uid":114,"videoUrl":"https://www.zhaoapi.cn/images/quarter/1512464846443PictureSelector_20171205_160204.mp4","wid":48,"workDesc":null},{"commentNum":null,"cover":"https://www.zhaoapi.cn/images/quarter/1512464885865007.jpg","createTime":"2017-12-05T17:08:05","favoriteNum":null,"latitude":"40","localUri":null,"longitude":"116","playNum":null,"praiseNum":null,"uid":114,"videoUrl":"https://www.zhaoapi.cn/images/quarter/1512464885865PictureSelector_20171205_160204.mp4","wid":49,"workDesc":null},{"commentNum":null,"cover":"https://www.zhaoapi.cn/images/quarter/1512465219115007.jpg","createTime":"2017-12-05T17:13:39","favoriteNum":null,"latitude":"40","localUri":null,"longitude":"116","playNum":null,"praiseNum":null,"uid":114,"videoUrl":"https://www.zhaoapi.cn/images/quarter/1512465219115PictureSelector_20171205_160204.mp4","wid":50,"workDesc":""},{"commentNum":null,"cover":"https://www.zhaoapi.cn/images/quarter/151254950635020171206163810.jpg","createTime":"2017-12-06T16:38:26","favoriteNum":null,"latitude":"40","localUri":null,"longitude":"116","playNum":null,"praiseNum":null,"uid":114,"videoUrl":"https://www.zhaoapi.cn/images/quarter/1512549506350video_20171206_163745.mp4","wid":84,"workDesc":"发布视频"},{"commentNum":null,"cover":"https://www.zhaoapi.cn/images/quarter/151254966761520171206164052.jpg","createTime":"2017-12-06T16:41:07","favoriteNum":null,"latitude":"40","localUri":null,"longitude":"116","playNum":null,"praiseNum":null,"uid":114,"videoUrl":"https://www.zhaoapi.cn/images/quarter/1512549667615video_20171206_164024.mp4","wid":85,"workDesc":"发布视频"},{"commentNum":null,"cover":"https://www.zhaoapi.cn/images/quarter/151254968384920171206164052.jpg","createTime":"2017-12-06T16:41:23","favoriteNum":null,"latitude":"40","localUri":null,"longitude":"116","playNum":null,"praiseNum":null,"uid":114,"videoUrl":"https://www.zhaoapi.cn/images/quarter/1512549683849video_20171206_164024.mp4","wid":86,"workDesc":"发布视频"},{"commentNum":null,"cover":"https://www.zhaoapi.cn/images/quarter/151254969142820171206164052.jpg","createTime":"2017-12-06T16:41:31","favoriteNum":null,"latitude":"40","localUri":null,"longitude":"116","playNum":null,"praiseNum":null,"uid":114,"videoUrl":"https://www.zhaoapi.cn/images/quarter/1512549691428video_20171206_164024.mp4","wid":87,"workDesc":"发布视频"},{"commentNum":null,"cover":"https://www.zhaoapi.cn/images/quarter/151254969469320171206164052.jpg","createTime":"2017-12-06T16:41:34","favoriteNum":null,"latitude":"40","localUri":null,"longitude":"116","playNum":null,"praiseNum":null,"uid":114,"videoUrl":"https://www.zhaoapi.cn/images/quarter/1512549694693video_20171206_164024.mp4","wid":88,"workDesc":"发布视频"},{"commentNum":null,"cover":"https://www.zhaoapi.cn/images/quarter/151254969692820171206164052.jpg","createTime":"2017-12-06T16:41:36","favoriteNum":null,"latitude":"40","localUri":null,"longitude":"116","playNum":null,"praiseNum":null,"uid":114,"videoUrl":"https://www.zhaoapi.cn/images/quarter/1512549696928video_20171206_164024.mp4","wid":89,"workDesc":"发布视频"},{"commentNum":null,"cover":"https://www.zhaoapi.cn/images/quarter/151254969770920171206164052.jpg","createTime":"2017-12-06T16:41:37","favoriteNum":null,"latitude":"40","localUri":null,"longitude":"116","playNum":null,"praiseNum":null,"uid":114,"videoUrl":"https://www.zhaoapi.cn/images/quarter/1512549697709video_20171206_164024.mp4","wid":90,"workDesc":"发布视频"}]}
     */

    public String msg;
    public String code;
    public DataBean data;

    public static class DataBean {
        /**
         * user : {"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1512559990209test.png","nickname":"%E6%9E%97","praiseNum":"null"}
         * worksEntities : [{"commentNum":null,"cover":"https://www.zhaoapi.cn/images/quarter/1512464846443007.jpg","createTime":"2017-12-05T17:07:26","favoriteNum":null,"latitude":"40","localUri":null,"longitude":"116","playNum":null,"praiseNum":null,"uid":114,"videoUrl":"https://www.zhaoapi.cn/images/quarter/1512464846443PictureSelector_20171205_160204.mp4","wid":48,"workDesc":null},{"commentNum":null,"cover":"https://www.zhaoapi.cn/images/quarter/1512464885865007.jpg","createTime":"2017-12-05T17:08:05","favoriteNum":null,"latitude":"40","localUri":null,"longitude":"116","playNum":null,"praiseNum":null,"uid":114,"videoUrl":"https://www.zhaoapi.cn/images/quarter/1512464885865PictureSelector_20171205_160204.mp4","wid":49,"workDesc":null},{"commentNum":null,"cover":"https://www.zhaoapi.cn/images/quarter/1512465219115007.jpg","createTime":"2017-12-05T17:13:39","favoriteNum":null,"latitude":"40","localUri":null,"longitude":"116","playNum":null,"praiseNum":null,"uid":114,"videoUrl":"https://www.zhaoapi.cn/images/quarter/1512465219115PictureSelector_20171205_160204.mp4","wid":50,"workDesc":""},{"commentNum":null,"cover":"https://www.zhaoapi.cn/images/quarter/151254950635020171206163810.jpg","createTime":"2017-12-06T16:38:26","favoriteNum":null,"latitude":"40","localUri":null,"longitude":"116","playNum":null,"praiseNum":null,"uid":114,"videoUrl":"https://www.zhaoapi.cn/images/quarter/1512549506350video_20171206_163745.mp4","wid":84,"workDesc":"发布视频"},{"commentNum":null,"cover":"https://www.zhaoapi.cn/images/quarter/151254966761520171206164052.jpg","createTime":"2017-12-06T16:41:07","favoriteNum":null,"latitude":"40","localUri":null,"longitude":"116","playNum":null,"praiseNum":null,"uid":114,"videoUrl":"https://www.zhaoapi.cn/images/quarter/1512549667615video_20171206_164024.mp4","wid":85,"workDesc":"发布视频"},{"commentNum":null,"cover":"https://www.zhaoapi.cn/images/quarter/151254968384920171206164052.jpg","createTime":"2017-12-06T16:41:23","favoriteNum":null,"latitude":"40","localUri":null,"longitude":"116","playNum":null,"praiseNum":null,"uid":114,"videoUrl":"https://www.zhaoapi.cn/images/quarter/1512549683849video_20171206_164024.mp4","wid":86,"workDesc":"发布视频"},{"commentNum":null,"cover":"https://www.zhaoapi.cn/images/quarter/151254969142820171206164052.jpg","createTime":"2017-12-06T16:41:31","favoriteNum":null,"latitude":"40","localUri":null,"longitude":"116","playNum":null,"praiseNum":null,"uid":114,"videoUrl":"https://www.zhaoapi.cn/images/quarter/1512549691428video_20171206_164024.mp4","wid":87,"workDesc":"发布视频"},{"commentNum":null,"cover":"https://www.zhaoapi.cn/images/quarter/151254969469320171206164052.jpg","createTime":"2017-12-06T16:41:34","favoriteNum":null,"latitude":"40","localUri":null,"longitude":"116","playNum":null,"praiseNum":null,"uid":114,"videoUrl":"https://www.zhaoapi.cn/images/quarter/1512549694693video_20171206_164024.mp4","wid":88,"workDesc":"发布视频"},{"commentNum":null,"cover":"https://www.zhaoapi.cn/images/quarter/151254969692820171206164052.jpg","createTime":"2017-12-06T16:41:36","favoriteNum":null,"latitude":"40","localUri":null,"longitude":"116","playNum":null,"praiseNum":null,"uid":114,"videoUrl":"https://www.zhaoapi.cn/images/quarter/1512549696928video_20171206_164024.mp4","wid":89,"workDesc":"发布视频"},{"commentNum":null,"cover":"https://www.zhaoapi.cn/images/quarter/151254969770920171206164052.jpg","createTime":"2017-12-06T16:41:37","favoriteNum":null,"latitude":"40","localUri":null,"longitude":"116","playNum":null,"praiseNum":null,"uid":114,"videoUrl":"https://www.zhaoapi.cn/images/quarter/1512549697709video_20171206_164024.mp4","wid":90,"workDesc":"发布视频"}]
         */

        public UserBean user;
        public List<WorksEntitiesBean> worksEntities;

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

        public static class WorksEntitiesBean {
            /**
             * commentNum : null
             * cover : https://www.zhaoapi.cn/images/quarter/1512464846443007.jpg
             * createTime : 2017-12-05T17:07:26
             * favoriteNum : null
             * latitude : 40
             * localUri : null
             * longitude : 116
             * playNum : null
             * praiseNum : null
             * uid : 114
             * videoUrl : https://www.zhaoapi.cn/images/quarter/1512464846443PictureSelector_20171205_160204.mp4
             * wid : 48
             * workDesc : null
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
            public Object workDesc;
        }
    }
}
