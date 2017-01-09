package zxj.com.allpeoplewt.adapter.holder;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerClickListener;

import java.util.Arrays;

import zxj.com.allpeoplewt.R;
import zxj.com.allpeoplewt.bean.ColumnBean;

/**
 * Created by ${zhaoxinJ} on 2016/11/15.
 */
public class FaceViewPagerHolder extends BaseViewHolder<ColumnBean.DataBean> {


    private final Banner face_vpager;

    public FaceViewPagerHolder(View itemView) {
        super(itemView);
        face_vpager = (Banner) itemView.findViewById(R.id.face_vpager);
    }

    @Override
    public void setData(final Context context, ColumnBean.DataBean dataBean) {
       /* face_vpager.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
//        face_vpager.setBannerTitles(list1);
//设置动画样式
        face_vpager.setBannerAnimation(Transformer.ZoomOutSlide);
//可以从网络加载图片
        ArrayList<String> list=new ArrayList<>();
        Log.e("2222222222", "setData: 00000000");
        list.add("http://p2.so.qhmsg.com/sdr/548_768_/t010b6b5ed2a65f02f7.jpg");
        list.add("http://p3.so.qhmsg.com/sdr/543_768_/t019c3f5413fa74ac58.jpg");
        list.add("http://p0.so.qhmsg.com/sdr/550_768_/t012cf3676f14046bf0.jpg");
        list.add("http://p0.so.qhmsg.com/sdr/549_768_/t01a4ca8fda1e9fae80.jpg");
        Log.e("11111111111", "setData: 00000000");
        face_vpager.setImages(list).setImageLoader(new GlideImageLoader()).start();*/
        face_vpager.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
        face_vpager.setBannerTitles(Arrays.asList("1/4","2/4","3/4","4/4"));
        face_vpager.setBannerAnimation(Transformer.Accordion);

        face_vpager.setImages(Arrays.asList(R.drawable.face_vp1,R.drawable.face_vp2,R.drawable.face_vp3,R.drawable.face_vp4)).setImageLoader(new GlideImageLoader()).start();
        face_vpager.setOnBannerClickListener(new OnBannerClickListener() {
            @Override
            public void OnBannerClick(int position) {
                Toast.makeText(context,"点击了"+position,Toast.LENGTH_SHORT).show();
            }
        });


    }


}
