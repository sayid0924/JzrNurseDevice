package com.jzr.nursedevice.ui.apadter;

import android.content.Context;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jzr.nursedevice.R;
import com.jzr.nursedevice.bean.NurseBean;
import com.jzr.nursedevice.bean.PatientInfoBean;

import java.util.List;

public class NurseApadter extends BaseQuickAdapter<NurseBean, BaseViewHolder> {

    private Context mContext;
    private List<NurseBean> data;
    private onItemClick onItemClick;

    public NurseApadter(List<NurseBean> data, Context mContext) {
        super(R.layout.item_nurse, data);
        this.mContext = mContext;
        this.data = data;
    }

    @Override
    protected void convert(final BaseViewHolder helper, final NurseBean item) {
        helper.setText(R.id.tv_date, item.getDate());
        helper.setText(R.id.tv_name, item.getName());
        helper.setText(R.id.tv_type, item.getType());
    }

    public interface onItemClick {
        void onItemClick(PatientInfoBean.DataBean item);
    }

    public void onItemClick(onItemClick onItemClick) {
        this.onItemClick = onItemClick;
    }

}
