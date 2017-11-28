package com.lenovo.bount.newsquarter;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.lenovo.bount.newsquarter.base.BaseActivity;
import com.lenovo.bount.newsquarter.base.BasePresenter;
import com.lenovo.bount.newsquarter.bean.ResponsBodyBean;
import com.lenovo.bount.newsquarter.presenter.ZhucePresenter;
import com.lenovo.bount.newsquarter.view.ZhuceView;

import java.util.ArrayList;
import java.util.List;

public class RegisterActivity extends BaseActivity implements ZhuceView{
    private LinearLayout rl;
    private EditText et_user;
    private EditText et_psd;
    private Button btn_zhuce;
    private ZhucePresenter presenter;
    @Override
    public List<BasePresenter> initPresenter() {
        List<BasePresenter> zhucelist=new ArrayList<>();
        zhucelist.add(presenter);
        return zhucelist;
    }

    @Override
    public int bindLayout() {
        return R.layout.activity_register;
    }

    @Override
    public void setLister() {
        btn_zhuce.setOnClickListener(this);
    }

    @Override
    public void Click(View view) {
    switch (view.getId())
    {
        case R.id.btn_zhuce:
            String s = et_user.getText().toString();
            String s1 = et_psd.getText().toString();
            presenter.zhuce(et_user.getText().toString(),et_psd.getText().toString());
            System.out.println("用户名"+s);
            System.out.println("密码"+s1);
            break;
    }
    }
    @Override
    public void initView() {
        rl = findViewById(R.id.rl_background);
        rl.getBackground().setAlpha(80);
        et_user = findViewById(R.id.et_user);
        et_psd = findViewById(R.id.et_psd);
        btn_zhuce = findViewById(R.id.btn_zhuce);
    }
    @Override
    public void initDate() {
        presenter = new ZhucePresenter(RegisterActivity.this);

    }
    @Override
    public void Success(ResponsBodyBean value) {
       showToast(value.msg);

    }

    @Override
    public void Error() {

    }

    @Override
    public void onFair() {

    }
}
