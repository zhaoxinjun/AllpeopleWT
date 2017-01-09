package zxj.com.allpeoplewt.module.serviceApi;


import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;
import zxj.com.allpeoplewt.bean.tvbean.EveryBean;

/**
 * 1.类的用途
 * 2.@author:zhaoxinjun
 * 3.@  2017/1/3.
 */

public interface IEveryApi {
    //v=2.2.4&os=1&ver=4
    @GET("json%2Fcategories%2F{a}%2Flist.json?11211639&os=1&v=2.2.4&os=1&ver=4")
    Observable<EveryBean> getEveryData(@Path("a") String a);
}
