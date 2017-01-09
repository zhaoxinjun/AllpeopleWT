package zxj.com.allpeoplewt.persenter;

import com.example.library.mvp.BasePresenter;

import java.util.List;

import zxj.com.allpeoplewt.bean.ColumnBean;
import zxj.com.allpeoplewt.module.ColumnModule;
import zxj.com.allpeoplewt.persenter.icallback.MyColumnCallback;
import zxj.com.allpeoplewt.persenter.ipersenter.IColumnPersenter;
import zxj.com.allpeoplewt.view.fragment.ColumnFragment;

/**
 * 1.类的用途
 * 2.@author:zhaoxinjun
 * 3.@  2017/1/3.
 */

public class ColumnPersenter  extends BasePresenter<ColumnModule,ColumnFragment> implements IColumnPersenter {

    public ColumnPersenter(ColumnFragment iBaseView) {
        super(iBaseView);
    }

    @Override
    protected ColumnModule createModel() {
        return new ColumnModule();
    }

    @Override
    public void getData() {
        getModel().getData(new MyColumnCallback() {
            @Override
            public void success(List<ColumnBean.DataBean> list) {
                getView().notifData(list);
            }

            @Override
            public void faild(String msg) {

            }
        });
    }
}
