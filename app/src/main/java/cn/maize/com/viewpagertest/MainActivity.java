package cn.maize.com.viewpagertest;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {

    private ViewPager viewPager;
    private List list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //1.查找控件
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        //2.获取数据
        int[] image_ids = {R.mipmap.image_1, R.mipmap.image_5, R.mipmap.image_6, R.mipmap.image_7, R.mipmap.image_10,
                R.mipmap.image_13, R.mipmap.image_14, R.mipmap.image_15, R.mipmap.image_16, R.mipmap.image_19, R.mipmap.image_21,
                R.mipmap.image_24, R.mipmap.image_25, R.mipmap.image_28, R.mipmap.image_29};
        //3.ViewPager要显示的view的控件，创建显示的View,存放在集合里
        list = new ArrayList();
        for (int i = 0; i < image_ids.length; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(image_ids[i]);
            list.add(imageView);
        }
        //4.使用适配器管理数据
        ImageAdapter adapter = new ImageAdapter(list);
        //5.关联控件和适配器
        viewPager.setAdapter(adapter);
        //6.修改默认加载个数
        viewPager.setOffscreenPageLimit(5);
        //7.设置监听器
        viewPager.setOnPageChangeListener(this);
        //8.设置默认选中的页面
        viewPager.setCurrentItem(3);
    }

    /**
     * 页面滚动的时候调用，常被用来实现滚动动画
     *
     * @param position
     * @param positionOffset
     * @param positionOffsetPixels
     */
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        Log.e("", "onPageScrolled：" + position);
    }

    /**
     * 新页面被选中
     *
     * @param position
     */
    @Override
    public void onPageSelected(final int position) {
        Log.e("", "onPageSelected：" + position);
        ImageView imageView = (ImageView) list.get(position);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, position + "", Toast.LENGTH_LONG).show();
            }
        });
    }

    /**
     * 滑动状态改变时调用
     *
     * @param state
     */
    @Override
    public void onPageScrollStateChanged(int state) {
        Log.e("", "onPageScrollStateChanged：" + state);
    }
}
