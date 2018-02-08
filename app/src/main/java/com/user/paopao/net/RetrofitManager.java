package com.user.paopao.net;

import android.accounts.NetworkErrorException;
import android.support.annotation.NonNull;
import android.util.Log;

import com.user.paopao.Constant;
import com.user.paopao.MyApplication;
import com.user.paopao.net.okhttp.ProgressListener;
import com.user.paopao.net.okhttp.ProgressRequestBody;
import com.user.paopao.net.okhttp.ProgressResponseBody;
import com.user.paopao.utils.NetworkUtil;


import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ConnectionPool;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * author：lily
 * date：2017/12/11 10:00
 * description: 网络请求管理类
 */
public class RetrofitManager {

    private static final int CONNEC_TIMEOUT = 5; //超时时间 5s
    private static final int READ_TIMEOUT = 10;
    private static ApiServer apiServer;
    private static RetrofitManager mInstance;
    private static OkHttpClient mOkhttp;
    private static Retrofit mRetrofit;

    public static RetrofitManager getInstance() {
        if (mInstance == null) {
            synchronized (RetrofitManager.class) {
                if (mInstance == null) {
                    mInstance = new RetrofitManager();
                }
            }
        }
        return mInstance;
    }

    /**
     * 初始化Retrofit
     */
    private RetrofitManager() {
        mRetrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(ScalarsConverterFactory.create())
                .baseUrl(Constant.Base_Url)
                .client(getOkhttpClient())
                .build();
        apiServer = mRetrofit.create(ApiServer.class);
    }

    /**
     * 初始化OkHttpClient
     *
     * @return
     */
    private OkHttpClient getOkhttpClient() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.i("ly", message);
            }
        });
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        mOkhttp = new OkHttpClient.Builder()
//                .addInterceptor(new PublicParamsInterceptor())
//                .addNetworkInterceptor(mTokenInterceptor)
//                .authenticator(mAuthenticator)
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        if (NetworkUtil.isNetworkAvailable(MyApplication.getInstance().getApplicationContext())) {
                            return chain.proceed(chain.request());
                        } else {
                            try {
                                throw new NetworkErrorException();
                            } catch (NetworkErrorException e) {
                                e.printStackTrace();
                            }
                        }
                        return null;
                    }
                })
                .addInterceptor(httpLoggingInterceptor)
                .connectTimeout(CONNEC_TIMEOUT, TimeUnit.SECONDS) //设置超时时间
                .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)  //设置读取超时时间
                .writeTimeout(READ_TIMEOUT, TimeUnit.SECONDS)  //设置写入超时时间
                .retryOnConnectionFailure(false)
                .connectionPool(new ConnectionPool())
                .hostnameVerifier(new HostnameVerifier() {   //添加https支持
                    @Override
                    public boolean verify(String hostname, SSLSession session) {
                        return true;
                    }
                })
                .build();
        return mOkhttp;
    }

    public ApiServer getApiServer() {
        return apiServer;
    }

    /**
     * get请求
     *
     * @param url
     * @param params
     * @param observer
     */
    public void get(String url, Map<String, String> params, Observer observer) {
        getApiServer().get(url, params).subscribeOn(Schedulers.io()).unsubscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(observer);
    }

    /**
     * post key-value 请求
     *
     * @param url
     * @param params
     * @param observer
     */
//    public void post(String baseurl, String url, Map<String, String> params, Observer observer) {
////        Url.BaseUrl = baseurl;
//        getApiServer().post(url, params).subscribeOn(Schedulers.io()).unsubscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(observer);
//    }
    public void post(String baseurl, String url, Map<String, String> params, Observer observer) {
//        Url.BaseUrl = baseurl;
        getApiServer().post(baseurl, url, params).subscribeOn(Schedulers.io()).unsubscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(observer);
    }

//    /**
//     * post json请求
//     *
//     * @param url
//     * @param json
//     * @param observer
//     */
//    public void json(String url, String json, Observer observer) {
//        RequestBody body = RequestBody.create(MediaType.parse("application/json;charset=utf-8"), json);
//        getApiServer().post(url, body).subscribeOn(Schedulers.io()).unsubscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(observer);
//    }

    /**
     * 上传单个文件
     *
     * @param url
     * @param file
     * @param progress
     */
    public void uploadFile(String url, File file, @NonNull final ProgressListener progress, Observer observer) {
        OkHttpClient.Builder newBuilder = mOkhttp.newBuilder();
        List<Interceptor> networkInterceptors = newBuilder.networkInterceptors();

        Interceptor it = new Interceptor() {
            @Override
            public Response intercept(Chain arg0) throws IOException {
                Request request = arg0.request();
                Request build = request.newBuilder().method(request.method(), new ProgressRequestBody(request.body(), progress)).build();
                return arg0.proceed(build);
            }
        };

        networkInterceptors.add(it);
        ApiServer apiServer = mRetrofit.newBuilder().client(newBuilder.build()).build().create(ApiServer.class);
        RequestBody body = RequestBody.create(MediaType.parse("multipart/form-data"), file);
        MultipartBody.Part part = MultipartBody.Part.createFormData("image", file.getName(), body);
        RequestBody des = RequestBody.create(MediaType.parse("multipart/form-data"), "des");
        apiServer.uploadFile(url, des, part).subscribeOn(Schedulers.io()).unsubscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(observer);
    }


    /**
     * 上传多个文件   --- TODO:
     *
     * @param url
     * @param files
     * @param observer
     */
    public void uploadFile(String url, List<File> files, Observable observer) {
        HashMap<String, RequestBody> maps = new HashMap<>();
        for (int i = 0; i < files.size(); i++) {
            File file = files.get(i);
            RequestBody body = RequestBody
                    .create(MediaType.parse("multipart/form-data"), file);
            maps.put(file.getName(), body);
        }
//        getApiServer().uploadFile(url, maps).subscribeOn(Schedulers.io()).unsubscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(observer);
    }

    /**
     * 下载文件
     *
     * @param url
     * @param listener
     */
    public void downLoadFile(String url, @NonNull final ProgressListener listener, @NonNull final retrofit2.Callback<ResponseBody> call) {
        OkHttpClient.Builder newBuilder = mOkhttp.newBuilder();
        List<Interceptor> networkInterceptors = newBuilder.networkInterceptors();

        Interceptor it = new Interceptor() {
            @Override
            public Response intercept(Chain arg0) throws IOException {
                Response proceed = arg0.proceed(arg0.request());
                ProgressResponseBody body = new ProgressResponseBody(proceed.body(), listener);
                return proceed.newBuilder().body(body).build();
            }
        };

        networkInterceptors.add(it);
        Retrofit build = mRetrofit.newBuilder().client(newBuilder.build()).build();
        ApiServer apiServer = build.create(ApiServer.class);
        apiServer.downloadFile(url).enqueue(call);
    }

//    Interceptor mTokenInterceptor = new Interceptor() {
//        @Override
//        public Response intercept(Chain chain) throws IOException {
//            Request originalRequest = chain.request();
//            if (AppData.getLogin() == null || AppData.getLogin().getToken() == null) {
//                return chain.proceed(originalRequest);
//            }
//            Request authorised = originalRequest.newBuilder()
//                    .header("token", AppData.getLogin().getToken())
//                    .build();
//            return chain.proceed(authorised);
//        }
//    };

//    Interceptor mTokenInterceptor = new Interceptor() {
//        @Override
//        public Response intercept(Chain chain) throws IOException {
//            Request originalRequest = chain.request();
//            if (Your.sToken == null || alreadyHasAuthorizationHeader(originalRequest)) {
//                return chain.proceed(originalRequest);
//            }
//            Request authorised = originalRequest.newBuilder()
//                    .header("Authorization", Your.sToken)
//                    .build();
//            return chain.proceed(authorised);
//        }
//    };

//    Authenticator mAuthenticator = new Authenticator() {
//        @Override public Request authenticate(Route route, Response response)
//                throws IOException {
//            Your.sToken = service.refreshToken();
//            return response.request().newBuilder()
//                    .addHeader("Authorization", newAccessToken)
//                    .build();
//        }
//    }
}
