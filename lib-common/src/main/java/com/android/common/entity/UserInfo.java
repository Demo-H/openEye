package com.android.common.entity;

import androidx.annotation.NonNull;

import java.io.Serializable;

/**
 * Created by Dhunter on 2020/6/4.
 */
public class UserInfo {
    @NonNull
    public String uuid;

    public String birthday;

    public String sex;

    public String accessToken;

    public String refreshToken;

    // 到期时间
    public String tokenExpireTime;

    public int type;

    public String name;

    public String email;

    public String phone;

    public String signature;

    public String avatarRemoteUrl;

    public ThirdAccount[] thirdAccounts;

    public String regionId;

    public class ThirdAccount implements Serializable {
        public String avatarUrl;
        public String nickName;
        public String openId;
        public int thirdType;
        public String token;
        public String unionId;
        public String email;
    }

    private UserInfo(){
        throw new UnsupportedOperationException("Do not instantiate");
    }

    public static UserInfo getInstance(){
        return UserHolder.INSTANCE;
    }

    private static class UserHolder{
        private static  final UserInfo INSTANCE =  new UserInfo();
    }
}
