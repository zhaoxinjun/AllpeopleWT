package zxj.com.allpeoplewt.persenter.icallback;

import java.util.List;

import zxj.com.allpeoplewt.bean.AlltvBean;

/**
 * 1.类的用途
 * 2.@author:zhaoxinjun
 * 3.@  2017/1/3.
 */

public interface MyAllTvCallback {
    void success(List<AlltvBean> list);
    void faild(String msg);
}
