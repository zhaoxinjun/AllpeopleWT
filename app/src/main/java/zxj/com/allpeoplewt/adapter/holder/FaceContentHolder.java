package zxj.com.allpeoplewt.adapter.holder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.library.utils.glideutils.imageutils.ImageUtilsManager;

import zxj.com.allpeoplewt.R;
import zxj.com.allpeoplewt.bean.tvbean.FaceBean;

/**
 * Created by ${zhaoxinJ} on 2016/11/15.
 */
public class FaceContentHolder extends BaseViewHolder<FaceBean.RoomBean.ListBean> {

    private final TextView face_title;
    private Context context;
    private final TextView face_nick;
    private final TextView face_view;
    private final ImageView face_thumb;
    private final ImageView face_avatar;

    public FaceContentHolder(View itemView) {
        super(itemView);
        face_title = (TextView) itemView.findViewById(R.id.face_title1);
        face_nick = (TextView) itemView.findViewById(R.id.face_nick);
        face_view = (TextView) itemView.findViewById(R.id.face_view);
        face_thumb = (ImageView) itemView.findViewById(R.id.face_thumb);
        face_avatar = (ImageView) itemView.findViewById(R.id.face_avatar);

    }

    @Override
    public void setData(Context context, FaceBean.RoomBean.ListBean listBean) {
        this.context = context;
        face_title.setText(listBean.title);
        face_nick.setText(listBean.nick);
        face_view.setText(listBean.view);
        ImageUtilsManager.getGlideUtils(ImageUtilsManager.Type.GLIDE).displayCircleImg(face_avatar,listBean.avatar);
        ImageUtilsManager.getGlideUtils(ImageUtilsManager.Type.GLIDE).displayRoundImg(face_thumb,listBean.thumb,10);
    }


}
