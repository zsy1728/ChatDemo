package com.example.chatdemo2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    private EditText et_name;
    private EditText et_ip;
    private EditText et_port;
    private TextView my_name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //获取id,连接控件
        Button login = (Button) findViewById(R.id.login);
        Button quit = (Button) findViewById(R.id.quit);
        et_name = findViewById(R.id.et_name);
        et_ip = (EditText) findViewById(R.id.et_ip);
        et_port = (EditText) findViewById(R.id.et_port);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //获取一个视图View对象里的字符串
                String name = et_name.getText().toString();
                //如果没输入名字
                if("".equals(name)){
                    Toast.makeText(MainActivity.this, "请输入用户名！", Toast.LENGTH_SHORT).show();
                }else{
                    Intent intent = new Intent(MainActivity.this,ChoosePicture.class);
                    //向下一活动传递信息                                        intent.putExtra("name",et_name.getText().toString());
                    intent.putExtra("ip",et_ip.getText().toString());
                    intent.putExtra("port",et_port.getText().toString());
                    intent.putExtra("name", name);
                    try{
                        startActivity(intent);
                    }catch(Exception e){
                        Log.d("MainActivity", "开启失败");
                        System.out.println("开启失败");
                        finish();
                    }
                }
            }
        });
//quit点击事件
        quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //用AlertDialog显示一个退出提示框
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("关闭提示");
                dialog.setMessage("确定退出登录？");
                dialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
//                        System.exit(0);
                    }
                });
                dialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                dialog.show();
            }
        });
    }
}