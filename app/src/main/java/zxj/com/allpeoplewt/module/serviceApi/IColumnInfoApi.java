package zxj.com.allpeoplewt.module.serviceApi;


import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;
import zxj.com.allpeoplewt.bean.ColumnInfoBean;

/**
 * 1.类的用途
 * 2.@author:zhaoxinjun
 * 3.@  2017/1/3.
 */

public interface IColumnInfoApi {
    @GET("{id}")
    Observable<ColumnInfoBean> getColumnInfoData(@Path("id") String id);
}
