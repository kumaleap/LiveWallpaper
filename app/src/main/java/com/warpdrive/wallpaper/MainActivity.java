package com.warpdrive.wallpaper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.Permission;
import com.yanzhenjie.permission.Rationale;
import com.yanzhenjie.permission.RationaleListener;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn).setOnClickListener(this);
        //申请权限
        AndPermission.with(this)
                .requestCode(100)
                .permission(Permission.CAMERA)
                .rationale(new RationaleListener() {
                    @Override
                    public void showRequestPermissionRationale(int requestCode, Rationale rationale) {
                    }
                }).callback(this).start();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn:
                //启动选择壁纸
                Intent pickWallpaper = new Intent(Intent.ACTION_SET_WALLPAPER);
                Intent chooser = Intent.createChooser(pickWallpaper, "选择壁纸");
                startActivity(chooser);
                break;
        }
    }
}
