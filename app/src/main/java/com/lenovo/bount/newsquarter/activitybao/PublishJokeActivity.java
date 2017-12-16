package com.lenovo.bount.newsquarter.activitybao;

import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lenovo.bount.newsquarter.GlideLoader;
import com.lenovo.bount.newsquarter.R;
import com.lenovo.bount.newsquarter.base.BaseActivity;
import com.lenovo.bount.newsquarter.base.BasePresenter;
import com.lenovo.bount.newsquarter.bean.ResponsBodyBean;
import com.lenovo.bount.newsquarter.presenter.PublishJokePresenter;
import com.lenovo.bount.newsquarter.utils.SpUtils;
import com.lenovo.bount.newsquarter.view.PublishJokeView;
import com.yancy.imageselector.ImageConfig;
import com.yancy.imageselector.ImageSelector;
import com.yancy.imageselector.ImageSelectorActivity;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PublishJokeActivity extends BaseActivity implements PublishJokeView {

    public static final int REQUEST_CODE = 1000;
    private TextView tv_fabiao;
    private EditText ed_fabiao;
    private PublishJokePresenter presenter;
    private TextView tv_duanzi_quxiao;
    private RelativeLayout rl1;
    private TextView pop_finish;
    private PopupWindow popupwindow;
    private View view2;
    private ImageView iv_tupain;
    private RecyclerView rv;
    private List<String> path;
    private com.lenovo.bount.newsquarter.adapter.Adapter adapter;
    @Override
    public int bindLayout() {
        return R.layout.activity_publish_joke;
    }

    @Override
    public void setLister() {
        tv_fabiao.setOnClickListener(this);
        tv_duanzi_quxiao.setOnClickListener(this);
        pop_finish.setOnClickListener(this);
        iv_tupain.setOnClickListener(this);
    }
    @Override
    public void Click(View view) {
    switch (view.getId())
    {
        case R.id.tv_fabiao:
            SpUtils utils=new SpUtils(this,"Login");
            String uid = utils.getString("uid", "");
            presenter.getpublish(uid,ed_fabiao.getText().toString(),path);
             startActivity(Activity.class);
            break;
        case R.id.tv_duanzi_quxiao:
            popupwindow = new PopupWindow(view2);
            popupwindow.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
            popupwindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
            popupwindow.showAsDropDown(view2,120,800);
            popupwindow.showAtLocation(rl1, Gravity.BOTTOM,30,20);

            break;
        case R.id.pop_finish:
            popupwindow.dismiss();
            break;
        case R.id.iv_tupain:
            ImageConfig imageConfig
                    = new ImageConfig.Builder(
                    // GlideLoader 可用自己用的缓存库
                    new GlideLoader())
                    // 如果在 4.4 以上，则修改状态栏颜色 （默认黑色）
                    .steepToolBarColor(getResources().getColor(R.color.green))
                    // 标题的背景颜色 （默认黑色）
                    .titleBgColor(getResources().getColor(R.color.green))
                    // 提交按钮字体的颜色  （默认白色）
                    .titleSubmitTextColor(getResources().getColor(R.color.white))
                    // 标题颜色 （默认白色）
                    .titleTextColor(getResources().getColor(R.color.white))
                    // 开启多选   （默认为多选）  (单选 为 singleSelect)
                    .mutiSelect()
                    // 多选时的最大数量   （默认 9 张）
                    .mutiSelectMaxSize(9)
                    // 已选择的图片路径
                    .pathList((ArrayList<String>) path)
                    // 拍照后存放的图片路径（默认 /temp/picture）
                    .filePath("/ImageSelector/Pictures")
                    // 开启拍照功能 （默认开启）
                    .showCamera()
                    .requestCode(REQUEST_CODE)
                    .build();
            ImageSelector.open(PublishJokeActivity.this, imageConfig); // 开启图片选择器
            break;
    }

    }
    @Override
    public void initView() {
         setshowActionBar(false);
        tv_fabiao = findViewById(R.id.tv_fabiao);
        ed_fabiao =  findViewById(R.id.ed_fabiao);
        tv_duanzi_quxiao=  findViewById(R.id.tv_duanzi_quxiao);
        view2 = View.inflate(this, R.layout.popw_layout,null);
        pop_finish = view2.findViewById(R.id.pop_finish);
        rl1 =  findViewById(R.id.rl1);
        iv_tupain = findViewById(R.id.iv_tupain);
        rv = findViewById(R.id.rv);
    }

    @Override
    public void initDate() {
        presenter = new PublishJokePresenter(this);
        path = new ArrayList<>();
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        rv.setLayoutManager(gridLayoutManager);
        adapter = new com.lenovo.bount.newsquarter.adapter.Adapter(this,path);
        rv.setAdapter(adapter);
        initShangchaun();
    }

    private void initShangchaun() {;
        List<File> files=new ArrayList<>();
        for (int i = 0; i <files.size() ; i++) {
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK && data != null) {
            List<String> pathList = data.getStringArrayListExtra(ImageSelectorActivity.EXTRA_RESULT);
            for (String path : pathList) {
                Log.i("ImagePathList", path);
            }
            path.clear();
            path.addAll(pathList);
            adapter.notifyDataSetChanged();
        }
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
    public void Error(String msg) {
        showToast(msg);
    }

    @Override
    public void onFair(String msg) {
        showToast(msg);
    }

}
