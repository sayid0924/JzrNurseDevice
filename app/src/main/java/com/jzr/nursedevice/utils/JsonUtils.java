package com.jzr.nursedevice.utils;

import android.content.Context;

import com.google.gson.Gson;
import com.jzr.nursedevice.bean.CheckDeptBean;
import com.jzr.nursedevice.bean.DoctorActionBean;
import com.jzr.nursedevice.bean.PatientInfoBean;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class JsonUtils {

    public static CheckDeptBean getDeptJson(Context context) {
        StringBuilder newstringBuilder = new StringBuilder();
        InputStream inputStream = null;
        try {
            inputStream = context.getResources().getAssets().open("dept.json");
            InputStreamReader isr = new InputStreamReader(inputStream);
            BufferedReader reader = new BufferedReader(isr);
            String jsonLine;
            while ((jsonLine = reader.readLine()) != null) {
                newstringBuilder.append(jsonLine);
            }
            reader.close();
            isr.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String result = newstringBuilder.toString();
        Gson gson = new Gson();
        CheckDeptBean checkDeptBean = gson.fromJson(result, CheckDeptBean.class);
        return checkDeptBean;

    }
    public static PatientInfoBean getPatientJson(Context context) {
        StringBuilder newstringBuilder = new StringBuilder();
        InputStream inputStream = null;
        try {
            inputStream = context.getResources().getAssets().open("patient.json");
            InputStreamReader isr = new InputStreamReader(inputStream);
            BufferedReader reader = new BufferedReader(isr);
            String jsonLine;
            while ((jsonLine = reader.readLine()) != null) {
                newstringBuilder.append(jsonLine);
            }
            reader.close();
            isr.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String result = newstringBuilder.toString();
        Gson gson = new Gson();
        PatientInfoBean patientBean = gson.fromJson(result, PatientInfoBean.class);
        return patientBean;

    }


    public static DoctorActionBean getDoctorActionJson(Context context) {
        StringBuilder newstringBuilder = new StringBuilder();
        InputStream inputStream = null;
        try {
            inputStream = context.getResources().getAssets().open("DoctorAction.json");
            InputStreamReader isr = new InputStreamReader(inputStream);
            BufferedReader reader = new BufferedReader(isr);
            String jsonLine;
            while ((jsonLine = reader.readLine()) != null) {
                newstringBuilder.append(jsonLine);
            }
            reader.close();
            isr.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String result = newstringBuilder.toString();
        Gson gson = new Gson();
        DoctorActionBean doctorActionBean = gson.fromJson(result, DoctorActionBean.class);
        return doctorActionBean;
    }

}
