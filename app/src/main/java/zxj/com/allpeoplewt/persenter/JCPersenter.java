package zxj.com.allpeoplewt.persenter;

import com.example.library.mvp.BasePresenter;

import java.util.List;

import zxj.com.allpeoplewt.bean.tvbean.JingCai;
import zxj.com.allpeoplewt.module.serviceApi.JCModule;
import zxj.com.allpeoplewt.persenter.icallback.MyJCCallback;
import zxj.com.allpeoplewt.persenter.ipersenter.IJCPersenter;
import zxj.com.allpeoplewt.view.fragment.alltvfragment.JCFragment;

/**
 * 1.类的用途
 * 2.@author:zhaoxinjun
 * 3.@  2017/1/3.
 */

public class JCPersenter extends BasePresenter<JCModule,JCFragment> implements IJCPersenter {

    public JCPersenter(JCFragment iBaseView) {
        super(iBaseView);
    }

    @Override
    protected JCModule createModel() {
        return new JCModule();
    }
    @Override
    public void getData() {
        getModel().getData(new MyJCCallback() {
            @Override
            public void success(List<JingCai> list) {
                getView().notifData(list);
            }
            @Override
            public void faild(String msg) {

            }
        });
    }
}
