package com.jzr.nursedevice.view.dialog;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.RelativeLayout;


import com.jzr.nursedevice.R;
public class KeyboardDialog extends Dialog {


    private RelativeLayout tvNum_1, tvNum_2, tvNum_3, tvNum_4, tvNum_5, tvNum_6,
            tvNum_7, tvNum_8, tvNum_9, tvNum_0, tvNum_36, tvNum_37,
            tvNum_00, tvNum_38, tvNum_39, rlDismiss, rlDel;

    private onItemClick onItemClick;
    private onDelClick onDelClick;

    public KeyboardDialog(@NonNull Context context) {
        super(context, R.style.keyboard_dialog);
        setContentView(R.layout.dialog_keyboard);

        tvNum_1 = findViewById(R.id.tv_num_1);
        tvNum_2 = findViewById(R.id.tv_num_2);
        tvNum_3 = findViewById(R.id.tv_num_3);
        tvNum_4 = findViewById(R.id.tv_num_4);
        tvNum_5 = findViewById(R.id.tv_num_5);
        tvNum_6 = findViewById(R.id.tv_num_6);
        tvNum_7 = findViewById(R.id.tv_num_7);
        tvNum_8 = findViewById(R.id.tv_num_8);
        tvNum_9 = findViewById(R.id.tv_num_9);
        tvNum_0 = findViewById(R.id.tv_num_0);
        tvNum_36 = findViewById(R.id.tv_num_36);
        tvNum_37 = findViewById(R.id.tv_num_37);
        tvNum_38 = findViewById(R.id.tv_num_38);
        tvNum_39 = findViewById(R.id.tv_num_39);
        tvNum_00 = findViewById(R.id.tv_num_00);
        rlDismiss = findViewById(R.id.rl_dismiss);
        rlDel = findViewById(R.id.rl_del);

        rlDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 if(onDelClick!=null){
                     onDelClick.onDelClick();
                 }
            }
        });

        rlDismiss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

        tvNum_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onItemClick != null) {
                    onItemClick.onItemClick("0");
                }
            }
        });
        tvNum_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onItemClick != null) {
                    onItemClick.onItemClick("1");
                }
            }
        });
        tvNum_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onItemClick != null) {
                    onItemClick.onItemClick("2");
                }
            }
        });
        tvNum_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onItemClick != null) {
                    onItemClick.onItemClick("3");
                }
            }
        });
        tvNum_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onItemClick != null) {
                    onItemClick.onItemClick("4");
                }
            }
        });
        tvNum_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onItemClick != null) {
                    onItemClick.onItemClick("5");
                }
            }
        });
        tvNum_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onItemClick != null) {
                    onItemClick.onItemClick("6");
                }
            }
        });
        tvNum_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onItemClick != null) {
                    onItemClick.onItemClick("7");
                }
            }
        });
        tvNum_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onItemClick != null) {
                    onItemClick.onItemClick("8");
                }
            }
        });
        tvNum_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onItemClick != null) {
                    onItemClick.onItemClick("9");
                }
            }
        });
        tvNum_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onItemClick != null) {
                    onItemClick.onItemClick("0");
                }
            }
        });
        tvNum_00.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onItemClick != null) {
                    onItemClick.onItemClick(".");
                }
            }
        });
        tvNum_36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onItemClick != null) {
                    onItemClick.onItemClick("36.");
                }
            }
        });
        tvNum_37.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onItemClick != null) {
                    onItemClick.onItemClick("37.");
                }
            }
        });
        tvNum_38.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onItemClick != null) {
                    onItemClick.onItemClick("38.");
                }
            }
        });
        tvNum_39.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onItemClick != null) {
                    onItemClick.onItemClick("39.");
                }
            }
        });

    }

    @Override
    public void show() {
        super.show();
        WindowManager.LayoutParams layoutParams = getWindow().getAttributes();
        layoutParams.gravity = Gravity.BOTTOM;
        layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
        layoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT;
        getWindow().getDecorView().setPadding(0, 0, 0, 0);
        getWindow().setAttributes(layoutParams);

    }


    public interface onItemClick {
        void onItemClick(String num);
    }

    public interface onDelClick {
        void onDelClick();
    }

    public void onItemClick(onItemClick onItemClick, onDelClick onDelClick) {
        this.onItemClick = onItemClick;
        this.onDelClick = onDelClick;
    }

}
