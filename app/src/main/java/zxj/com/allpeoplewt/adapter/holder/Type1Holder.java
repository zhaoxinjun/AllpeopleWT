package zxj.com.allpeoplewt.adapter.holder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;
import java.util.List;

import zxj.com.allpeoplewt.R;
import zxj.com.allpeoplewt.bean.DailyBean;

/**
 * Created by ${zhaoxinJ} on 2016/11/15.
 */
public class Type1Holder extends BaseViewHolder<DailyBean.TopStoriesBean> {

public List<DailyBean.TopStoriesBean> list=new ArrayList<>();
    private final ImageView daily_item1_img;
    private final TextView daily_item1_textView;

    public Type1Holder(View itemView) {
        super(itemView);
        daily_item1_img = (ImageView) itemView.findViewById(R.id.daily_item1_img);
        daily_item1_textView = (TextView) itemView.findViewById(R.id.daily_item1_textview);
    }

    @Override
    public void setData(Context context, DailyBean.TopStoriesBean topStoriesBean) {
        daily_item1_textView.setText(topStoriesBean.title);
        Glide.with(context)
                .load(topStoriesBean.image)
                .thumbnail( 0.3f)//缩略图
                .centerCrop()
                .crossFade()
                .dontAnimate()//没有动画
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(daily_item1_img);
    }


}
