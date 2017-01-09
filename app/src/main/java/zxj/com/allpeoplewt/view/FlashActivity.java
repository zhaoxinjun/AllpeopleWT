package zxj.com.allpeoplewt.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;

import com.example.library.mvp.MvpActivity;
import com.example.library.mvp.ibase.IBasePresenter;
import com.example.library.mvp.ibase.IBaseView;
import com.jaeger.library.StatusBarUtil;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.functions.Action1;
import zxj.com.allpeoplewt.R;

public class FlashActivity extends MvpActivity {
    @Override
    protected IBasePresenter createPresenter(IBaseView view) {
        return null;
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void initViews(Bundle bundle) {

    }

    @Override
    public int bindLayout() {
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);

        return R.layout.activity_main;
    }

    @Override
    public void initVariables() {
        StatusBarUtil.setTranslucent(this,0);
    }

    @Override
    public void loadData() {
        //延迟两秒跳转
        Observable.timer(3000, TimeUnit.MILLISECONDS)
//                .subscribeOn(Schedulers.io())
//                .observeOn(Schedulers.newThread())
                .subscribe(new Action1<Long>() {
                    @Override
                    public void call(Long aLong) {
                        if (!isFinishing())
                            startActivity(new Intent(FlashActivity.this,HomeActivity.class));
                        FlashActivity.this.finish();
                    }
                })
                .isUnsubscribed();
    }

    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Api api = Retrofit2Helper.getInstance().getRetrofit("http://news-at.zhihu.com/api/4/news/").create(Api.class);
             api.getData()
                .subscribeOn(Schedulers.io())
               .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Bean>() {
                    @Override
                    public void call(Bean bean) {
                        L.e(bean.stories.get(1).title);
                    }
                });
    }*/

}