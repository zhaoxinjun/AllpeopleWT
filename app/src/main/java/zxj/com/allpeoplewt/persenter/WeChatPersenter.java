package zxj.com.allpeoplewt.persenter;

import com.example.library.mvp.BasePresenter;

import java.util.List;

import zxj.com.allpeoplewt.bean.WeChatBean;
import zxj.com.allpeoplewt.module.WeChatModule;
import zxj.com.allpeoplewt.persenter.icallback.MyWeChatCallback;
import zxj.com.allpeoplewt.persenter.ipersenter.IWeChatPersenter;
import zxj.com.allpeoplewt.view.fragment.WeChatFragment;

/**
 * 1.类的用途
 * 2.@author:zhaoxinjun
 * 3.@  2017/1/3.
 */

public class WeChatPersenter extends BasePresenter<WeChatModule,WeChatFragment> implements IWeChatPersenter {

    public WeChatPersenter(WeChatFragment iBaseView) {
        super(iBaseView);
    }

    @Override
    protected WeChatModule createModel() {
        return new WeChatModule();
    }

    @Override
    public void refrash() {
        getModel().refrash(new MyWeChatCallback() {
            @Override
            public void success(List<WeChatBean.NewslistBean> list) {
                getView().refrashData(list);
            }

            @Override
            public void faild(String msg) {

            }
        });
    }

    @Override
    public void load() {
        getModel().load(new MyWeChatCallback() {
            @Override
            public void success(List<WeChatBean.NewslistBean> list) {
                getView().loadMoreData(list);
            }

            @Override
            public void faild(String msg) {

            }
        });
    }
}
