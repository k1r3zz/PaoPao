package com.user.paopao.net.okhttp;


import com.user.paopao.utils.MD5;
import com.user.paopao.utils.TimeUtils;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.Buffer;

/**
 * author：lily
 * date：2017/12/28 10:00
 * description: 公共请求参数拦截器类
 */
public class PublicParamsInterceptor implements Interceptor {
    public static final String MD5_KEY = "AUTOSHENGDA";

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();

        String method = request.method();

        if (method.equals("GET")) {
            request = addPublicParamsGet(request);
        } else if (method.equals("POST")) {
            request = addPublicParamsPost(request);
        }

        Response response = chain.proceed(request);
        return response;
    }

    private Request addPublicParamsPost(Request request) throws IOException {
        if (!(request.body() instanceof FormBody)) {
            return request;
        }

        FormBody body = (FormBody) request.body();

        String value = "";
        FormBody.Builder formBody = new FormBody.Builder();
        for (int i = 0; i < body.size(); i++) {
            String key = body.encodedName(i);
            String vue = body.encodedValue(i);
            formBody.addEncoded(key, vue);
            if ("service".equals(key)) {
                value = vue;
            }
        }

        String timestamp = TimeUtils.getTimestamp();
        String digest = getMD5Post(value, timestamp).trim();
        formBody.addEncoded("timestamp", timestamp);
        formBody.addEncoded("digest", digest);
        FormBody form = formBody.build();
        Buffer buffer = new Buffer();
        form.writeTo(buffer);

        return request.newBuilder().post(RequestBody.create(MediaType.parse("application/x-www-form-urlencoded;charset=UTF-8"), buffer.readUtf8())).build();
    }

    private String getMD5Post(String url, String timestamp) {
        StringBuffer sb = new StringBuffer();
        sb.append(MD5_KEY);
        sb.append(url);
        sb.append(timestamp);
        sb.append(MD5_KEY);
        String sign = MD5.encodeString(sb.toString(), "UTF-8");
        return sign;
    }

    private Request addPublicParamsGet(Request request) {
        String url = request.url().toString();

        String timestamp = TimeUtils.getTimestamp();
        String digest = getMD5(url, timestamp).trim();

        if (url.endsWith("&")) {
            url += "timestamp=" + timestamp + "&digest=" + digest;
        } else {
            url += "&timestamp=" + timestamp + "&digest=" + digest;
        }

        return request.newBuilder().url(url).build();
    }


    private String getMD5(String url, String time) {
        StringBuffer sb = new StringBuffer();
        sb.append(MD5_KEY);
        url = url.substring(url.indexOf("!") + 1, url.indexOf("?"));
        sb.append(url);
        sb.append(time);
        sb.append(MD5_KEY);
        String sign = MD5.encodeString(sb.toString(), "UTF-8");
        return sign;
    }
}
