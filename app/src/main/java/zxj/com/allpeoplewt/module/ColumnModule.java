package zxj.com.allpeoplewt.module;

import com.example.library.mvp.BaseModel;
import com.example.library.utils.netutils.ICallback;
import com.example.library.utils.netutils.Retrofit2Helper;

import java.util.ArrayList;
import java.util.List;

import zxj.com.allpeoplewt.bean.ColumnBean;
import zxj.com.allpeoplewt.module.imodule.iColumnModule;
import zxj.com.allpeoplewt.module.serviceApi.IColumnApi;
import zxj.com.allpeoplewt.persenter.icallback.MyColumnCallback;

/**
 * 1.类的用途
 * 2.@author:zhaoxinjun
 * 3.@  2017/1/3.
 */

public class ColumnModule extends BaseModel<IColumnApi> implements iColumnModule {
    List<ColumnBean.DataBean> list;

    @Override
    public void getData(final MyColumnCallback callback) {
        list=new ArrayList<>();
        IColumnApi api = Retrofit2Helper
                .getInstance()
                .getRetrofit("http://news-at.zhihu.com/api/4/")
                .create(IColumnApi.class);
        setApi(api);
        deploy(getApi().getColumnData(), new ICallback<ColumnBean>() {

            @Override
            public void onCompleted(ColumnBean columnBean) {
                list.addAll(columnBean.data);
                callback.success(list);
            }

            @Override
            public void onFailed(String errMsg) {
                callback.faild(errMsg);
            }
        });
    }
}
