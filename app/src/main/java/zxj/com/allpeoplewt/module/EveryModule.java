package zxj.com.allpeoplewt.module;

import com.example.library.mvp.BaseModel;
import com.example.library.utils.netutils.ICallback;
import com.example.library.utils.netutils.Retrofit2Helper;

import java.util.ArrayList;
import java.util.List;

import zxj.com.allpeoplewt.bean.tvbean.EveryBean;
import zxj.com.allpeoplewt.bean.tvbean.JingCai;
import zxj.com.allpeoplewt.module.imodule.iEveryModule;
import zxj.com.allpeoplewt.module.serviceApi.IEveryApi;
import zxj.com.allpeoplewt.persenter.icallback.MyEveryCallback;

/**
 * 1.类的用途
 * 2.@author:zhaoxinjun
 * 3.@  2017/1/3.
 */

public class EveryModule extends BaseModel<IEveryApi> implements iEveryModule {
    List<EveryBean.DataBean> lists;
    List<JingCai> listJC;
    @Override
    public void getData(final MyEveryCallback callback,String path) {
        lists=new ArrayList<>();
        listJC=new ArrayList<>();
        IEveryApi api = Retrofit2Helper
                .getInstance()
                .getRetrofit("http://www.quanmin.tv/")
                .create(IEveryApi.class);
        setApi(api);
       deploy(getApi().getEveryData(path), new ICallback<EveryBean>() {

           @Override
           public void onCompleted(EveryBean faceBean) {
               lists.addAll(faceBean.data);
               callback.success(lists);
           }

           @Override
           public void onFailed(String errMsg) {
                callback.faild(errMsg);
           }
       });
    }

}
