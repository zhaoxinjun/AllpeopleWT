package zxj.com.allpeoplewt.view.fragment;

import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.library.mvp.BaseMvpFragment;
import com.example.library.mvp.ibase.IBaseView;
import com.lcodecore.tkrefreshlayout.Footer.BottomProgressView;
import com.lcodecore.tkrefreshlayout.RefreshListenerAdapter;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.lcodecore.tkrefreshlayout.header.SinaRefreshView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import zxj.com.allpeoplewt.R;
import zxj.com.allpeoplewt.adapter.WeChatRecyclerAdapter;
import zxj.com.allpeoplewt.bean.WeChatBean;
import zxj.com.allpeoplewt.persenter.WeChatPersenter;
import zxj.com.allpeoplewt.view.iview.IWeChatFragment;

/**
 * 1.类的用途
 * 2.@author:zhaoxinjun
 * 3.@  2017/1/2.
 */

public class WeChatFragment extends BaseMvpFragment<WeChatPersenter> implements IWeChatFragment {
    @Bind(R.id.wx_refreshLayout)TwinklingRefreshLayout wx_refreshLayout;
    @Bind(R.id.wx_recyclerview)RecyclerView wx_recyclerview;
    ArrayList<WeChatBean.NewslistBean> list=new ArrayList<>();
    private WeChatRecyclerAdapter adapter;

    @Override
    protected WeChatPersenter createPresenter(IBaseView view) {
        return new WeChatPersenter(this);
    }

    @Override
    public int bindLayout() {
        return R.layout.wechat_fragment_layout;
    }

    @Override
    public void initVariables() {
        wx_recyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new WeChatRecyclerAdapter(getActivity(),list);
        wx_recyclerview.setAdapter(adapter);
        //可以自定义下拉刷新上拉加载的布局
        wx_refreshLayout.setHeaderView(new SinaRefreshView(getActivity()));
        wx_refreshLayout.setBottomView(new BottomProgressView(getActivity()));
        wx_refreshLayout.setOnRefreshListener(new RefreshListenerAdapter(){
            @Override
            public void onRefresh(final TwinklingRefreshLayout refreshLayout) {
                refrash();
            }

            @Override
            public void onLoadMore(final TwinklingRefreshLayout refreshLayout) {
                load();
            }
        });
        adapter.setOnItemClickLitener(new WeChatRecyclerAdapter.OnItemClickLitener() {
            @Override
            public void onItemClick(View view, int position) {
                WebView webView = new WebView(getActivity());
                webView.getSettings().setJavaScriptEnabled(true);
                webView.loadUrl(list.get(position).url);
                webView.setWebViewClient(new WebViewClient());
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                AlertDialog dialog = builder.create();
                dialog.setView(webView);
                dialog.show();
            }

            @Override
            public void onItemLongClick(View view, int position) {

            }
        });
    }

    @Override
    public void loadData() {
        getPresenter().refrash();
    }

    @Override//更新加载更多
    public void loadMoreData(List<WeChatBean.NewslistBean> list) {
        this.list.addAll(list);
        adapter.notifyDataSetChanged();
        wx_refreshLayout.finishLoadmore();
    }
    @Override//更新下拉刷新
    public void refrashData(List<WeChatBean.NewslistBean> list) {
        this.list.clear();
        this.list.addAll(list);
        adapter.notifyDataSetChanged();
        wx_refreshLayout.finishRefreshing();
    }
    @Override//请求加载数据
    public void load(){
        getPresenter().load();
    }
    @Override//请求刷新数据
    public void refrash(){
        getPresenter().refrash();
    }
}
