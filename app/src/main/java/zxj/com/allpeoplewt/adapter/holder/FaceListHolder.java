package zxj.com.allpeoplewt.adapter.holder;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import zxj.com.allpeoplewt.R;
import zxj.com.allpeoplewt.adapter.FaceListAdapter;
import zxj.com.allpeoplewt.bean.tvbean.FaceBean;

/**
 * Created by ${zhaoxinJ} on 2016/11/15.
 */
public class FaceListHolder extends BaseViewHolder<FaceBean.RoomBean> {

//public List<FaceBean.RoomBean> list=new ArrayList<>();
    private final RecyclerView face_recyclerview;
    private Context context;

    public FaceListHolder(View itemView) {
        super(itemView);
        face_recyclerview = (RecyclerView) itemView.findViewById(R.id.face_recyclerview);

    }

    @Override
    public void setData(Context context, FaceBean.RoomBean bean) {
        this.context = context;

        GridLayoutManager gridLayoutManager1 =  new GridLayoutManager(context,2);
        gridLayoutManager1 .setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return position==0?2:1;
            }
        });
        face_recyclerview.setLayoutManager(gridLayoutManager1);
        FaceListAdapter adapter=new FaceListAdapter(context,bean);
        face_recyclerview.setAdapter(adapter);
    }


}
