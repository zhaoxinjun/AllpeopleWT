package zxj.com.allpeoplewt.adapter.holder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.library.utils.glideutils.imageutils.ImageUtilsManager;

import java.util.ArrayList;
import java.util.List;

import zxj.com.allpeoplewt.R;
import zxj.com.allpeoplewt.bean.ColumnBean;

/**
 * Created by ${zhaoxinJ} on 2016/11/15.
 */
public class ColumnHolder extends BaseViewHolder<ColumnBean.DataBean> {

public List<ColumnBean.DataBean> list=new ArrayList<>();
    private final ImageView column_img;
    private final TextView column_text;

    public ColumnHolder(View itemView) {
        super(itemView);
        column_img = (ImageView) itemView.findViewById(R.id.column_item_img);
        column_text = (TextView) itemView.findViewById(R.id.column_item_text);
    }

    @Override
    public void setData(Context context, ColumnBean.DataBean dataBean) {
     /*   daily_item1_textView.setText(topStoriesBean.title);
        Glide.with(context)
                .load(topStoriesBean.image)
                .thumbnail( 0.3f)//缩略图
                .centerCrop()
                .crossFade()
                .dontAnimate()//没有动画
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(daily_item1_img);*/
        column_text.setText(dataBean.name);
        ImageUtilsManager.getGlideUtils(ImageUtilsManager.Type.GLIDE).displayRoundImg(column_img,dataBean.thumbnail);
    }


}
