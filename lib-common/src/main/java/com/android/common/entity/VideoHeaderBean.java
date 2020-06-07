package com.android.common.entity;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by Dhunter on 2020/6/4.
 */
public class VideoHeaderBean implements Parcelable {

    public String videoTitle;

    public String category;

    public String video_description;

    // 点赞
    public int collectionCount;

    // 分享
    public int shareCount;

    public String avatar;

    public String nickName;

    public String userDescription;

    public String playerUrl;

    public String blurredUrl;

    public int videoId;

    public VideoHeaderBean() {

    }

    public VideoHeaderBean(String videoTitle, String category,
                           String video_description, int collectionCount, int shareCount,
                           String avatar, String nickName, String userDescription,
                           String playerUrl, String blurredUrl, int videoId)
    {
        this.videoTitle = videoTitle;
        this.category = category;
        this.video_description = video_description;
        this.collectionCount = collectionCount;
        this.shareCount = shareCount;
        this.avatar = avatar;
        this.nickName = nickName;
        this.userDescription = userDescription;
        this.playerUrl = playerUrl;
        this.blurredUrl = blurredUrl;
        this.videoId = videoId;
    }

    protected VideoHeaderBean(Parcel in)
    {
        videoTitle = in.readString();
        category = in.readString();
        video_description = in.readString();
        collectionCount = in.readInt();
        shareCount = in.readInt();
        avatar = in.readString();
        nickName = in.readString();
        userDescription = in.readString();
        playerUrl = in.readString();
        blurredUrl = in.readString();
        videoId = in.readInt();

    }

    @Override
    public void writeToParcel(Parcel dest, int flags)
    {
        dest.writeString(videoTitle);
        dest.writeString(category);
        dest.writeString(video_description);
        dest.writeInt(collectionCount);
        dest.writeInt(shareCount);
        dest.writeString(avatar);
        dest.writeString(nickName);
        dest.writeString(userDescription);
        dest.writeString(playerUrl);
        dest.writeString(blurredUrl);
        dest.writeInt(videoId);
    }

    @Override
    public int describeContents()
    {
        return 0;
    }

    public static final Creator<VideoHeaderBean> CREATOR =
            new Creator<VideoHeaderBean>()
            {
                @Override
                public VideoHeaderBean createFromParcel(Parcel in)
                {
                    return new VideoHeaderBean(in);
                }

                @Override
                public VideoHeaderBean[] newArray(int size)
                {
                    return new VideoHeaderBean[size];
                }
            };

    @Override
    public String toString() {
        return "VideoHeaderBean{" +
                "videoTitle='" + videoTitle + '\'' +
                ", category='" + category + '\'' +
                ", video_description='" + video_description + '\'' +
                ", collectionCount=" + collectionCount +
                ", shareCount=" + shareCount +
                ", avatar='" + avatar + '\'' +
                ", nickName='" + nickName + '\'' +
                ", userDescription='" + userDescription + '\'' +
                ", playerUrl='" + playerUrl + '\'' +
                ", blurredUrl='" + blurredUrl + '\'' +
                ", videoId=" + videoId +
                '}';
    }
}
