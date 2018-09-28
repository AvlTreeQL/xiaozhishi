package com.heheql.qiu98.zhishi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ZhishiActivity extends Activity {
    private ImageView btHome;
    private ImageView btZhishi;
    private ImageView btMessage;
    private ImageView btMine;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhishi);
        setListoner();
    }
    protected void setListoner() {
        btHome = findViewById(R.id.zhishi_imgHome);
        btZhishi = findViewById(R.id.zhishi_imgZhishi);
        btMessage = findViewById(R.id.zhishi_imgMessage);
        btMine = findViewById(R.id.zhishi_imgMine);
        btHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ZhishiActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        btMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ZhishiActivity.this, MessageActivity.class);
                startActivity(intent);
            }
        });
        btMine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ZhishiActivity.this, MineActivity.class);
                startActivity(intent);
            }
        });

    }
}
