package com.android.player;

import com.android.base.model.BaseModel;
import com.android.base.utils.GsonUtils;
import com.android.common.entity.BaseCustomViewModel;
import com.android.common.global.GlobalKey;
import com.android.player.bean.LeftAlignTextHeader;
import com.android.player.bean.ReplyBean;
import com.android.player.bean.TextCard;
import com.android.player.bean.VideoSmallCard;
import com.android.player.bean.viewmodel.ReplyViewModel;
import com.android.player.bean.viewmodel.VideoCardViewModel;
import com.android.player.bean.viewmodel.VideoTextViewModel;
import com.android.rxeasyhttp.EasyHttp;
import com.android.rxeasyhttp.exception.ApiException;
import com.android.rxeasyhttp.subsciber.BaseSubscriber;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import io.reactivex.Observable;
import io.reactivex.functions.BiFunction;

/**
 * Created by Dhunter on 2020/6/5.
 */
public class VideoPlayerModel<T> extends BaseModel<T> {
    /**
     * 相关推荐
     */
    public static final String NOMINATE_URL = GlobalKey.BASE_URL + "/v4/video/related";
    /**
     * 热门评论
     */
    public static final String REPLY_URL = GlobalKey.BASE_URL + "/v2/replies/video";
    public int videoId = 186856;

    @Override
    protected void load() {
        Observable<String> nominateObservable = EasyHttp.get(NOMINATE_URL)
                .params("id", String.valueOf(videoId))
                .cacheKey("nominate")
                .execute(String.class);
        Observable<String> replyObservable = EasyHttp.get(REPLY_URL)
                .params("videoId", String.valueOf(videoId))
                .cacheKey("reply")
                .execute(String.class);
        Observable.zip(nominateObservable,
                replyObservable,
                new BiFunction<String, String, ArrayList<BaseCustomViewModel>>() {
                    @Override
                    public ArrayList<BaseCustomViewModel> apply(String s, String s2)
                            throws Exception {
                        return parseJson(s, s2);

                    }
                }).subscribe(new BaseSubscriber<ArrayList<BaseCustomViewModel>>() {
            @Override
            public void onError(ApiException e)
            {
                loadFail(e.getMessage());
            }

            @Override
            public void onNext(ArrayList<BaseCustomViewModel> viewModels) {
                loadSuccess((T)viewModels);
            }
        });
    }

    private ArrayList<BaseCustomViewModel> parseJson(String nominateData,
                                                     String replyData) {
        ArrayList<BaseCustomViewModel> viewModels = new ArrayList<>();
        parseNominateData(viewModels, nominateData);
        parseReplyData(viewModels, replyData);
        return viewModels;
    }

    private void parseNominateData(ArrayList<BaseCustomViewModel> viewModels,
                                   String nominateData) {
        try {
            JSONObject jsonObject = new JSONObject(nominateData);
            JSONArray itemList = jsonObject.optJSONArray("itemList");
            if (itemList != null) {
                for (int i = 0; i < itemList.length(); i++) {
                    JSONObject ccurrentObject = itemList.getJSONObject(i);
                    switch (ccurrentObject.optString("type")) {
                        case "textCard":
                            TextCard textCard = GsonUtils.fromLocalJson(
                                    ccurrentObject.toString(),
                                    TextCard.class);
                            VideoTextViewModel textViewModel =
                                    new VideoTextViewModel();
                            textViewModel.textTitle =
                                    textCard.data.text;
                            viewModels.add(textViewModel);
                            break;
                        case "videoSmallCard":
                            VideoSmallCard videoSmallCard = GsonUtils
                                    .fromLocalJson(ccurrentObject.toString(),
                                            VideoSmallCard.class);
                            paresVideoCard(viewModels, videoSmallCard);
                            break;
                        default:
                            break;
                    }
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void parseReplyData(ArrayList<BaseCustomViewModel> viewModels,
                                String replyData) {
        try {
            JSONObject jsonObject = new JSONObject(replyData);
            JSONArray itemList = jsonObject.optJSONArray("itemList");
            if (itemList != null) {
                for (int i = 0; i < itemList.length(); i++) {
                    JSONObject ccurrentObject = itemList.getJSONObject(i);
                    switch (ccurrentObject.optString("type")) {
                        case "leftAlignTextHeader":
                            LeftAlignTextHeader alignTextHeader = GsonUtils
                                    .fromLocalJson(ccurrentObject.toString(),
                                            LeftAlignTextHeader.class);
                            VideoTextViewModel textViewModel =
                                    new VideoTextViewModel();
                            textViewModel.textTitle =
                                    alignTextHeader.data.text;
                            viewModels.add(textViewModel);
                            break;
                        case "reply":
                            ReplyBean reply = GsonUtils.fromLocalJson(
                                    ccurrentObject.toString(),
                                    ReplyBean.class);
                            ReplyViewModel replyViewModel =
                                    new ReplyViewModel();
                            if (reply != null) {
                                replyViewModel.avatar =
                                        reply.data.user.avatar;
                                replyViewModel.nickName =
                                        reply.data.user.nickname;
                                replyViewModel.replyMessage =
                                        reply.data.message;
                                replyViewModel.releaseTime =
                                        reply.data.user.releaseDate;
                                replyViewModel.likeCount =
                                        reply.data.likeCount;
                                viewModels.add(replyViewModel);
                            }
                            break;
                        default:
                            break;
                    }
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void paresVideoCard(ArrayList<BaseCustomViewModel> viewModels,
                                VideoSmallCard videoSmallCard) {
        if (videoSmallCard == null) {
            return;
        }
        VideoCardViewModel videoCardViewModel = new VideoCardViewModel();
        videoCardViewModel.coverUrl =
                videoSmallCard.data.cover.detail;
        videoCardViewModel.videoTime = videoSmallCard.data.duration;
        videoCardViewModel.title = videoSmallCard.data.title;
        videoCardViewModel.description =
                videoSmallCard.data.author.name + " / # "
                        + videoSmallCard.data.category;
        videoCardViewModel.authorUrl =
                videoSmallCard.data.author.icon;
        videoCardViewModel.userDescription =
                videoSmallCard.data.author.description;
        videoCardViewModel.nickName =
                videoSmallCard.data.author.name;
        videoCardViewModel.video_description =
                videoSmallCard.data.description;
        videoCardViewModel.playerUrl = videoSmallCard.data.playUrl;
        videoCardViewModel.blurredUrl =
                videoSmallCard.data.cover.blurred;
        videoCardViewModel.videoId = videoSmallCard.data.id;
        videoCardViewModel.collectionCount =
                videoSmallCard.data.consumption.collectionCount;
        videoCardViewModel.shareCount =
                videoSmallCard.data.consumption.shareCount;
        viewModels.add(videoCardViewModel);
    }

}
