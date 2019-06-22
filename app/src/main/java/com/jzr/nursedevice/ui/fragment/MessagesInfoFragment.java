package com.jzr.nursedevice.ui.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.webkit.WebView;

import com.jzr.nursedevice.R;
import com.jzr.nursedevice.base.BaseFragment;
import com.jzr.nursedevice.base.Constant;
import com.jzr.nursedevice.bean.MessagesBean;
import com.jzr.nursedevice.ui.apadter.MessagesApadter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MessagesInfoFragment extends BaseFragment {

    private static MessagesInfoFragment messagesInfoFragment;

    private MessagesApadter apadter;

    private List<MessagesBean> data= new ArrayList<>();

    @BindView(R.id.rv_messages)
    RecyclerView rvMessages;

    public static MessagesInfoFragment newInstance() {
        messagesInfoFragment = new MessagesInfoFragment();
        return messagesInfoFragment;
    }


    @Override
    public void loadData() {
        setState(Constant.STATE_SUCCESS);
    }

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_messagesinfo;
    }

    @Override
    public void attachView() {

    }

    @Override
    protected void initView(Bundle bundle) {

        apadter = new MessagesApadter(data,getSupportActivity());
        rvMessages.setLayoutManager(new LinearLayoutManager(getSupportActivity()));
        rvMessages.setAdapter(apadter);


    }
}
