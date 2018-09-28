package com.heheql.qiu98.zhishi;

import android.app.Activity;
import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends Activity {

    private AutoCompleteTextView etMail;
    private EditText etPass;
    private Button mLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // Set up the login form.
        etMail = (AutoCompleteTextView) findViewById(R.id.email);
        populateAutoComplete(); //自动补全

        etPass = (EditText) findViewById(R.id.password);

        mLogin = (Button)findViewById(R.id.email_sign_in_button);
        mLogin.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (loginPro()) {
                    Intent intent = new Intent(LoginActivity.this, MineActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    //验证用户是否存在
    private boolean loginPro(){
        String username = etMail.getText().toString();
        String password = etPass.getText().toString();
        try {
            JSONObject jsonObj = query(username, password);
            if(jsonObj.getInt("userId") > 0) return true;
        }catch (Exception e){//显示对话框

        }
        return false;
    }
    //给服务器username, password, 如果有这个用户，返回一个含有userId的JSONObject
    private JSONObject query(String username, String password) throws Exception{
        Map<String, String> mp = new HashMap<>();
        mp.put("user", username);
        mp.put("pass", password);

        return new JSONObject().put("userId", 1);
    }
    private void populateAutoComplete() {
    //    if (!mayRequestContacts()) {
     //       return;
     //   }

    //    getLoaderManager().initLoader(0, null, this);
    }
}

