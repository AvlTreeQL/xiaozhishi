package com.heheql.qiu98.zhishi;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
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

public class MessageActivity extends Activity {
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
        setContentView(R.layout.activity_message);
        setListoner();
        setGridview();
    }
    protected void setGridview(){
        gridView = (GridView) findViewById(R.id.message_gridview);
        initData();
        //item信息
        String[] from={"item_message_img","item_message_title","item_message_context","item_message_time","item_message_imgread"};

        int[] to={R.id.item_message_img, R.id.item_message_title, R.id.item_message_context, R.id.item_message_time, R.id.item_message_imgread};
        adapter=new SimpleAdapter(this, dataList, R.layout.item_message_list, from, to);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {
                AlertDialog.Builder builder= new AlertDialog.Builder(MessageActivity.this);
                builder.setTitle("提示").setMessage(dataList.get(arg2).get("item_message_title").toString()).create().show();
            }
        });
    }
    void initData() {
        //图标
        int icno[] = { R.drawable.item_message_head, R.drawable.item_message_head, R.drawable.item_message_head};
        int isread[] = { R.drawable.bg_doat, R.drawable.bg_doat, R.drawable.bg_doat};
        //图标下的文字
        String name[]={"服装设计稿","胶带设计稿","饰品设计稿"};
        String context[]={"衣柜永远填不满的小美好","弥补生活中的每一个缺憾","发布专属于你的故饰会"};
        String time[] = {"2:24 am","9:10 am","2:10 am"};
        dataList = new ArrayList<Map<String, Object>>();
        for (int i = 0; i <icno.length; i++) {
            Map<String, Object> map=new HashMap<String, Object>();
            map.put("item_message_img", icno[i]);
            map.put("item_message_title",name[i]);
            map.put("item_message_context",context[i]);
            map.put("item_message_time",time[i]);
            map.put("item_message_imgread",isread[i]);
            dataList.add(map);
        }
    }
    protected void setListoner() {
        btHome = findViewById(R.id.message_imgHome);
        btZhishi = findViewById(R.id.message_imgZhishi);
        btMessage = findViewById(R.id.message_imgMessage);
        btMine = findViewById(R.id.message_imgMine);
        btHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MessageActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        btZhishi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MessageActivity.this, ZhishiActivity.class);
                startActivity(intent);
            }
        });
        btMine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MessageActivity.this, MineActivity.class);
                startActivity(intent);
            }
        });

    }
}
