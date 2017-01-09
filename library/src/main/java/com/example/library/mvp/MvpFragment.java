//package com.example.library.mvp;
//
//import android.os.Bundle;
//import android.support.annotation.Nullable;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//
//import com.example.library.mvp.ibase.IBasePresenter;
//import com.example.library.mvp.ibase.IBaseView;
//
//
///**
// * 类描述：MVP架构下的Fragment基类
// * 创建人：yekh
// * 创建时间：2016/7/6 10:32
// */
//public abstract class MvpFragment<P extends IBasePresenter> extends BaseFragment {
//
//    protected P mPresenter;
//
//    protected abstract P createPresenter(IBaseView view);
//
//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle
//            savedInstanceState) {
//        mPresenter = createPresenter(this);
//        return super.onCreateView(inflater, container, savedInstanceState);
//    }
//
//    @Override
//    public void onDestroy() {
//
//        if (null != mPresenter) {
//            mPresenter.onDestroy();
//        }
//        super.onDestroy();
//    }
//
//}