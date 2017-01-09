package zxj.com.allpeoplewt.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import zxj.com.allpeoplewt.R;
import zxj.com.allpeoplewt.adapter.holder.BaseViewHolder;
import zxj.com.allpeoplewt.adapter.holder.Type0Holder;
import zxj.com.allpeoplewt.adapter.holder.Type1Holder;
import zxj.com.allpeoplewt.bean.DailyBean;

/**
 * 1.类的用途
 * 2.@author:zhaoxinjun
 * 3.@  2017/1/3.
 */

public class DialyRecyclerAdapter extends RecyclerView.Adapter<BaseViewHolder>{
    private Context context;
    private List<DailyBean.TopStoriesBean> list=new ArrayList<>();
    private final LayoutInflater minflater;

    public DialyRecyclerAdapter(Context context, ArrayList<DailyBean.TopStoriesBean> list) {
        this.context = context;
        this.list = list;
        minflater = LayoutInflater.from(context);
    }


    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType==0)
            return new Type0Holder(minflater.inflate(R.layout.daily_home_item0,parent,false));
        else
            return new Type1Holder(minflater.inflate(R.layout.daily_home_item1,parent,false));
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        if(position==0) {
            if (holder instanceof Type0Holder) {

                holder.setData(context, list);
            }
        }
        else {
            holder.setData(context, list.get(position - 1));
        }
    }

    @Override//条目count
    public int getItemCount() {
        return list.size()+1;
    }

    @Override//类型
    public int getItemViewType(int position) {

        switch (position){
            case 0:
                return 0;
            default:
                return 1;
        }

    }
}
