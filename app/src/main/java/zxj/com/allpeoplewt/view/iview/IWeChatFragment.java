package zxj.com.allpeoplewt.view.iview;

import com.example.library.mvp.ibase.IBaseView;

import java.util.List;

import zxj.com.allpeoplewt.bean.WeChatBean;

/**
 * 1.类的用途
 * 2.@author:zhaoxinjun
 * 3.@  2017/1/3.
 */

public interface IWeChatFragment extends IBaseView{
    void loadMoreData(List<WeChatBean.NewslistBean> list);
    void refrashData(List<WeChatBean.NewslistBean> list);
    void load();
    void refrash();
}
