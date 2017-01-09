package zxj.com.allpeoplewt.persenter.icallback;

import java.util.List;

import zxj.com.allpeoplewt.bean.tvbean.JingCai;

/**
 * 1.类的用途
 * 2.@author:zhaoxinjun
 * 3.@  2017/1/3.
 */

public interface MyJCCallback {
    void success(List<JingCai> list);
    void faild(String msg);
}
