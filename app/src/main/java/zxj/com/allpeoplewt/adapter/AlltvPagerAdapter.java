package zxj.com.allpeoplewt.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import zxj.com.allpeoplewt.bean.AlltvBean;

/**
 * 1.主页指针的适配器
 * 2.@author:zhaoxinjun
 * 3.@  2017/1/2.
 */

public class AlltvPagerAdapter extends FragmentPagerAdapter {


    private List<AlltvBean> list;
    private List<Fragment> fragmentList;

    /*  private String[] path={"",
              "lol",
              "beauty",
              "overwatch",
              "huwai",
              "heartstone",
              "mobilegame",
              "webgame",
              "tvgame",
              "wangzhe",
              "",
              "dota2",
              "cfpc",
              "dnf",
              "qqfeiche",
              "war3",
              "nba2k",
              "minecraft",
              "fifa",
              "blizzard",
              "qiuqiu",
              "erciyuan"};*/
    public AlltvPagerAdapter(FragmentManager fm,List<AlltvBean> list,List<Fragment> fragmentList) {
        super(fm);
        this.fragmentList = fragmentList;
        this.list=new ArrayList<>();
     this.list.addAll(list);
       // this.list=list;
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
    /* 重写与TabLayout配合 */
    @Override
    public CharSequence getPageTitle(int position) {
        String title = list.get(position).name;
        return title;
    }

    @Override
    public Fragment getItem(int position) {

return fragmentList.get(position);
    }
}
