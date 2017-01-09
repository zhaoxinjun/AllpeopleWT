package zxj.com.allpeoplewt.module.serviceApi;


import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;
import zxj.com.allpeoplewt.bean.ColumnListBean;

/**
 * 1.类的用途
 * 2.@author:zhaoxinjun
 * 3.@  2017/1/3.
 */

public interface IColumnListApi {
    @GET("{id}")
    Observable<ColumnListBean> getColumnListData(@Path("id")String id);
}
