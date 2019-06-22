package com.jzr.nursedevice.ui.fragment.patient;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.flyco.tablayout.SegmentTabLayout;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.jzr.nursedevice.R;
import com.jzr.nursedevice.base.BaseFragment;
import com.jzr.nursedevice.base.BaseFragmentPageAdapter;
import com.jzr.nursedevice.base.Constant;
import com.jzr.nursedevice.bean.PatientInfoBean;
import com.jzr.nursedevice.ui.fragment.doctoraction.EndActionFragment;
import com.jzr.nursedevice.ui.fragment.doctoraction.NoActionFragment;
import com.jzr.nursedevice.ui.fragment.doctoraction.TodayActionFragment;

import java.util.ArrayList;

import butterknife.BindView;

public class ShortActionFragment extends BaseFragment {
    public static ShortActionFragment shortActionFragment;
    private  PatientInfoBean.DataBean data ;

    public static ShortActionFragment newInstance(PatientInfoBean.DataBean data) {
        shortActionFragment = new ShortActionFragment();
        shortActionFragment.data = data;
        return shortActionFragment;
    }

    private String[] mTitles = {"未执行", "已执行","今日医嘱"};
    private BaseFragmentPageAdapter myAdapter;
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private ArrayList<String> mTitleList = new ArrayList<>();

    @BindView(R.id.tab_layout)
    SegmentTabLayout tabLayout;

    @BindView(R.id.vp)
    ViewPager vp;


    @Override
    public void loadData() {
        setState(Constant.STATE_SUCCESS);
    }

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_long_action;
    }

    @Override
    public void attachView() {

    }

    @Override
    protected void initView(Bundle bundle) {

        mFragments.add(NoActionFragment.newInstance(data,2));
        mFragments.add(EndActionFragment.newInstance(data,2));
        mFragments.add(TodayActionFragment.newInstance(data,2));

        myAdapter = new BaseFragmentPageAdapter(getChildFragmentManager(), mFragments, mTitleList);
        vp.setAdapter(myAdapter);
        tabLayout.setTabData(mTitles);

        tabLayout.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                vp.setCurrentItem(position);
            }

            @Override
            public void onTabReselect(int position) {

            }
        });

        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                tabLayout.setCurrentTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }


    public  void RefreshData(){
        NoActionFragment.noActionFragment.RefreshData();
        EndActionFragment.endActionFragment.RefreshData();
    }




}
