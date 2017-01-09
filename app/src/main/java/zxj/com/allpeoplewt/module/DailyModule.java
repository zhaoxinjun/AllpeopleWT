package zxj.com.allpeoplewt.module;

import com.example.library.mvp.BaseModel;
import com.example.library.utils.netutils.ICallback;
import com.example.library.utils.netutils.Retrofit2Helper;

import java.util.ArrayList;
import java.util.List;

import zxj.com.allpeoplewt.bean.DailyBean;
import zxj.com.allpeoplewt.module.imodule.iDailyModule;
import zxj.com.allpeoplewt.module.serviceApi.IDailyApi;
import zxj.com.allpeoplewt.persenter.icallback.MyDailyCallback;

/**
 * 1.类的用途
 * 2.@author:zhaoxinjun
 * 3.@  2017/1/3.
 */

public class DailyModule extends BaseModel<IDailyApi> implements iDailyModule {
    List<DailyBean.TopStoriesBean> list;
    @Override
    public void getData(final MyDailyCallback callback) {
        list=new ArrayList<>();
        IDailyApi api = Retrofit2Helper
                .getInstance()
                .getRetrofit("http://news-at.zhihu.com/api/4/")
                .create(IDailyApi.class);
        setApi(api);
       deploy(getApi().getDailyData(), new ICallback<DailyBean>() {

           @Override
           public void onCompleted(DailyBean dailyBean) {
               list.addAll(dailyBean.top_stories);
               callback.success(list);
           }

           @Override
           public void onFailed(String errMsg) {
                callback.faild(errMsg);
           }
       });
    }
}
