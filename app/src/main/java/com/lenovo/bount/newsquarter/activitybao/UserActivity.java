package com.lenovo.bount.newsquarter.activitybao;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.lenovo.bount.newsquarter.R;
import com.lenovo.bount.newsquarter.bean.ResponsBodyBean;
import com.lenovo.bount.newsquarter.interceptor.MyInterceptor;
import com.lenovo.bount.newsquarter.presenter.NickNamePresenter;
import com.lenovo.bount.newsquarter.view.NickNameView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UserActivity extends AppCompatActivity implements NickNameView,View.OnClickListener {
    private String name;
    @BindView(R.id.imageView3)
    ImageView imageView3;
    @BindView(R.id.textView2)
    TextView textView2;
    @BindView(R.id.iv_touxiang)
    ImageView ivTouxiang;
    @BindView(R.id.jt)
    ImageView jt;
    @BindView(R.id.phone_name)
    TextView phoneName;
    @BindView(R.id.tv_nick)
    TextView tvNick;
    @BindView(R.id.imageView2)
    ImageView imageView2;
    @BindView(R.id.imageView)
    ImageView imageView;
    private NickNamePresenter nickNamePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        ButterKnife.bind(this);
        initData();
        tvNick.setOnClickListener(this);
    }

    private void initData() {
        nickNamePresenter = new NickNamePresenter(this);

    }
    @Override
    public void Success(ResponsBodyBean value) {
        Toast.makeText(this, value.msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void Error(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFair(Throwable e) {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.tv_nick:

                final EditText inputServer = new EditText(this);
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("修改昵称").setIcon(android.R.drawable.ic_dialog_info).setView(inputServer)
                        .setNegativeButton("取消", null);
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {



                    public void onClick(DialogInterface dialog, int which) {
                        name = inputServer.getText().toString();
                        nickNamePresenter.getnick(MyInterceptor.uid,inputServer.getText().toString());
                    }
                });
                builder.show();
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        tvNick.setText(name);
    }
}
