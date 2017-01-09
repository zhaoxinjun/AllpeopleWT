package zxj.com.allpeoplewt.view.fragment.alltvfragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.library.mvp.BaseMvpFragment;
import com.example.library.mvp.ibase.IBaseView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import zxj.com.allpeoplewt.R;
import zxj.com.allpeoplewt.adapter.FaceRecyclerAdapter;
import zxj.com.allpeoplewt.bean.tvbean.FaceBean;
import zxj.com.allpeoplewt.persenter.FacePersenter;
import zxj.com.allpeoplewt.view.iview.IFaceFragment;

/**
 * 1.类的用途
 * 2.@author:zhaoxinjun
 * 3.@  2017/1/2.
 */

public class FaceFragment extends BaseMvpFragment<FacePersenter> implements IFaceFragment {
    @Bind(R.id.face_main_recyclerview)RecyclerView face_main_recyclerview;
    ArrayList<FaceBean.RoomBean> list=new ArrayList<>();
    private FaceRecyclerAdapter adapter;

    @Override
    protected FacePersenter createPresenter(IBaseView view) {
        return new FacePersenter(this);
    }

    @Override
    public int bindLayout() {
        return R.layout.face_fragment_layout;
    }

    @Override
    public void initVariables() {
        face_main_recyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));

    }

    @Override
    public void loadData() {
        getPresenter().getData();
    }

    @Override
    public void notifData(List<FaceBean.RoomBean> list) {
        this.list.clear();
        this.list.addAll(list);
        adapter = new FaceRecyclerAdapter(getActivity(),list);
        face_main_recyclerview.setAdapter(adapter);
       // adapter.notifyDataSetChanged();
      ///  adapter = new FaceRecyclerAdapter(getActivity(),this.list);
       //face_recyclerview.setAdapter(adapter);
    }
}
