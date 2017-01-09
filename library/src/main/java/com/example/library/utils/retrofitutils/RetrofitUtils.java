package com.example.library.utils.retrofitutils;

import com.example.library.utils.OkHttpUtils;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
*1.类的用途
*2.@zhaoxinjun
*3.2016/12/30
*/

public class RetrofitUtils {
    private static Retrofit retrofit;
   // private static  String url;
    public static Retrofit getRetrofit(String baseUrl){
        if(retrofit==null){
            synchronized (RetrofitUtils.class){
                if(retrofit==null) {
                    //url = baseUrl;
                     retrofit = new Retrofit

                             .Builder()
                            .baseUrl(baseUrl)
                            .client(new OkHttpClient.Builder().addInterceptor(new
                                    HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)).build())
                        .callFactory(OkHttpUtils.getOkHttpClient())
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();
                }
            }
        }
      return retrofit;
    }
    public <T> T create(final Class<T> cls,String baseurl) {
        T t = getRetrofit(baseurl).create(cls);
        return t;
    }


}
