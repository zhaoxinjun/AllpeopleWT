package zxj.com.allpeoplewt.module.imodule;

import com.example.library.mvp.ibase.IBaseModel;

import zxj.com.allpeoplewt.persenter.icallback.MyAllTvCallback;

/**
 * 1.类的用途
 * 2.@author:zhaoxinjun
 * 3.@  2017/1/3.
 */

public interface iAllTvModule extends IBaseModel{
    void getData(MyAllTvCallback callback);
}
