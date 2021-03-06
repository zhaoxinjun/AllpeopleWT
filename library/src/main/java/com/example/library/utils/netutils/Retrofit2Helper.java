package com.example.library.utils.netutils;

import android.support.annotation.Nullable;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
*1.Retrofit2辅助类
*2.@zhaoxinjun
*3.2016/12/30
*/
public class Retrofit2Helper {

    private Retrofit mRetrofit;

    private String baseUrl = "";

    private Retrofit2Helper() {

    }

    public static Retrofit2Helper getInstance() {
        return LazyHolder.INSTANCE;
    }

    private static final class LazyHolder {
        private static final Retrofit2Helper INSTANCE = new Retrofit2Helper();
    }

    public Retrofit getRetrofit(@Nullable String baseUrl) {

        if(mRetrofit==null || !this.baseUrl.equals(baseUrl)){
            this.baseUrl=baseUrl;
            Retrofit.Builder builder = new Retrofit.Builder()
                    .client(OkHttpClientHelper.getInstance().getOkHttpClient())
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create());
            Retrofit retrofit = builder
                    .baseUrl(this.baseUrl)
                    .build();
            mRetrofit = retrofit;
        }
        return mRetrofit;
    }

}