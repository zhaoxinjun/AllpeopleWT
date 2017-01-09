package zxj.com.allpeoplewt.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * 1.主页指针的适配器
 * 2.@author:zhaoxinjun
 * 3.@  2017/1/2.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {


    private String[] tabTitleArray={"日报","专栏","微信","热门"};
    private List<Fragment> fragmentList;

    public ViewPagerAdapter(FragmentManager fm,List<Fragment> fragmentList) {
        super(fm);
        this.fragmentList= fragmentList;
    }


    @Override
    public int getCount() {
        return tabTitleArray.length;
    }
    /* 重写与TabLayout配合 */
    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitleArray[position % tabTitleArray.length];
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position%tabTitleArray.length);
    }
}
