package com.jzr.nursedevice.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.flyco.tablayout.SegmentTabLayout;
import com.flyco.tablayout.SlidingTabLayout;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.jzr.nursedevice.R;
import com.jzr.nursedevice.base.BaseFragment;
import com.jzr.nursedevice.base.BaseFragmentPageAdapter;
import com.jzr.nursedevice.base.Constant;
import com.jzr.nursedevice.ui.fragment.doctoraction.EndActionFragment;
import com.jzr.nursedevice.ui.fragment.doctoraction.NoActionFragment;
import com.jzr.nursedevice.ui.fragment.doctoraction.TodayActionFragment;
import com.jzr.nursedevice.ui.fragment.nurse.NurseRecordFragment;
import com.jzr.nursedevice.ui.fragment.nurse.TodayNurseFragment;
import com.jzr.nursedevice.ui.fragment.patient.LongActionFragment;

import java.util.ArrayList;

import butterknife.BindView;

public class NurseInfoFragment extends BaseFragment {

    private static NurseInfoFragment nurseInfoFragment;

    private BaseFragmentPageAdapter myAdapter;
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private ArrayList<String> mTitleList = new ArrayList<>();

    @BindView(R.id.tab_layout)
    SlidingTabLayout tabLayout;

    @BindView(R.id.vp)
    ViewPager vp;

    public static NurseInfoFragment newInstance() {
        nurseInfoFragment = new NurseInfoFragment();
        return nurseInfoFragment;
    }

    @Override
    public void loadData() {
        setState(Constant.STATE_SUCCESS);
    }

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_nurseinfo;
    }

    @Override
    public void attachView() {

    }

    @Override
    protected void initView(Bundle bundle) {

        mTitleList.add("今日护理");
        mTitleList.add("护理记录");

        mFragments.add(TodayNurseFragment.newInstance());
        mFragments.add(NurseRecordFragment.newInstance());

        myAdapter = new BaseFragmentPageAdapter(getChildFragmentManager(), mFragments, mTitleList);
        vp.setAdapter(myAdapter);
          tabLayout.setViewPager(vp);

    }
}
