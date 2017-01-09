package com.example.library.mvp;

import android.app.Dialog;
import android.os.Bundle;

import com.example.library.mvp.ibase.IBasePresenter;
import com.example.library.mvp.ibase.IBaseView;

/**
 * Created by gaojian on 2016/12/28.
 */

public abstract class BaseMvpFragment<P extends IBasePresenter> extends
        BaseFragment implements IBaseView {
    private P mPresenter;
    private Dialog mLoadingDialog;

    protected abstract P createPresenter(IBaseView view);

    @Override
    public void initViews(Bundle savedInstanceState) {
        mPresenter = createPresenter(this);
        mLoadingDialog = getLoadingDialog();
        if (mPresenter == null) {
            throw new RuntimeException("presenter muse be in createPresenter");
        }
    }

    public P getPresenter() {
        return mPresenter;
    }

    protected Dialog getLoadingDialog() {
        return new Dialog(getActivity());
    }

    @Override
    public void showLoading() {
        if (mLoadingDialog != null && !mLoadingDialog.isShowing())
            mLoadingDialog.show();
    }

    @Override
    public void hideLoading() {
        if (mLoadingDialog != null && mLoadingDialog.isShowing())
            mLoadingDialog.dismiss();
    }

}
