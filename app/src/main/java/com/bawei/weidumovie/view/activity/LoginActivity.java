package com.bawei.weidumovie.view.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.weidumovie.R;
import com.bawei.weidumovie.disanfang.Base64;
import com.bawei.weidumovie.disanfang.EncryptUtil;
import com.bawei.weidumovie.model.bean.Logins;
import com.bawei.weidumovie.model.bean.Request;
import com.bawei.weidumovie.presenter.LoginPresenter;
import com.bawei.weidumovie.view.consion.DataCall;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity {


    @BindView(R.id.text_yx)
    EditText textYx;
    @BindView(R.id.text_pwd)
    EditText textPwd;
    @BindView(R.id.text_wjpwd)
    Button textWjpwd;
    @BindView(R.id.text_weixin)
    ImageButton textWeixin;
    private LoginPresenter loginPresenter;

    @Override
    protected void initView(Bundle savedInstanceState) {
        SharedPreferences sp = getSharedPreferences("name", MODE_PRIVATE);
        String Email = sp.getString("Email", "");
        String Mm = sp.getString("Mm", "");

        textYx.setText(Email);
        textPwd.setText(Mm);
        loginPresenter = new LoginPresenter(new LoginPresen());

    }

    @OnClick(R.id.text_zhuce)
    public void zhuce() {
        Intent intent = new Intent(LoginActivity.this, ZhuCeActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.text_loig)
    public void login() {

        String yx = textYx.getText().toString();
        String pwd = textPwd.getText().toString();

        String pwds = Base64.encode(pwd.getBytes());
        String mm = EncryptUtil.encrypt(pwds);

        loginPresenter.Request(yx, mm);

    }

    @Override
    protected int LayoutId() {
        return R.layout.activity_login;
    }


    private class LoginPresen implements DataCall<Logins> {
        @Override
        public void Success(Logins data) {
            Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
        }

        @Override
        public void Error(Request request) {

        }
    }
}
