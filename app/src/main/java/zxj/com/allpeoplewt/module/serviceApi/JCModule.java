package zxj.com.allpeoplewt.module.serviceApi;

import com.example.library.mvp.BaseModel;
import com.example.library.utils.netutils.ICallback;
import com.example.library.utils.netutils.Retrofit2Helper;

import java.util.ArrayList;
import java.util.List;

import zxj.com.allpeoplewt.bean.tvbean.JingCai;
import zxj.com.allpeoplewt.module.imodule.iJCModule;
import zxj.com.allpeoplewt.persenter.icallback.MyJCCallback;

/**
 * 1.类的用途
 * 2.@author:zhaoxinjun
 * 3.@  2017/1/3.
 */

public class JCModule extends BaseModel<IJCApi> implements iJCModule {
    List<JingCai> listJC;
    @Override
    public void getData(final MyJCCallback callback) {
        listJC=new ArrayList<>();
        IJCApi api = Retrofit2Helper
                .getInstance()
                .getRetrofit("http://www.quanmin.tv/")
                .create(IJCApi.class);
        setApi(api);
        deploy1(getApi().getJCData("2.2.4","1","4"), new ICallback<List<JingCai>>() {

            @Override
            public void onCompleted(List<JingCai> jingCaiList) {
                listJC.addAll(jingCaiList);
                callback.success(listJC);
            }

            @Override
            public void onFailed(String errMsg) {
                callback.faild(errMsg);
            }
        });
    }

}
