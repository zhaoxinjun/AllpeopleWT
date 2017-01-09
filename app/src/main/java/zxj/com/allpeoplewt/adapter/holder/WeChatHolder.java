package zxj.com.allpeoplewt.adapter.holder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.library.utils.glideutils.imageutils.ImageUtilsManager;

import zxj.com.allpeoplewt.R;
import zxj.com.allpeoplewt.bean.WeChatBean;

/**
 * Created by ${zhaoxinJ} on 2016/11/15.
 */
public class WeChatHolder extends BaseViewHolder<WeChatBean.NewslistBean> {

    private final ImageView wechat_item_img;
    private final TextView wechat_item_textview;

    public WeChatHolder(View itemView) {
        super(itemView);
        wechat_item_img = (ImageView) itemView.findViewById(R.id.wechat_item_img);
        wechat_item_textview = (TextView) itemView.findViewById(R.id.wechat_item_textview);
    }

    @Override
    public void setData(Context context, WeChatBean.NewslistBean newslistBean) {
        wechat_item_textview.setText(newslistBean.title);
          ImageUtilsManager
                  .getGlideUtils(ImageUtilsManager.Type.GLIDE)
                  .displayRoundImg(wechat_item_img,newslistBean.picUrl);

    }


}
