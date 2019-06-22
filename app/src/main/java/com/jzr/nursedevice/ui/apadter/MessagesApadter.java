package com.jzr.nursedevice.ui.apadter;

import android.content.Context;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jzr.nursedevice.R;
import com.jzr.nursedevice.bean.MessagesBean;
import com.jzr.nursedevice.bean.PatientInfoBean;

import java.util.List;

public class MessagesApadter extends BaseQuickAdapter<MessagesBean, BaseViewHolder> {

    private Context mContext;
    private List<MessagesBean> data;
    private onItemClick onItemClick;

    public MessagesApadter(List<MessagesBean> data, Context mContext) {
        super(R.layout.item_nurse, data);
        this.mContext = mContext;
        this.data = data;
    }

    @Override
    protected void convert(final BaseViewHolder helper, final MessagesBean item) {

    }

    public interface onItemClick {
        void onItemClick(PatientInfoBean.DataBean item);
    }

    public void onItemClick(onItemClick onItemClick) {
        this.onItemClick = onItemClick;
    }

}
