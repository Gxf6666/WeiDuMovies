package com.bawei.weidumovie.view.activity;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bawei.weidumovie.R;
import com.bawei.weidumovie.disanfang.Base64;
import com.bawei.weidumovie.disanfang.EncryptUtil;
import com.bawei.weidumovie.model.bean.Request;
import com.bawei.weidumovie.presenter.EmailCodePresenter;
import com.bawei.weidumovie.presenter.RegisterPresenter;
import com.bawei.weidumovie.view.consion.DataCall;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ZhuCeActivity extends BaseActivity {


    @BindView(R.id.text_nc)
    EditText textNc;
    @BindView(R.id.text_yx1)
    EditText textYx1;
    @BindView(R.id.text_pwd1)
    EditText textPwd1;
    @BindView(R.id.text_yz)
    EditText textYz;
    @BindView(R.id.text_yanzheng)
    Button textYanzheng;
    private RegisterPresenter registerPresenter;
    private SharedPreferences.Editor edit;
    private EmailCodePresenter emailCodePresenter;

    @Override
    protected void initView(Bundle savedInstanceState) {


        registerPresenter = new RegisterPresenter(new RegisterPresen());

    }

    @OnClick(R.id.text_yanzheng)
    public void Yanzheng() {
        String Email = textYx1.getText().toString();
        emailCodePresenter = new EmailCodePresenter(new EmailCode());
        emailCodePresenter.Request((String) Email);
    }

    @OnClick(R.id.text_zhuce1)
    public void ZhuCe() {
        String Name = textNc.getText().toString();
        String Email = textYx1.getText().toString();
        String Pwd = textPwd1.getText().toString();
        String yanzheng = textYz.getText().toString();

        String Pwds = Base64.encode(Pwd.getBytes());
        String Mm = EncryptUtil.encrypt(Pwds);

        SharedPreferences sp = getSharedPreferences("name", MODE_PRIVATE);
        edit = sp.edit();
        edit.putString("Email", Email);
        edit.putString("Mm", Pwd);
        edit.commit();

        registerPresenter.Request(Name, Mm, Email, yanzheng);
    }

    @Override
    protected int LayoutId() {
        return R.layout.activity_zhu_ce;
    }

    private class RegisterPresen implements DataCall<Request> {
        @Override
        public void Success(Request data) {
//             Toast.makeText(ZhuCeActivity.this, data.message, Toast.LENGTH_SHORT).show();
            finish();
        }

        @Override
        public void Error(Request request) {

        }
    }

    private class EmailCode implements DataCall<Request> {
        @Override
        public void Success(Request data) {
            //Toast.makeText(ZhuCeActivity.this, data.message, Toast.LENGTH_SHORT).show();
        }

        @Override
        public void Error(Request request) {

        }
    }
}

