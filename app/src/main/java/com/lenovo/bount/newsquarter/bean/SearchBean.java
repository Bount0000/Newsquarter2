package com.lenovo.bount.newsquarter.bean;

import java.util.List;

/**
 * Created by lenovo on 2017/12/9.
 */

public class SearchBean {

    /**
     * msg : 查询成功
     * code : 0
     * data : [{"age":null,"appkey":null,"appsecret":null,"createtime":"2017-12-07T14:39:02","email":null,"fans":null,"follow":null,"gender":0,"icon":"https://www.zhaoapi.cn/images/551.jpg","latitude":null,"longitude":null,"mobile":"15988888888","money":0,"nickname":"_zhang","password":"111111","praiseNum":null,"token":"AD7D76CB63F7A5E17C64A14A4FE588D1","uid":551,"userId":null,"username":"15988888888"}]
     * page : 1
     */

    public String msg;
    public String code;
    public int page;
    public List<DataBean> data;

    public static class DataBean {
        /**
         * age : null
         * appkey : null
         * appsecret : null
         * createtime : 2017-12-07T14:39:02
         * email : null
         * fans : null
         * follow : null
         * gender : 0
         * icon : https://www.zhaoapi.cn/images/551.jpg
         * latitude : null
         * longitude : null
         * mobile : 15988888888
         * money : 0
         * nickname : _zhang
         * password : 111111
         * praiseNum : null
         * token : AD7D76CB63F7A5E17C64A14A4FE588D1
         * uid : 551
         * userId : null
         * username : 15988888888
         */

        public Object age;
        public Object appkey;
        public Object appsecret;
        public String createtime;
        public Object email;
        public Object fans;
        public Object follow;
        public int gender;
        public String icon;
        public Object latitude;
        public Object longitude;
        public String mobile;
        public int money;
        public String nickname;
        public String password;
        public Object praiseNum;
        public String token;
        public int uid;
        public Object userId;
        public String username;
    }
}
