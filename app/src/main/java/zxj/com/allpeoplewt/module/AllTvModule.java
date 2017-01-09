package zxj.com.allpeoplewt.module;

import com.example.library.mvp.BaseModel;
import com.example.library.utils.netutils.ICallback;
import com.example.library.utils.netutils.Retrofit2Helper;

import java.util.ArrayList;
import java.util.List;

import zxj.com.allpeoplewt.bean.AlltvBean;
import zxj.com.allpeoplewt.module.imodule.iAllTvModule;
import zxj.com.allpeoplewt.module.serviceApi.IAllTvApi;
import zxj.com.allpeoplewt.persenter.icallback.MyAllTvCallback;

/**
 * 1.类的用途
 * 2.@author:zhaoxinjun
 * 3.@  2017/1/3.
 */

public class AllTvModule extends BaseModel<IAllTvApi> implements iAllTvModule {
    List<AlltvBean> list;
    @Override
    public void getData(final MyAllTvCallback callback) {
        list=new ArrayList<>();
        IAllTvApi api = Retrofit2Helper
                .getInstance()
                .getRetrofit("http://www.quanmin.tv/json/app/index/category/")
                .create(IAllTvApi.class);
        setApi(api);
       deploy1(getApi().getAllTvData("2.2.4","1","4"), new ICallback<List<AlltvBean>>() {

           @Override
           public void onCompleted(List<AlltvBean> alltvBeanList) {
               list.addAll(alltvBeanList);
               callback.success(list);
           }

           @Override
           public void onFailed(String errMsg) {
                callback.faild(errMsg);
           }
       });
    }
}
