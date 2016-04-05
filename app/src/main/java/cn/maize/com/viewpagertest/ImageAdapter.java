package cn.maize.com.viewpagertest;

import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/**
 * @author jackhappyness
 * @version 1.0
 * @describe ViewPager适配器
 * @date 2016/4/1
 */
public class ImageAdapter extends PagerAdapter {
    private List list;

    public ImageAdapter(List list) {
        this.list = list;
    }

    /**
     * 获取显示的页数
     *
     * @return
     */
    @Override
    public int getCount() {
        return list.size();
    }

    /**
     * 实例化item，把要显示的View添加到View的容器ViewPager
     *
     * @param container
     * @param position
     * @return
     */
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView imageView = (ImageView) list.get(position);
        container.addView(imageView);
        Log.e("instantiateItem", "添加view:" + position);
        return imageView;
    }

    /**
     * 判断传递过来的View是否是要显示的View
     *
     * @param view
     * @param object
     * @return
     */
    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    /**
     * 销毁View
     *
     * @param container
     * @param position
     * @param object
     */
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        Log.e("destroyItem", "销毁view:" + position);
        container.removeView((View) list.get(position));
    }
}
