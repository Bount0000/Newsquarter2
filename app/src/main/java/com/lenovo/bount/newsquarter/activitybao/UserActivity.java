package com.lenovo.bount.newsquarter.activitybao;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.lenovo.bount.newsquarter.R;
import com.lenovo.bount.newsquarter.bean.ResponsBodyBean;
import com.lenovo.bount.newsquarter.interceptor.MyInterceptor;
import com.lenovo.bount.newsquarter.presenter.ChangePicturePresenter;
import com.lenovo.bount.newsquarter.presenter.NickNamePresenter;
import com.lenovo.bount.newsquarter.utils.Utils;
import com.lenovo.bount.newsquarter.view.ChangePictureView;
import com.lenovo.bount.newsquarter.view.NickNameView;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import butterknife.BindView;
import butterknife.ButterKnife;

import static com.lenovo.bount.newsquarter.App.context;

public class UserActivity extends AppCompatActivity implements NickNameView,View.OnClickListener,ChangePictureView {
    private String name;
    protected static final int CHOOSE_PICTURE = 0;
    protected static final int TAKE_PICTURE = 1;
    private static final int CROP_SMALL_PICTURE = 2;
    protected static Uri tempUri;
    @BindView(R.id.imageView3)
    ImageView imageView3;
    @BindView(R.id.textView2)
    TextView textView2;
    @BindView(R.id.iv_touxiang2)
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
    private EditText inputServer;
    private ChangePicturePresenter changePicturePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        ButterKnife.bind(this);
        initData();
        tvNick.setOnClickListener(this);
        ivTouxiang.setOnClickListener(this);
    }

    private void initData() {
        nickNamePresenter = new NickNamePresenter(this);
        changePicturePresenter = new ChangePicturePresenter(this);
        Intent intent = getIntent();
        String icon = intent.getStringExtra("icon");
        String nickname = intent.getStringExtra("nickname");
        Glide.with(context).load(icon).asBitmap().centerCrop().into(new BitmapImageViewTarget(ivTouxiang) {
            @Override
            protected void setResource(Bitmap resource) {
                RoundedBitmapDrawable circularBitmapDrawable =
                        RoundedBitmapDrawableFactory.create(context.getResources(), resource);
                circularBitmapDrawable.setCircular(true);
                ivTouxiang.setImageDrawable(circularBitmapDrawable);
            }
        });
        System.out.println("+++nickname++++"+nickname);
        tvNick.setText(nickname);
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
                inputServer = new EditText(this);
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("修改昵称").setIcon(android.R.drawable.ic_dialog_info).setView(inputServer)
                        .setNegativeButton("取消", null);
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        name = inputServer.getText().toString();
                        tvNick.setText(name);
                        nickNamePresenter.getnick(MyInterceptor.uid, inputServer.getText().toString());
                    }
                });
                builder.show();
                break;
            case R.id.iv_touxiang2:
                //修改头像
                showChooseAlterDialog();
                 break;
        }

    }

    private void showChooseAlterDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("设置头像");
        String[] items = { "选择本地照片", "拍照" };
        builder.setNegativeButton("取消", null);
        builder.setItems(items, new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case CHOOSE_PICTURE: // 选择本地照片
                        Intent openAlbumIntent = new Intent(
                                Intent.ACTION_GET_CONTENT);
                        openAlbumIntent.setType("image/*");
                        startActivityForResult(openAlbumIntent, CHOOSE_PICTURE);
                        break;
                    case TAKE_PICTURE: // 拍照
                        Intent openCameraIntent = new Intent(
                                MediaStore.ACTION_IMAGE_CAPTURE);
                        tempUri = Uri.fromFile(new File(Environment
                                .getExternalStorageDirectory(), "image.jpg"));
                        // 指定照片保存路径（SD卡），image.jpg为一个临时文件，每次拍照后这个图片都会被替换
                        openCameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, tempUri);
                        startActivityForResult(openCameraIntent, TAKE_PICTURE);
                        break;
                }
            }
        });
        builder.create().show();
    }

    @Override
    public void ChageTxSuccess(ResponsBodyBean value) {
        Toast.makeText(this, value.msg, Toast.LENGTH_SHORT).show();
        System.out.println("===头像====="+value.msg);
    }

    @Override
    public void ChageTxError(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        System.out.println("====头像===="+msg);
    }

    @Override
    public void ChageTxonFair(Throwable e) {
        Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
        System.out.println("====头像===="+e.toString());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) { // 如果返回码是可以用的
            switch (requestCode) {
                case TAKE_PICTURE:
                    startPhotoZoom(tempUri); // 开始对图片进行裁剪处理
                    break;
                case CHOOSE_PICTURE:
                    startPhotoZoom(data.getData()); // 开始对图片进行裁剪处理
                    break;
                case CROP_SMALL_PICTURE:
                    if (data != null) {
                        setImageToView(data); // 让刚才选择裁剪得到的图片显示在界面上
                    }
                    break;
            }
        }
    }
    /**
     * 裁剪图片方法实现
     *
     * @param uri
     */
    protected void startPhotoZoom(Uri uri) {
        if (uri == null) {
            Log.i("tag", "The uri is not exist.");
        }
        tempUri = uri;
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/*");
        // 设置裁剪
        intent.putExtra("crop", "true");
        // aspectX aspectY 是宽高的比例
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        // outputX outputY 是裁剪图片宽高
        intent.putExtra("outputX", 150);
        intent.putExtra("outputY", 150);
        intent.putExtra("return-data", true);
        startActivityForResult(intent, CROP_SMALL_PICTURE);
    }
    /**
     * 保存裁剪之后的图片数据
     *
     * @param
     *
     * @param
     */
    protected void setImageToView(Intent data) {
        Bundle extras = data.getExtras();
        if (extras != null) {
            Bitmap photo = extras.getParcelable("data");
            Utils utils=new Utils();
            photo = utils.toRoundBitmap(photo); // 这个时候的图片已经被处理成圆形的了
            ivTouxiang.setImageBitmap(photo);
            uploadPic(photo);//下载图片
        }
       }
    /**
     * 上传头像
     * @param
     */
    private void uploadPic(Bitmap bitmap) {
        File file=new File("/mnt/sdcard/007.jpg");
        try {
            BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream(file));
            bitmap.compress(Bitmap.CompressFormat.JPEG,100,bos);
            bos.flush();
            bos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        changePicturePresenter.getChange(MyInterceptor.uid,file);
    }

}
