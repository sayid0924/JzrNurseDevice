package com.jzr.nursedevice.ui.activity.setting;

import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blankj.utilcode.utils.TimeUtils;
import com.jzr.nursedevice.R;
import com.jzr.nursedevice.base.BaseActivity;
import com.jzr.nursedevice.bean.PatientInfoBean;
import com.jzr.nursedevice.db.database.PatientBeanDbDao;
import com.jzr.nursedevice.db.entity.PatientBeanDb;
import com.jzr.nursedevice.ui.apadter.SortApadter;
import com.jzr.nursedevice.utils.GreenDaoUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class DeptTemActivity extends BaseActivity {


    @BindView(R.id.rl_back)
    RelativeLayout rlBack;
    @BindView(R.id.actionbar_title)
    TextView actionbarTitle;
    @BindView(R.id.left_title)
    TextView leftTitle;

    @BindView(R.id.tv_date)
    TextView tvDate;
    @BindView(R.id.tv_type)
    TextView tvType;


    @BindView(R.id.rv_sort)
    RecyclerView rvSort;


    private PatientBeanDbDao collectionInfoDao;
    private SortApadter apadter;
    private List<PatientInfoBean.DataBean> data;
    private PatientInfoBean patientBean;

    private LinearLayoutManager mLinearLayoutManager;


    @Override
    public int getLayoutId() {
        return R.layout.activity_dept_tem;
    }

    @Override
    public void attachView() {

    }

    @Override
    public void detachView() {

    }

    @Override
    public void initView() {
        leftTitle.setText("全科体温");

        tvDate.setText(TimeUtils.getNowTimeString());
        tvType.setText("口温");

        collectionInfoDao = GreenDaoUtil.getDaoSession().getPatientBeanDbDao();
        PatientBeanDb infoBeanDb = collectionInfoDao.queryBuilder().where(
                PatientBeanDbDao.Properties.Id.eq(0)).unique();
        if (infoBeanDb != null) {
            patientBean = infoBeanDb.getPatientBean();
            data = patientBean.getData();
            actionbarTitle.setText(data.get(0).getName() + data.get(0).getBedName()+"床" +data.get(0).getCureNo());
        }

        apadter = new SortApadter(data, this);
        mLinearLayoutManager = new LinearLayoutManager(this);
        rvSort.setLayoutManager(mLinearLayoutManager);
        rvSort.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        rvSort.setAdapter(apadter);
        apadter.onItemClick(new SortApadter.onItemClick() {
            @Override
            public void onItemClick(PatientInfoBean.DataBean item, int checkedPosition) {
                apadter.setCheckedPosition(checkedPosition);
                actionbarTitle.setText(item.getName() +item.getBedName()+"床" +item.getCureNo());
                moveToCenter(checkedPosition);
            }
        });

    }

    //将当前选中的item居中
    private void moveToCenter(int position) {
        //将点击的position转换为当前屏幕上可见的item的位置以便于计算距离顶部的高度，从而进行移动居中
        View childAt = rvSort.getChildAt(position - mLinearLayoutManager.findFirstVisibleItemPosition());
        if (childAt != null) {
            int y = (childAt.getTop() - rvSort.getHeight() / 2);
            rvSort.smoothScrollBy(0, y);
        }
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
