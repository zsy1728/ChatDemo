package com.example.chatdemo2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class ChoosePicture extends AppCompatActivity implements View.OnClickListener {
    private String et_name;
    private String et_ip;
    private String et_port;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_picture);
        Log.d("ChoosePicture", "start----");

        Intent intent = getIntent();
        et_name = intent.getStringExtra("name");
        et_ip = intent.getStringExtra("ip");
        et_port = intent.getStringExtra("port");
        Button button1 = (Button)findViewById(R.id.one);
        Button button2 = (Button)findViewById(R.id.two);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(ChoosePicture.this, ChatRoom.class);
        intent.putExtra("name",et_name.toString());
        intent.putExtra("ip",et_ip.toString());
        intent.putExtra("port",et_port.toString());

        switch(v.getId()){
            case R.id.one:
                intent.putExtra("imageId",R.drawable.d7f9ae);
                break;
            case R.id.two:
                intent.putExtra("imageId",R.drawable.weimei20230124204448);
                break;
        }
        startActivity(intent);
    }
}