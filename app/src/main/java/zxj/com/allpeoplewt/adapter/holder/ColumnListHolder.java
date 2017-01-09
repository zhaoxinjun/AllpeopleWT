package zxj.com.allpeoplewt.adapter.holder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.library.utils.glideutils.imageutils.ImageUtilsManager;

import zxj.com.allpeoplewt.R;
import zxj.com.allpeoplewt.bean.ColumnListBean;

/**
 * Created by ${zhaoxinJ} on 2016/11/15.
 */
public class ColumnListHolder extends BaseViewHolder<ColumnListBean.StoriesBean> {

    private final ImageView wechat_item_img;
    private final TextView wechat_item_textview;

    public ColumnListHolder(View itemView) {
        super(itemView);
        wechat_item_img = (ImageView) itemView.findViewById(R.id.column_list_item_img);
        wechat_item_textview = (TextView) itemView.findViewById(R.id.column_list_item_textview);
    }

    @Override
    public void setData(Context context, ColumnListBean.StoriesBean newslistBean) {
        wechat_item_textview.setText(newslistBean.title);
          ImageUtilsManager
                  .getGlideUtils(ImageUtilsManager.Type.GLIDE)
                  .displayRoundImg(wechat_item_img,newslistBean.images.get(0));

    }


}
