package zxj.com.allpeoplewt.adapter.holder;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;
import java.util.List;

import zxj.com.allpeoplewt.R;
import zxj.com.allpeoplewt.bean.DailyBean;

/**
 * Created by ${zhaoxinJ} on 2016/11/15.
 */
public class Type0Holder extends BaseViewHolder<List<DailyBean.TopStoriesBean>> {
    private ArrayList<ImageView> listRound= new ArrayList<ImageView>();
public List<DailyBean.TopStoriesBean> list=new ArrayList<>();
    private final ViewPager viewPager;
    private final LinearLayout main_ll_yuan;
    private Context context;
    private  TextView daily_item1_textview;

    public Type0Holder(View itemView) {
        super(itemView);
        viewPager = (ViewPager) itemView.findViewById(R.id.daily_item0_vp);
        main_ll_yuan = (LinearLayout) itemView.findViewById(R.id.home_ll_yuan);
        daily_item1_textview = (TextView) itemView.findViewById(R.id.daily_item0_textview);
    }

    @Override
    public void setData(Context context, List<DailyBean.TopStoriesBean> list) {
        this.list.clear();
        this.context = context;
        this.list.addAll(list);
        initdots();
        initEvent();

    }

    private void initdots() {//将小圆点放入视图，添加到集合

        listRound.clear();
        for (int i = 0; i < list.size(); i++) {
            ImageView imgview=new ImageView(context);
            if(i==0){
                imgview.setImageResource(R.drawable.trueround);
            }else {
                imgview.setImageResource(R.drawable.redround);
            }
            LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(20, 20);
            params.setMargins(5, 0, 5, 0);
            main_ll_yuan.addView(imgview, params);//添加到自定义的线性布局
            listRound.add(imgview);
        }
    }

    private void initEvent() {


        viewPager.setAdapter(new MyPagerAdapter());
        viewPager.setOnPageChangeListener(new MyPageChangeListener());
        handler.sendEmptyMessage(0);

    }

    /**
     * ================================================
     */
    class MyPagerAdapter extends PagerAdapter {
        @Override
        public int getCount() {
            return list.size()*10000;
        }
        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0==arg1;
        }
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            // container.removeView(imgList.get(position%imgList.size()));
            container.removeView((ImageView)(object));

        }
        @Override
        public Object instantiateItem(ViewGroup container, final int position) {

            // container.addView(imgList.get(position%list.size()));

            ImageView iv=new ImageView(context);
            Glide.with(context)
                    .load(list.get(position%list.size()).image)
                    .thumbnail( 0.3f)//缩略图
                    .centerCrop()
                    .crossFade()
                    .dontAnimate()//没有动画
                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                    .into(iv);

            iv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context,"点击viewpager，下标为："+position%list.size(),Toast.LENGTH_SHORT).show();
                }
            });
            container.addView(iv);
            return iv;
        }
    }
    class MyPageChangeListener implements ViewPager.OnPageChangeListener {

        @Override
        public void onPageScrollStateChanged(int arg0) {
            // TODO Auto-generated method stub

        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {
            // TODO Auto-generated method stub

        }

        @Override
        public void onPageSelected(int arg0) {
            daily_item1_textview.setText(list.get(arg0%list.size()).title);
            for (int i = 0; i <listRound.size(); i++) {
                listRound.get(i).setImageResource(R.drawable.redround);
            }

            listRound.get(arg0%listRound.size()).setImageResource(R.drawable.trueround);

        }

    }
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            int currentItem = viewPager.getCurrentItem();
           int i = currentItem+1;
            viewPager.setCurrentItem(i);
            handler.sendEmptyMessageDelayed(0,4000);
        }
    };
}
