package zxj.com.allpeoplewt.persenter;

import com.example.library.mvp.BasePresenter;

import java.util.List;

import zxj.com.allpeoplewt.bean.tvbean.FaceBean;
import zxj.com.allpeoplewt.module.FaceModule;
import zxj.com.allpeoplewt.persenter.icallback.MyFaceCallback;
import zxj.com.allpeoplewt.persenter.ipersenter.IFacePersenter;
import zxj.com.allpeoplewt.view.fragment.alltvfragment.FaceFragment;

/**
 * 1.类的用途
 * 2.@author:zhaoxinjun
 * 3.@  2017/1/3.
 */

public class FacePersenter extends BasePresenter<FaceModule,FaceFragment> implements IFacePersenter {

    public FacePersenter(FaceFragment iBaseView) {
        super(iBaseView);
    }

    @Override
    protected FaceModule createModel() {
        return new FaceModule();
    }

    @Override
    public void getData() {
        getModel().getData(new MyFaceCallback() {
            @Override
            public void success(List<FaceBean.RoomBean> list) {
                getView().notifData(list);
            }

            @Override
            public void faild(String msg) {

            }
        });
    }
}
