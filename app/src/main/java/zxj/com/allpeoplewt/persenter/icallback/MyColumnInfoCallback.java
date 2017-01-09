package zxj.com.allpeoplewt.persenter.icallback;

import zxj.com.allpeoplewt.bean.ColumnInfoBean;

/**
 * 1.类的用途
 * 2.@author:zhaoxinjun
 * 3.@  2017/1/3.
 */

public interface MyColumnInfoCallback {
    void success(ColumnInfoBean columnInfoBean);
    void faild(String msg);
}
