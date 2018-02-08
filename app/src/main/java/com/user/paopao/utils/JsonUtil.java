package com.user.paopao.utils;


import com.google.gson.Gson;
import com.user.paopao.entity.BaseBean;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * author :kira
 * date: 2018/1/31.
 * description:
 */

public class JsonUtil {


    public static <T> BaseBean<T> fromJsonObject(String reader, Class<T> clazz) {
        Gson gson = new Gson();
        Type type = new ParameterizedTypeImpl(BaseBean.class, new Class[]{clazz});
        return gson.fromJson(reader, type);
    }

    public static <T> BaseBean<List<T>> fromJsonArray(String reader, Class<T> clazz) {
        Gson gson = new Gson();
        // 生成List<T> 中的 List<T>
        Type listType = new ParameterizedTypeImpl(List.class, new Class[]{clazz});
        // 根据List<T>生成完整的Result<List<T>>
        Type type = new ParameterizedTypeImpl(BaseBean.class, new Type[]{listType});
        return gson.fromJson(reader, type);
    }


}



