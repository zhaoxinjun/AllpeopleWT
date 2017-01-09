package zxj.com.allpeoplewt.module;

import com.example.library.mvp.BaseModel;
import com.example.library.utils.netutils.ICallback;
import com.example.library.utils.netutils.Retrofit2Helper;

import java.util.ArrayList;
import java.util.List;

import zxj.com.allpeoplewt.bean.ColumnListBean;
import zxj.com.allpeoplewt.module.imodule.iColumnListModule;
import zxj.com.allpeoplewt.module.serviceApi.IColumnListApi;
import zxj.com.allpeoplewt.persenter.icallback.MyColumnListCallback;

/**
 * 1.类的用途
 * 2.@author:zhaoxinjun
 * 3.@  2017/1/3.
 */

public class ColumnListModule extends BaseModel<IColumnListApi> implements iColumnListModule {
    List<ColumnListBean.StoriesBean> list;

    @Override
    public void getData(final MyColumnListCallback callback,String id) {
        list=new ArrayList<>();
        IColumnListApi api = Retrofit2Helper
                .getInstance()
                .getRetrofit("http://news-at.zhihu.com/api/4/section/")
                .create(IColumnListApi.class);
        setApi(api);
        deploy(getApi().getColumnListData(id), new ICallback<ColumnListBean>() {

            @Override
            public void onCompleted(ColumnListBean columnListBean) {
                list.addAll(columnListBean.stories);
                callback.success(list);
            }

            @Override
            public void onFailed(String errMsg) {
                callback.faild(errMsg);
            }
        });
    }
}
