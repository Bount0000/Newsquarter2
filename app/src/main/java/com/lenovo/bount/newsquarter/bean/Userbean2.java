package com.lenovo.bount.newsquarter.bean;

/**
 * Created by lenovo on 2017/11/27.
 */

public class Userbean2 {

    /**
     * msg : 获取用户信息成功
     * code : 0
     * data : {"age":null,"appkey":null,"appsecret":null,"createtime":"2017-11-30T19:47:01","email":null,"fans":0,"follow":0,"gender":0,"icon":"https://www.zhaoapi.cn/images/114.jpg","latitude":null,"longitude":null,"mobile":"15011462829","money":0,"nickname":"Bount","password":"000000","praiseNum":null,"token":"1D34763F54E391E345A71D6C3050A323","uid":114,"userId":null,"username":"15011462829"}
     */

    public String msg;
    public String code;
    public DataBean data;

    public static class DataBean {
        /**
         * age : null
         * appkey : null
         * appsecret : null
         * createtime : 2017-11-30T19:47:01
         * email : null
         * fans : 0
         * follow : 0
         * gender : 0
         * icon : https://www.zhaoapi.cn/images/114.jpg
         * latitude : null
         * longitude : null
         * mobile : 15011462829
         * money : 0
         * nickname : Bount
         * password : 000000
         * praiseNum : null
         * token : 1D34763F54E391E345A71D6C3050A323
         * uid : 114
         * userId : null
         * username : 15011462829
         */

        public Object age;
        public Object appkey;
        public Object appsecret;
        public String createtime;
        public Object email;
        public int fans;
        public int follow;
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
