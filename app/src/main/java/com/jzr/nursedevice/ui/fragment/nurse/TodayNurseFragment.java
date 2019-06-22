package com.jzr.nursedevice.ui.fragment.nurse;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;

import com.flyco.tablayout.SegmentTabLayout;
import com.flyco.tablayout.SlidingTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.jzr.nursedevice.R;
import com.jzr.nursedevice.base.BaseFragment;
import com.jzr.nursedevice.base.BaseFragmentPageAdapter;
import com.jzr.nursedevice.base.Constant;
import com.jzr.nursedevice.ui.fragment.MessagesInfoFragment;
import com.jzr.nursedevice.ui.fragment.NurseInfoFragment;
import com.jzr.nursedevice.ui.fragment.PatientInfoFragment;
import com.jzr.nursedevice.ui.fragment.doctoraction.EndActionFragment;
import com.jzr.nursedevice.ui.fragment.doctoraction.NoActionFragment;
import com.jzr.nursedevice.ui.fragment.patient.AllActionFragment;

import java.util.ArrayList;

import butterknife.BindView;

public class TodayNurseFragment extends BaseFragment {

    private static TodayNurseFragment todayNurseFragment;

    private ArrayList<String> mTitleList = new ArrayList<>();
    private ArrayList<Fragment> mFragments = new ArrayList<>();

    private BaseFragmentPageAdapter myAdapter;

    private String[] mTitles = {"全部护理", "医嘱执行","生命体征"};
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();

   @BindView(R.id.tab_layout)
   SegmentTabLayout tabLayout;

   @BindView(R.id.vp)
   ViewPager vp;

    public static TodayNurseFragment newInstance() {
        todayNurseFragment = new TodayNurseFragment();
        return todayNurseFragment;
    }

    @Override
    public void loadData() {
        setState(Constant.STATE_SUCCESS);
    }

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_today_nurse;
    }

    @Override
    public void attachView() {

    }

    @Override
    protected void initView(Bundle bundle) {

        mFragments.add(AllNurseFragment.newInstance());
        mFragments.add(AllNurseFragment.newInstance());
        mFragments.add(AllNurseFragment.newInstance());

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
}
