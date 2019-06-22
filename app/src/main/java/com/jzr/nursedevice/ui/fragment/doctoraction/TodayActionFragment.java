package com.jzr.nursedevice.ui.fragment.doctoraction;

import com.jzr.nursedevice.R;
import com.jzr.nursedevice.base.BaseFragment;
import com.jzr.nursedevice.base.Constant;
import com.jzr.nursedevice.bean.PatientInfoBean;

public class TodayActionFragment extends BaseFragment {
    private static TodayActionFragment todayActionFragment;
    private  int type;

    public static TodayActionFragment newInstance(PatientInfoBean.DataBean data, int type) {
        todayActionFragment = new TodayActionFragment();
        todayActionFragment.type = type;
        return todayActionFragment;
    }


    @Override
    public void loadData() {
        setState(Constant.STATE_SUCCESS);
    }

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_today_action;
    }

    @Override
    public void attachView() {

    }
}
