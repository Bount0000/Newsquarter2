package com.lenovo.bount.newsquarter.activitybao;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.lenovo.bount.newsquarter.R;
import com.lenovo.bount.newsquarter.base.BaseActivity;
import com.lenovo.bount.newsquarter.base.BasePresenter;
import com.lenovo.bount.newsquarter.bean.ResponsBodyBean;
import com.lenovo.bount.newsquarter.bean.Userbean;
import com.lenovo.bount.newsquarter.presenter.LoginPresenter;
import com.lenovo.bount.newsquarter.utils.SpUtils;
import com.lenovo.bount.newsquarter.view.LoginView;

import java.util.ArrayList;
import java.util.List;

public class Login2Activity extends BaseActivity implements LoginView{


    private TextView tv_zhuce;
    private TextView but_log;
    private List<BasePresenter> presenterList;
    private LoginPresenter loginPresenter;
    private EditText et_user;
    private EditText et_psd;
    private TextView tv_youke;


    @Override
    public int bindLayout() {
        return R.layout.activity_login2;
    }

    @Override
    public void setLister() {
        tv_zhuce.setOnClickListener(this);
        but_log.setOnClickListener(this);
        tv_youke.setOnClickListener(this);
    }

    @Override
    public void Click(View view) {
        switch (view.getId())
        {
            case R.id.tv_zhuce:
                startActivity(new Intent(Login2Activity.this,RegisterActivity.class));
                finish();
                break;
            case R.id.but_log:
                loginPresenter.login(et_user.getText().toString(),et_psd.getText().toString());
                if(!TextUtils.isEmpty(et_user.getText().toString())&&!TextUtils.isEmpty(et_psd.getText().toString()))
                {
                 startActivity(new Intent(Login2Activity.this,MainActivity.class));
                    finish();
                }
                break;
            case R.id.tv_youke:
                startActivity(MainActivity.class);
                finish();
                break;
         }
         }
    @Override
    public void initView() {
        setshowActionBar(false);
        tv_zhuce = (TextView) findViewById(R.id.tv_zhuce);
        but_log = (TextView) findViewById(R.id.but_log);
        et_user = (EditText) findViewById(R.id.et_user);
        et_psd = (EditText) findViewById(R.id.et_psd);
        tv_youke = (TextView) findViewById(R.id.tv_youke);
    }

    @Override
    public void initDate() {
        loginPresenter = new LoginPresenter(this);
    }

    @Override
    public List<BasePresenter> initPresenter() {
        presenterList = new ArrayList<>();
        presenterList.add(loginPresenter);
        return presenterList;
    }

    @Override
    public void Success(ResponsBodyBean<Userbean> userbean) {
        showToast(userbean.msg);
        SpUtils utils=new SpUtils(this,"Login");
        String uid = userbean.data.uid;
        String token = userbean.data.token;
        String icon = userbean.data.icon;
        utils.putString("uid",uid);
        utils.putString("token",token);
        utils.putString("icon",icon);
        System.out.println("====login======="+uid);
    }
    @Override
    public void Error() {

    }

    @Override
    public void onFair() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
