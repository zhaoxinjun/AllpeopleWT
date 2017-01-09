package zxj.com.allpeoplewt.persenter.icallback;

import java.util.List;

import zxj.com.allpeoplewt.bean.DailyBean;

/**
 * 1.类的用途
 * 2.@author:zhaoxinjun
 * 3.@  2017/1/3.
 */

public interface MyDailyCallback {
    void success(List<DailyBean.TopStoriesBean> list);
    void faild(String msg);
}
