package com.jzr.nursedevice.ui.activity.patientdiaolog;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blankj.utilcode.utils.EmptyUtils;
import com.blankj.utilcode.utils.ToastUtils;
import com.google.gson.Gson;
import com.jzr.nursedevice.R;
import com.jzr.nursedevice.base.BaseActivity;
import com.jzr.nursedevice.bean.CodeDataOfInfusionBean;
import com.jzr.nursedevice.bean.PatientInfoBean;
import com.jzr.nursedevice.bean.ionew.IonewGetdevlistBean;
import com.jzr.nursedevice.bean.ionew.boby.IonewBindingBoby;
import com.jzr.nursedevice.bean.ionew.boby.IonewGetdevlistBoby;
import com.jzr.nursedevice.presenter.contract.activity.InfusionContract;
import com.jzr.nursedevice.presenter.impl.activity.infusionActivityPresenter;
import com.jzr.nursedevice.utils.PreferUtil;

import org.greenrobot.eventbus.Subscribe;

import butterknife.BindView;
import butterknife.OnClick;

public class InfusionActivity extends BaseActivity implements InfusionContract.View {

    private infusionActivityPresenter presenter = new infusionActivityPresenter();
    private PatientInfoBean.DataBean item;
    private String codeData;

    @BindView(R.id.rl_back)
    RelativeLayout rlBack;
    @BindView(R.id.actionbar_title)
    TextView actionbarTitle;
    @BindView(R.id.left_title)
    TextView leftTitle;

    @BindView(R.id.tv_bed_no)
    TextView tvBedNo;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_device_mac)
    TextView tvDeviceMac;
    @BindView(R.id.bt_register)
    TextView btRegister;


    @Override
    public int getLayoutId() {
        return R.layout.activity_infusion;
    }

    @Override
    public void attachView() {
        presenter.attachView(this);
    }

    @Override
    public void detachView() {

    }

    @Override
    public void initView() {

        String pData = getIntent().getStringExtra("data");
        item = new Gson().fromJson(pData, PatientInfoBean.DataBean.class);

        actionbarTitle.setText(item.getName() + "  " + item.getBedName() + " " + item.getCureNo());
        leftTitle.setText("输液仪");

        tvBedNo.setText(item.getBedName());
        tvName.setText(item.getName());

        IonewGetdevlistBoby ionewGetdevlistBoby = new IonewGetdevlistBoby();
        ionewGetdevlistBoby.setHaveFreeDev(1);
        presenter.FetchIonewGetdevlist(ionewGetdevlistBoby);
        showWaitingDialog("正在加载中....");

    }

    @Subscribe
    public void getEventBus(CodeDataOfInfusionBean codeDataOfInfusionBean) {
        codeData = codeDataOfInfusionBean.getCodeData();
        tvDeviceMac.setText(codeData);
    }

    @OnClick({R.id.rl_back, R.id.bt_register})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_back:
                finish();
                break;
            case R.id.bt_register:

                if (EmptyUtils.isNotEmpty(codeData)) {

                    IonewBindingBoby ionewBindingBoby = new IonewBindingBoby();
                    ionewBindingBoby.setMac(codeData);
                    ionewBindingBoby.setUserName(PreferUtil.getInstance().getUserName());
                    ionewBindingBoby.setSeatBedDeviceID(0);
                    ionewBindingBoby.setSeatBedID(item.getId());
                    presenter.FetchIonewBinding(ionewBindingBoby);
                    showWaitingDialog("正在绑定中....");

                } else {
                    ToastUtils.showLongToast("请先扫描输液仪二维码");
                }

                break;

        }
    }

    @Override
    public void FetchIonewBindingSuccess() {
        hideWaitingDialog();
        ToastUtils.showLongToast("绑定成功");
    }

    @Override
    public void FetchIonewGetdevlistSuccess(IonewGetdevlistBean ionewGetdevlistBean) {
        hideWaitingDialog();
    }

    @Override
    public void showError(String message) {
        hideWaitingDialog();
        ToastUtils.showLongToast(message);
    }

}
