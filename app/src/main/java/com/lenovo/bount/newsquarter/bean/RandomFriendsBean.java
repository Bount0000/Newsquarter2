package com.lenovo.bount.newsquarter.bean;

import java.util.List;

/**
 * Created by lenovo on 2017/12/18.
 */

public class RandomFriendsBean {

    /**
     * msg : 请求成功
     * code : 1
     * data : [{"age":null,"appkey":"35eae370ba9c65b7","appsecret":"003D15143367A956BE1C989386423EFF","createtime":"2017-11-14T15:31:18","email":null,"fans":null,"follow":null,"gender":null,"icon":null,"latitude":null,"longitude":null,"mobile":"13522933193","money":null,"nickname":null,"password":"8F669074CAF5513351A2DE5CC22AC04C","praiseNum":null,"token":null,"uid":2303,"userId":null,"username":"13522933193"},{"age":null,"appkey":"ee4a51dcec3a876a","appsecret":"9BFCC845EC3BF5BE17EDE936A55C7E18","createtime":"2017-11-14T15:41:26","email":null,"fans":null,"follow":null,"gender":null,"icon":null,"latitude":null,"longitude":null,"mobile":"18810809754","money":null,"nickname":null,"password":"8F669074CAF5513351A2DE5CC22AC04C","praiseNum":null,"token":null,"uid":2304,"userId":null,"username":"18810809754"},{"age":null,"appkey":"df739ef4c3800713","appsecret":"544CD81D9B8B6A90D84CCB7C06F8E352","createtime":"2017-11-14T15:42:27","email":null,"fans":null,"follow":null,"gender":null,"icon":null,"latitude":null,"longitude":null,"mobile":"18810709642","money":null,"nickname":null,"password":"36FEA9EDD86A667E4F3B327497470799","praiseNum":null,"token":null,"uid":2305,"userId":null,"username":"18810709642"},{"age":null,"appkey":"b9dd27aa2e7e7df2","appsecret":"26F1E1733B562201DB0FFE84446AA2B8","createtime":"2017-11-14T15:42:28","email":null,"fans":null,"follow":null,"gender":null,"icon":null,"latitude":null,"longitude":null,"mobile":"13522933139","money":null,"nickname":null,"password":"8F669074CAF5513351A2DE5CC22AC04C","praiseNum":null,"token":null,"uid":2306,"userId":null,"username":"13522933139"},{"age":null,"appkey":"a89981f66b1a0c9d","appsecret":"963CDA57312D3728C002EB93619CD6CA","createtime":"2017-11-14T16:24:37","email":null,"fans":null,"follow":null,"gender":null,"icon":null,"latitude":null,"longitude":null,"mobile":"18810425221","money":null,"nickname":null,"password":"8F669074CAF5513351A2DE5CC22AC04C","praiseNum":null,"token":null,"uid":2307,"userId":null,"username":"18810425221"},{"age":null,"appkey":"b01fa747687f038d","appsecret":"DCCFC75C7EB72D0E37FB55AEFBA1D33B","createtime":"2017-11-14T18:23:23","email":null,"fans":null,"follow":null,"gender":null,"icon":null,"latitude":null,"longitude":null,"mobile":"15878523654","money":null,"nickname":null,"password":"8F669074CAF5513351A2DE5CC22AC04C","praiseNum":null,"token":null,"uid":2308,"userId":null,"username":"15878523654"},{"age":null,"appkey":"4b9051ed85b89cdc","appsecret":"824983758FDE3A3FFA8A1F41CAFF2F51","createtime":"2017-11-15T09:47:54","email":null,"fans":null,"follow":null,"gender":null,"icon":null,"latitude":null,"longitude":null,"mobile":"13223431333","money":null,"nickname":null,"password":"8F669074CAF5513351A2DE5CC22AC04C","praiseNum":null,"token":"A4A4D34638C14AB416DC959B6002E0E4","uid":2309,"userId":null,"username":"13223431333"},{"age":null,"appkey":"4c2a16fcaf9d2569","appsecret":"57027F88043079ED03AB036D135A3F61","createtime":"2017-11-14T18:40:47","email":null,"fans":null,"follow":null,"gender":null,"icon":null,"latitude":null,"longitude":null,"mobile":"15936906487","money":null,"nickname":null,"password":"7792A1F7048ECB10FE716CE6FD38E884","praiseNum":null,"token":null,"uid":2310,"userId":null,"username":"15936906487"},{"age":null,"appkey":"c233a273fd390c3d","appsecret":"E60B673C574C77F7AAADC054ACF173F4","createtime":"2017-11-14T19:01:43","email":null,"fans":null,"follow":null,"gender":null,"icon":null,"latitude":null,"longitude":null,"mobile":"13534555433","money":null,"nickname":null,"password":"8F669074CAF5513351A2DE5CC22AC04C","praiseNum":null,"token":null,"uid":2311,"userId":null,"username":"13534555433"},{"age":null,"appkey":"58066478aea48f3d","appsecret":"7D09DCAB3CDBCA69EC6C7165BBEFFCE3","createtime":"2017-11-14T19:02:22","email":null,"fans":null,"follow":null,"gender":null,"icon":null,"latitude":null,"longitude":null,"mobile":"13556788909","money":null,"nickname":null,"password":"8F669074CAF5513351A2DE5CC22AC04C","praiseNum":null,"token":null,"uid":2312,"userId":null,"username":"13556788909"}]
     */

    public String msg;
    public String code;
    public List<DataBean> data;

    public static class DataBean {
        /**
         * age : null
         * appkey : 35eae370ba9c65b7
         * appsecret : 003D15143367A956BE1C989386423EFF
         * createtime : 2017-11-14T15:31:18
         * email : null
         * fans : null
         * follow : null
         * gender : null
         * icon : null
         * latitude : null
         * longitude : null
         * mobile : 13522933193
         * money : null
         * nickname : null
         * password : 8F669074CAF5513351A2DE5CC22AC04C
         * praiseNum : null
         * token : null
         * uid : 2303
         * userId : null
         * username : 13522933193
         */

        public Object age;
        public String appkey;
        public String appsecret;
        public String createtime;
        public Object email;
        public Object fans;
        public Object follow;
        public Object gender;
        public Object icon;
        public Object latitude;
        public Object longitude;
        public String mobile;
        public Object money;
        public Object nickname;
        public String password;
        public Object praiseNum;
        public Object token;
        public int uid;
        public Object userId;
        public String username;
    }
}
