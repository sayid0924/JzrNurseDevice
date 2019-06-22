package com.jzr.nursedevice.ui.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.Toast;

import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.google.gson.Gson;
import com.jzr.nursedevice.R;
import com.jzr.nursedevice.base.BaseActivity;
import com.jzr.nursedevice.base.BaseFragmentPageAdapter;
import com.jzr.nursedevice.bean.CodeDataOfHomeBean;
import com.jzr.nursedevice.bean.PatientInfoBean;
import com.jzr.nursedevice.bean.TabEntity;
import com.jzr.nursedevice.db.database.PatientBeanDbDao;
import com.jzr.nursedevice.db.entity.PatientBeanDb;
import com.jzr.nursedevice.service.KeepLiveService;
import com.jzr.nursedevice.service.nettyUtils.NettyService;
import com.jzr.nursedevice.ui.activity.patientdiaolog.PatientDialogActivity;
import com.jzr.nursedevice.ui.fragment.MessagesInfoFragment;
import com.jzr.nursedevice.ui.fragment.NurseInfoFragment;
import com.jzr.nursedevice.ui.fragment.PatientInfoFragment;
import com.jzr.nursedevice.ui.fragment.SettingFragment;
import com.jzr.nursedevice.utils.CommonUtil;
import com.jzr.nursedevice.utils.GreenDaoUtil;
import com.jzr.nursedevice.utils.listener.DemoBeautyCallback;
import com.jzr.nursedevice.utils.listener.XHChatManagerListener;
import com.jzr.nursedevice.utils.listener.XHGroupManagerListener;
import com.jzr.nursedevice.utils.listener.XHLoginManagerListener;
import com.jzr.nursedevice.utils.listener.XHVoipManagerListener;
import com.jzr.nursedevice.utils.listener.XHVoipP2PManagerListener;
import com.orhanobut.logger.Logger;
import com.starrtc.starrtcsdk.api.XHClient;
import com.starrtc.starrtcsdk.api.XHCustomConfig;
import com.starrtc.starrtcsdk.apiInterface.IXHErrorCallback;
import com.starrtc.starrtcsdk.apiInterface.IXHResultCallback;
import com.starrtc.starrtcsdk.core.beauty.XHBeautyManager;

import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class HomeActivity extends BaseActivity {

    private BaseFragmentPageAdapter myAdapter;
    private ArrayList<String> mTitleList = new ArrayList<>();
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    public static HomeActivity homeActivity;

    private long exitTime;

    private PatientBeanDbDao collectionInfoDao;

    private String[] mTitles = {"患者", "护理", "消息", "更多"};
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();

    private int[] mIconUnselectIds = {
            R.drawable.icon_nurse, R.drawable.icon_patient,
            R.drawable.icon_message, R.drawable.icon_move};

    private int[] mIconSelectIds = {
            R.drawable.icon_nurse_n, R.drawable.icon_patient_n,
            R.drawable.icon_message_n_, R.drawable.icon_move_n};

    @BindView(R.id.tab_layout)
    CommonTabLayout tabLayout;

    @BindView(R.id.vp)
    ViewPager vp;


    @Override
    public int getLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    public void attachView() {

    }

    @Override
    public void detachView() {

    }

    @Override
    public void initView() {
        setSwipeBackEnable(false);
        mFragments.add(PatientInfoFragment.newInstance());
        mFragments.add(NurseInfoFragment.newInstance());
        mFragments.add(MessagesInfoFragment.newInstance());
        mFragments.add(SettingFragment.newInstance());
        homeActivity = this;
        myAdapter = new BaseFragmentPageAdapter(getSupportFragmentManager(), mFragments, mTitleList);
        vp.setAdapter(myAdapter);

        for (int i = 0; i < mTitles.length; i++) {
            mTabEntities.add(new TabEntity(mTitles[i], mIconSelectIds[i], mIconUnselectIds[i]));
        }

        tabLayout.setTabData(mTabEntities);
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

        startService();
        startService(new Intent(this, NettyService.class));

    }

    private void startService(){
        Intent intent = new Intent(this, KeepLiveService.class);
        startService(intent);
    }

    @Subscribe
    public void getEventBus(CodeDataOfHomeBean codeDataOfHomeBean) {
        String codeData = codeDataOfHomeBean.getCodeData();
        collectionInfoDao = GreenDaoUtil.getDaoSession().getPatientBeanDbDao();
        PatientBeanDb infoBeanDb = collectionInfoDao.queryBuilder().where(PatientBeanDbDao.Properties.Id.eq(0)).unique();
        if (infoBeanDb != null) {
            PatientInfoBean patientBean = infoBeanDb.getPatientBean();
            List<PatientInfoBean.DataBean> data = patientBean.getData();
            String[] patientData = codeData.split(":");
            String patientNo = patientData[1];
            for (int i = 0; i < data.size(); i++) {
                String cureno= data.get(i).getCureNo();
                if (patientNo.equals(cureno)) {
                    Intent pIntent = new Intent(HomeActivity.this, PatientDialogActivity.class);
                    pIntent.putExtra("data", new Gson().toJson(data.get(i)));
                    startActivityIn(pIntent, HomeActivity.this);
                }
            }
        }
    }

    @Override
    public void onBackPressed() {
        if ((System.currentTimeMillis() - exitTime) > 2000) {
            Toast.makeText(getApplicationContext(), "再按一次退出程序",
                    Toast.LENGTH_SHORT).show();
            exitTime = System.currentTimeMillis();
        } else {
            finish();
            System.exit(0);
        }
    }

}
