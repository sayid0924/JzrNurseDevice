package com.jzr.nursedevice.ui.activity.patientdiaolog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blankj.utilcode.utils.ToastUtils;
import com.google.gson.Gson;
import com.jzr.nursedevice.R;
import com.jzr.nursedevice.base.BaseActivity;
import com.jzr.nursedevice.bean.PatientInfoBean;
import com.jzr.nursedevice.view.dialog.KeyboardDialog;
import com.orhanobut.logger.Logger;

import butterknife.BindView;
import butterknife.OnClick;

public class TemperatureActivity extends BaseActivity {


    private PatientInfoBean.DataBean item;

    @BindView(R.id.rl_back)
    RelativeLayout rlBack;
    @BindView(R.id.actionbar_title)
    TextView actionbarTitle;
    @BindView(R.id.left_title)
    TextView leftTitle;

    @BindView(R.id.ll_tem)
    LinearLayout llTem;
    @BindView(R.id.tv_tem)
    TextView tvTem;

    @BindView(R.id.ll_pulse)
    LinearLayout llPulse;
    @BindView(R.id.tv_pulse)
    TextView tvPulse;

    @BindView(R.id.ll_breath)
    LinearLayout llBreath;
    @BindView(R.id.tv_breath)
    TextView tvBreath;

    @BindView(R.id.ll_heart)
    LinearLayout llHeart;
    @BindView(R.id.tv_heart)
    TextView tvHeart;


    private String sTem;
    private StringBuffer stringBufferTem;
    private KeyboardDialog keyboardDialog;


    @Override
    public int getLayoutId() {
        return R.layout.activity_temperature;
    }

    @Override
    public void attachView() {

    }

    @Override
    public void detachView() {

    }

    @Override
    public void initView() {

        String pData = getIntent().getStringExtra("data");
        item = new Gson().fromJson(pData, PatientInfoBean.DataBean.class);
        actionbarTitle.setText(item.getName() + "  " + item.getBedName() + " " + item.getCureNo());
        leftTitle.setText("体温单");

    }

    @OnClick({R.id.rl_back, R.id.ll_tem, R.id.ll_pulse, R.id.ll_breath, R.id.ll_heart})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_back:
                finish();
                break;
            case R.id.ll_tem:
                showKeyBoardDialog(R.id.ll_tem);
                break;
            case R.id.ll_pulse:
                showKeyBoardDialog(R.id.ll_pulse);
                break;
            case R.id.ll_breath:
                showKeyBoardDialog(R.id.ll_breath);
                break;
            case R.id.ll_heart:
                showKeyBoardDialog(R.id.ll_heart);
                break;
        }
    }

    private void showKeyBoardDialog(final int view) {
         if(keyboardDialog!=null && keyboardDialog.isShowing()){
             keyboardDialog.dismiss();
             keyboardDialog=null;
         }
        keyboardDialog = new KeyboardDialog(this);
        keyboardDialog.show();
        keyboardDialog.setCancelable(true);
        keyboardDialog.onItemClick(new KeyboardDialog.onItemClick() {
            @Override
            public void onItemClick(String num) {
                switch (view) {
                    case R.id.ll_tem:
                        sTem = tvTem.getText().toString();
                        stringBufferTem = new StringBuffer();
                        stringBufferTem.append(sTem + num);
                        tvTem.setText(stringBufferTem.toString());
                        break;
                    case R.id.ll_pulse:
                        sTem = tvPulse.getText().toString();
                        stringBufferTem = new StringBuffer();
                        stringBufferTem.append(sTem + num);
                        tvPulse.setText(stringBufferTem.toString());
                        break;
                    case R.id.ll_breath:
                        sTem = tvBreath.getText().toString();
                        stringBufferTem = new StringBuffer();
                        stringBufferTem.append(sTem + num);
                        tvBreath.setText(stringBufferTem.toString());
                        break;
                    case R.id.ll_heart:
                        sTem = tvHeart.getText().toString();
                        stringBufferTem = new StringBuffer();
                        stringBufferTem.append(sTem + num);
                        tvHeart.setText(stringBufferTem.toString());
                        break;
                }
            }
        }, new KeyboardDialog.onDelClick() {
            @Override
            public void onDelClick() {
                switch (view) {
                    case R.id.ll_tem:
                        sTem = tvTem.getText().toString();
                        if (sTem.length() != 0) {
                            tvTem.setText(sTem.substring(0, sTem.length() - 1));
                        } else {
                            ToastUtils.showLongToast("没有数值");
                        }
                        break;
                    case R.id.ll_pulse:
                        sTem = tvPulse.getText().toString();
                        if (sTem.length() != 0) {
                            tvPulse.setText(sTem.substring(0, sTem.length() - 1));
                        } else {
                            ToastUtils.showLongToast("没有数值");
                        }
                        break;
                    case R.id.ll_breath:
                        sTem = tvBreath.getText().toString();
                        if (sTem.length() != 0) {
                            tvBreath.setText(sTem.substring(0, sTem.length() - 1));
                        } else {
                            ToastUtils.showLongToast("没有数值");
                        }
                        break;
                    case R.id.ll_heart:
                        sTem = tvHeart.getText().toString();
                        if (sTem.length() != 0) {
                            tvHeart.setText(sTem.substring(0, sTem.length() - 1));
                        } else {
                            ToastUtils.showLongToast("没有数值");
                        }
                        break;
                }
            }
        });
    }
}
