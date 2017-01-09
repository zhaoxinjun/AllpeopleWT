package zxj.com.allpeoplewt.view.iview;

import com.example.library.mvp.ibase.IBaseView;

import zxj.com.allpeoplewt.bean.ColumnInfoBean;

/**
 * 1.类的用途
 * 2.@author:zhaoxinjun
 * 3.@  2017/1/3.
 */

public interface IColumnInfoActivity extends IBaseView{
    void notifData(ColumnInfoBean columnInfoBean);
}
