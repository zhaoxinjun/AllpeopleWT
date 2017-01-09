package zxj.com.allpeoplewt.persenter.icallback;

import java.util.List;

import zxj.com.allpeoplewt.bean.tvbean.FaceBean;

/**
 * 1.类的用途
 * 2.@author:zhaoxinjun
 * 3.@  2017/1/3.
 */

public interface MyFaceCallback {
    void success(List<FaceBean.RoomBean> list);
    void faild(String msg);
}
