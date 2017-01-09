package zxj.com.allpeoplewt.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import zxj.com.allpeoplewt.R;
import zxj.com.allpeoplewt.adapter.holder.BaseViewHolder;
import zxj.com.allpeoplewt.adapter.holder.EveryContentHolder;
import zxj.com.allpeoplewt.bean.tvbean.EveryBean;

/**
 * 1.类的用途
 * 2.@author:zhaoxinjun
 * 3.@  2017/1/3.
 */

public class TvListAdapter extends RecyclerView.Adapter<BaseViewHolder>{
    private Context context;
    private List<EveryBean.DataBean> list=new ArrayList<>();
    private final LayoutInflater minflater;

    public TvListAdapter(Context context, List<EveryBean.DataBean> list) {
        this.context = context;
        this.list.clear();
        this.list.addAll(list);
        minflater = LayoutInflater.from(context);
    }


    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new EveryContentHolder(minflater.inflate(R.layout.every_tv_item,parent,false));
    }




    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
            holder.setData(context, list.get(position));

    }

    @Override//条目count
    public int getItemCount() {
        return list.size();
    }
}
