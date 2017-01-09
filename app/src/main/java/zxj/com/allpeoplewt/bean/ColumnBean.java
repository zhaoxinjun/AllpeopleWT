package zxj.com.allpeoplewt.bean;

import com.example.library.utils.netutils.ResponseBean;

import java.util.List;

/**
 * 1.类的用途
 * 2.@author:zhaoxinjun
 * 3.@  2017/1/3.
 */

public class ColumnBean extends ResponseBean{

    /**
     * description : 看别人的经历，理解自己的生活
     * id : 1
     * name : 深夜惊奇
     * thumbnail : http://pic3.zhimg.com/91125c9aebcab1c84f58ce4f8779551e.jpg
     */

    public List<DataBean> data;

    public static class DataBean {
        public String description;
        public int id;
        public String name;
        public String thumbnail;
    }
}
