package com.android.player.bean;

import java.io.Serializable;

/**
 * Created by Dhunter on 2020/6/5.
 */
public class ReplyBean implements Serializable {
    /**
     * type : reply
     * data : {"dataType":"ReplyBeanForClient","id":1230296904789655552,"videoId":186856,"videoTitle":"枪响之后没有赢家，带你身临其境体验战争","parentReplyId":0,"rootReplyId":1230296904789655552,"sequence":1,"message":"董卿在主持人大赛说过这句话：枪响之后没有赢家","replyStatus":"PUBLISHED","createTime":1582160615000,"user":{"uid":303533138,"nickname":"pursuitx","avatar":"http://img.kaiyanapp.com/7a2ec5e8cdbdec3c4f08e858d624b552.jpeg?imageMogr2/quality/60/format/jpg","userType":"NORMAL","ifPgc":false,"description":"Marvels\u2019s girl.\n人民有信仰，国家有力量.\n（ding～🌼✨这里是漫威女孩的个人分享主页，我会给大家推荐美剧，app，书籍，电影，壁纸等等.）","area":null,"gender":"female","registDate":1579167182000,"releaseDate":1582096809000,"cover":"http://img.kaiyanapp.com/77cc500a57126ec65e92c60a485e8b43.jpeg?imageMogr2/quality/60/format/jpg","actionUrl":"eyepetizer://pgc/detail/303533138/?title=pursuitx&userType=NORMAL&tabIndex=0","followed":false,"limitVideoOpen":false,"library":"BLOCK","birthday":1057075200000,"country":"澳大利亚","city":"","university":"","job":"学生","expert":false},"likeCount":46,"liked":false,"hot":false,"userType":null,"type":"video","actionUrl":null,"imageUrl":"","ugcVideoId":null,"parentReply":null,"showParentReply":true,"showConversationButton":false,"ugcVideoUrl":null,"cover":null,"userBlocked":false,"sid":"1230296904789655552"}
     * tag : null
     * id : 0
     * adIndex : -1
     */

    public String type;
    public DataBean data;
    public Object tag;
    public int id;
    public int adIndex;

    public static class DataBean {
        /**
         * dataType : ReplyBeanForClient
         * id : 1230296904789655552
         * videoId : 186856
         * videoTitle : 枪响之后没有赢家，带你身临其境体验战争
         * parentReplyId : 0
         * rootReplyId : 1230296904789655552
         * sequence : 1
         * message : 董卿在主持人大赛说过这句话：枪响之后没有赢家
         * replyStatus : PUBLISHED
         * createTime : 1582160615000
         * user : {"uid":303533138,"nickname":"pursuitx","avatar":"http://img.kaiyanapp.com/7a2ec5e8cdbdec3c4f08e858d624b552.jpeg?imageMogr2/quality/60/format/jpg","userType":"NORMAL","ifPgc":false,"description":"Marvels\u2019s girl.\n人民有信仰，国家有力量.\n（ding～🌼✨这里是漫威女孩的个人分享主页，我会给大家推荐美剧，app，书籍，电影，壁纸等等.）","area":null,"gender":"female","registDate":1579167182000,"releaseDate":1582096809000,"cover":"http://img.kaiyanapp.com/77cc500a57126ec65e92c60a485e8b43.jpeg?imageMogr2/quality/60/format/jpg","actionUrl":"eyepetizer://pgc/detail/303533138/?title=pursuitx&userType=NORMAL&tabIndex=0","followed":false,"limitVideoOpen":false,"library":"BLOCK","birthday":1057075200000,"country":"澳大利亚","city":"","university":"","job":"学生","expert":false}
         * likeCount : 46
         * liked : false
         * hot : false
         * userType : null
         * type : video
         * actionUrl : null
         * imageUrl :
         * ugcVideoId : null
         * parentReply : null
         * showParentReply : true
         * showConversationButton : false
         * ugcVideoUrl : null
         * cover : null
         * userBlocked : false
         * sid : 1230296904789655552
         */
        public String dataType;
        public long id;
        public int videoId;
        public String videoTitle;
        public int parentReplyId;
        public long rootReplyId;
        public int sequence;
        public String message;
        public String replyStatus;
        public long createTime;
        public UserBean user;
        public int likeCount;
        public boolean liked;
        public boolean hot;
        public Object userType;
        public String type;
        public Object actionUrl;
        public String imageUrl;
        public Object ugcVideoId;
        public Object parentReply;
        public boolean showParentReply;
        public boolean showConversationButton;
        public Object ugcVideoUrl;
        public Object cover;
        public boolean userBlocked;
        public String sid;

        public static class UserBean {
            /**
             * uid : 303533138
             * nickname : pursuitx
             * avatar : http://img.kaiyanapp.com/7a2ec5e8cdbdec3c4f08e858d624b552.jpeg?imageMogr2/quality/60/format/jpg
             * userType : NORMAL
             * ifPgc : false
             * description : Marvels’s girl.
             人民有信仰，国家有力量.
             （ding～🌼✨这里是漫威女孩的个人分享主页，我会给大家推荐美剧，app，书籍，电影，壁纸等等.）
             * area : null
             * gender : female
             * registDate : 1579167182000
             * releaseDate : 1582096809000
             * cover : http://img.kaiyanapp.com/77cc500a57126ec65e92c60a485e8b43.jpeg?imageMogr2/quality/60/format/jpg
             * actionUrl : eyepetizer://pgc/detail/303533138/?title=pursuitx&userType=NORMAL&tabIndex=0
             * followed : false
             * limitVideoOpen : false
             * library : BLOCK
             * birthday : 1057075200000
             * country : 澳大利亚
             * city :
             * university :
             * job : 学生
             * expert : false
             */

            public int uid;
            public String nickname;
            public String avatar;
            public String userType;
            public boolean ifPgc;
            public String description;
            public Object area;
            public String gender;
            public long registDate;
            public long releaseDate;
            public String cover;
            public String actionUrl;
            public boolean followed;
            public boolean limitVideoOpen;
            public String library;
            public long birthday;
            public String country;
            public String city;
            public String university;
            public String job;
            public boolean expert;
        }
    }
}
