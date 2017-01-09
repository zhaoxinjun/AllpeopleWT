package zxj.com.allpeoplewt.bean.tvbean;

import com.example.library.utils.netutils.ResponseBean;

import java.util.List;

/**
 * 1.类的用途
 * 2.@author:zhaoxinjun
 * 3.@  2017/1/6.
 */

public class EveryBean extends ResponseBean{


    public int total;
    public String icon;
    public int pageCount;
    public int page;
    public int size;

    public List<DataBean> data;

    public static class DataBean {
        public String nick;
        public String avatar;
        public int follow;
        public String id;
        public String uid;
        public String title;
        public String category_id;
        public String slug;
        public String intro;
        public String announcement;
        public String cover;
        public String play_at;
        public String last_play_at;
        public String view;
        public String views;
        public String status;
        public String landscape;
        public String position;
        public String weight;
        public String check;
        public String recommend_image;
        public String videoQuality;
        public String category_name;
        public int screen;
        public String start_time;
        public String thumb;
        public String video;
        public String maxOnline;
        public String maxViews;
        public String love_cover;
        public String categoryId;
        public boolean hidden;
        public boolean play_status;
    }
}
