package zxj.com.allpeoplewt.module.serviceApi;


import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;
import zxj.com.allpeoplewt.bean.WeChatBean;

/**
 * 1.类的用途
 * 2.@author:zhaoxinjun
 * 3.@  2017/1/3.
 */

public interface IWeChatApi {
//http://api.tianapi.com/wxnew?key=3d88f5fb6e5a1fbf2921dbb643f25894&num=10&page=1
//http://api.tianapi.com/
// wxnew
// ?key=3d88f5fb6e5a1fbf2921dbb643f25894
// &num=10
// &page=1
    @GET("wxnew")
    Observable<WeChatBean> getWeChatData(
            @Query("key") String key,
            @Query("num") String num,
            @Query("page") String page
    );
//Observable<WetChatBean> getWetData(@Query("key") String key, @Query("num") String num, @Query("page") String page);
}
