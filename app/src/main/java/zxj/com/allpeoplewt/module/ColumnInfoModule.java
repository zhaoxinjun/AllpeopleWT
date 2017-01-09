package zxj.com.allpeoplewt.module;

import com.example.library.mvp.BaseModel;
import com.example.library.utils.netutils.ICallback;
import com.example.library.utils.netutils.Retrofit2Helper;

import zxj.com.allpeoplewt.bean.ColumnInfoBean;
import zxj.com.allpeoplewt.module.imodule.iColumnInfoModule;
import zxj.com.allpeoplewt.module.serviceApi.IColumnInfoApi;
import zxj.com.allpeoplewt.persenter.icallback.MyColumnInfoCallback;

/**
 * 1.类的用途
 * 2.@author:zhaoxinjun
 * 3.@  2017/1/3.
 */

public class ColumnInfoModule extends BaseModel<IColumnInfoApi> implements iColumnInfoModule {
    @Override
    public void getData(final MyColumnInfoCallback callback, String id) {
        IColumnInfoApi api = Retrofit2Helper
                .getInstance()
                .getRetrofit("http://news-at.zhihu.com/api/4/news/")
                .create(IColumnInfoApi.class);
        setApi(api);
        deploy(getApi().getColumnInfoData(id), new ICallback<ColumnInfoBean>() {

            @Override
            public void onCompleted(ColumnInfoBean columnInfoBean) {
                callback.success(columnInfoBean);
            }

            @Override
            public void onFailed(String errMsg) {
                callback.faild(errMsg);
            }
        });
    }
}
