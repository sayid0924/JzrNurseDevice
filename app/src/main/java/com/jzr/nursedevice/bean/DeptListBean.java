package com.jzr.nursedevice.bean;

import java.util.List;

public class DeptListBean  {


    /**
     * code : 0
     * status : 0
     * message : 成功
     * msg : 成功
     * count : 0
     * timestamp : 2019-04-13T03:22:24.040Z
     * data : [{"code":"1303","name":"产科"},{"code":"1403","name":"新生儿科"},{"code":"1407","name":"儿科住院"},{"code":"7027","name":"妇科"}]
     */

    private int code;
    private int status;
    private String message;
    private String msg;
    private int count;
    private String timestamp;
    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * code : 1303
         * name : 产科
         */

        private String code;
        private String name;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
