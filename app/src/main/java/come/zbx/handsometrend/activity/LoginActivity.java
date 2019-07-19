package come.zbx.handsometrend.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import come.zbx.handsometrend.R;


public class LoginActivity extends BaseActivity {

    private final String TAG = "LoginActivity";
    @BindView(R.id.layout_inputpwd)
    RelativeLayout layout_inputpwd;
    @BindView(R.id.layout_inputvali)
    RelativeLayout layout_inputvali;
    @BindView(R.id.btn_login)
    Button btn_login;
    @BindView(R.id.tv_getvali)
    TextView tv_getvali;
    @BindView(R.id.edit_phone)
    EditText edit_phone;
    @BindView(R.id.edit_pwd)
    EditText edit_pwd;
    @BindView(R.id.edit_vali)
    EditText edit_vali;
    @BindView(R.id.tv_switch_loginway)
    TextView tv_switch_loginway;
    @BindView(R.id.img_delete)
    ImageView img_delete;
    @BindView(R.id.img_hidden)
    ImageView img_hidden;

    private TimeCount time;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        time = new TimeCount(10 * 1000, 1000);
        edit_phone.addTextChangedListener(new MyTextWatcher());

    }

    @OnClick({R.id.btn_login, R.id.tv_switch_loginway, R.id.tv_getvali, R.id.tv_agree, R.id.img_delete, R.id.img_hidden})
    public void OnViewClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                Log.d(TAG, "点击了登录");
                break;
            case R.id.tv_switch_loginway:
                Log.d(TAG, "点击切换登录方式");
                if (layout_inputvali.isShown()) {
                    layout_inputpwd.setVisibility(View.VISIBLE);
                    layout_inputvali.setVisibility(View.GONE);
                    tv_switch_loginway.setText("验证码登录");
                } else {
                    layout_inputpwd.setVisibility(View.GONE);
                    layout_inputvali.setVisibility(View.VISIBLE);
                    tv_switch_loginway.setText("密码登录");
                }

                break;
            case R.id.tv_getvali:
                Log.d(TAG, "点击获取验证码");
                time.start();
                break;
            case R.id.tv_agree:
                Log.d(TAG, "点击了用户协议");
                Intent it=new Intent(LoginActivity.this,aMainActivity.class);
                startActivity(it);
                break;
            case R.id.img_delete:
                edit_phone.setText("");
                break;
            case R.id.img_hidden:
                if(edit_pwd.getInputType()==129){
                    edit_pwd.setInputType(128);
                    img_hidden.setImageResource(R.mipmap.show);
                }else if(edit_pwd.getInputType()==128){
                    edit_pwd.setInputType(129);
                    img_hidden.setImageResource(R.mipmap.hidden);
                }

                break;
        }
    }

    private Boolean ValiPhone(String phone) {
        if (phone.length() == 11) {
            return true;
        }
        return false;
    }

    class MyTextWatcher implements TextWatcher {
        @Override
        public void afterTextChanged(Editable s) {
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count,
                                      int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before,
                                  int count) {
            if (!TextUtils.isEmpty(edit_phone.getText().toString().trim())) {
                img_delete.setVisibility(View.VISIBLE);
                if (ValiPhone(edit_phone.getText().toString().trim())) {
                    btn_login.setEnabled(true);
                    btn_login.setBackground(getResources().getDrawable(R.drawable.btn_login_selector));
                    tv_getvali.setTextColor(getResources().getColor(R.color.tv_vali_true));
                }else{
                    btn_login.setEnabled(false);
                    btn_login.setBackground(getResources().getDrawable(R.drawable.btn_login_selector));
                    tv_getvali.setTextColor(getResources().getColor(R.color.tv_vali_false));
                }
            } else {
                img_delete.setVisibility(View.INVISIBLE);
            }

        }
    }

    class TimeCount extends CountDownTimer {

        public TimeCount(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            tv_getvali.setTextColor(getResources().getColor(R.color.tv_vali_false));
            tv_getvali.setClickable(false);
            tv_getvali.setText(millisUntilFinished / 1000 + " S");
        }

        @Override
        public void onFinish() {
            tv_getvali.setTextColor(getResources().getColor(R.color.tv_vali_true));
            tv_getvali.setClickable(true);
            tv_getvali.setText("重新获取");

        }
    }


}//end
