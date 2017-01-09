package zxj.com.allpeoplewt.adapter.holder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.library.utils.glideutils.imageutils.ImageUtilsManager;

import zxj.com.allpeoplewt.R;
import zxj.com.allpeoplewt.bean.tvbean.EveryBean;

/**
 * Created by ${zhaoxinJ} on 2016/11/15.
 */
public class EveryContentHolder extends BaseViewHolder<EveryBean.DataBean> {

    private final TextView face_title;
    private Context context;
    private final TextView face_nick;
    private final TextView face_view;
    private final ImageView face_thumb;
    private final ImageView face_avatar;

    public EveryContentHolder(View itemView) {
        super(itemView);
        face_title = (TextView) itemView.findViewById(R.id.every_title1);
        face_nick = (TextView) itemView.findViewById(R.id.every_nick);
        face_view = (TextView) itemView.findViewById(R.id.every_view);
        face_thumb = (ImageView) itemView.findViewById(R.id.every_thumb);
        face_avatar = (ImageView) itemView.findViewById(R.id.every_avatar);

    }

    @Override
    public void setData(Context context,EveryBean.DataBean dataBean) {
        this.context = context;
        face_title.setText(dataBean.title);
        face_nick.setText(dataBean.nick);
        face_view.setText(dataBean.view);
        ImageUtilsManager.getGlideUtils(ImageUtilsManager.Type.GLIDE).displayCircleImg(face_avatar,dataBean.avatar);
        ImageUtilsManager.getGlideUtils(ImageUtilsManager.Type.GLIDE).displayRoundImg(face_thumb,dataBean.thumb,10);
    }


}
