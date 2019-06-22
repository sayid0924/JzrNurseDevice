package com.jzr.nursedevice.ui.apadter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jzr.nursedevice.R;
import com.jzr.nursedevice.bean.DoctorActionBean;
import com.jzr.nursedevice.bean.PatientInfoBean;

import java.util.List;

public class DoctorActionApadter extends BaseQuickAdapter<DoctorActionBean.DataBean, BaseViewHolder> {

    private Context mContext;
    private List<DoctorActionBean.DataBean> data;
    private onItemClick onItemClick;


    public DoctorActionApadter(List<DoctorActionBean.DataBean> data, Context mContext ) {
        super(R.layout.item_doctor_action, data);
        this.mContext = mContext;
        this.data = data;
    }

    @Override
    protected void convert(final BaseViewHolder helper, final DoctorActionBean.DataBean item) {

        helper.setText(R.id.tv_order_name,item.getOrderName() + " " + item.getStandards() );
        helper.setText(R.id.tv_use_date,item.getUseDate());
        //   医嘱类型: 0=临嘱, 1=长嘱
        String orderType;
        if(item.getOrderType()==0){
            orderType ="临嘱";
        }else {
            orderType ="长嘱";
        }
        helper.setText(R.id.tv_order_type,orderType);
        helper.setText(R.id.tv_drug_way,item.getDrugWay());

        if (item.getIsExec() == 0) {  // 是否已經執行過
           helper.setText(R.id.tv_is_exec,"未执行");
        } else {
            helper.setText(R.id.tv_is_exec,"已执行");
        }

        helper.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(onItemClick!=null){
                    onItemClick.onItemClick(item);
                }
            }
        });

    }

    public interface onItemClick {
        void onItemClick(DoctorActionBean.DataBean item);
    }

    public void onItemClick(onItemClick onItemClick) {
        this.onItemClick = onItemClick;
    }

}
