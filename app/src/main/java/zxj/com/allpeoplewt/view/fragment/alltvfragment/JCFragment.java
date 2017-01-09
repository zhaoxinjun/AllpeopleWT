package zxj.com.allpeoplewt.view.fragment.alltvfragment;

import android.util.Log;

import com.example.library.mvp.BaseMvpFragment;
import com.example.library.mvp.ibase.IBaseView;

import java.util.ArrayList;
import java.util.List;

import zxj.com.allpeoplewt.R;
import zxj.com.allpeoplewt.bean.tvbean.JingCai;
import zxj.com.allpeoplewt.persenter.JCPersenter;
import zxj.com.allpeoplewt.view.iview.IJCFragment;

/**
 * 1.类的用途
 * 2.@author:zhaoxinjun
 * 3.@  2017/1/2.
 */

public class JCFragment extends BaseMvpFragment<JCPersenter> implements IJCFragment {
  //  @Bind(R.id.every_recyclerview)RecyclerView every_recyclerview;
    List<JingCai> list=new ArrayList<>();


   // private FaceRecyclerAdapter adapter;

    @Override
    protected JCPersenter createPresenter(IBaseView view) {
        return new JCPersenter(this);
    }

    @Override
    public int bindLayout() {
        return R.layout.jc_fragment_layout;

    }

    @Override
    public void initVariables() {
  //      every_recyclerview.setLayoutManager(new Li nearLayoutManager(getActivity()));


    }

    @Override
    public void loadData() {

            getPresenter().getData();
    }

    @Override
    public void notifData(List<JingCai> list) {
        this.list.clear();
        this.list.addAll(list);
        Log.e("-~~~~-","---~~~~~~~~~~~~~-");
        Log.e("************","---********------"+list.get(0).name);
     //   adapter = new EveryRecyclerAdapter(getActivity(),list);
    //    every_recyclerview.setAdapter(adapter);
       // adapter.notifyDataSetChanged();
      ///  adapter = new FaceRecyclerAdapter(getActivity(),this.list);
       //face_recyclerview.setAdapter(adapter);
    }
}
