package zxj.com.allpeoplewt.persenter;

import com.example.library.mvp.BasePresenter;

import java.util.List;

import zxj.com.allpeoplewt.bean.ColumnListBean;
import zxj.com.allpeoplewt.module.ColumnListModule;
import zxj.com.allpeoplewt.persenter.icallback.MyColumnListCallback;
import zxj.com.allpeoplewt.persenter.ipersenter.IColumnListPersenter;
import zxj.com.allpeoplewt.view.ColumnListActivity;

/**
 * 1.类的用途
 * 2.@author:zhaoxinjun
 * 3.@  2017/1/3.
 */

public class ColumnListPersenter extends BasePresenter<ColumnListModule,ColumnListActivity> implements IColumnListPersenter {

    public ColumnListPersenter(ColumnListActivity iBaseView) {
        super(iBaseView);
    }

    @Override
    protected ColumnListModule createModel() {
        return new ColumnListModule();
    }

    @Override
    public void getData(String id) {
        getModel().getData(new MyColumnListCallback() {
            @Override
            public void success(List<ColumnListBean.StoriesBean> list) {
                getView().notifData(list);
            }

            @Override
            public void faild(String msg) {

            }
        },id);
    }
}
