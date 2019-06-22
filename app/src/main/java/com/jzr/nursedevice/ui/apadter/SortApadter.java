package com.jzr.nursedevice.ui.apadter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jzr.nursedevice.R;
import com.jzr.nursedevice.bean.PatientInfoBean;

import java.util.List;

public class SortApadter extends BaseQuickAdapter<PatientInfoBean.DataBean, BaseViewHolder> {

    private Context mContext;
    private List<PatientInfoBean.DataBean> data;
    private onItemClick onItemClick;
     private int checkedPosition;

    public SortApadter(List<PatientInfoBean.DataBean> data, Context mContext) {
        super(R.layout.item_sort_list, data);
        this.mContext = mContext;
        this.data = data;
    }

    @Override
    protected void convert(final BaseViewHolder helper, final PatientInfoBean.DataBean item) {

        LinearLayout linearLayout = helper.getView(R.id.linear_layout);
        TextView tvSort = helper.getView(R.id.tv_sort);
        TextView tvBedNo = helper.getView(R.id.tv_bed_no);

        tvSort.setText(item.getName());
        tvBedNo.setText(item.getBedName()+"床");

        if (helper.getLayoutPosition() == checkedPosition) {
            linearLayout.setBackgroundColor(Color.parseColor("#f3f3f3"));
            tvSort.setTextColor(Color.parseColor("#0068cf"));
            tvBedNo.setTextColor(Color.parseColor("#0068cf"));
        } else {
            linearLayout.setBackgroundColor(Color.parseColor("#FFFFFF"));
            tvSort.setTextColor(Color.parseColor("#1e1d1d"));
            tvBedNo.setTextColor(Color.parseColor("#1e1d1d"));
        }

        helper.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onItemClick != null)
                    onItemClick.onItemClick(item,helper.getLayoutPosition());
            }
        });
    }

    public void setCheckedPosition(int checkedPosition) {
        this.checkedPosition = checkedPosition;
        notifyDataSetChanged();
    }

    public  interface onItemClick {
        void onItemClick(PatientInfoBean.DataBean item, int checkedPosition);
    }

    public  void  onItemClick(onItemClick onItemClick){
        this.onItemClick = onItemClick;
    }
}
