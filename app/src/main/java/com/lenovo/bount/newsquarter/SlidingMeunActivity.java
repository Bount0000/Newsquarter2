package com.lenovo.bount.newsquarter;

import android.os.Bundle;

import com.kson.slidingmenu.SlidingMenu;
import com.kson.slidingmenu.app.SlidingFragmentActivity;
import com.lenovo.bount.newsquarter.fragment.LeftFragment;

public class SlidingMeunActivity extends SlidingFragmentActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sliding_meun);
        //设置左菜单
        setBehindContentView(R.layout.leftfrag_layout);

        getSupportFragmentManager().beginTransaction().replace(R.id.left_fl,new LeftFragment()).commit();

        SlidingMenu menu=getSlidingMenu();

        //设置左滑右滑菜单
        menu.setMode(SlidingMenu.LEFT_RIGHT);
        //设置滑动屏幕范围
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_MARGIN);
        //划出时主页面显示的剩余宽度
        //menu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
        //设置菜单的宽度
        menu.setBehindWidth(400);
        //滑动时渐变程度
        menu.setFadeDegree(0.35f);
    }
}
