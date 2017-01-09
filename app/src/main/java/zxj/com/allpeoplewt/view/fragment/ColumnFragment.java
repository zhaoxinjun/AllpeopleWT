package zxj.com.allpeoplewt.view.fragment;

import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.library.mvp.BaseMvpFragment;
import com.example.library.mvp.ibase.IBaseView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import zxj.com.allpeoplewt.R;
import zxj.com.allpeoplewt.adapter.ColumnRecyclerAdapter;
import zxj.com.allpeoplewt.bean.ColumnBean;
import zxj.com.allpeoplewt.persenter.ColumnPersenter;
import zxj.com.allpeoplewt.view.ColumnListActivity;
import zxj.com.allpeoplewt.view.iview.IColumnFragment;

/**
 * 1.类的用途
 * 2.@author:zhaoxinjun
 * 3.@  2017/1/2.
 */

public class ColumnFragment extends BaseMvpFragment<ColumnPersenter> implements IColumnFragment {
    @Bind(R.id.column_fragment_recyclerview)RecyclerView column_recyclerview;
    List<ColumnBean.DataBean> list=new ArrayList<>();
    private ColumnRecyclerAdapter adapter;

    @Override
    protected ColumnPersenter createPresenter(IBaseView view) {
        return new ColumnPersenter(this);
    }

    @Override
    public int bindLayout() {
        return R.layout.column_fragment_layout;
    }

    @Override
    public void initVariables() {
        column_recyclerview.setLayoutManager(new GridLayoutManager(getActivity(),2));
    }

    @Override
    public void loadData() {
        getPresenter().getData();
    }

    @Override
    public void notifData(final List<ColumnBean.DataBean> list) {
        this.list.clear();
        this.list=list;
        adapter = new ColumnRecyclerAdapter(getActivity(),list);
        column_recyclerview.setAdapter(adapter);
        adapter.setOnItemClickLitener(new ColumnRecyclerAdapter.OnItemClickLitener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent=new Intent(getActivity(),ColumnListActivity.class);
                intent.putExtra("id",ColumnFragment.this.list.get(position).id+"");
                intent.putExtra("title",ColumnFragment.this.list.get(position).name);
                startActivity(intent);
            }

            @Override
            public void onItemLongClick(View view, int position) {

            }
        });
    }
}
