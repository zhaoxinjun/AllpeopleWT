package zxj.com.allpeoplewt.persenter;

import com.example.library.mvp.BasePresenter;

import java.util.List;

import zxj.com.allpeoplewt.bean.tvbean.EveryBean;
import zxj.com.allpeoplewt.module.EveryModule;
import zxj.com.allpeoplewt.persenter.icallback.MyEveryCallback;
import zxj.com.allpeoplewt.persenter.ipersenter.IEveryPersenter;
import zxj.com.allpeoplewt.view.fragment.alltvfragment.EveryFragment;

/**
 * 1.类的用途
 * 2.@author:zhaoxinjun
 * 3.@  2017/1/3.
 */

public class EveryPersenter extends BasePresenter<EveryModule,EveryFragment> implements IEveryPersenter {

    public EveryPersenter(EveryFragment iBaseView) {
        super(iBaseView);
    }

    @Override
    protected EveryModule createModel() {
        return new EveryModule();
    }

    @Override
    public void getData(String path) {
        getModel().getData(new MyEveryCallback() {
            @Override
            public void success(List<EveryBean.DataBean> list) {
                getView().notifData(list);
            }
            @Override
            public void faild(String msg) {

            }
        },path);
    }
}
