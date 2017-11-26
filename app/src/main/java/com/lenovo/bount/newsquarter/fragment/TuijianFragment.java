package com.lenovo.bount.newsquarter.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lenovo.bount.newsquarter.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/11/13.
 */

public class TuijianFragment extends Fragment {

    private View view;
    private TabLayout tab;
    private ViewPager vp;
    private List<Fragment> fragmentList;
    private MyAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = View.inflate(getContext(), R.layout.tuijian_frag,null);
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
        fragmentList.add(new NeMengFragment());
        fragmentList.add(new GuanzhuFragment());

        adapter = new MyAdapter(getFragmentManager());
        vp.setAdapter(adapter);
        tab.setupWithViewPager(vp);
    }
    private void initView() {
        tab = getView().findViewById(R.id.tab);
        vp = getView().findViewById(R.id.vp);
    }

    class MyAdapter extends FragmentPagerAdapter
    {
        private String[] title={"关注","热门"};

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
