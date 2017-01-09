package zxj.com.allpeoplewt.view.iview;

import com.example.library.mvp.ibase.IBaseView;

import java.util.List;

import zxj.com.allpeoplewt.bean.ColumnBean;

/**
 * 1.类的用途
 * 2.@author:zhaoxinjun
 * 3.@  2017/1/3.
 */

public interface IColumnFragment extends IBaseView{
    void notifData(List<ColumnBean.DataBean> list);
}
