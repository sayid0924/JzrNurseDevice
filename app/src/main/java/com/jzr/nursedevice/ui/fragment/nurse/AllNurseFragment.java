package com.jzr.nursedevice.ui.fragment.nurse;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.jzr.nursedevice.R;
import com.jzr.nursedevice.base.BaseFragment;
import com.jzr.nursedevice.base.Constant;
import com.jzr.nursedevice.bean.NurseBean;
import com.jzr.nursedevice.ui.apadter.NurseApadter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class AllNurseFragment extends BaseFragment {


    private static AllNurseFragment allNurseFragment;
    private NurseApadter apadter;

    private List<NurseBean> data = new ArrayList<>();

    @BindView(R.id.rv_nurse)
    RecyclerView rvNurse;

    public static AllNurseFragment newInstance() {
        allNurseFragment = new AllNurseFragment();
        return allNurseFragment;
    }


    @Override
    public void loadData() {
        setState(Constant.STATE_SUCCESS);
    }

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_all_nurse;
    }

    @Override
    public void attachView() {

    }

    @Override
    protected void initView(Bundle bundle) {

        data.add(new NurseBean("06:00","刘四媛(098170)","生命体征"));
        data.add(new NurseBean("08:00","骆宇轩(098171)","生命体征"));
        data.add(new NurseBean("09:00","彭晓慧(098172)","病房巡视"));
        data.add(new NurseBean("10:00","叶觉英(098173)","病房巡视"));
        data.add(new NurseBean("15:00","钟雯清(098174)","护士护理"));
        data.add(new NurseBean("17:00","  高婵  (098175)","护士护理"));
        data.add(new NurseBean("18:00","周慧欢(098176)","医嘱执行"));
        data.add(new NurseBean("20:00","文杏环(098177)","医嘱执行"));
        data.add(new NurseBean("21:00","何玉玲(098178)","生命体征"));
        data.add(new NurseBean("22:00","李水珍(098179)","生命体征"));

        apadter = new NurseApadter(data, getSupportActivity());
        rvNurse.setLayoutManager(new LinearLayoutManager(getSupportActivity()));
        rvNurse.setAdapter(apadter);



    }
}
