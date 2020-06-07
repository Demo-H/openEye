package com.android.player.bean;

import java.io.Serializable;

/**
 * Created by Dhunter on 2020/6/5.
 */
public class TextCard implements Serializable {
    /**
     * type : textCard
     * data : {"dataType":"TextCard","id":0,"type":"header4","text":"相关推荐","subTitle":null,"actionUrl":"","adTrack":null,"follow":null}
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
         * dataType : TextCard
         * id : 0
         * type : header4
         * text : 相关推荐
         * subTitle : null
         * actionUrl :
         * adTrack : null
         * follow : null
         */

        public String dataType;
        public int id;
        public String type;
        public String text;
        public Object subTitle;
        public String actionUrl;
        public Object adTrack;
        public Object follow;
    }
}
