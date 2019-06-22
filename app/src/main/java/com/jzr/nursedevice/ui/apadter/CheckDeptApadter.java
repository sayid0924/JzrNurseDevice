package com.jzr.nursedevice.ui.apadter;

import android.content.Context;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import com.jzr.nursedevice.R;
import com.jzr.nursedevice.bean.CheckDeptBean;
import com.jzr.nursedevice.bean.DeptListBean;
import com.jzr.nursedevice.bean.DeptListBean.DataBean;


import java.util.List;

public class CheckDeptApadter extends BaseQuickAdapter<DeptListBean.DataBean, BaseViewHolder> {

    private Context mContext;
    private List<DeptListBean.DataBean> data;
    private  onItemClick onItemClick;

    public CheckDeptApadter(List<DeptListBean.DataBean> data, Context mContext) {
        super(R.layout.item_check_dept, data);
        this.mContext = mContext;
        this.data = data;
    }

    @Override
    protected void convert(final BaseViewHolder helper, final DeptListBean.DataBean item) {

        helper.setText(R.id.tv_deptname,item.getName());
        helper.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(onItemClick!=null)
                    onItemClick.onItemClick(item);
            }
        });
    }


    public  interface onItemClick {
        void onItemClick(DeptListBean.DataBean  item);

    }
    public  void  onItemClick(onItemClick onItemClick){
        this.onItemClick = onItemClick;
    }

}
