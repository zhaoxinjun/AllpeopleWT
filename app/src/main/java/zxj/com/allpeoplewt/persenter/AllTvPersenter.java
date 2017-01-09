package zxj.com.allpeoplewt.persenter;

import com.example.library.mvp.BasePresenter;

import java.util.List;

import zxj.com.allpeoplewt.bean.AlltvBean;
import zxj.com.allpeoplewt.module.AllTvModule;
import zxj.com.allpeoplewt.persenter.icallback.MyAllTvCallback;
import zxj.com.allpeoplewt.persenter.ipersenter.IAllTvPersenter;
import zxj.com.allpeoplewt.view.AllTvActivity;

/**
 * 1.类的用途
 * 2.@author:zhaoxinjun
 * 3.@  2017/1/3.
 */

public class AllTvPersenter extends BasePresenter<AllTvModule,AllTvActivity> implements IAllTvPersenter {

    public AllTvPersenter(AllTvActivity iBaseView) {
        super(iBaseView);
    }

    @Override
    protected AllTvModule createModel() {
        return new AllTvModule();
    }

    @Override
    public void getData() {
        getModel().getData(new MyAllTvCallback() {
            @Override
            public void success(List<AlltvBean> list) {
                getView().notifData(list);
            }

            @Override
            public void faild(String msg) {

            }
        });
    }
}
