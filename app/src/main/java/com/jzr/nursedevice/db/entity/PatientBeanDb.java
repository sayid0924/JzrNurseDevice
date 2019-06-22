package com.jzr.nursedevice.db.entity;

import com.google.gson.Gson;
import com.jzr.nursedevice.bean.PatientInfoBean;

import org.greenrobot.greendao.annotation.Convert;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Keep;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.converter.PropertyConverter;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class PatientBeanDb {

    @Id(autoincrement = true)
    private Long id;

    @Property
    @Convert(converter = PatientBeanConverter.class, columnType = String.class)
    private PatientInfoBean patientBean;

//    @Generated(hash = 1761726544)
    @Keep
    public PatientBeanDb(Long id, PatientInfoBean patientBean) {
        this.id = id;
        this.patientBean = patientBean;

    }

//    @Generated(hash = 469589109)
    public PatientBeanDb() {

    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PatientInfoBean getPatientBeanDb() {
        return this.patientBean;
    }

    public void setBedInfoBean(PatientInfoBean patientBean) {
        this.patientBean = patientBean;
    }

    public PatientInfoBean getPatientBean() {
        return this.patientBean;
    }

    public void setPatientBean(PatientInfoBean patientBean) {
        this.patientBean = patientBean;
    }

    public static class PatientBeanConverter implements PropertyConverter<PatientInfoBean, String> {
        @Override
        public PatientInfoBean convertToEntityProperty(String databaseValue) {
            if (databaseValue == null) {
                return null;
            }
            return new Gson().fromJson(databaseValue, PatientInfoBean.class);
        }

        @Override
        public String convertToDatabaseValue(PatientInfoBean entityProperty) {
            if (entityProperty == null) {
                return null;
            }
            return new Gson().toJson(entityProperty);
        }
    }

}

