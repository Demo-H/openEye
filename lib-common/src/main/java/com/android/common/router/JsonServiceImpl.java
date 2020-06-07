package com.android.common.router;

import android.content.Context;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.service.SerializationService;
import com.android.base.utils.GsonUtils;

import java.lang.reflect.Type;

/**
 * Created by Dhunter on 2020/6/4.
 */
@Route(path = "/video/json")
public class JsonServiceImpl implements SerializationService {
    @Override
    public <T> T json2Object(String input, Class<T> clazz) {
        return GsonUtils.fromLocalJson(input, clazz);
    }

    @Override
    public String object2Json(Object instance) {
        return GsonUtils.toJson(instance);
    }

    @Override
    public <T> T parseObject(String input, Type clazz) {
        return GsonUtils.fromLocalJson(input,clazz);
    }

    @Override
    public void init(Context context) {

    }
}
