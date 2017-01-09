package com.example.library.mvp;


import com.example.library.mvp.ibase.IBaseModel;
import com.example.library.utils.netutils.ICallback;
import com.example.library.utils.netutils.ResponseBean;

import java.net.SocketTimeoutException;
import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
*1.类的用途
*2.@zhaoxinjun
*3.2016/12/31
*/
public abstract class BaseModel<E> implements IBaseModel {
    private E api;
    private Subscription mSubscription;

    private Observable threadControl(Observable observable){
        return observable
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }

    public void setApi(E api) {
        this.api = api;
    }

    public E getApi() {
        return api;
    }

    private Subscription subscribe(Observable observable,final ICallback callback){
        return observable
                .subscribe(new Subscriber<ResponseBean>() {
                        @Override
                        public void onCompleted() {

                        }

                        @Override
                    public void onError(Throwable e) {
                        if(callback!=null){
                            if(e instanceof SocketTimeoutException)
                                callback.onFailed("服务器异常");
                            else
                                callback.onFailed(e.getMessage());
                        }

                    }
                    @Override
                    public void onNext(ResponseBean response) {
                        if(callback!=null) {
                                callback.onCompleted(response);
                        }
                    }
                });
    }
    private Subscription subscribe1(Observable observable,final ICallback callback){
        return observable
                .subscribe(new Subscriber<List<ResponseBean>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        if(callback!=null){
                            if(e instanceof SocketTimeoutException)
                                callback.onFailed("服务器异常");
                            else
                                callback.onFailed(e.getMessage());
                        }

                    }
                    @Override
                    public void onNext(List<ResponseBean> list) {
                        if(callback!=null) {
                            callback.onCompleted(list);
                        }
                    }
                });
    }

    protected Subscription deploy(Observable observable, final ICallback callback){
        mSubscription = subscribe(threadControl(observable),callback);
        return mSubscription;
    }
    protected Subscription deploy1(Observable observable, final ICallback callback){
        mSubscription = subscribe1(threadControl(observable),callback);
        return mSubscription;
    }


    @Override
    public void onDestroy() {
        if (null != mSubscription && mSubscription.isUnsubscribed()) {
            mSubscription.unsubscribe();
        }
    }
}
