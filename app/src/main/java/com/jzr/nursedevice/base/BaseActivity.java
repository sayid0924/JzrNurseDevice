package com.jzr.nursedevice.base;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.jaeger.library.StatusBarUtil;
import com.jzr.nursedevice.R;
import com.jzr.nursedevice.bean.EventBusBean;
import com.jzr.nursedevice.ui.activity.VoipRingingActivity;
import com.jzr.nursedevice.utils.AEvent;
import com.jzr.nursedevice.utils.IEventListener;
import com.jzr.nursedevice.view.SwipeBackActivity.SwipeBackActivity;
import com.jzr.nursedevice.view.SwipeBackActivity.SwipeBackLayout;
import com.jzr.nursedevice.view.dialog.CustomDialog;
import com.orhanobut.logger.Logger;
import com.starrtc.starrtcsdk.api.XHClient;
import com.starrtc.starrtcsdk.core.im.message.XHIMMessage;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.LinkedList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity extends SwipeBackActivity  implements IEventListener {

    public final static List<AppCompatActivity> mActivities = new LinkedList<>();
    private SwipeBackLayout mSwipeBackLayout;
    private Unbinder bind;
    private CustomDialog mDialogWaiting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//竖屏
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        setContentView(getLayoutId());

        bind = ButterKnife.bind(this);
        //沉浸式状态栏
        StatusBarUtil.setColor(this, getResources().getColor(R.color.color_44A4E4), 10);
        attachView();
        initView();
        EventBus.getDefault().register(this);

        synchronized (mActivities) {
            mActivities.add(this);
        }
    }

    @Subscribe
    public void getEventBus(EventBusBean eventBusBean) {

    }

    public void killAll() {
        // 复制了一份mActivities 集合
        List<AppCompatActivity> copy;
        synchronized (mActivities) {
            copy = new LinkedList<>(mActivities);
        }
        for (AppCompatActivity activity : copy) {
            activity.finish();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
            addListener();
    }

    public void onPause() {
        super.onPause();
        removeListener();
    }

    @Override
    public void dispatchEvent(String aEventID, boolean success, final Object eventObj) {
        switch (aEventID){
            case AEvent.AEVENT_VOIP_REV_CALLING:
                Logger.e(AEvent.AEVENT_VOIP_REV_CALLING);

                Intent intent = new Intent(BaseActivity.this,VoipRingingActivity.class);
                intent.putExtra("targetId",eventObj.toString());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK );
                startActivity(intent);

                break;
            case AEvent.AEVENT_VOIP_P2P_REV_CALLING:
                Logger.e(AEvent.AEVENT_VOIP_P2P_REV_CALLING);
                break;
            case AEvent.AEVENT_C2C_REV_MSG:
                Logger.e(AEvent.AEVENT_C2C_REV_MSG);
                break;
            case AEvent.AEVENT_GROUP_REV_MSG:
                Logger.e(AEvent.AEVENT_GROUP_REV_MSG);
                break;
            case AEvent.AEVENT_USER_OFFLINE:
                Logger.e(AEvent.AEVENT_USER_OFFLINE);
                break;
            case AEvent.AEVENT_USER_ONLINE:
                Logger.e(AEvent.AEVENT_USER_ONLINE);
                break;
        }
    }

    private void addListener(){
        AEvent.addListener(AEvent.AEVENT_VOIP_REV_CALLING,this);
        AEvent.addListener(AEvent.AEVENT_VOIP_P2P_REV_CALLING,this);
        AEvent.addListener(AEvent.AEVENT_C2C_REV_MSG,this);
        AEvent.addListener(AEvent.AEVENT_GROUP_REV_MSG,this);
        AEvent.addListener(AEvent.AEVENT_USER_ONLINE,this);
        AEvent.addListener(AEvent.AEVENT_USER_OFFLINE,this);
    }
    private void removeListener(){
        AEvent.removeListener(AEvent.AEVENT_VOIP_REV_CALLING,this);
        AEvent.removeListener(AEvent.AEVENT_VOIP_P2P_REV_CALLING,this);
        AEvent.removeListener(AEvent.AEVENT_C2C_REV_MSG,this);
        AEvent.removeListener(AEvent.AEVENT_GROUP_REV_MSG,this);
        AEvent.removeListener(AEvent.AEVENT_USER_ONLINE,this);
        AEvent.removeListener(AEvent.AEVENT_USER_OFFLINE,this);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        return super.dispatchTouchEvent(event);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        synchronized (mActivities) {
            mActivities.remove(this);
        }
        if (bind != null)
            bind.unbind();
//        if (secnnerReceiver != null)
//            unregisterReceiver(secnnerReceiver);
        detachView();
    }

    @SuppressWarnings("deprecation")
    public void initSwipeBackLayout() {
        mSwipeBackLayout = getSwipeBackLayout();
        mSwipeBackLayout.setEdgeTrackingEnabled(SwipeBackLayout.EDGE_LEFT);
    }

    public void setEdgeTrackingEnabled(int size, int position) {
        if (size == 0) {
        }
        // 只有一个fragment  - 左右滑关闭
        else if (size == 1 && position == 0) {
            mSwipeBackLayout.setEdgeTrackingEnabled(SwipeBackLayout.EDGE_ALL);
        }
        // 多个fragment  - 位于左侧尽头 - 只可左滑关闭
        else if (size != 1 && position == 0) {
            mSwipeBackLayout.setEdgeTrackingEnabled(SwipeBackLayout.EDGE_LEFT);
        }
        // 多个fragment  - 位于右侧尽头 - 只可右滑关闭
        else if (size != 1 && position == size - 1) {
            mSwipeBackLayout.setEdgeTrackingEnabled(SwipeBackLayout.EDGE_RIGHT);
        }
        // 多个fragment  - 位于中间 - 屏蔽所有左右滑关闭事件
        else {
            mSwipeBackLayout.setEdgeTrackingEnabled(0);
        }
    }

    protected void finishActivity() {
        overridePendingTransition(R.anim.slide_right_in, R.anim.slide_right_out);
    }

    public void startActivityIn(Intent intent, Activity curAct) {
        if (intent != null) {
            curAct.startActivity(intent);
            curAct.overridePendingTransition(R.anim.slide_left_in, R.anim.slide_left_out);
        }
    }

    @Override
    public void finish() {
        super.finish();
        finishActivity();
    }

    /**
     * 显示等待提示框
     */
    public Dialog showWaitingDialog(String tip) {
        hideWaitingDialog();
        View view = View.inflate(this, R.layout.dialog_waiting, null);
        if (!TextUtils.isEmpty(tip))
            ((TextView) view.findViewById(R.id.tvTip)).setText(tip);
        mDialogWaiting = new CustomDialog(this, view, R.style.MyDialog);
        mDialogWaiting.show();
        mDialogWaiting.setCancelable(true);
        return mDialogWaiting;
    }

    /**
     * 隐藏等待提示框
     */
    public void hideWaitingDialog() {
        if (mDialogWaiting != null) {
            mDialogWaiting.dismiss();
            mDialogWaiting = null;
        }
    }

    public abstract int getLayoutId();

    public abstract void attachView();

    public abstract void detachView();

    public abstract void initView();



}
