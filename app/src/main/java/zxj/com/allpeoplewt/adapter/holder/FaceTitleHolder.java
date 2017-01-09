package zxj.com.allpeoplewt.adapter.holder;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import zxj.com.allpeoplewt.R;
import zxj.com.allpeoplewt.bean.tvbean.FaceBean;

/**
 * Created by ${zhaoxinJ} on 2016/11/15.
 */
public class FaceTitleHolder extends BaseViewHolder<FaceBean.RoomBean> {

    private final TextView face_title;
    private Context context;

    public FaceTitleHolder(View itemView) {
        super(itemView);
        face_title = (TextView) itemView.findViewById(R.id.face_title);

    }

    @Override
    public void setData(Context context, FaceBean.RoomBean roomBean) {
        this.context = context;
        face_title.setText(roomBean.name);
    }


}
