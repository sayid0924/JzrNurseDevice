package com.jzr.nursedevice.ui.activity.patientdiaolog;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bigkoo.pickerview.builder.OptionsPickerBuilder;
import com.bigkoo.pickerview.listener.OnOptionsSelectListener;
import com.bigkoo.pickerview.view.OptionsPickerView;
import com.blankj.utilcode.utils.TimeUtils;
import com.google.gson.Gson;
import com.jzr.nursedevice.R;
import com.jzr.nursedevice.base.BaseActivity;
import com.jzr.nursedevice.bean.PatientInfoBean;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

public class VitalSignsActivity extends BaseActivity {


    private PatientInfoBean.DataBean item;


    private ArrayList<String> food = new ArrayList<>();
    private ArrayList<String> clothes = new ArrayList<>();
    private ArrayList<String> computer = new ArrayList<>();
    private OptionsPickerView pvNoLinkOptions;

    @BindView(R.id.rl_back)
    RelativeLayout rlBack;
    @BindView(R.id.actionbar_title)
    TextView actionbarTitle;
    @BindView(R.id.left_title)
    TextView leftTitle;

    @BindView(R.id.tv_date)
    TextView tvDate;
    @BindView(R.id.tv_ti)
    TextView tvTi;
    @BindView(R.id.ll_ti)
    LinearLayout llTi;



    @Override
    public int getLayoutId() {
        return R.layout.activity_vital_signs;
    }

    @Override
    public void attachView() {

    }

    @Override
    public void detachView() {

    }

    @Override
    public void initView() {
        setSwipeBackEnable(true);

        String pData = getIntent().getStringExtra("data");
        item = new Gson().fromJson(pData, PatientInfoBean.DataBean.class);

        actionbarTitle.setText(item.getName()+"  "+ item.getBedName() + "床  "+item.getCureNo());
        leftTitle.setText("生命体征");
        tvDate.setText(TimeUtils.getNowTimeString());
        getNoLinkData();
        initNoLinkOptionsPicker();

    }

    @OnClick({R.id.rl_back, R.id.ll_ti})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_back:
                finish();
                break;
            case R.id.ll_ti:
                pvNoLinkOptions.show();
                break;
        }
    }


    private void initNoLinkOptionsPicker() {// 不联动的多级选项
        pvNoLinkOptions = new OptionsPickerBuilder(this, new OnOptionsSelectListener() {

            @Override
            public void onOptionsSelect(int options1, int options2, int options3, View v) {
                String str = food.get(options1)  + ":     " + clothes.get(options2) + computer.get(options3)+" °C";
                tvTi.setText(str);
            }
        }).build();
        pvNoLinkOptions.setNPicker(food, clothes, computer);
        pvNoLinkOptions.setSelectOptions(0, 1, 1);

    }


    private void getNoLinkData() {
        food.add("口温");
        food.add("腋温");
        food.add("肛温");

        clothes.add("35");
        clothes.add("36");
        clothes.add("37");
        clothes.add("38");
        clothes.add("39");
        clothes.add("40");
        clothes.add("41");
        clothes.add("42");

        computer.add(".0");
        computer.add(".1");
        computer.add(".2");
        computer.add(".3");
        computer.add(".4");
        computer.add(".5");
        computer.add(".6");
        computer.add(".7");
        computer.add(".8");
        computer.add(".9");
    }

}
