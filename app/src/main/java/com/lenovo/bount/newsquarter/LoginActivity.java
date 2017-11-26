package com.lenovo.bount.newsquarter;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.lenovo.bount.newsquarter.base.BaseActivity;

public class LoginActivity extends BaseActivity {

    private TextView other_way;

   /* public LoginActivity(BasePresenter presenter) {
        super(presenter);
    }

    @Override
    public BasePresenter initPresenter() {
        return null;
    }
*/
    @Override
    public int bindLayout() {
        return R.layout.activity_login;
    }

    @Override
    public void setLister() {
        other_way.setOnClickListener(this);
    }

    @Override
    public void Click(View view) {
     switch (view.getId())
     {
         case R.id.other_way:
             startActivity(new Intent(LoginActivity.this,Login2Activity.class));
             break;
     }
    }

    @Override
    public void initView() {
        other_way = findViewById(R.id.other_way);
    }

    @Override
    public void initDate() {

    }

}
