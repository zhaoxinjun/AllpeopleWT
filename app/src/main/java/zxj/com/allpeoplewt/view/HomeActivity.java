package zxj.com.allpeoplewt.view;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import com.example.library.baseactivity.BaseActivity;
import com.jaeger.library.StatusBarUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import zxj.com.allpeoplewt.R;
import zxj.com.allpeoplewt.adapter.ViewPagerAdapter;
import zxj.com.allpeoplewt.view.fragment.ColumnFragment;
import zxj.com.allpeoplewt.view.fragment.DailyFragment;
import zxj.com.allpeoplewt.view.fragment.F4;
import zxj.com.allpeoplewt.view.fragment.WeChatFragment;

public class HomeActivity extends BaseActivity {
    @Bind(R.id.home_tablayout)TabLayout home_tablayout;
    @Bind(R.id.viewpager) ViewPager viewPager;
    @Bind(R.id.drawerLayout)DrawerLayout mDrawerLayout;
    @Bind(R.id.mToolBar)Toolbar mToolBar;
    @Bind(R.id.nv_menu_left)NavigationView nv_menu_left;
    private ActionBarDrawerToggle mDrawerToggle;
    private List<Fragment> fragmentList;
    @Override
    public void initVariables() {

    }

    @Override
    public void initViews(Bundle savedInstanceState) {
        mToolBar.setTitle("标题");  //设置主标题
        setSupportActionBar(mToolBar); //设置actionbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //创建返回键，并实现打开关/闭监听
        // getSupportActionBar().setHomeButtonEnabled(true);  //设置返回键可用

        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolBar, R.string.app_name, R.string.app_name) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };
        mDrawerToggle.syncState();  //初始化状态
        mDrawerLayout.addDrawerListener(mDrawerToggle); //将DrawerLayout与DrawerToggle绑定
        //状态栏
        StatusBarUtil.setColor(this, Color.parseColor("#389D37"),0);

        nv_menu_left.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_item1:
                        mToolBar.setTitle("发布模块");
                        break;
                    case R.id.navigation_item2:
                        //mToolBar.setTitle("全民TV");
                        startAct(AllTvActivity.class);
                        break;
                    case R.id.navigation_sub_item1:
                        mToolBar.setTitle("设置");
                        break;
                    case R.id.navigation_sub_item2:
                        mToolBar.setTitle("关于");
                        break;
                }

                //将选中设为点击状态
//                item.setChecked(true);
                //关闭抽屉
                mDrawerLayout.closeDrawers();
                return true;
            }
        });
        //设置fragment和指针
        initFragmentList();
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(), fragmentList);
        viewPager.setAdapter(adapter);
        //将tabLayout和ViewPager绑定
        home_tablayout.setupWithViewPager(viewPager);
    }

    private void initFragmentList() {
        fragmentList = new ArrayList<>();
        DailyFragment f1=new DailyFragment();
        ColumnFragment f2=new ColumnFragment();
        WeChatFragment f3=new WeChatFragment();
        F4 f4=new F4();
        fragmentList.add(f1);
        fragmentList.add(f2);
        fragmentList.add(f3);
        fragmentList.add(f4);

    }

    @Override
    public void loadData() {

    }

    @Override
    public int bindLayout() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        return R.layout.activity_home;
    }


    /**
     * toolbar  右侧菜单
     * @param menu
     * @return
     */

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_day) {
            Toast.makeText(this, "点击了日间", Toast.LENGTH_SHORT).show();
            return true;
        }else if (id == R.id.action_night) {
            Toast.makeText(this, "点击了夜间", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
