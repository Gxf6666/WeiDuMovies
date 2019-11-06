package com.bawei.weidumovie.view.activity;

import android.content.Intent;
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

public class LoginActivity extends BaseActivity {


    @BindView(R.id.text_yx)
    EditText textYx;
    @BindView(R.id.text_pwd)
    EditText textPwd;
    @BindView(R.id.text_wjpwd)
    Button textWjpwd;
    @BindView(R.id.text_zhuce)
    TextView textZhuce;
    @BindView(R.id.text_loig)
    Button textLoig;
    @BindView(R.id.text_weixin)
    ImageButton textWeixin;
    private LoginPresenter loginPresenter;

    @Override
    protected void initView(Bundle savedInstanceState) {

        String yx = textYx.getText().toString();
        String pwd = textPwd.getText().toString();

        String pwds = Base64.encode(pwd.getBytes());
        String mm = EncryptUtil.encrypt(pwds);

        loginPresenter = new LoginPresenter(new LoginPresen());
        loginPresenter.Request(yx,mm);
    }

    @Override
    protected int LayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    private class LoginPresen implements DataCall<List<Logins>> {
        @Override
        public void Success(List<Logins> data) {
            Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(LoginActivity.this,MainActivity.class);
            startActivity(intent);
        }

        @Override
        public void Error(Request request) {

        }
    }
}
