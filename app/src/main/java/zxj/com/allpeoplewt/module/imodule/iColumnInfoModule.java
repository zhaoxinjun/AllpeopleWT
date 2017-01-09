package zxj.com.allpeoplewt.module.imodule;

import com.example.library.mvp.ibase.IBaseModel;

import zxj.com.allpeoplewt.persenter.icallback.MyColumnInfoCallback;

/**
 * 1.类的用途
 * 2.@author:zhaoxinjun
 * 3.@  2017/1/3.
 */

public interface iColumnInfoModule extends IBaseModel{
    void getData(MyColumnInfoCallback callback, String id);
}
