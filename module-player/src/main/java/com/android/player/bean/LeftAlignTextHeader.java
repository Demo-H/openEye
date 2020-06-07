package com.android.player.bean;

import java.io.Serializable;

/**
 * Created by Dhunter on 2020/6/5.
 */
public class LeftAlignTextHeader implements Serializable {
    /**
     * type : leftAlignTextHeader
     * data : {"dataType":"LeftAlignTextHeader","text":"热门评论","font":"normal","actionUrl":"eyepetizer://replies/hot?videoId=186856&type=video","adTrack":null}
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
         * dataType : LeftAlignTextHeader
         * text : 热门评论
         * font : normal
         * actionUrl : eyepetizer://replies/hot?videoId=186856&type=video
         * adTrack : null
         */
        public String dataType;
        public String text;
        public String font;
        public String actionUrl;
        public Object adTrack;
    }
}
