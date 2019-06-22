package com.jzr.nursedevice.ui.activity.patientdiaolog;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blankj.utilcode.utils.TimeUtils;
import com.google.gson.Gson;
import com.jzr.nursedevice.R;
import com.jzr.nursedevice.base.BaseActivity;
import com.jzr.nursedevice.bean.PatientInfoBean;

import butterknife.BindView;
import butterknife.OnClick;

public class PatrolActivity extends BaseActivity {

    private PatientInfoBean.DataBean item;

    @BindView(R.id.rl_back)
    RelativeLayout rlBack;
    @BindView(R.id.actionbar_title)
    TextView actionbarTitle;
    @BindView(R.id.left_title)
    TextView leftTitle;

    @BindView(R.id.tv_date)
    TextView tvDate;
    @BindView(R.id.tv_spirits)
    TextView tvSpirits;
    @BindView(R.id.tv_tem)
    TextView tvTem;
    @BindView(R.id.tv_infusion)
    TextView tvInfusion;
    @BindView(R.id.tv_channe)
    TextView tvChanne;
    @BindView(R.id.tv_skin)
    TextView tvSkin;
    @BindView(R.id.tv_give)
    TextView tvGive;
    @BindView(R.id.et_eye)
    EditText etEye;
    @BindView(R.id.ll_spirits)
    LinearLayout llSpirits;
    @BindView(R.id.ll_tem)
    LinearLayout llTem;
    @BindView(R.id.ll_infusion)
    LinearLayout llInfusion;
    @BindView(R.id.ll_channe)
    LinearLayout llChanne;
    @BindView(R.id.ll_skin)
    LinearLayout llSkin;
    @BindView(R.id.ll_give)
    LinearLayout llGive;


    @Override
    public int getLayoutId() {
        return R.layout.activity_patrol;
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

        actionbarTitle.setText(item.getName()+"  "+ item.getBedName() + " "+item.getCureNo());
        leftTitle.setText("巡视病房");


        tvDate.setText(TimeUtils.getNowTimeString());
    }

    @OnClick({R.id.rl_back, R.id.ll_spirits, R.id.ll_tem, R.id.ll_infusion, R.id.ll_channe, R.id.ll_skin, R.id.ll_give})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_back:
                finish();
                break;
            case R.id.ll_spirits:
                showAlertDialog(R.array.select, R.id.ll_spirits);
                break;
            case R.id.ll_tem:
                showAlertDialog(R.array.tem, R.id.ll_tem);
                break;
            case R.id.ll_infusion:
                showAlertDialog(R.array.infusion, R.id.ll_infusion);
                break;
            case R.id.ll_channe:
                showAlertDialog(R.array.channe, R.id.ll_channe);
                break;
            case R.id.ll_skin:
                showAlertDialog(R.array.skin, R.id.ll_skin);
                break;
            case R.id.ll_give:
                showAlertDialog(R.array.give, R.id.ll_give);
                break;

        }
    }

    public void showAlertDialog(final int array, final int type) {
        AlertDialog.Builder builder = new AlertDialog.Builder(PatrolActivity.this);
        //定义对话框内容
        builder.setTitle("请选择内容");
        //选择点击对话框内的内容时的监听事件
        builder.setItems(array, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String[] aryShop = getResources().getStringArray(array);
                switch (type) {
                    case R.id.ll_spirits:
                        tvSpirits.setText(aryShop[which]);
                        break;
                    case R.id.ll_tem:
                        tvTem.setText(aryShop[which]);
                        break;
                    case R.id.ll_infusion:
                        tvInfusion.setText(aryShop[which]);
                        break;
                    case R.id.ll_channe:
                        tvChanne.setText(aryShop[which]);
                        break;
                    case R.id.ll_skin:
                        tvSkin.setText(aryShop[which]);
                        break;
                    case R.id.ll_give:
                        tvGive.setText(aryShop[which]);
                        break;
                }
            }
        });
        //定义父对话框中的点击事件
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //销毁父对话框对象，回到主页
                dialog.dismiss();
            }
        });
        builder.show();
    }

}
