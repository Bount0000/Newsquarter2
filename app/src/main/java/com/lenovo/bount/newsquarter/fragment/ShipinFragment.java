package com.lenovo.bount.newsquarter.fragment;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.lenovo.bount.newsquarter.R;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/11/13.
 */

public class ShipinFragment extends Fragment {

    private View view;
    private TabLayout tab;
    private ViewPager vp;
    private List<Fragment> fragmentList;
    private TuijianFragment.MyAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = View.inflate(getContext(), R.layout.shipin_frag,null);
        return view;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        TextView tv=view.findViewById(R.id.tv);
        initView();
        initData();
    }

    private void initData() {
        fragmentList = new ArrayList<>();
        fragmentList.add(new GuanzhuFragment());
        fragmentList.add(new ReMenFragment());
        MyAdapter adapter = new MyAdapter(getFragmentManager());
        vp.setAdapter(adapter);
        tab.setupWithViewPager(vp);
        tab.post(new Runnable() {
            @Override
            public void run() {
                setIndicator(tab, 60, 60);
            }
        });
    }
    private void initView() {
        tab = getView().findViewById(R.id.tab);
        vp = getView().findViewById(R.id.vp);
    }
    public static void setIndicator(TabLayout tabs, int leftDip, int rightDip) {
        Class<?> tabLayout = tabs.getClass();
        Field tabStrip = null;
        try {
            tabStrip = tabLayout.getDeclaredField("mTabStrip");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        tabStrip.setAccessible(true);
        LinearLayout llTab = null;
        try {
            llTab = (LinearLayout) tabStrip.get(tabs);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        int left = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, leftDip, Resources.getSystem().getDisplayMetrics());
        int right = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, rightDip, Resources.getSystem().getDisplayMetrics());

        for (int i = 0; i < llTab.getChildCount(); i++) {
            View child = llTab.getChildAt(i);
            child.setPadding(0, 0, 0, 0);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, 1);
            params.leftMargin = left;
            params.rightMargin = right;
            child.setLayoutParams(params);
            child.invalidate();
        }
    }
    class MyAdapter extends FragmentPagerAdapter
    {
        private String[] title={"热门","热门"};

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return title[position];
        }
    }
}
