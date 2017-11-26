package com.lenovo.bount.newsquarter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.lenovo.bount.newsquarter.build.ImmersionUtil;

public class QidongActivity extends AppCompatActivity {
    private int[] head={R.mipmap.a,R.mipmap.b,R.mipmap.c};
    private ImageView iv_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_qidong);
         initView();
        ImmersionUtil.TransparentStatusbar(this);
        ImmersionUtil.FullScreenMod(true,this);
    }
    private void initView() {
        iv_btn = findViewById(R.id.iv_btn);
      ViewPager vp= findViewById(R.id.vp);
      VpAdapter adapter=new VpAdapter();
      vp.setAdapter(adapter);
      vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
         @Override
         public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                  if(position==2)
                  {
                   iv_btn.setVisibility(View.VISIBLE);
                   iv_btn.setOnClickListener(new View.OnClickListener() {
                       @Override
                       public void onClick(View view) {
                         startActivity(new Intent(QidongActivity.this,MainActivity.class));
                       }
                   });
                  }
                }

         @Override
         public void onPageSelected(int position) {

         }
         @Override
         public void onPageScrollStateChanged(int state) {

         }
     });
    }
    class VpAdapter extends PagerAdapter
    {

        @Override
        public int getCount() {
            return head.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View view=View.inflate(QidongActivity.this,R.layout.viewpager_layout,null);
            ImageView iv= view.findViewById(R.id.iv);
            iv_btn= view.findViewById(R.id.iv_btn);
            iv.setImageResource(head[position]);
            container.addView(view);
            return view;
        }
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }
}
