package com.jzr.nursedevice.ui.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.blankj.utilcode.utils.ToastUtils;
import com.jzr.nursedevice.R;
import com.jzr.nursedevice.base.BaseActivity;
import com.jzr.nursedevice.bean.CheckDeptBean;
import com.jzr.nursedevice.bean.DeptListBean;
import com.jzr.nursedevice.presenter.contract.activity.CheckDeptContract;
import com.jzr.nursedevice.presenter.impl.activity.CheckDeptActivityPresenter;
import com.jzr.nursedevice.ui.apadter.CheckDeptApadter;
import com.jzr.nursedevice.utils.JsonUtils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class CheckDeptActivity extends BaseActivity implements CheckDeptContract.View {


    private CheckDeptActivityPresenter presenter = new CheckDeptActivityPresenter();

    private CheckDeptApadter apadter;
    private CheckDeptBean checkDeptBean;

    private List<DeptListBean.DataBean> dataBean = new ArrayList<>();

    @BindView(R.id.rv_dept)
    RecyclerView rvDept;
    @BindView(R.id.actionbar_title)
    TextView actionbarTitle;
    @BindView(R.id.rl_back)
    RelativeLayout rlBack;


    @Override
    public int getLayoutId() {
        return R.layout.activity_check_dept;
    }

    @Override
    public void attachView() {
        presenter.attachView(this);
    }

    @Override
    public void detachView() {
        presenter.detachView();
    }

    @Override
    public void initView() {

        actionbarTitle.setText("请选择科室");
        String userCode = getIntent().getStringExtra("userCode");
        presenter.FetchDeptList("userCode", userCode);
        showWaitingDialog("正在加载中.....");
//     checkDeptBean = JsonUtils.getDeptJson(this);

        apadter = new CheckDeptApadter(dataBean, this);
        rvDept.setLayoutManager(new LinearLayoutManager(this));
        rvDept.setAdapter(apadter);

        apadter.onItemClick(new CheckDeptApadter.onItemClick() {
            @Override
            public void onItemClick(DeptListBean.DataBean item) {
                EventBus.getDefault().post(item);
                finish();
            }
        });
    }

    @OnClick({R.id.rl_back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_back:
                finish();
                break;
        }
    }

    @Subscribe
    public void onEvent(DeptListBean.DataBean item) {

    }


    //  获取科室列表成功
    @Override
    public void FetchDeptListSuccess(DeptListBean data) {
        hideWaitingDialog();
        apadter.setNewData(data.getData());
        apadter.notifyDataSetChanged();
    }

    @Override
    public void showError(String message) {
        hideWaitingDialog();
        ToastUtils.showLongToast(message);
    }
}
