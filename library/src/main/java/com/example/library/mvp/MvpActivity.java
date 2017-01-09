package com.example.library.mvp;

import android.os.Bundle;

import com.example.library.baseactivity.BaseActivity;
import com.example.library.mvp.ibase.IBasePresenter;
import com.example.library.mvp.ibase.IBaseView;

import butterknife.ButterKnife;


/**
 * 类描述：MVP架构下的Activity基类
 * 创建人：yekh
 * 创建时间：2016/7/6 10:27
 */
public abstract class MvpActivity <P extends IBasePresenter> extends BaseActivity implements IBaseView{


    private P mPresenter;

    protected abstract P createPresenter(IBaseView view);

    @Override
    public void initViews(Bundle bundle) {
        mPresenter = createPresenter(this);
        if(mPresenter==null){
            throw new RuntimeException("presenter muse be in createPresenter");
        }
    }

    @Override
    protected void onDestroy() {
        //避免Presenter持有该对象，先销毁Presenter
        if (null != mPresenter) {
            mPresenter.onDestroy();
        }
        mPresenter=null;
        ButterKnife.unbind(this);//销毁注解绑定
        super.onDestroy();
    }

    public P getPresenter() {
        return mPresenter;
    }
}