package com.lenovo.bount.newsquarter.activitybao;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.lenovo.bount.newsquarter.R;
import com.lenovo.bount.newsquarter.adapter.GetUserVideoAd;
import com.lenovo.bount.newsquarter.base.BaseActivity;
import com.lenovo.bount.newsquarter.base.BasePresenter;
import com.lenovo.bount.newsquarter.bean.Getuser;
import com.lenovo.bount.newsquarter.bean.ResponsBodyBean;
import com.lenovo.bount.newsquarter.bean.Userbean2;
import com.lenovo.bount.newsquarter.interceptor.MyInterceptor;
import com.lenovo.bount.newsquarter.presenter.FollowPresenter;
import com.lenovo.bount.newsquarter.presenter.GetUservideo;
import com.lenovo.bount.newsquarter.presenter.PresonPresenter;
import com.lenovo.bount.newsquarter.utils.SpUtils;
import com.lenovo.bount.newsquarter.view.FollowView;
import com.lenovo.bount.newsquarter.view.GetUservideoView;
import com.lenovo.bount.newsquarter.view.PresonView;

import java.util.ArrayList;
import java.util.List;

public class GuanzhuActivity extends BaseActivity implements PresonView,FollowView,GetUservideoView {
    private ImageView iv_gutx;
    private PresonPresenter uerperson;
    private TextView fans_num;
    private TextView follow_num;
    private ImageView guanzhu;
    private GetUservideo uservideopresenter;
    private XRecyclerView xrv;
    private Userbean2.DataBean userdata;
    private FollowPresenter follesenterpresenter;
    private int useruid;
    private int i;
    @Override
    public int bindLayout()
    {
        return R.layout.activity_guanzhu;
    }

    @Override
    public void setLister() {
        guanzhu.setOnClickListener(this);
    }

    @Override
    public void Click(View view) {
    switch (view.getId())
    {
        case R.id.guanzhu:
            String uid = MyInterceptor.uid;
            System.out.println("===拦截器uid===="+uid);
            System.out.println("===fowllouid===="+useruid);
            follesenterpresenter.getfollow("114", this.useruid +"");
            if(i%2==0)
            { i++;
                guanzhu.setImageResource(R.mipmap.jguanzhu);
            }
            else
            {
                guanzhu.setImageResource(R.mipmap.yguanzhu);
                i++;
            }
            break;
    }
    }

    @Override
    public void initView() {
        setshowActionBar(false);
        iv_gutx = findViewById(R.id.iv_gutx);
        fans_num = findViewById(R.id.fans_num);
        follow_num = findViewById(R.id.follow_num);
        guanzhu = findViewById(R.id.guanzhu);
        xrv = findViewById(R.id.xrv);

    }
    @Override
    public void initDate() {
        Intent intent = getIntent();
        useruid = intent.getIntExtra("uid", 0);
        uerperson = new PresonPresenter(this);
        uerperson.getuser(useruid +"");
        follesenterpresenter = new FollowPresenter(this);
        uservideopresenter = new GetUservideo(this);
    }

    @Override
    public List<BasePresenter> initPresenter() {
        List<BasePresenter> userlist=new ArrayList<>();
        userlist.add(uerperson);
        userlist.add(uservideopresenter);
        return userlist;
    }
    @Override
    public void Success(Userbean2 userbean) {
        showToast(userbean.msg);
        userdata = userbean.data;
       String icon = userbean.data.icon;
         int fans = userbean.data.fans;
         int follow = userbean.data.follow;
         String token = userbean.data.token;
         iv_gutx.setImageURI(Uri.parse(icon));
         fans_num.setText(fans+"");
         follow_num.setText(follow+"");
         int uid = userbean.data.uid;
         SpUtils utils=new SpUtils(this,"User");
         utils.putString("token",token);
         uservideopresenter.getUservideo(uid+"",1);
    }

    @Override
    public void Error(String msg) {
        showToast(msg);
    }

    @Override
    public void onFair(Throwable e) {
        showToast(e.toString());
    }

    @Override
    public void FollowSuccess(ResponsBodyBean value) {
        showToast(value.msg);

    }

    @Override
    public void FollowError(String msg) {
        showToast(msg);
    }

    @Override
    public void FollowOnFair(Throwable e) {
        showToast(e.toString());
    }
    @Override
    public void getUserSuccess(Getuser value) {
        List<Getuser.DataBean> data = value.data;
        LinearLayoutManager manager=new LinearLayoutManager(this);
        GetUserVideoAd adapter=new GetUserVideoAd(this,data,userdata);
        xrv.setAdapter(adapter);
        xrv.setLayoutManager(manager);
        SpUtils utils=new SpUtils(this,"User");
        utils.putString("token","1D34763F54E391E345A71D6C3050A323");
    }

    @Override
    public void getUserError(String msg) {

    }

    @Override
    public void getUsermsOnFair(String msg) {

    }
}
