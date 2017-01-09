package zxj.com.allpeoplewt.module.serviceApi;


import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;
import zxj.com.allpeoplewt.bean.tvbean.JingCai;

/**
 * 1.类的用途
 * 2.@author:zhaoxinjun
 * 3.@  2017/1/3.
 */

public interface IJCApi {
    @GET("json%2Fcategories%2F%2Flist.json?11211639")
    Observable<List<JingCai>> getJCData(@Query("v") String v,
                                            @Query("os") String os,
                                            @Query("ver") String ver);
}
