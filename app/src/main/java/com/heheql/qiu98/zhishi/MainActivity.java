package com.heheql.qiu98.zhishi;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private ImageView btHome;
    private ImageView btZhishi;
    private ImageView btMessage;
    private ImageView btMine;

    private GridView gridView;
    private List<Map<String, Object>> dataList;
    private SimpleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setListoner();
        setGridview();
    }
    protected void setGridview(){
        gridView = (GridView) findViewById(R.id.home_gridview);
        initData();
        String[] from={"item_home_img","item_home_title","item_home_context"};

        int[] to={R.id.item_home_img, R.id.item_home_title, R.id.item_home_context};
        adapter=new SimpleAdapter(this, dataList, R.layout.item_home_list, from, to);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {
                AlertDialog.Builder builder= new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("提示").setMessage(dataList.get(arg2).get("item_home_title").toString()).create().show();
            }
        });
    }
    void initData() {
        //图标
        int icno[] = { R.drawable.button1, R.drawable.button2, R.drawable.button3,
                R.drawable.button4, R.drawable.button5, R.drawable.button6};
        //图标下的文字
        String name[]={"服装设计稿","胶带设计稿","饰品设计稿","明星周边设计","明星周边设计","明星周边设计"};
        String context[]={"衣柜永远填不满的小美好","弥补生活中的每一个缺憾","发布专属于你的故饰会","下一个肆月山河就是你","下一个肆月山河就是你","下一个肆月山河就是你"};
        dataList = new ArrayList<Map<String, Object>>();
        for (int i = 0; i <icno.length; i++) {
            Map<String, Object> map=new HashMap<String, Object>();
            map.put("item_home_img", icno[i]);
            map.put("item_home_title",name[i]);
            map.put("item_home_context",context[i]);
            dataList.add(map);
        }
    }
    protected void setListoner() {
        btHome = findViewById(R.id.home_imgHome);
        btZhishi = findViewById(R.id.home_imgZhishi);
        btMessage = findViewById(R.id.home_imgMessage);
        btMine = findViewById(R.id.home_imgMine);
        btZhishi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ZhishiActivity.class);
                startActivity(intent);
                finish();
            }
        });
        btMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MessageActivity.class);
                startActivity(intent);
                finish();
            }
        });
        btMine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MineActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
