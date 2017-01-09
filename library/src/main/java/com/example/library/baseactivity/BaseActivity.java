package com.example.library.baseactivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.library.mvp.ibase.IOnCreate;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by zxj on 2016/11/3.
 */
public abstract class BaseActivity extends AppCompatActivity implements IOnCreate {

    private static Ipermissions ipermissions;
    private View view;
    private final static LinkedList<BaseActivity> mActivities = new LinkedList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        synchronized (mActivities) {
            mActivities.add(this);
        }
        bindLayout();
        if (bindLayout() != 0) {
            view=View.inflate(this,bindLayout(),null);
            setContentView(view);
            ButterKnife.bind(this);
            initVariables();
            initViews(savedInstanceState);
            loadData();
        }
    }


    public <T extends View>T findView(int viewId){
        return (T) findViewById(viewId);
    }

    public static void requestRuntimePermissions(String[] permissions,Ipermissions permissionListener){
        ipermissions = permissionListener;
        List<String> listRequest = new ArrayList<>();
        for(String permission:permissions){
            if(ContextCompat.checkSelfPermission(mActivities.getLast(),permission)!= PackageManager.PERMISSION_GRANTED){
                listRequest.add(permission);
            }
        }
        if(!listRequest.isEmpty()){
            ActivityCompat.requestPermissions(mActivities.getLast(),listRequest.toArray(new String[listRequest.size()]),1);

        }else{
            ipermissions.onGranted();
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 1:
                if(grantResults.length>0){
                    List<String> deniedPermissions = new ArrayList<>();
                    for (int i = 0; i < grantResults.length; i++) {
                        int grantResult = grantResults[i];
                        String permission = permissions[i];
                        if(grantResult!=PackageManager.PERMISSION_GRANTED){
                            deniedPermissions.add(permission);
                        }
                    }
                    if(deniedPermissions.isEmpty()){
                        ipermissions.onGranted();
                    }else{
                        ipermissions.onDenied(deniedPermissions);
                    }
                }
                break;
            default:
                break;
        }
    }

    //销毁所有activity
    public void killAll(){
        LinkedList<BaseActivity> baseActivities = new LinkedList<>(mActivities);
        for(BaseActivity base:baseActivities){
            base.finish();
        }
    }

    //跳转activity
    public void startAct(Class<? extends BaseActivity> cls) {
        Intent intent = new Intent(this, cls);
        startActivity(intent);
    }
    public void startAct(Class<? extends BaseActivity> cls, Bundle bundle) {
        Intent intent = new Intent(this, cls);
        intent.putExtras(bundle);
        startActivity(intent);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        //每次finish销毁当前activity
        synchronized (mActivities){
            mActivities.remove(this);
        }
        ButterKnife.unbind(this);//销毁注解绑定
    }
}
