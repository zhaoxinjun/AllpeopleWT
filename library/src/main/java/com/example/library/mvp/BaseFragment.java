package com.example.library.mvp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.library.baseactivity.BaseActivity;
import com.example.library.mvp.ibase.IOnCreate;

import butterknife.ButterKnife;

/**
 * Created by gaojian on 2016/12/28.
 */

public abstract class BaseFragment extends Fragment implements IOnCreate {

    private View mView;


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        if (bindLayout() != 0) {
            mView = View.inflate(getActivity(), bindLayout(), null);
            ButterKnife.bind(this, mView);
            initViews(savedInstanceState);
            initVariables();
            loadData();
        }
        return mView;
    }

    public void startAct(Class<? extends BaseActivity> cls) {
        Intent intent = new Intent(getActivity(), cls);
        startActivity(intent);
    }

    public void startAct(Class<? extends BaseActivity> cls, Bundle bundle) {
        Intent intent = new Intent(getActivity(), cls);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    @Override
    public View getView() {
        return mView;
    }

    /**
     * 重构findViewById
     *
     * @param viewId
     * @param <T>
     * @return
     */
    public <T extends View> T findView(int viewId) {
        if (mView != null) {
            return (T) mView.findViewById(viewId);
        }
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);//销毁注解绑定
    }
}
