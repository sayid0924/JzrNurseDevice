package com.jzr.nursedevice.ui.activity.patientdiaolog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.jzr.nursedevice.R;
import com.jzr.nursedevice.base.BaseActivity;
import com.jzr.nursedevice.bean.PatientInfoBean;

import butterknife.BindView;
import butterknife.OnClick;

public class EvaluationActivity extends BaseActivity {


    private PatientInfoBean.DataBean item;

    @BindView(R.id.rl_back)
    RelativeLayout rlBack;
    @BindView(R.id.actionbar_title)
    TextView actionbarTitle;
    @BindView(R.id.left_title)
    TextView leftTitle;


    @Override
    public int getLayoutId() {
        return R.layout.activity_evaluation;
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
        leftTitle.setText("评估");

    }

    @OnClick({R.id.rl_back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_back:
                finish();
                break;

        }
    }

}
