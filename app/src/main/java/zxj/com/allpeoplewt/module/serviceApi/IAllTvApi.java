package zxj.com.allpeoplewt.module.serviceApi;


import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;
import zxj.com.allpeoplewt.bean.AlltvBean;

/**
 * 1.类的用途
 * 2.@author:zhaoxinjun
 * 3.@  2017/1/3.
 */

public interface IAllTvApi {
//    v=2.2.4&os=1&ver=4
    @GET("info-android.json")
    Observable<List<AlltvBean>> getAllTvData(
            @Query("v") String v,
            @Query("os") String os,
            @Query("ver") String ver

    );
//    @GET("wxnew")
//    Observable<WeChatBean> getWeChatData(
//            @Query("key") String key,
//            @Query("num") String num,
//            @Query("page") String page
//    );
}
