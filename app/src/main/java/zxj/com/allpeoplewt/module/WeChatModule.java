package zxj.com.allpeoplewt.module;

import com.example.library.mvp.BaseModel;
import com.example.library.utils.netutils.ICallback;
import com.example.library.utils.netutils.Retrofit2Helper;

import java.util.ArrayList;
import java.util.List;

import zxj.com.allpeoplewt.bean.WeChatBean;
import zxj.com.allpeoplewt.module.imodule.iWeChatModule;
import zxj.com.allpeoplewt.module.serviceApi.IWeChatApi;
import zxj.com.allpeoplewt.persenter.icallback.MyWeChatCallback;

/**
 * 1.类的用途
 * 2.@author:zhaoxinjun
 * 3.@  2017/1/3.
 */

public class WeChatModule extends BaseModel<IWeChatApi> implements iWeChatModule {
    List<WeChatBean.NewslistBean> list;
    private int page=1;
    @Override
    public void load(final MyWeChatCallback callback) {
        list=new ArrayList<>();
        page++;
        IWeChatApi api = Retrofit2Helper
                .getInstance()
                .getRetrofit("http://api.tianapi.com/")
                .create(IWeChatApi.class);
        setApi(api);
        deploy(getApi().getWeChatData("09691a96d0c41d30215a888632e1b96e","10",page+""), new ICallback<WeChatBean>() {

            @Override
            public void onCompleted(WeChatBean weChatBean) {
                list.addAll(weChatBean.newslist);
                callback.success(list);
            }

            @Override
            public void onFailed(String errMsg) {
                callback.faild(errMsg);
            }
        });
    }
    @Override
    public void refrash(final MyWeChatCallback callback) {
        list=new ArrayList<>();
        IWeChatApi api = Retrofit2Helper
                .getInstance()
                .getRetrofit("http://api.tianapi.com/")
                .create(IWeChatApi.class);
        setApi(api);
        deploy(getApi().getWeChatData("09691a96d0c41d30215a888632e1b96e","10","1"), new ICallback<WeChatBean>() {

            @Override
            public void onCompleted(WeChatBean weChatBean) {
                list.addAll(weChatBean.newslist);
                callback.success(list);
            }

            @Override
            public void onFailed(String errMsg) {
                callback.faild(errMsg);
            }
        });
    }
}
