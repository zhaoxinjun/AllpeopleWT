package zxj.com.allpeoplewt.module.serviceApi;


import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;
import zxj.com.allpeoplewt.bean.tvbean.FaceBean;

/**
 * 1.类的用途
 * 2.@author:zhaoxinjun
 * 3.@  2017/1/3.
 */

public interface IFaceApi {
    //11241742&v=2.2.4&os=1&ver=4
    @GET("list-android.json?11241742")
    Observable<FaceBean> getFaceData(
          //  @Query()String str,
            @Query("v")String v,
            @Query("os")String os,
            @Query("ver")String ver
    );
}
