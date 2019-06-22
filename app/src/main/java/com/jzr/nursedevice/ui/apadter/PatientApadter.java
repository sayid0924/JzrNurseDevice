package com.jzr.nursedevice.ui.apadter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jzr.nursedevice.R;
import com.jzr.nursedevice.bean.PatientInfoBean;
import com.jzr.nursedevice.utils.CommonUtil;

import java.util.List;

public class PatientApadter extends BaseQuickAdapter<PatientInfoBean.DataBean, BaseViewHolder> {

    private Context mContext;
    private List<PatientInfoBean.DataBean> data;
    private onItemClick onItemClick;

    public PatientApadter(List<PatientInfoBean.DataBean> data, Context mContext) {
        super(R.layout.item_patient, data);
        this.mContext = mContext;
        this.data = data;
    }

    @Override
    protected void convert(final BaseViewHolder helper, final PatientInfoBean.DataBean item) {

        try {

            TextView tvLevel = helper.getView(R.id.tv_level_no);
            LinearLayout llBedNo = helper.getView(R.id.ll_bed_no);

            helper.setText(R.id.tv_deptname, CommonUtil.replaceString2Star(item.getName(), 1, 1));
            helper.setText(R.id.tv_age, item.getAge());
            helper.setText(R.id.tv_sex, item.getSexText());
            helper.setText(R.id.tv_cure_no, item.getCureNo());
            helper.setText(R.id.tv_bed_no, item.getBedName());
            helper.setText(R.id.tv_doctor_name, item.getDoctorName());
            helper.setText(R.id.tv_enjoin_info, item.getDiagnose());
            tvLevel.setText(item.getNurseLevelName());
            tvLevel.setTextColor(Color.parseColor(item.getNurseLevelBgColor()));

            GradientDrawable myGrad = (GradientDrawable) llBedNo.getBackground();
            myGrad.setColor(Color.parseColor(item.getNurseLevelBgColor()));

            helper.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (onItemClick != null)
                        onItemClick.onItemClick(item);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public interface onItemClick {
        void onItemClick(PatientInfoBean.DataBean item);
    }

    public void onItemClick(onItemClick onItemClick) {
        this.onItemClick = onItemClick;
    }

}
