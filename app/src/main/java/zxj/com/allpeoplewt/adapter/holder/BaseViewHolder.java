package zxj.com.allpeoplewt.adapter.holder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by ${zhaoxinJ} on 2016/11/15.
 */
/**
*1.类的用途
*2.@zhaoxinjun
*3.2016/11/23
*/
//home界面item的Viewholder的基类
public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder{
    public BaseViewHolder(View itemView) {
        super(itemView);
    }
    public abstract void setData(Context context,T t);
}
