package zxj.com.allpeoplewt.view;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.Window;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.library.mvp.MvpActivity;
import com.example.library.mvp.ibase.IBaseView;
import com.example.library.utils.glideutils.imageutils.ImageUtilsManager;

import butterknife.Bind;
import zxj.com.allpeoplewt.R;
import zxj.com.allpeoplewt.bean.ColumnInfoBean;
import zxj.com.allpeoplewt.persenter.ColumnInfoPersenter;
import zxj.com.allpeoplewt.view.iview.IColumnInfoActivity;

public class ColumnInfoActivity extends MvpActivity<ColumnInfoPersenter> implements IColumnInfoActivity {
    private String id;
    @Bind(R.id.detail_bar_image)
    ImageView detailBarImage;
    @Bind(R.id.detail_bar_copyright)
    TextView detailBarCopyright;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbar;
    @Bind(R.id.app_bar)
    AppBarLayout appBar;
    @Bind(R.id.wv_detail_content)
    WebView wvDetailContent;
    @Bind(R.id.nsv_scroller)
    NestedScrollView nsvScroller;
    @Bind(R.id.fab)
    FloatingActionButton fab;
    @Override
    protected ColumnInfoPersenter createPresenter(IBaseView view) {
        return new ColumnInfoPersenter(this);
    }

    @Override
    public void notifData(ColumnInfoBean riBaoDetailBean) {
        toolbar.setTitle(riBaoDetailBean.title);
        ImageUtilsManager.getGlideUtils(ImageUtilsManager.Type.GLIDE).display(detailBarImage,riBaoDetailBean.image);
//        Glide.with(this).load(riBaoDetailBean.image).into(detailBarImage);
        detailBarCopyright.setText(riBaoDetailBean.image_source);
        wvDetailContent.getSettings().setJavaScriptEnabled(true);
        wvDetailContent.setWebViewClient(new WebViewClient());
        wvDetailContent.loadUrl(riBaoDetailBean.share_url);
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
        return R.layout.activity_column_info;
    }

    @Override
    public void initVariables() {
        Intent intent = getIntent();
        id = intent.getStringExtra("infoid");

        toolbar.setTitle("");  //设置主标题
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar); //设置actionbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void loadData() {
        getPresenter().getData(id);
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
