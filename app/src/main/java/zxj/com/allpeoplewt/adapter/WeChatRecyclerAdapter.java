package zxj.com.allpeoplewt.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import zxj.com.allpeoplewt.R;
import zxj.com.allpeoplewt.adapter.holder.BaseViewHolder;
import zxj.com.allpeoplewt.adapter.holder.WeChatHolder;
import zxj.com.allpeoplewt.bean.WeChatBean;

/**
 * 1.类的用途
 * 2.@author:zhaoxinjun
 * 3.@  2017/1/3.
 */

public class WeChatRecyclerAdapter extends RecyclerView.Adapter<BaseViewHolder>{
    private Context context;
    private List<WeChatBean.NewslistBean> list=new ArrayList<>();
    private final LayoutInflater minflater;

    public WeChatRecyclerAdapter(Context context, List<WeChatBean.NewslistBean> list) {
        this.context = context;
        this.list = list;
        minflater = LayoutInflater.from(context);
    }


    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new WeChatHolder(minflater.inflate(R.layout.wechat_home_item,parent,false));
    }

    @Override
    public void onBindViewHolder(final BaseViewHolder holder, int position) {
        holder.setData(context, list.get(position));
        if (mOnItemClickLitener != null)
        {
            holder.itemView.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    int pos = holder.getLayoutPosition();
                    mOnItemClickLitener.onItemClick(holder.itemView, pos);
                }
            });

            holder.itemView.setOnLongClickListener(new View.OnLongClickListener()
            {
                @Override
                public boolean onLongClick(View v)
                {
                    int pos = holder.getLayoutPosition();
                    mOnItemClickLitener.onItemLongClick(holder.itemView, pos);
                    return false;
                }
            });
        }
    }

    @Override//条目count
    public int getItemCount() {
        return list.size();
    }

    public interface OnItemClickLitener
    {
        void onItemClick(View view, int position);
        void onItemLongClick(View view , int position);
    }

    private OnItemClickLitener mOnItemClickLitener;

    public void setOnItemClickLitener(OnItemClickLitener mOnItemClickLitener)
    {
        this.mOnItemClickLitener = mOnItemClickLitener;
    }
}
