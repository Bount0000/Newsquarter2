package com.lenovo.bount.newsquarter;

import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lenovo.bount.newsquarter.base.BaseActivity;
import com.lenovo.bount.newsquarter.base.BasePresenter;
import com.lenovo.bount.newsquarter.bean.ResponsBodyBean;
import com.lenovo.bount.newsquarter.presenter.PublishJokePresenter;
import com.lenovo.bount.newsquarter.utils.SpUtils;
import com.lenovo.bount.newsquarter.view.PublishJokeView;

import java.util.ArrayList;
import java.util.List;

public class PublishJokeActivity extends BaseActivity implements PublishJokeView {

    private TextView tv_fabiao;
    private EditText ed_fabiao;
    private PublishJokePresenter presenter;
    private TextView tv_duanzi_quxiao;
    private RelativeLayout rl1;
    private TextView pop_finish;
    private PopupWindow popupWindow;
    private View view2;

    @Override
    public int bindLayout() {
        return R.layout.activity_publish_joke;
    }

    @Override
    public void setLister() {
        tv_fabiao.setOnClickListener(this);
        tv_duanzi_quxiao.setOnClickListener(this);
        pop_finish.setOnClickListener(this);
    }

    @Override
    public void Click(View view) {
    switch (view.getId())
    {
        case R.id.tv_fabiao:
            SpUtils utils=new SpUtils(this,"Login");
            String uid = utils.getString("uid", "");
            presenter.getpublish(uid,ed_fabiao.getText().toString());
            break;
        case R.id.tv_duanzi_quxiao:
            popupWindow = new PopupWindow(view2, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            popupWindow.showAsDropDown(view2,120,1400);
            popupWindow.showAtLocation(rl1, Gravity.BOTTOM,30,20);
           /*
            popupWindow.showAsDropDown(view2,-300,-400);
            popupWindow.showAtLocation(rl1,Gravity.BOTTOM,30,20);*/
          /*  PopupWindow popupWindow = new PopupWindow(view2);
            popupWindow.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
            popupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);*/
            break;
        case R.id.pop_finish:
            popupWindow.dismiss();
            break;
    }
    }
    @Override
    public void initView() {
        tv_fabiao = findViewById(R.id.tv_fabiao);
        ed_fabiao = findViewById(R.id.ed_fabiao);
        tv_duanzi_quxiao=findViewById(R.id.tv_duanzi_quxiao);
        view2 = View.inflate(this, R.layout.popw_layout,null);
        pop_finish = view2.findViewById(R.id.pop_finish);
        rl1 = findViewById(R.id.rl1);
    }

    @Override
    public void initDate() {
        presenter = new PublishJokePresenter(this);
    }

    @Override
    public List<BasePresenter> initPresenter() {
        List<BasePresenter> presentersList=new ArrayList<>();
        presentersList.add(presenter);
        return presentersList;
    }

    @Override
    public void Success(ResponsBodyBean bodyBean) {
         showToast(bodyBean.msg);
    }

    @Override
    public void Error() {
        showToast("失败");
    }

    @Override
    public void onFair(Throwable e) {
        showToast("失败");
    }
}
