package zxj.com.allpeoplewt.view.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.library.mvp.BaseMvpFragment;
import com.example.library.mvp.ibase.IBaseView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import zxj.com.allpeoplewt.R;
import zxj.com.allpeoplewt.adapter.DialyRecyclerAdapter;
import zxj.com.allpeoplewt.bean.DailyBean;
import zxj.com.allpeoplewt.persenter.DailyPersenter;
import zxj.com.allpeoplewt.view.iview.IDailyFragment;

/**
 * 1.类的用途
 * 2.@author:zhaoxinjun
 * 3.@  2017/1/2.
 */

public class DailyFragment extends BaseMvpFragment<DailyPersenter> implements IDailyFragment {
    @Bind(R.id.daily_recyclerview)RecyclerView daily_recyclerview;
    ArrayList<DailyBean.TopStoriesBean> list=new ArrayList<>();
    private DialyRecyclerAdapter adapter;

    @Override
    protected DailyPersenter createPresenter(IBaseView view) {
        return new DailyPersenter(this);
    }

    @Override
    public int bindLayout() {
        return R.layout.daily_fragment_layout;
    }

    @Override
    public void initVariables() {
        daily_recyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        /*adapter = new DialyRecyclerAdapter(getActivity(),list);
        daily_recyclerview.setAdapter(adapter);*/
    }

    @Override
    public void loadData() {
        getPresenter().getData();
    }

    @Override
    public void notifData(List<DailyBean.TopStoriesBean> list) {
        this.list.clear();
        this.list.addAll(list);
       // adapter.notifyDataSetChanged();
        adapter = new DialyRecyclerAdapter(getActivity(),this.list);
        daily_recyclerview.setAdapter(adapter);
    }
}
