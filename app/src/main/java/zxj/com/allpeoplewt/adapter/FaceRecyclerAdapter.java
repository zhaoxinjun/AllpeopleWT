package zxj.com.allpeoplewt.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import zxj.com.allpeoplewt.R;
import zxj.com.allpeoplewt.adapter.holder.BaseViewHolder;
import zxj.com.allpeoplewt.adapter.holder.FaceListHolder;
import zxj.com.allpeoplewt.adapter.holder.FaceViewPagerHolder;
import zxj.com.allpeoplewt.bean.tvbean.FaceBean;

/**
 * 1.类的用途
 * 2.@author:zhaoxinjun
 * 3.@  2017/1/3.
 */

public class FaceRecyclerAdapter extends RecyclerView.Adapter<BaseViewHolder>{
    private Context context;
    private List<FaceBean.RoomBean> list=new ArrayList<>();
    private final LayoutInflater minflater;

    public FaceRecyclerAdapter(Context context, List<FaceBean.RoomBean> list) {
        this.context = context;
        this.list = list;
        minflater = LayoutInflater.from(context);
    }


    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType==0)
            return new FaceViewPagerHolder(minflater.inflate(R.layout.face_viewpage_item,parent,false));
        else
            return new FaceListHolder(minflater.inflate(R.layout.face_list_item,parent,false));
    }




    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        if(position==0)
            holder.setData(null,null);
        else
            holder.setData(context, list.get(position-1));

    }

    @Override//条目count
    public int getItemCount() {
        return list.size()+1;
    }

    @Override
    public int getItemViewType(int position) {
        if(position==0) return 0;
        else  return 1;
    }
}
