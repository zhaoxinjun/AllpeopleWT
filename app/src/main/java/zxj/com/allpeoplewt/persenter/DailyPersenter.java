package zxj.com.allpeoplewt.persenter;

import com.example.library.mvp.BasePresenter;

import java.util.List;

import zxj.com.allpeoplewt.bean.DailyBean;
import zxj.com.allpeoplewt.module.DailyModule;
import zxj.com.allpeoplewt.persenter.icallback.MyDailyCallback;
import zxj.com.allpeoplewt.persenter.ipersenter.IDailyPersenter;
import zxj.com.allpeoplewt.view.fragment.DailyFragment;

/**
 * 1.类的用途
 * 2.@author:zhaoxinjun
 * 3.@  2017/1/3.
 */

public class DailyPersenter extends BasePresenter<DailyModule,DailyFragment> implements IDailyPersenter{

    public DailyPersenter(DailyFragment iBaseView) {
        super(iBaseView);
    }

    @Override
    protected DailyModule createModel() {
        return new DailyModule();
    }

    @Override
    public void getData() {
        getModel().getData(new MyDailyCallback() {
            @Override
            public void success(List<DailyBean.TopStoriesBean> list) {
                getView().notifData(list);
            }

            @Override
            public void faild(String msg) {

            }
        });
    }
}
