package com.android.player.bean.viewmodel;

import com.android.common.entity.BaseCustomViewModel;

/**
 * Created by Dhunter on 2020/6/5.
 */
public class VideoCardViewModel extends BaseCustomViewModel {
    public String coverUrl;

    public int videoTime;

    public String title;

    public String description;

    public String authorUrl;

    public String video_description;

    public String userDescription;

    public String nickName;

    public String playerUrl;

    public String blurredUrl;

    public int videoId;

    // 点赞
    public int collectionCount;

    // 分享
    public int shareCount;
}
