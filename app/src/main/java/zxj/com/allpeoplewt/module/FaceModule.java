package zxj.com.allpeoplewt.module;

import android.util.Log;

import com.example.library.mvp.BaseModel;
import com.example.library.utils.netutils.ICallback;
import com.example.library.utils.netutils.Retrofit2Helper;

import java.util.ArrayList;
import java.util.List;

import zxj.com.allpeoplewt.bean.tvbean.FaceBean;
import zxj.com.allpeoplewt.module.imodule.iFaceModule;
import zxj.com.allpeoplewt.module.serviceApi.IFaceApi;
import zxj.com.allpeoplewt.persenter.icallback.MyFaceCallback;

/**
 * 1.类的用途
 * 2.@author:zhaoxinjun
 * 3.@  2017/1/3.
 */

public class FaceModule extends BaseModel<IFaceApi> implements iFaceModule {
    List<FaceBean.RoomBean> lists;
    @Override
    public void getData(final MyFaceCallback callback) {
        lists=new ArrayList<>();
        IFaceApi api = Retrofit2Helper
                .getInstance()
                .getRetrofit("http://www.quanmin.tv/json/app/index/recommend/")
                .create(IFaceApi.class);
        setApi(api);
       deploy(getApi().getFaceData("2.2.4","1","4"), new ICallback<FaceBean>() {

           @Override
           public void onCompleted(FaceBean faceBean) {
               lists.addAll(faceBean.room);
               callback.success(lists);
           }

           @Override
           public void onFailed(String errMsg) {
                callback.faild(errMsg);
           }
       });
    }
}
