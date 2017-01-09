package zxj.com.allpeoplewt.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import zxj.com.allpeoplewt.R;
import zxj.com.allpeoplewt.adapter.holder.BaseViewHolder;
import zxj.com.allpeoplewt.adapter.holder.FaceContentHolder;
import zxj.com.allpeoplewt.adapter.holder.FaceTitleHolder;
import zxj.com.allpeoplewt.bean.tvbean.FaceBean;

/**
 * 1.类的用途
 * 2.@author:zhaoxinjun
 * 3.@  2017/1/3.
 */

public class FaceListAdapter extends RecyclerView.Adapter<BaseViewHolder>{
    private Context context;
    private List<FaceBean.RoomBean.ListBean> list=new ArrayList<>();
    private FaceBean.RoomBean bean;
    private final LayoutInflater minflater;

    public FaceListAdapter(Context context, FaceBean.RoomBean bean) {
        this.context = context;
        this.bean = bean;
        list.addAll(bean.list);
        minflater = LayoutInflater.from(context);
    }


    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType==0)
            return new FaceTitleHolder(minflater.inflate(R.layout.face_listitem_title,parent,false));
        else
            return new FaceContentHolder(minflater.inflate(R.layout.face_listitem_img,parent,false));
    }




    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        if(position==0)
           holder.setData(context,bean);
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
