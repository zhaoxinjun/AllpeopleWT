package zxj.com.allpeoplewt.module.serviceApi;


import retrofit2.http.GET;
import rx.Observable;
import zxj.com.allpeoplewt.bean.ColumnBean;

/**
 * 1.类的用途
 * 2.@author:zhaoxinjun
 * 3.@  2017/1/3.
 */

public interface IColumnApi {
    @GET("sections")
    Observable<ColumnBean> getColumnData();
}
