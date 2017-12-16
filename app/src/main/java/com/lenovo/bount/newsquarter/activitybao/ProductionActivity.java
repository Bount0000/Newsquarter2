package com.lenovo.bount.newsquarter.activitybao;

import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.lenovo.bount.newsquarter.R;
import com.lenovo.bount.newsquarter.base.BaseActivity;
import com.lenovo.bount.newsquarter.base.BasePresenter;
import com.lenovo.bount.newsquarter.fragment.BendiFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProductionActivity extends BaseActivity {

    @BindView(R.id.shezhi_back)
    ImageView shezhiBack;
    @BindView(R.id.she_r1)
    RelativeLayout sheR1;
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.vp)
    ViewPager vp;
    private List<Fragment> fragmentList;

    @Override
    public int bindLayout() {
        return R.layout.activity_production2;
    }

    @Override
    public void setLister() {

    }

    @Override
    public void Click(View view) {

    }

    @Override
    public void initView() {
        ButterKnife.bind(this);
        setshowActionBar(false);
    }

    @Override
    public void initDate() {

        fragmentList = new ArrayList<>();
        fragmentList.add(new BendiFragment());
        fragmentList.add(new BendiFragment());
        MyAdapter myAdapter = new MyAdapter(getSupportFragmentManager());
        vp.setAdapter(myAdapter);
        tabLayout.setupWithViewPager(vp);
       /* tabLayout.post(new Runnable() {
            @Override
            public void run() {
                setIndicator(tab, 60, 60);
            }
        });*/

    }

    @Override
    public List<BasePresenter> initPresenter() {
        return null;
    }




    class MyAdapter extends FragmentPagerAdapter {
        private String[] title = {"本地作品", "已上传作品"};

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
