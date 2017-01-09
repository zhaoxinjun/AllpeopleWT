package zxj.com.allpeoplewt.view;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import com.example.library.mvp.MvpActivity;
import com.example.library.mvp.ibase.IBaseView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import zxj.com.allpeoplewt.R;
import zxj.com.allpeoplewt.adapter.ColmnListRecyclerAdapter;
import zxj.com.allpeoplewt.bean.ColumnListBean;
import zxj.com.allpeoplewt.persenter.ColumnListPersenter;
import zxj.com.allpeoplewt.view.iview.IColumnListActivity;

public class ColumnListActivity extends MvpActivity<ColumnListPersenter> implements IColumnListActivity{

    @Bind(R.id.column_list_toolBar)Toolbar toolbar;
    @Bind(R.id.column_list_recyclerview)RecyclerView recyclerview;
    private String id;
    private List<ColumnListBean.StoriesBean> mList=new ArrayList<>();
    private ColmnListRecyclerAdapter adapter;

    @Override
    protected ColumnListPersenter createPresenter(IBaseView view) {
        return new ColumnListPersenter(this);
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
        return R.layout.activity_column_list;
    }

    @Override
    public void initVariables() {
        Intent intent = getIntent();
        id = intent.getStringExtra("id");
        String title = intent.getStringExtra("title");

        toolbar.setTitle(title);  //设置主标题
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar); //设置actionbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ColmnListRecyclerAdapter(this,mList);
        recyclerview.setAdapter(adapter);
        adapter.setOnItemClickLitener(new ColmnListRecyclerAdapter.OnItemClickLitener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent=new Intent(ColumnListActivity.this,ColumnInfoActivity.class);
                String a=mList.get(position).id+"";
                intent.putExtra("infoid",mList.get(position).id+"");
                startActivity(intent);
            }

            @Override
            public void onItemLongClick(View view, int position) {

            }
        });

    }

    @Override
    public void loadData() {
        getPresenter().getData(id);
    }

    @Override
    public void notifData(List<ColumnListBean.StoriesBean> list) {
        Toast.makeText(this, ""+list.size(), Toast.LENGTH_SHORT).show();
        mList.addAll(list);
        adapter.notifyDataSetChanged();
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
}
