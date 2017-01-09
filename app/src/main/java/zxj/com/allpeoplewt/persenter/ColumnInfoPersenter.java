package zxj.com.allpeoplewt.persenter;

import com.example.library.mvp.BasePresenter;

import zxj.com.allpeoplewt.bean.ColumnInfoBean;
import zxj.com.allpeoplewt.module.ColumnInfoModule;
import zxj.com.allpeoplewt.persenter.icallback.MyColumnInfoCallback;
import zxj.com.allpeoplewt.persenter.ipersenter.IColumnInfoPersenter;
import zxj.com.allpeoplewt.view.ColumnInfoActivity;

/**
 * 1.类的用途
 * 2.@author:zhaoxinjun
 * 3.@  2017/1/3.
 */

public class ColumnInfoPersenter extends BasePresenter<ColumnInfoModule,ColumnInfoActivity> implements IColumnInfoPersenter {

    public ColumnInfoPersenter(ColumnInfoActivity iBaseView) {
        super(iBaseView);
    }

    @Override
    protected ColumnInfoModule createModel() {
        return new ColumnInfoModule();
    }

    @Override
    public void getData(String id) {
        getModel().getData(new MyColumnInfoCallback() {
            @Override
            public void success(ColumnInfoBean columnInfoBean) {
                getView().notifData(columnInfoBean);
            }

            @Override
            public void faild(String msg) {

            }
        },id);
    }
}
