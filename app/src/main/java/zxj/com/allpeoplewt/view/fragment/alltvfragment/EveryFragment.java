package zxj.com.allpeoplewt.view.fragment.alltvfragment;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.library.mvp.BaseMvpFragment;
import com.example.library.mvp.ibase.IBaseView;

import java.util.ArrayList;
import java.util.List;

import zxj.com.allpeoplewt.R;
import zxj.com.allpeoplewt.adapter.TvListAdapter;
import zxj.com.allpeoplewt.bean.tvbean.EveryBean;
import zxj.com.allpeoplewt.persenter.EveryPersenter;
import zxj.com.allpeoplewt.view.iview.IEveryFragment;

/**
 * 1.类的用途
 * 2.@author:zhaoxinjun
 * 3.@  2017/1/2.
 */

public class EveryFragment extends BaseMvpFragment<EveryPersenter> implements IEveryFragment {
   // @Bind(R.id.every_recyclerview)
    RecyclerView every_recyclerview;
    ArrayList<EveryBean.DataBean> list1=new ArrayList<>();


    private TvListAdapter adapter;

    @Override
    protected EveryPersenter createPresenter(IBaseView view) {
        return new EveryPersenter(this);
    }

    @Override
    public int bindLayout() {
        return R.layout.every_fragment_layout;

    }

    @Override
    public void initVariables() {
        every_recyclerview=  findView(R.id.every_recyclerview);
        every_recyclerview.setLayoutManager(new GridLayoutManager(getActivity(),2));
        adapter = new TvListAdapter(getActivity(),list1);
        every_recyclerview.setAdapter(adapter);
    }

    @Override
    public void loadData() {
        Bundle bundle = getArguments();
        String path = bundle.getString("path");
            getPresenter().getData(path);
    }

    @Override
    public void notifData(List<EveryBean.DataBean> list) {
        list1.clear();
        list1.addAll(list);
        adapter.notifyDataSetChanged();
    }
}
