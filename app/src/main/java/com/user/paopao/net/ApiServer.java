package com.user.paopao.net;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

/**
 * author：lily
 * date：2017/12/11 10:00
 * description: 接口请求方式
 */
public interface ApiServer {

    @GET("{url}")
    Observable<String> get(@Path("url") String url,
                           @QueryMap Map<String, String> maps);
    @FormUrlEncoded
    @POST("{prefix}/{url}")
    Observable<String> post(
            @Path("prefix") String prefix,
            @Path("url") String url,
            @FieldMap Map<String, String> maps);

    @POST("{url}")
    Observable<String> post(
            @Path("url") String url,
            @Body RequestBody body);

    @Multipart
    @POST("{url}")
    Observable<String> uploadFile(
            @Path("url") String url,
            @Part("description") RequestBody description,
            @Part MultipartBody.Part file);

    @Multipart
    @POST("{url}")
    Observable<String> uploadFile(
            @Path("url") String url,
            @PartMap Map<String, RequestBody> map);

    @GET
    Call<ResponseBody> downloadFile(@Url String fileUrl);
}
