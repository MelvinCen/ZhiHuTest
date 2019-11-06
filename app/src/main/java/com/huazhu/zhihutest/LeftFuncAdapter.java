package com.huazhu.zhihutest;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class LeftFuncAdapter extends BaseAdapter {

    private Context mContext;

    public LeftFuncAdapter(Context context) {
        mContext = context;
    }

    private int[] imagesId =
            {R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher,
                    R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher};
    private String[] titles = {"首页", "发现", "关注", "收藏", "草稿", "提问"};

    @Override
    public int getCount() {
        return titles.length;
    }

    @Override
    public Object getItem(int position) {
        return titles[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = View.inflate(mContext, R.layout.left_list_item, null);

        ImageView imageView = view.findViewById(R.id.iv_photo);
        TextView textView =  view.findViewById(R.id.tv_title);

        imageView.setBackgroundResource(imagesId[position]);
        textView.setText(titles[position]);
        return view;
    }
}
