package zxj.com.allpeoplewt.view;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.Window;

import com.example.library.mvp.MvpActivity;
import com.example.library.mvp.ibase.IBaseView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import zxj.com.allpeoplewt.R;
import zxj.com.allpeoplewt.adapter.AlltvPagerAdapter;
import zxj.com.allpeoplewt.bean.AlltvBean;
import zxj.com.allpeoplewt.persenter.AllTvPersenter;
import zxj.com.allpeoplewt.view.fragment.alltvfragment.EveryFragment;
import zxj.com.allpeoplewt.view.fragment.alltvfragment.FaceFragment;
import zxj.com.allpeoplewt.view.fragment.alltvfragment.JCFragment;
import zxj.com.allpeoplewt.view.iview.IAllTvActivity;

/**
 *
 李韦  16:58:38
 @GET("list-android.json?11241742")
 李韦  16:58:50
 @GET("json%2Fcategories%2Fbeauty%2Flist.json?11211639")
 *
 */
public class AllTvActivity extends MvpActivity<AllTvPersenter> implements IAllTvActivity {
    @Bind(R.id.alltv_toolBar)Toolbar toolbar;
    @Bind(R.id.alltv_tablayout)TabLayout alltv_tablayout;
    @Bind(R.id.alltv_viewpager) ViewPager alltv_viewpager;
    private List<AlltvBean> mlist=new ArrayList<>();
    private String[] path={"",
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
            "erciyuan"};
    private List<Fragment> fragmentlist=new ArrayList<>();
    private AlltvPagerAdapter adapter;

    @Override
    protected AllTvPersenter createPresenter(IBaseView view) {
        return new AllTvPersenter(this);
    }

    @Override
    public void notifData(List<AlltvBean> list) {
        mlist.addAll(list);
        initFragmentList();
        adapter = new AlltvPagerAdapter(getSupportFragmentManager(),mlist,fragmentlist);
        alltv_viewpager.setAdapter(adapter);
       /* AlltvPagerAdapter adapter = new AlltvPagerAdapter(getSupportFragmentManager(),mlist,fragmentlist);
        alltv_viewpager.setAdapter(adapter);
        //将tabLayout和ViewPager绑定
        alltv_tablayout.setTabMode (TabLayout.MODE_SCROLLABLE);//指针标题多时需要设置
        alltv_tablayout.setupWithViewPager(alltv_viewpager);
*/
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public int bindLayout() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        return R.layout.activity_all_tv;
    }

    @Override
    public void initVariables() {
        toolbar.setTitle("全民TV");  //设置主标题
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar); //设置actionbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        //将tabLayout和ViewPager绑定
        alltv_tablayout.setTabMode (TabLayout.MODE_SCROLLABLE);//指针标题多时需要设置
        alltv_tablayout.setupWithViewPager(alltv_viewpager);

    }

    @Override
    public void loadData() {

        getPresenter().getData();
    }

    private void initFragmentList() {
        fragmentlist = new ArrayList<>();
        for (int i = 0; i < mlist.size(); i++) {
            if(i==0){
                fragmentlist.add(new FaceFragment());
            }else if(mlist.get(i).name.equals("精彩推荐")){
                fragmentlist.add(new JCFragment());
            }else{
                EveryFragment everyFragment=new EveryFragment();
                Bundle bundle = new Bundle();
                bundle.putString("path", path[i]);
                everyFragment.setArguments(bundle);
                fragmentlist.add(everyFragment);
            }
        }

    }

    /**
     * 设置返回键 点击finash
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home)
        {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
  /*  @Bind(R.id.alltv_toolBar)Toolbar toolbar;
    @Bind(R.id.alltv_tablayout)TabLayout alltv_tablayout;
    @Bind(R.id.alltv_viewpager) ViewPager alltv_viewpager;
    private List<Fragment> fragmentList;
    private List<AlltvBean> list=new ArrayList<>();
    @Override
    public int bindLayout() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        return R.layout.activity_all_tv;
    }

    @Override
    public void initVariables() {

    }

    @Override
    public void initViews(Bundle savedInstanceState) {
        toolbar.setTitle("全民TV");  //设置主标题
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar); //设置actionbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initFragmentList();
        AlltvPagerAdapter adapter = new AlltvPagerAdapter(getSupportFragmentManager(), fragmentList,list);
        alltv_viewpager.setAdapter(adapter);
        //将tabLayout和ViewPager绑定
        alltv_tablayout.setupWithViewPager(alltv_viewpager);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home)
        {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void loadData() {

    }


    private void initFragmentList() {
        fragmentList = new ArrayList<>();
        tv1 f1=new tv1();
        tv2 f2=new tv2();
        fragmentList.add(f1);
        fragmentList.add(f2);

    }*/
}
