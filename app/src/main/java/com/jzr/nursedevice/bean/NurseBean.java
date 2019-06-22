package com.jzr.nursedevice.bean;

public class NurseBean {

    public NurseBean(String date, String name, String type) {
        this.date = date;
        this.name = name;
        this.type = type;
    }

    String date;
    String name;
    String type;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
