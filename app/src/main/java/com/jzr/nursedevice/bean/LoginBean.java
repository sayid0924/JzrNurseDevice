package com.jzr.nursedevice.bean;

/**
 * Created by Mervin on 2018/7/25 0025.
 */

public class LoginBean {


    /**
     * code : 200
     * status : 200
     * message : ok
     * msg : ok
     * tokenType : Bearer
     * data : eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiIxIiwic3ViIjoiYWRtaW4iLCJhdWQiOiJhZG1pbiIsImV4cCI6MTU1NTE1MjQxNiwiaWF0IjoxNTU1MTIzNjE2fQ.XPY6cfcWxNz6FVRnkwKD_Ljfq1rpsHOWGd7JSUOj8RKGcwqEnVRZLlQD6dcVog-OvzF4i9fnVbuZfX6fy8DZSA
     */

    private int code;
    private int status;
    private String message;
    private String msg;
    private String tokenType;
    private String data;

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

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
